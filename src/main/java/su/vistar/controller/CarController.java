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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;

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

    @PostMapping()
    public @ResponseBody CarDTO addNewCar (@RequestParam(name="id") long id, @RequestParam(name="year") int year, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String username = jwtTokenUtil.getUsernameFromHeader(request);
            UserDAO user = userDetailsService.findUserByUsername(username);

                ModelDAO model = modelService.getById(id);

                if(model.getName() == null)
                    response.sendError(HttpServletResponse.SC_NO_CONTENT);

                CarDAO car = new CarDAO();
                car.setModel(model);
                car.setYear(year);
                carService.add(car);

//TODO Constructors for child-entities
                UserCarDAO userCar = new UserCarDAO();
                userCar.setCarID(car.getID());
                userCar.setUserID(user.getID());
                userCarService.add(userCar);

                BrandModelDAO brandModel = brandModelService.getByModelID(id);
                BrandDAO brand = brandService.getById(brandModel.getMarkID());

                return new CarDTO(brand.getName(),model.getName(),year);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody void deleteCar (@PathVariable(name ="id") long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = jwtTokenUtil.getUsernameFromHeader(request);
        UserDAO user = userDetailsService.findUserByUsername(username);

        List<UserCarDAO> userCars = userCarService.getAllByID(user.getID());

        if(userCars.size()==0)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);

        for(UserCarDAO userCar : userCars)
            if(userCar.getCarID() == id)
                if(userCars.size()==1)
                    response.sendError(HttpServletResponse.SC_NOT_MODIFIED,"This car couldn't be deleted. It is a single car for user "+username);
                 else {
                    carService.delete(carService.getById(userCar.getCarID()));
                    userCarService.delete(userCar);
                }
    }
}
