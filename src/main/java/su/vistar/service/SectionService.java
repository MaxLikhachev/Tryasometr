package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Section;
import su.vistar.repository.SectionRepository;

import java.util.List;


@Service
public class SectionService {
    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    
    public Section save(Section section) {
        return sectionRepository.save(section);
    }
    
    public Section getById(long id) {
        return sectionRepository.findById(id).orElseGet(Section::new);
    }

    public Section updateFactor(long id, float factor) {
        Section section = getById(id);
        section.setId(id);
        section.setFactor(factor);
        return sectionRepository.save(section);
    }
    
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }

    public List<Section> getAllById(Iterable<Long> ids) {
        return sectionRepository.findAllById(ids);
    }
    
    public void delete(Section section) {
        sectionRepository.delete(section);
    }
}
