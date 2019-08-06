package su.vistar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.model.entity.Section;
import su.vistar.model.entity.Vibration;
import su.vistar.service.SectionService;
import su.vistar.service.VibrationService;

@Controller
@RequestMapping(path = "/vibration")
public class VibrationController {
    protected final Log logger = LogFactory.getLog(this.getClass());
    private final VibrationService vibrationService;
    private final SectionService sectionService;

    public VibrationController(VibrationService vibrationService, SectionService sectionService) {
        this.vibrationService = vibrationService;
        this.sectionService = sectionService;
    }

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(vibrationService.getAll());
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<?> add(@RequestParam long section_id, @RequestParam float latitude, @RequestParam float longitude, @RequestParam float factor) {
        Section section = sectionService.getById(section_id);

        Vibration vibration = new Vibration();
        vibration.setFactor(factor);
        vibration.setLatitude(latitude);
        vibration.setLongitude(longitude);
        return ResponseEntity.ok(vibrationService.add(vibration));
    }
}
