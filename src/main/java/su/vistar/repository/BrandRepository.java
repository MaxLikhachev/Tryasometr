package su.vistar.repository;

import org.springframework.stereotype.Repository;
import su.vistar.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    //@Query(value = "select * from brands where name=:name", nativeQuery = true)
    //Brand getByName(@Param("name") String name);
}
