package su.vistar.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import su.vistar.entity.Hole;
import su.vistar.entity.Section;
import su.vistar.entity.Vibration;
import su.vistar.service.HoleService;
import su.vistar.service.SectionService;
import su.vistar.service.VibrationService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledVibrationAnalyzer {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");

    @Autowired private HoleService holeService;
    @Autowired private SectionService sectionService;
    @Autowired private VibrationService vibrationService;

    @Scheduled(cron="*/10 * * * * *", zone="UTC")
    public void analyzeVibration() {
        Date start = new Date();

        List<Vibration> vibration = vibrationService.getAll();
        //setHole(0,0,0);
        vibrationService.remove();
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("All vibrations were analyzed\nStarted at: " + df.format(start)+"\nFinished at: "  + df.format(end)+"\nAnalysis time: " + time + " ms\n");
    }

    public void setHole(Section section, float latitude, float longitude, float factor) {
        Hole hole = new Hole();
        hole.setLatitude(latitude);
        hole.setLongitude(longitude);
        hole.setFactor(factor);
        holeService.add(hole);

        section.getHoles().add(hole);
        sectionService.edit(section);

        System.out.println("Hole detected in section #" + section.getID() + " : " + latitude + " " + longitude);
    }
}
