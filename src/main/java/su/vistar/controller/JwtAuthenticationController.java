package su.vistar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import su.vistar.component.JwtTokenUtil;
import su.vistar.model.entity.UserData;
import su.vistar.model.request.JwtRequest;
import su.vistar.model.response.JwtResponse;
import su.vistar.service.JwtUserDetailsService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping
public class JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    //protected final Log logger = LogFactory.getLog(this.getClass());
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> updateAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        logger.info("User :" + authenticationRequest.getUsername() + " login");
        return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()))));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, HttpServletResponse response) throws Exception {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        } catch (Exception e) {
            UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>());
            UserData user = userDetailsService.save(userDetails);
            logger.info("User #" + user.getID() + " sign up");
            return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(userDetails)));
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}