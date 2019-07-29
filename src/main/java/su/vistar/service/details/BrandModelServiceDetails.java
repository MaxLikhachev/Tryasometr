package su.vistar.service.details;

import su.vistar.model.dao.BrandModelDAO;
import su.vistar.repository.BrandModelRepository;
import su.vistar.service.BrandModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandModelServiceDetails implements BrandModelService {
    @Autowired
    private BrandModelRepository brandModelRepository;
    @Override
    public BrandModelDAO add(BrandModelDAO brandModel){return brandModelRepository.save(brandModel);}
    @Override
    public BrandModelDAO getByModelID(long id){
        Optional<BrandModelDAO> optionalCarMark = brandModelRepository.findById(id);
        BrandModelDAO brandModel = optionalCarMark.isPresent() ? optionalCarMark.get() : new BrandModelDAO();
        return brandModel;}
    @Override
    public List<BrandModelDAO> getAllByID(long model_id){ return brandModelRepository.findAllById(model_id); }
    @Override
    public void remove(){ brandModelRepository.deleteAll();}
}
