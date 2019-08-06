package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Hole;
import su.vistar.repository.HoleRepository;
import su.vistar.service.HoleService;

import java.util.List;
@Service
public class HoleServiceDetails implements HoleService {
    private final HoleRepository holeRepository;

    public HoleServiceDetails(HoleRepository holeRepository) {
        this.holeRepository = holeRepository;
    }

    //@Override
    public Hole add(Hole hole) {
        return holeRepository.save(hole);
    }

    //@Override
    public Hole getById(long id) {
        return holeRepository.findById(id).orElseGet(Hole::new);
    }

    //@Override
    public List<Hole> getAll() {
        return holeRepository.findAll();
    }

    //@Override
    public Hole edit(Hole hole) {
        return holeRepository.saveAndFlush(hole);
    }

    //@Override
    public void delete(Hole hole) {
        holeRepository.delete(hole);
    }
    //@Override
    //public Hole getByName(String name){return holeRepository.getByName(name);}
}
