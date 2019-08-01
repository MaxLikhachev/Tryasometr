package su.vistar.repository;

import org.springframework.stereotype.Repository;
import su.vistar.model.dao.BrandDAO;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BrandRepository extends JpaRepository<BrandDAO, Long> {
    //@Query(value = "select * from brands where name=:name", nativeQuery = true)
    //BrandDAO getByName(@Param("name") String name);
}
