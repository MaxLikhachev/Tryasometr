package su.vistar.component;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import su.vistar.model.entity.BufferedHole;
import su.vistar.model.entity.Hole;
import su.vistar.model.entity.Section;
import su.vistar.service.BufferedHoleService;
import su.vistar.service.HoleService;
import su.vistar.service.SectionService;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledHoleBufferAnalyzer {
private final HoleService holeService;
    private final SectionService sectionService;
    private final BufferedHoleService bufferedHoleService;

    public ScheduledHoleBufferAnalyzer(HoleService holeService, SectionService sectionService, BufferedHoleService bufferedHoleService) {
        this.holeService = holeService;
        this.sectionService = sectionService;
        this.bufferedHoleService = bufferedHoleService;
    }

    @Scheduled(cron = "20 * * * * *", zone = "UTC")
    public void analyzeHoleBuffer() {
        Date start = new Date();
        try {
            analyzeBuffer();
        } catch (JpaSystemException e) {
        } catch (IndexOutOfBoundsException e) {
        }
        bufferedHoleService.remove();
        long time = new Date().getTime() - start.getTime();
    }

    private void analyzeBuffer() {
        List<BufferedHole> buffer = bufferedHoleService.getAllSorted();
        long prevId = 0;
        float prevDistance = 0;
        final float distinction = 1;
        Hole temp = new Hole();

        for(BufferedHole hole : buffer) {
            if(hole.getSectionId() != prevId || hole.getDistance() - prevDistance > distinction) {
                setHole(prevId, temp.getBegin(), prevDistance);

                prevId = hole.getSectionId();
                prevDistance = hole.getDistance();

                temp = new Hole(prevDistance, prevDistance);
            }
        }
        setHole(prevId, temp.getBegin(), prevDistance);
    }

    private void setHole(long id, float begin, float end) {
        Section section = sectionService.getById(id);
        section.setId(id);
        section.getHoles().add(holeService.save(new Hole(begin, end)));
        sectionService.save(section);
    }
}
