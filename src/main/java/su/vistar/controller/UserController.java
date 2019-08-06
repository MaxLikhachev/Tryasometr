package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.component.JwtTokenUtil;
import su.vistar.entity.UserData;
import su.vistar.service.JwtUserDetailsService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    protected JwtTokenUtil jwtTokenUtil;
    @Autowired
    protected JwtUserDetailsService userService;

    @GetMapping
    public @ResponseBody
    ResponseEntity<?> viewUser(HttpServletRequest request) {
        return ResponseEntity.ok(userService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request)));
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<?> editUser(@RequestParam UserData newUser, HttpServletRequest request) {
        return ResponseEntity.ok(userService.update(newUser));
    }
}