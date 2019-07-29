package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import su.vistar.model.dao.*;
import su.vistar.model.dto.CarDTO;
import su.vistar.model.dto.UserDTO;
import su.vistar.service.*;
import su.vistar.service.details.JwtUserDetailsService;


import su.vistar.config.JwtTokenUtil;
import su.vistar.model.JwtRequest;
import su.vistar.model.JwtResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CarService carService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private UserCarService userCarService;
	@Autowired
	private BrandModelService brandModelService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> signUpUser(@RequestBody UserDTO user) throws Exception {
		UserDetails userDetails = userDetailsService.signUpUser(user);
		UserDAO newUser = userDetailsService.save(user);

		List<CarDAO> cars = new ArrayList<>();
		for(CarDTO car : user.getCars()) {
			ModelDAO model = modelService.getByName(car.getModel());
			//BrandDAO brand = brandService.getByName(car.getModel());

			CarDAO newCar = new CarDAO();
			newCar.setModel(model);
			newCar.setYear(car.getYear());
			carService.add(newCar);

			UserCarDAO userCar = new UserCarDAO();
			userCar.setUserID(newUser.getID());
			userCar.setCarID(newCar.getID());
			userCarService.add(userCar);

			userCarService.add(new UserCarDAO());
		}

		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
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