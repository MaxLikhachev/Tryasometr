package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    //@Query(value = "select * from models where name=:name", nativeQuery = true)
    //Model getByName(String name);
}
