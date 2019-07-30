package su.vistar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import su.vistar.config.JwtTokenUtil;
import su.vistar.service.*;
import su.vistar.service.details.JwtUserDetailsService;

public class DI {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;
    private BrandService brandService;
    private CarService carService;
    private ModelService modelService;
    private UserCarService userCarService;
    private BrandModelService brandModelService;

    @Autowired
    public DI() {}
    //TODO DIConstructor and Setters
}
