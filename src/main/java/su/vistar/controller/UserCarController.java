package su.vistar.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.component.JwtTokenUtil;
import su.vistar.model.entity.Brand;
import su.vistar.model.entity.Car;
import su.vistar.model.entity.Model;
import su.vistar.model.entity.UserData;
import su.vistar.model.response.CarResponse;
import su.vistar.service.BrandService;
import su.vistar.service.CarService;
import su.vistar.service.ModelService;
import su.vistar.service.UserDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user/cars")
public class UserCarController {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final JwtTokenUtil jwtTokenUtil;
    private final CarService carService;
    private final ModelService modelService;
    private final UserDataService userDataService;
    private final BrandService brandService;

    public UserCarController(JwtTokenUtil jwtTokenUtil, CarService carService, ModelService modelService, UserDataService userDataService, BrandService brandService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.carService = carService;
        this.modelService = modelService;
        this.userDataService = userDataService;
        this.brandService = brandService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<?> addUserCar(@RequestParam(name = "model_id") long id, @RequestParam(name = "year") int year, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData user = userDataService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));

        Model model = modelService.getById(id);

        if (model.getName() == null)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);

        Car car = new Car();
        car.setModel(modelService.add(model));
        car.setYear(year);
        carService.add(car);

        user.getCars().add(car);
        userDataService.add(user);

        return ResponseEntity.ok(Response(car, response));
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<?> getAllUserCars(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData user = userDataService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));

        List<CarResponse> cars = Response(user.getCars(), response);
        if (cars.size() == 0)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);

        return ResponseEntity.ok(cars);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteUserCar(@PathVariable(name = "id") long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData user = userDataService.findByUsername(jwtTokenUtil.getUsernameFromHeader(request));
        try {
            for (Car car : user.getCars())
                if (car.getID() == id)
                    if (user.getCars().size() == 1)
                        response.sendError(HttpServletResponse.SC_NOT_MODIFIED, "This car couldn't be deleted. It is a single car for this user ");
                    else
                        carService.delete(carService.getById(car.getID()));
        } catch (NullPointerException e){
            response.sendError(HttpServletResponse.SC_NO_CONTENT, "This car couldn't be deleted. It is a single car for this user ");
        }
        return ResponseEntity.ok("Successfully deleted");
    }

    private List<CarResponse> Response(List<Car> cars, HttpServletResponse response) throws IOException {
        List<CarResponse> responses = new ArrayList<>();
        for (Car car : cars)
            responses.add(Response(car, response));
        return responses;
    }

    private CarResponse Response(Car car, HttpServletResponse response) throws IOException {
        Brand brand = new Brand();
        try {
            brand = brandService.getByModelId(car.getModel().getID());
        } catch (NullPointerException e) {
            response.sendError(HttpServletResponse.SC_NO_CONTENT);
        }
        return new CarResponse(car, brand);
    }
}

