package su.vistar.controller;

import su.vistar.config.JwtTokenUtil;
import su.vistar.model.dao.*;
import su.vistar.model.dto.CarDTO;
import su.vistar.model.dto.ModelDTO;
import su.vistar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.service.details.JwtUserDetailsService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path="/cars")
public class CarController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private CarService carService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private UserCarService userCarService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandModelService brandModelService;

    @PostMapping("/new")
    public @ResponseBody CarDTO put (@RequestParam(name="id") long id, @RequestParam(name="year") int year, HttpServletRequest request){
        String username = jwtTokenUtil.getUsernameFromHeader(request);
        UserDAO user = userDetailsService.findUserByUsername(username);
        ModelDAO model = modelService.getById(id);

        CarDAO car = new CarDAO();
        car.setModel(model);
        car.setYear(year);
        carService.add(car);

        UserCarDAO userCar = new UserCarDAO();
        userCar.setCarID(car.getID());
        userCar.setUserID(user.getID());
        userCarService.add(userCar);

        BrandModelDAO brandModel = brandModelService.getByModelID(id);
        BrandDAO brand = brandService.getById(brandModel.getMarkID());

        return new CarDTO(brand.getName(),model.getName(),year);
    }

}
