package su.vistar.authentication.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import su.vistar.authentication.component.JwtTokenUtil;
import su.vistar.authentication.model.request.JwtRequest;
import su.vistar.authentication.model.response.JwtResponse;
import su.vistar.authentication.service.JwtUserDetailsService;
import su.vistar.logging.service.LogService;
import su.vistar.model.entity.UserData;
import su.vistar.service.UserDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping
public class JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UserDataService userDataService;
    private final LogService logger;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, LogService logger, UserDataService userDataService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userDataService = userDataService;
        this.logger = logger;
    }

    @PostMapping(value = "/login")
    public ResponseEntity updateAuthenticationToken(@NotNull @RequestBody JwtRequest authenticationRequest, HttpServletRequest httpServletRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        logger.info("User : "+authenticationRequest.getUsername()+" login", this.getClass().toString());
        return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()))));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity createAuthenticationToken(@NotNull @RequestBody JwtRequest authenticationRequest, HttpServletRequest httpServletRequest, HttpSession session) {
        try {
            userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        } catch (UsernameNotFoundException e) {
            UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
            userDataService.save(new UserData(userDetails.getUsername(), userDetailsService.getPassword(userDetails.getPassword()), userDetails.getAuthorities().toString().replaceAll("\\[","").replaceAll("]","")));
            logger.info("User : "+userDetails.getUsername()+" signup", this.getClass().toString());
            return ResponseEntity.ok(new JwtResponse(jwtTokenUtil.generateToken(userDetails)));
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}