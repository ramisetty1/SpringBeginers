package it.telecom.Ccc_Auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.telecom.Ccc_Auth.entity.User;
import java.util.List;
import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);
	
	@Query(value = "select * from users where email= :emailId and password= :pwd", nativeQuery = true)
	Optional<User> dbLoginWithQuery(@Param("emailId") String email, @Param("pwd") String password);
	
	
	

}
