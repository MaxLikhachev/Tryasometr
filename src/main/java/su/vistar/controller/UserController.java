package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.config.JwtTokenUtil;
import su.vistar.model.dao.*;
import su.vistar.model.dto.UserDTO;
import su.vistar.service.CarService;
import su.vistar.service.JwtUserDetailsService;
import su.vistar.service.ModelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	protected JwtTokenUtil jwtTokenUtil;
	@Autowired
	protected JwtUserDetailsService userService;

	@GetMapping
	public @ResponseBody
	ResponseEntity<?> viewUser (HttpServletRequest request){
		return ResponseEntity.ok(userService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request)));
	}

	//TODO update user's data
	@PutMapping
	public @ResponseBody
	ResponseEntity<?> editUser (@RequestParam UserDTO userDTO, HttpServletRequest request){
		UserDAO user = userService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request));
		return ResponseEntity.ok(new UserDTO(userService.save(new UserDTO(user))));
	}
}