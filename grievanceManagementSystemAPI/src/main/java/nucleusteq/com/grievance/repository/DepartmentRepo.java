package nucleusteq.com.grievance.repository;

import nucleusteq.com.grievance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Department repository.
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

  String GET_DEPARTMENT_BY_NAME = "select * from department where dept_name=:name";

  @Query(value = GET_DEPARTMENT_BY_NAME, nativeQuery = true)
  Department getDepartmentByName(@Param("name") String name);

  String IS_ADMIN = "select count(user_id) from users where user_id=:userId";
  @Query(value = IS_ADMIN , nativeQuery = true )
  int isAdmin(@Param("userId") Integer userId);
  
}

