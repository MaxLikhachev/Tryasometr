package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.config.JwtTokenUtil;
import su.vistar.model.JwtRequest;
import su.vistar.model.JwtResponse;
import su.vistar.model.dao.*;
import su.vistar.model.dto.CarDTO;
import su.vistar.model.dto.UserDTO;
import su.vistar.service.*;
import su.vistar.service.details.JwtUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/user")
public class UserController {
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

	@GetMapping("/info")
	public @ResponseBody
	UserDTO getData (HttpServletRequest request){
		UserDAO user = userDetailsService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request));
		UserDTO newUser = new UserDTO(user);

		List<CarDAO> cars = carService.getAllByUserID(user.getID());
		List<CarDTO> newCars =  new ArrayList<>();

		for(CarDAO car : cars) {
			BrandModelDAO brandModel = brandModelService.getByModelID(car.getModel().getID());
			BrandDAO brand = brandService.getById(brandModel.getMarkID());

			newCars.add(new CarDTO(brand.getName(), car.getModel().getName(), car.getYear()));
		}
		newUser.setCars(newCars);

		return newUser;
	}
}