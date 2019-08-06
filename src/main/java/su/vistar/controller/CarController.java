package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import su.vistar.service.BrandService;
import su.vistar.service.CarService;
import su.vistar.service.ModelService;

@Controller
@RequestMapping(path = "/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;


}
