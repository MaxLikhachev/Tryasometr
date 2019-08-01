package su.vistar.controller;

import su.vistar.config.JwtTokenUtil;
import su.vistar.model.dao.*;
import su.vistar.model.dto.CarDTO;
import su.vistar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.service.JwtUserDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    private BrandService brandService;


}
