package nucleusteq.com.grievanceManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nucleusteq.com.grievanceManagementSystem.entity.Users;

public interface UserRepo extends JpaRepository<Users,Integer>{

	String query = "select * from users where username=:username";
	@Query(value = query, nativeQuery = true)
	Users getByUserName(@Param("username") String username);
	
	
}
