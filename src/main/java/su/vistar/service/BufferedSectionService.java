package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.BufferedSection;
import su.vistar.repository.BufferedSectionRepository;

import java.util.List;


@Service
public class BufferedSectionService {
    private final BufferedSectionRepository bufferedSectionRepository;

    public BufferedSectionService(BufferedSectionRepository bufferedSectionRepository) {
        this.bufferedSectionRepository = bufferedSectionRepository;
    }

    public BufferedSection save(BufferedSection bufferedSection) {
        return bufferedSectionRepository.save(bufferedSection);
    }

    public BufferedSection getById(long id) {
        return bufferedSectionRepository.findById(id).orElseGet(BufferedSection::new);
    }

    public List<BufferedSection> getAllSorted() {
        return bufferedSectionRepository.findAllByOrderBySectionId();
    }

    public List<BufferedSection> getAll() {
        return bufferedSectionRepository.findAll();
    }

    public void deleteAllById(long id) {
        bufferedSectionRepository.deleteAllBySectionId(id);
    }

    public List<BufferedSection> getAllById(long id) {
        return bufferedSectionRepository.findAllBySectionId(id);
    }

    public float getAverageFactorById(long id) {
        float sum = 0;
        for (BufferedSection section : bufferedSectionRepository.findAllBySectionId(id))
            sum += section.getFactor();
        return sum / bufferedSectionRepository.countAllBySectionId(id);
    }

    public void remove() {
        bufferedSectionRepository.deleteAll();
    }
}
