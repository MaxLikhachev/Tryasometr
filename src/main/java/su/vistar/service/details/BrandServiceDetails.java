package su.vistar.service.details;

import su.vistar.repository.BrandRepository;
import su.vistar.model.dao.BrandDAO;
import su.vistar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceDetails implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public BrandDAO add(BrandDAO mark){return brandRepository.save(mark);}
    @Override
    public BrandDAO getById(long id){
        Optional<BrandDAO> optionalCarMark = brandRepository.findById(id);
        BrandDAO mark = optionalCarMark.isPresent() ? optionalCarMark.get() : new BrandDAO();
        return mark;
    }
    @Override
    public List<BrandDAO> getAll(){return brandRepository.findAll();}
    @Override
    public void remove() {brandRepository.deleteAll();}
    @Override
    public BrandDAO getByName(String name){return brandRepository.getByName(name);}
}
