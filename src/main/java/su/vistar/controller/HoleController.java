package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import su.vistar.service.HoleService;

@Controller
@RequestMapping(path = "/holes")
public class HoleController {
    @Autowired
    private HoleService holeService;
/*
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(holeService.getAll());
    }
 */
}
