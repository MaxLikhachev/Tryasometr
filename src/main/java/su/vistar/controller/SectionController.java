package su.vistar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import su.vistar.model.entity.Hole;
import su.vistar.service.SectionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/sections")
public class SectionController {
    protected final Log logger = LogFactory.getLog(this.getClass());
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(sectionService.getAll());
    }

    @GetMapping(path = "/{section_id}/holes")
    public @ResponseBody
    ResponseEntity<?> getAllModels(@PathVariable(name = "section_id") long sectionID, HttpServletResponse response) throws IOException {
        List<Hole> holes = sectionService.getById(sectionID).getHoles();
        if (holes == null)
            response.sendError(HttpServletResponse.SC_NO_CONTENT);
        return ResponseEntity.ok(holes);
    }
}
