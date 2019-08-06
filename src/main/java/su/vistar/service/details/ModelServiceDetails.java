package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Model;
import su.vistar.repository.ModelRepository;
import su.vistar.service.ModelService;

import java.util.List;
@Service
public class ModelServiceDetails implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceDetails(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model add(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model getById(long id) {
        return modelRepository.findById(id).orElseGet(Model::new);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public void remove() {
        modelRepository.deleteAll();
    }
}
