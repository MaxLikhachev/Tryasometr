package su.vistar.service;

import org.springframework.stereotype.Service;
import su.vistar.entity.Brand;

import java.util.List;


@Service
public interface BrandService {
    Brand add(Brand brand);

    Brand getById(long id);

    List<Brand> getAll();

    Brand edit(Brand brand);

    void delete(Brand brand);
}
