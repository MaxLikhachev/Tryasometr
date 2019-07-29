package su.vistar.repository;

import org.springframework.stereotype.Repository;
import su.vistar.model.dao.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CarRepository extends JpaRepository<CarDAO, Long> {
    //@Query(value = "select * from user_car where user_id=:user_id", nativeQuery = true)
    //List<CarDAO> findAllById(long user_id);
}
