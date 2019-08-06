package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Vibration;

import java.util.List;


@Service
public interface VibrationService {
    Vibration add(Vibration vibration);

    Vibration getById(long id);

    List<Vibration> getAll();

    Vibration edit(Vibration vibration);

    void delete(Vibration vibration);

    void remove();
}
