package su.vistar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import su.vistar.model.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer> {
	
	//UserDAO findByUsername(String username);

	@Query(value = "select * from user where username=:username", nativeQuery = true)
	UserDAO findByUsername(@Param("username") String username);

	@Query(value = "update user set phone=:phone, email=:email where username=:username", nativeQuery = true)
	UserDAO update(@Param("username") String username, @Param("phone") String phone, @Param("email") String email);
}