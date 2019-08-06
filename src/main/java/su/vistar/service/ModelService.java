package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.entity.Model;

import java.util.List;


@Service
public interface ModelService {
    Model add(Model model);

    Model getById(long id);

    List<Model> getAll();

    void remove();
}
