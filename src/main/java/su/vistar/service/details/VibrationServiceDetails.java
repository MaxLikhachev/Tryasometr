package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Vibration;
import su.vistar.repository.VibrationRepository;
import su.vistar.service.VibrationService;

import java.util.List;
@Service
public class VibrationServiceDetails implements VibrationService {
    private final VibrationRepository vibrationRepository;

    public VibrationServiceDetails(VibrationRepository vibrationRepository) {
        this.vibrationRepository = vibrationRepository;
    }

    @Override
    public Vibration add(Vibration vibration) {
        return vibrationRepository.save(vibration);
    }

    @Override
    public Vibration getById(long id) {
        return vibrationRepository.findById(id).orElseGet(Vibration::new);
    }

    @Override
    public List<Vibration> getAll() {
        return vibrationRepository.findAll();
    }

    @Override
    public Vibration edit(Vibration vibration) {
        return vibrationRepository.saveAndFlush(vibration);
    }

    @Override
    public void delete(Vibration vibration) {
        vibrationRepository.delete(vibration);
    }

    @Override
    public void remove() {
        vibrationRepository.deleteAll();
    }
}
