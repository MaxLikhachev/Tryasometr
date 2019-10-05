package su.vistar.component;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import su.vistar.model.entity.BufferedSection;
import su.vistar.service.BufferedSectionService;
import su.vistar.service.SectionService;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledSectionBufferAnalyzer {
    private final SectionService sectionService;
    private final BufferedSectionService bufferedSectionService;

    public ScheduledSectionBufferAnalyzer(SectionService sectionService, BufferedSectionService bufferedSectionService) {
        this.sectionService = sectionService;
        this.bufferedSectionService = bufferedSectionService;
    }

    @Scheduled(cron = "10 * * * * *", zone = "UTC")
    public void analyzeBufferedSection() {
        Date start = new Date();
        try {
            analyzeBuffer();
        } catch (JpaSystemException e) {
        } catch (IndexOutOfBoundsException e) {
        }
        bufferedSectionService.remove();
        long time = new Date().getTime() - start.getTime();
    }

    private void analyzeBuffer() {
        List<BufferedSection> buffer = bufferedSectionService.getAllSorted();
        long prevId = buffer.get(0).getSectionId();
        float sumFactor = 0;
        int count = 0;

        for(BufferedSection bufferedSection : buffer)
            if (bufferedSection.getSectionId() == prevId) {
                sumFactor += bufferedSection.getFactor();
                count++;
            } else {
                sectionService.updateFactor(prevId, sumFactor / count);

                prevId = bufferedSection.getSectionId();
                sumFactor = bufferedSection.getFactor();
                count = 1;
            }
        sectionService.updateFactor(prevId,sumFactor/count);
    }
}
