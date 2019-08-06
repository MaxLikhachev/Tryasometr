package su.vistar.service.details;

import org.springframework.stereotype.Service;
import su.vistar.model.entity.Brand;
import su.vistar.repository.BrandRepository;
import su.vistar.service.BrandService;

import java.util.List;
@Service
public class BrandServiceDetails implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceDetails(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(long id) {
        return brandRepository.findById(id).orElseGet(Brand::new);
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

    @Override
    public Brand getByModelId(long modelID) {
        return brandRepository.getByModelId(modelID);
    }
}
