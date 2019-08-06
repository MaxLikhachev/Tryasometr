package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "select * from brands join brands_models on brands_models.brand_id=brands.id where brands_models.models_id =:modelID", nativeQuery = true)
    Brand getByModelId(long modelID);
}
