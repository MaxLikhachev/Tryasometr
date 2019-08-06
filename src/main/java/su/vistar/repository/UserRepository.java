package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import su.vistar.entity.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

    //UserData findByUsername(String username);

    @Query(value = "select * from users where username=:username", nativeQuery = true)
    UserData findByUsername(@Param("username") String username);

    @Query(value = "update users set phone=:phone, email=:email where username=:username", nativeQuery = true)
    UserData update(@Param("username") String username, @Param("phone") String phone, @Param("email") String email);
}