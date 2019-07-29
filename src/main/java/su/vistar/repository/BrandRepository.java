package su.vistar.repository;

import org.springframework.stereotype.Repository;
import su.vistar.model.dao.BrandDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface BrandRepository extends JpaRepository<BrandDAO, Long> {
    @Query(value = "select * from brand where name=:name", nativeQuery = true)
    BrandDAO getByName(@Param("name") String name);
}
