package su.vistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import su.vistar.entity.UserData;
import su.vistar.entity.Vibration;
import su.vistar.service.VibrationService;

@Controller
@RequestMapping(path="/vibration")
public class VibrationController {
    @Autowired private VibrationService vibrationService;

    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> getAll(){ return ResponseEntity.ok(vibrationService.getAll()); }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<?> add(@RequestParam Vibration vibration){ return ResponseEntity.ok(vibrationService.add(vibration)); }
}
