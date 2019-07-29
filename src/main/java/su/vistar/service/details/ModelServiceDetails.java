package su.vistar.service.details;

import su.vistar.repository.ModelRepository;
import su.vistar.model.dao.ModelDAO;
import su.vistar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ModelServiceDetails implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Override
    public ModelDAO add(ModelDAO model){return modelRepository.save(model);}
    @Override
    public ModelDAO getById(long id){
        Optional<ModelDAO> optionalCarModel = modelRepository.findById(id);
        ModelDAO model = optionalCarModel.isPresent() ? optionalCarModel.get() : new ModelDAO();
        return model;
    }
    @Override
    public ModelDAO getByName(String name){
        return modelRepository.getByName(name);
    }
    @Override
    public List<ModelDAO> getAll(){return modelRepository.findAll();}
    @Override
    public void remove() {modelRepository.deleteAll();}
}