package su.vistar.repository;

import org.springframework.stereotype.Repository;
import su.vistar.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    //@Query(value = "select * from models where name=:name", nativeQuery = true)
    //Model getByName(String name);
}
