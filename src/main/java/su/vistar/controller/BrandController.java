package su.vistar.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.entity.Model;
import su.vistar.service.BrandService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/brands")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @GetMapping(path = "/{brand_id}/models")
    public @ResponseBody
    ResponseEntity<?> getAllModels(@PathVariable(name = "brand_id") long brandID, HttpServletResponse response) throws IOException {
        List<Model> models = brandService.getById(brandID).getModels();
        if (models == null) {
            //
            response.sendError(HttpServletResponse.SC_NO_CONTENT);
            //ResponseEntity.status(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(models);
    }
}
