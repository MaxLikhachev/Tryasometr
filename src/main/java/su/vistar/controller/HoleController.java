package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.entity.Model;
import su.vistar.service.HoleService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path="/holes")
public class HoleController {
    @Autowired private HoleService holeService;
/*
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(holeService.getAll());
    }
 */
}
