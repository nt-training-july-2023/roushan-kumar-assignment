package nucleusteq.com.grievance.service;

import java.util.List;

import org.springframework.data.domain.Page;

import nucleusteq.com.grievance.dto.ChangePassword;
import nucleusteq.com.grievance.dto.LoginDto;
import nucleusteq.com.grievance.dto.ResponseDto;
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
   * @param pageSize 
   * @param offSet 
   *
   * @return All user.
   */
  Page<UserDto> getAllUser(Integer offSet, Integer pageSize);

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
  String savePowerUser(Integer key);

  /**
   * Authenticate user.
   *
   * @param loginDto is class
   * @return boolean
   */
  boolean authenticate(LoginDto loginDto);

  /**
   * get user by username.
   *
   * @param username as string
   * @return user.
   */
  UserDto getByUsername(String username);

  /**
   * Return user by user id.
   *
   * @param userId id of user.
   * @return user.
   */
  Users getById(Integer userId);

  /**
   * Authenticate user is admin or not.
   *
   * @param user username and password.
   * @return true if admin else return false.
   */
  boolean authenticateIsAdmin(UserDto user);

  /**
   * To change password.
   *
   * @param changePassword it contains old and new password.
   * @return response.
   */
  ResponseDto changePassword(ChangePassword changePassword);
}
