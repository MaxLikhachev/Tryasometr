package su.vistar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.entity.Car;
import su.vistar.entity.Model;
import su.vistar.entity.UserData;
import su.vistar.service.CarService;
import su.vistar.service.ModelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/user/cars")
public class UserCarController extends UserController {
    @Autowired
    protected CarService carService;
    @Autowired
    protected ModelService modelService;

    @PostMapping
    public @ResponseBody
    ResponseEntity<?> addUserCar(@RequestParam(name = "model_id") long id, @RequestParam(name = "year") int year, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData user = userService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request));
        Model model = modelService.getById(id);

        if (model.getName() == null)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);

        Car car = new Car();
        car.setModel(modelService.add(model));
        car.setYear(year);
        carService.add(car);

        user.setCars(new ArrayList<>());
        user.getCars().add(car);
        userService.save(user);

        return ResponseEntity.ok(car);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteUserCar(@PathVariable(name = "id") long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserData user = userService.findUserByUsername(jwtTokenUtil.getUsernameFromHeader(request));
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
}

