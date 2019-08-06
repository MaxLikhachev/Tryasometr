package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.entity.Hole;

import java.util.List;


@Service
public interface HoleService {
    Hole add(Hole hole);

    Hole getById(long id);

    List<Hole> getAll();

    Hole edit(Hole hole);

    void delete(Hole hole);
}
