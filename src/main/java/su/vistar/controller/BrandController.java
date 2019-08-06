package su.vistar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.model.entity.Brand;
import su.vistar.model.entity.Model;
import su.vistar.model.response.BrandResponse;
import su.vistar.model.response.ModelResponse;
import su.vistar.service.BrandService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/brands")
public class BrandController {
    protected final Log logger = LogFactory.getLog(this.getClass());
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll() {
        List<BrandResponse> responses = new ArrayList<>();
        for (Brand brand : brandService.getAll())
            responses.add(new BrandResponse(brand));
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{brand_id}/models")
    public @ResponseBody
    ResponseEntity<?> getAllModels(@PathVariable(name = "brand_id") long brandID, HttpServletResponse response) throws IOException {
        if (brandService.getById(brandID).getModels().size() == 0)
            response.sendError(HttpServletResponse.SC_NO_CONTENT, "Brand or models not found");
        List<ModelResponse> responses = new ArrayList<>();
        for (Model model : brandService.getById(brandID).getModels())
            responses.add(new ModelResponse(model));
        return ResponseEntity.ok(responses);
    }
}
