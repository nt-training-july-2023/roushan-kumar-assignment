package nucleusteq.com.grievance.repository;

import nucleusteq.com.grievance.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserRepo interface.
 *
 */
public interface UserRepo extends JpaRepository<Users, Integer> {

  /**
   * get user by username.
   */
  String GET_USER_BY_USERNAME = "select * from users where username=:username";

  /**
   * get user by username.
   *
   * @param username is string.
   * @return user.
   */
  @Query(value = GET_USER_BY_USERNAME, nativeQuery = true)
  Users getByUserName(@Param("username") String username);

   /**
    * get user by email.
    */
   String GET_USER_BY_EMAIL = "select * from users where email=:email";

   /**
    * get user by email.
    *
    * @param email is string.
    * @return user.
    */
   @Query(value = GET_USER_BY_EMAIL, nativeQuery = true)
   Users getByEmail(@Param("email") String email);
   

}
