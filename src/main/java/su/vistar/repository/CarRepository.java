package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    //@Query(value = "select * from user_car where user_id=:user_id", nativeQuery = true)
    //List<Car> findAllById(long user_id);
}
