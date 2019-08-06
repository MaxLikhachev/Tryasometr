package su.vistar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.component.JwtTokenUtil;
import su.vistar.model.entity.UserData;
import su.vistar.service.UserDataService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/user")
public class UserDataController {
    private final JwtTokenUtil jwtTokenUtil;
    private final Log logger = LogFactory.getLog(this.getClass());
    private final UserDataService userDataService;

    public UserDataController(JwtTokenUtil jwtTokenUtil, UserDataService userDataService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDataService = userDataService;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<?> getUser(HttpServletRequest request) {
        UserData user = userDataService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));
        //return ResponseEntity.ok(new UserDataResponse(user));
        return ResponseEntity.ok(user);
    }
/*
    @PutMapping
    public @ResponseBody
    ResponseEntity<?> editUser(@RequestParam UserData newUser, HttpServletRequest request) {
        return ResponseEntity.ok(userDataService.update(newUser));
    }

 */
}