package su.vistar.service.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.entity.Vibration;
import su.vistar.repository.VibrationRepository;
import su.vistar.service.VibrationService;

import java.util.List;
import java.util.Optional;
@Service
public class VibrationServiceDetails implements VibrationService {
    @Autowired
    private VibrationRepository vibrationRepository;

    @Override
    public Vibration add(Vibration vibration) {
        return vibrationRepository.save(vibration);
    }

    @Override
    public Vibration getById(long id) {
        Optional<Vibration> optionalCarVibration = vibrationRepository.findById(id);
        Vibration vibration = optionalCarVibration.isPresent() ? optionalCarVibration.get() : new Vibration();
        return vibration;
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
