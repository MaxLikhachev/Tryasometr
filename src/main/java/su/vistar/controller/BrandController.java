package su.vistar.controller;

import su.vistar.model.dao.BrandDAO;
import su.vistar.model.dao.BrandModelDAO;
import su.vistar.model.dto.BrandDTO;
import su.vistar.model.dto.ModelDTO;
import su.vistar.service.BrandModelService;
import su.vistar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.service.ModelService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/brands")
public class BrandController {
    @Autowired private BrandService brandService;
    @Autowired private BrandModelService brandModelService;
    @Autowired private ModelService modelService;

    @GetMapping()
    public @ResponseBody List<BrandDTO> getAll(){
        List<BrandDAO> brands = brandService.getAll();
        List<BrandDTO> newBrands = new ArrayList<>();

        for(BrandDAO brand: brands) newBrands.add(new BrandDTO(brand));

        return newBrands;
    }
}
