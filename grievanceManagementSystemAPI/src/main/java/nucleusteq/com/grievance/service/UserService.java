package nucleusteq.com.grievance.service;

import java.util.List;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Users;

/**
 * userService Interface.
 *
 * @author roush
 * @version 1.0.0
 */

public interface UserService {

  /**
   * get all user.
   *
   * @return All user.
   */
  List<Users> getAllUser();

  /**
  * save user.
  *
  * @param userDto userDto Class.
  * @return response.
  */
  UserDto save(UserDto userDto);

  /**
   * save power user.
   *
   * @param key secret key.
   * @return string
   */
  String savePowerUser(int key);

  /**
   * Authenticate user.
   *
   * @param userDto is class
   * @return boolean
   */
  boolean authenticate(UserDto userDto);

  /**
   * get user by username.
   *
   * @param username as string
   * @return
   */
  UserDto getByUsername(String username);

  /*
   * 
   */
  Users getById(Integer userId);
}
