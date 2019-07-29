package su.vistar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.vistar.model.dao.ModelDAO;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ModelRepository extends JpaRepository<ModelDAO, Long> {
    @Query(value = "select * from model where name=:name", nativeQuery = true)
    ModelDAO getByName(String name);
}
