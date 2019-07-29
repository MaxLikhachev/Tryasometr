package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.vistar.model.dao.UserCarDAO;

import java.util.List;
@Repository
public interface UserCarRepository extends JpaRepository<UserCarDAO, Long> {
    @Query(value = "select * from user_car where user_id=:user_id", nativeQuery = true)
    List<UserCarDAO> findAllById(long user_id);


}
