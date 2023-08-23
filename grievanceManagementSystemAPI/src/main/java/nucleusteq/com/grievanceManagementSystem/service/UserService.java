package nucleusteq.com.grievanceManagementSystem.service;

import java.util.List;

import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;


public interface UserService {
	
	 List<Users> getAllUser();
	 Users save(Users user);
	 Users login(UserDto userDto);
	 boolean authenticate(UserDto userDto);
}
