package nucleusteq.com.grievance.repository;

import nucleusteq.com.grievance.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * RoleRepo interface.
 *
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {

  /**
   * get role by name.
   */
  String GET_ROLE_BY_NAME = "select * from role where name=:name";

  /**
   * get role by name.
   *
   * @param name name is string.
   * @return role
   */
  @Query(value = GET_ROLE_BY_NAME, nativeQuery = true)
  Role getRoleByName(@Param("name") String name);
}
