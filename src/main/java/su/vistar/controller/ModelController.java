package su.vistar.controller;

import su.vistar.model.dao.BrandDAO;
import su.vistar.model.dao.BrandModelDAO;
import su.vistar.model.dao.ModelDAO;
import su.vistar.model.dto.BrandDTO;
import su.vistar.model.dto.ModelDTO;
import su.vistar.service.BrandModelService;
import su.vistar.service.BrandService;
import su.vistar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/brands/{brand_name}/models")
public class ModelController {
    @Autowired private ModelService modelService;
    @Autowired private BrandModelService brandModelService;
    @Autowired private BrandService brandService;

    @GetMapping()
    public @ResponseBody List<ModelDTO> getByID(@PathVariable(name ="brand_name") String brandName, HttpServletResponse response){
        BrandDAO brand = brandService.getByName(brandName);
        List<BrandModelDAO> markModels = brandModelService.getAllByID(brand.getID());
        List<ModelDTO> models = new ArrayList<>();

        for(BrandModelDAO markModel : markModels)
            models.add(new ModelDTO(markModel.getModelID(), modelService.getById(markModel.getModelID())));

        return models;
    }
}
