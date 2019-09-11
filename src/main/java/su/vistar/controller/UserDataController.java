package su.vistar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.vistar.authentication.component.JwtTokenUtil;
import su.vistar.logging.service.LogService;
import su.vistar.model.entity.UserData;
import su.vistar.model.request.UserDataRequest;
import su.vistar.model.response.UserDataResponse;
import su.vistar.service.UserDataService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserDataController {
    private final JwtTokenUtil jwtTokenUtil;
    private final LogService logger;
    private final UserDataService userService;

    public UserDataController(JwtTokenUtil jwtTokenUtil, UserDataService userService, LogService logger) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.logger = logger;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity get(HttpServletRequest request) {
        UserData user = userService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));
        return ResponseEntity.ok(new UserDataResponse(user.getUsername(),user.getName(),user.getSurname(),user.getSecondName(),user.getEmail(),user.getPhone()));
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity edit(@RequestBody @Valid UserDataRequest userRequest, HttpServletRequest request) {
        UserData user = userService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setName(userRequest.getName());
        user.setSecondName(userRequest.getSecondName());
        user.setSurname(userRequest.getSurname());
        userService.save(user);
        return ResponseEntity.ok(new UserDataResponse(user.getUsername(),user.getName(),user.getSurname(),user.getSecondName(),user.getEmail(),user.getPhone()));
    }

    @DeleteMapping
    public @ResponseBody
    ResponseEntity delete(HttpServletRequest request) {
        userService.delete(userService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request)));
        return ResponseEntity.ok("User successfully deleted");
    }

}