package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.entity.Section;
import su.vistar.entity.Vibration;
import su.vistar.service.SectionService;
import su.vistar.service.VibrationService;

@Controller
@RequestMapping(path = "/vibration")
public class VibrationController {
    @Autowired
    private VibrationService vibrationService;
    @Autowired
    private SectionService sectionService;

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
