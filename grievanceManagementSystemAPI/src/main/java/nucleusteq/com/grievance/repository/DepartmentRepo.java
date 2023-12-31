package nucleusteq.com.grievance.repository;

import nucleusteq.com.grievance.entity.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Department repository.
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

  /**
   * get department name.
   */
  String GET_DEPARTMENT_BY_NAME = "select * from department "
      + "where dept_name=:name";

  /**
   * department name.
   *
   * @param name department name.
   * @return department name.
   */
  @Query(value = GET_DEPARTMENT_BY_NAME, nativeQuery = true)
  Department getDepartmentByName(@Param("name") String name);

  /**
   * Is admin.
   */
  String IS_ADMIN = "select count(user_id)"
      + "from users where user_id=:userId and password=:password";

  /**
   * is admin.
   *
   * @param userId user id.
   * @param password password.
   * @return 1 or 0.
   */
  @Query(value = IS_ADMIN, nativeQuery = true)
  int isAdmin(@Param("userId") Integer userId,
              @Param("password") String password);

  /**
   * Get department with page size.
   */
  String GET_DEPARTMENT_WITH_PAGESIZE = "select DISTINCT * from department"
  + " order by dept_id ASC "
  + "OFFSET :offSet rows fetch next :pageSize rows only ";

  /**
   * List of department with page size.
   *
   * @param offSet
   * @param pageSize
   * @return List of department with page size.
   */
   @Query(value = GET_DEPARTMENT_WITH_PAGESIZE, nativeQuery = true)
   List<Department> findAllWithPageSize(
       Integer offSet,
       Integer pageSize);
}
