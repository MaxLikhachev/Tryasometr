package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import su.vistar.model.entity.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUsername(@Param("username") String username);
}