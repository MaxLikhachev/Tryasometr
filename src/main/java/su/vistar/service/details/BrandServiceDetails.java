package su.vistar.service.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.entity.Brand;
import su.vistar.repository.BrandRepository;
import su.vistar.service.BrandService;

import java.util.List;
import java.util.Optional;
@Service
public class BrandServiceDetails implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(long id) {
        Optional<Brand> optionalCarBrand = brandRepository.findById(id);
        Brand brand = optionalCarBrand.isPresent() ? optionalCarBrand.get() : new Brand();
        return brand;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand edit(Brand brand) {
        return brandRepository.saveAndFlush(brand);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }
}
