package nucleusteq.com.grievanceManagementSystem.controller;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.service.RoleService;
import nucleusteq.com.grievanceManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UsersController {
	@Autowired
	private UserService userService;
	private RoleService roleService;
	public UsersController(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	@GetMapping("/all")
	public List<Users> getAllUsers()
	{
		return userService.getAllUser();
	}
	@PostMapping("/save")
	public Users saveUser(@RequestBody UserDto userDto)
	{
		Users tempUser = new Users();
		tempUser.setUsername(userDto.getUsername());
		tempUser.setFirstName(userDto.getFirstName());
		tempUser.setLastName(userDto.getLastName());
		tempUser.setEmail(userDto.getEmail());
		tempUser.setPassword(userDto.getPassword());
		tempUser.setInitalPassword(1);
		tempUser.setRole(Arrays.asList(roleService.getRoleByName("Admin")));
		return userService.save(tempUser);
	}

}
