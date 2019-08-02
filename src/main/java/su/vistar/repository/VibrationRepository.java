package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.vistar.entity.Section;
import su.vistar.entity.Vibration;

@Repository
public interface VibrationRepository extends JpaRepository<Vibration, Long> {
    //@Query(value = "select * from brands where name=:name", nativeQuery = true)
    //Brand getByName(@Param("name") String name);
}
