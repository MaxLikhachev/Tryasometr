package su.vistar.service;

import su.vistar.repository.BrandRepository;
import su.vistar.model.dao.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandService{
    @Autowired
    private BrandRepository brandRepository;
    //@Override
    public BrandDAO add(BrandDAO brand){return brandRepository.save(brand);}
    //@Override
    public BrandDAO getById(long id){
        Optional<BrandDAO> optionalCarBrand = brandRepository.findById(id);
        BrandDAO brand = optionalCarBrand.isPresent() ? optionalCarBrand.get() : new BrandDAO();
        return brand;
    }
    //@Override
    public List<BrandDAO> getAll(){return brandRepository.findAll();}
    //@Override
    public BrandDAO edit(BrandDAO brand){return brandRepository.saveAndFlush(brand);}
    //@Override
    public void delete(BrandDAO brand) {brandRepository.delete(brand);}
    //@Override
    //public BrandDAO getByName(String name){return brandRepository.getByName(name);}
}
