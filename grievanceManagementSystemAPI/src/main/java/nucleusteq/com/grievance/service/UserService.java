package nucleusteq.com.grievanceManagementSystem.service;

import java.util.List;
import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;

/**
 * @author roush
 * @version 1.0.0
 */

public interface UserService {
  List<Users> getAllUser();

  UserDto save(UserDto userDto);

  String savePowerUser(int key);

  Users login(UserDto userDto);

  boolean authenticate(UserDto userDto);
}
