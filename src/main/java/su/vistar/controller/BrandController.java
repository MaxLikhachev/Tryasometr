package su.vistar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import su.vistar.model.dao.BrandDAO;
import su.vistar.model.dao.ModelDAO;
import su.vistar.model.dto.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.service.BrandService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/brands")
public class BrandController {
    @Autowired private BrandService brandService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAllBrands(){
        List<BrandDAO> brands = brandService.getAll();
        List<BrandDTO> newBrands = new ArrayList<>();
        for(BrandDAO brand: brands) newBrands.add(new BrandDTO(brand));
        return ResponseEntity.ok(newBrands);
    }

    @GetMapping(path="/{brand_id}/models")
    public @ResponseBody ResponseEntity<?> getAllModelsByBrandName(@PathVariable(name ="brand_id") long brandID, HttpServletResponse response) throws IOException {
        List<ModelDAO> models = brandService.getById(brandID).getModels();
        if (models.size() == 0)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);
        return ResponseEntity.ok(models);
    }
}
