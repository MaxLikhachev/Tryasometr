package su.vistar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.vistar.model.entity.BufferedHole;
import su.vistar.model.entity.BufferedSection;
import su.vistar.model.entity.Hole;
import su.vistar.model.entity.Section;
import su.vistar.model.request.HoleRequest;
import su.vistar.model.request.SectionRequest;
import su.vistar.model.response.HoleResponse;
import su.vistar.model.response.SectionResponse;
import su.vistar.service.BufferedHoleService;
import su.vistar.service.BufferedSectionService;
import su.vistar.service.HoleService;
import su.vistar.service.SectionService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/sections")
public class SectionController {
    private final SectionService sectionService;
    private final BufferedSectionService bufferedSectionService;
    private final HoleService holeService;
    private final BufferedHoleService bufferedHoleService;

    public SectionController(SectionService sectionService, BufferedSectionService bufferedSectionService, HoleService holeService, BufferedHoleService bufferedHoleService) {
        this.holeService = holeService;
        this.bufferedHoleService = bufferedHoleService;
        this.sectionService = sectionService;
        this.bufferedSectionService = bufferedSectionService;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity getById(@PathVariable(name = "id") long id) {
        Section section = sectionService.getById(id);
        return ResponseEntity.ok(new SectionResponse(id, section.getFactor()));
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity put(@PathVariable(name = "id") long id, @RequestBody SectionRequest section) {
        return ResponseEntity.ok(bufferedSectionService.save(new BufferedSection(System.currentTimeMillis(), id, section.getFactor())));
    }

    @GetMapping(path="/some")
    public @ResponseBody
    ResponseEntity getAllById(@RequestBody Iterable<Long> ids) {
        try {
            List<Section> sections = sectionService.getAllById(ids);
            List<SectionResponse> response = new ArrayList<>();
            for (Section section : sections)
                response.add(new SectionResponse(section.getId(), section.getFactor()));
            return ResponseEntity.ok(sections);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpServletResponse.SC_NO_CONTENT).body(null);
        }
    }

    @GetMapping(path = "/{id}/holes")
    public @ResponseBody
    ResponseEntity getAllHolesById(@PathVariable(name = "id") long id) {
        try {
            List<HoleResponse> holes = new ArrayList<>();
            for (Hole hole : sectionService.getById(id).getHoles())
                holes.add(new HoleResponse(hole.getBegin(), hole.getEnd()));
            return ResponseEntity.ok(holes);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpServletResponse.SC_NO_CONTENT).body(null);
        }
    }

    @PutMapping(path = "/{id}/holes")
    public @ResponseBody
    ResponseEntity putAllHolesById(@PathVariable(name = "id") long id, @RequestBody List<HoleRequest> holes) {
        for (HoleRequest hole : holes)
            bufferedHoleService.save(new BufferedHole(System.currentTimeMillis(), id, hole.getDistance()));
        return ResponseEntity.ok(null);
    }
}
