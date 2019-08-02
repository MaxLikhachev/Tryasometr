package su.vistar.controller;

import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping(path="/brands/{brand_name}/models")
public class ModelController {
    //@Autowired private BrandService brandService;

    /*@GetMapping(path="/brands/{brand_name}/models")
    public @ResponseBody List<Model> index(@PathVariable(name ="brand_name") String brandName, HttpServletResponse response){

        /*Brand brand = brandService.getByName(brandName);
        List<BrandModelDAO> markModels = brandModelService.getAllByID(brand.getID());
        List<ModelDTO> models = new ArrayList<>();

        for(BrandModelDAO markModel : markModels)
            models.add(new ModelDTO(markModel.getModelID(), modelService.getById(markModel.getModelID())));

        return brandService.getByName(brandName).getModels();
    }*/
}
