package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Section;
import su.vistar.repository.SectionRepository;
import su.vistar.service.SectionService;

import java.util.List;
@Service
public class SectionServiceDetails implements SectionService {
    private final SectionRepository sectionRepository;

    public SectionServiceDetails(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section add(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section getById(long id) {
        return sectionRepository.findById(id).orElseGet(Section::new);
    }

    @Override
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Section edit(Section section) {
        return sectionRepository.saveAndFlush(section);
    }

    @Override
    public void delete(Section section) {
        sectionRepository.delete(section);
    }
}
