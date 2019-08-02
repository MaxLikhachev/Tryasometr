package su.vistar.controller;

import su.vistar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;


}
