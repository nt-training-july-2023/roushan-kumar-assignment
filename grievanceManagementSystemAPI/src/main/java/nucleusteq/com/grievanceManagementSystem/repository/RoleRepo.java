package nucleusteq.com.grievanceManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nucleusteq.com.grievanceManagementSystem.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	String query = "select * from role where name=:name";
	@Query(value = query, nativeQuery = true)
	Role getRoleByName(@Param("name") String name);

}
