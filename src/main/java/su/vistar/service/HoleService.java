package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Hole;
import su.vistar.repository.HoleRepository;

import java.util.List;


@Service
public class HoleService {
    private final HoleRepository holeRepository;

    public HoleService(HoleRepository holeRepository) {
        this.holeRepository = holeRepository;
    }
    
    public Hole save(Hole hole) {
        return holeRepository.save(hole);
    }

    public Hole findById(long id) {
        return holeRepository.findById(id).orElseGet(Hole::new);
    }

    public List<Hole> findAll() {
        return holeRepository.findAll();
    }

    public void delete(Hole hole) {
        holeRepository.delete(hole);
    }
}
