package su.vistar.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import su.vistar.model.entity.Hole;
import su.vistar.model.entity.Section;
import su.vistar.model.entity.Vibration;
import su.vistar.service.HoleService;
import su.vistar.service.SectionService;
import su.vistar.service.VibrationService;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledVibrationAnalyzer {
    //private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    //protected final Log logger = LogFactory.getLog(this.getClass());
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());


    private final HoleService holeService;
    private final SectionService sectionService;
    private final VibrationService vibrationService;

    public ScheduledVibrationAnalyzer(HoleService holeService, SectionService sectionService, VibrationService vibrationService) {
        this.holeService = holeService;
        this.sectionService = sectionService;
        this.vibrationService = vibrationService;
    }

    @Scheduled(cron = "*/10 * * * * *", zone = "UTC")
    public void analyzeVibration() {
        logger.warn("Started vibration analise");
        Date start = new Date();

        List<Vibration> vibration = vibrationService.getAll();
        //setHole(0,0,0);
        vibrationService.remove();
        long time = new Date().getTime() - start.getTime();
        logger.info("All vibrations were analyzed. Analysis time: " + time + " ms");
    }

    public void setHole(Section section, float latitude, float longitude, float factor) {
        Hole hole = new Hole();
        hole.setLatitude(latitude);
        hole.setLongitude(longitude);
        hole.setFactor(factor);
        holeService.add(hole);

        section.getHoles().add(hole);
        sectionService.edit(section);

        logger.info("Hole detected in section #" + section.getID() + " : " + latitude + " " + longitude);
    }
}
