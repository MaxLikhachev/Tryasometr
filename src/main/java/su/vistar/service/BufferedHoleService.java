package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.BufferedHole;
import su.vistar.repository.BufferedHoleRepository;

import java.util.List;


@Service
public class BufferedHoleService {
    private final BufferedHoleRepository bufferedHoleRepository;

    public BufferedHoleService(BufferedHoleRepository bufferedHoleRepository) {
        this.bufferedHoleRepository = bufferedHoleRepository;
    }

    
    public BufferedHole save(BufferedHole bufferedHole) {
        return bufferedHoleRepository.save(bufferedHole);
    }

    
    public BufferedHole getById(long id) {
        return bufferedHoleRepository.findById(id).orElseGet(BufferedHole::new);
    }

    
    public List<BufferedHole> getAll() {
        return bufferedHoleRepository.findAll();
    }

    public List<BufferedHole> getAllSorted() {
        return bufferedHoleRepository.findAllByOrderBySectionIdDistance();
    }
    
    public void delete(BufferedHole bufferedHole) {
        bufferedHoleRepository.delete(bufferedHole);
    }

    
    public void remove() {
        bufferedHoleRepository.deleteAll();
    }
}
