package su.vistar.service;

import su.vistar.entity.Model;
import su.vistar.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;
    //@Override
    public Model add(Model model){return modelRepository.save(model);}
    //@Override
    public Model getById(long id){
        Optional<Model> optionalCarModel = modelRepository.findById(id);
        Model model;
        if (optionalCarModel.isPresent()) model = optionalCarModel.get();
        else model = new Model();
        return model;
    }
    //@Override
    //public Model getByName(String name){
    //    return modelRepository.getByName(name);
    //}
    //@Override
    public List<Model> getAll(){return modelRepository.findAll();}
   // @Override
    public void remove() {modelRepository.deleteAll();}
}
