package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Section;

import java.util.List;


@Service
public interface SectionService {
    Section add(Section section);

    Section getById(long id);

    List<Section> getAll();

    Section edit(Section section);

    void delete(Section section);
}
