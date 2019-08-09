package su.vistar.component;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import su.vistar.service.JwtUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtUserDetailsService userDetailsService;

    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.begin.string}")
    private static String jwtBeginString;

    @Autowired
    private void setUserRepository(JwtUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    private void setPasswordEncoder(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        AtomicReference<String> username = new AtomicReference<>();
        AtomicReference<String> jwtToken = new AtomicReference<>();

        // JWT Token is in the form "JWT token". Remove JWT word and get only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith(jwtBeginString)) {
                jwtToken.set(requestTokenHeader.substring(jwtBeginString.length()));
            try {
                    username.set(jwtTokenUtil.getUsernameFromToken(jwtToken.get()));
            } catch (IllegalArgumentException e) {
                logger.warn("Unable to get JWT");
            } catch (ExpiredJwtException e) {
                logger.warn("JWT has expired");
            }
        } else {
            if (requestTokenHeader == null) logger.warn("JWT not provided");
            else if (!requestTokenHeader.startsWith(jwtBeginString)) logger.warn("JWT not begin with \""+jwtBeginString+"\" string");
        }

        // Once we get the token validate it.
        if (username.get() != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username.get());

            // if token is valid configure Spring Security to manually set
            // authentication
            if (jwtTokenUtil.validateToken(jwtToken.get(), userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}