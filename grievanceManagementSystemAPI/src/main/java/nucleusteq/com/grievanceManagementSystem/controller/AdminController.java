package nucleusteq.com.grievanceManagementSystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.service.RoleService;
import nucleusteq.com.grievanceManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	private RoleService roleService;
	public AdminController(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@PutMapping("/create/poweruser/{key}")
	public String createPowerUser(@PathVariable int key)
	{
		Users powerUser = new Users();
		try {
			if(key==987) {
				powerUser.setUsername("root");
				powerUser.setPassword("root");
				powerUser.setEmail("root@nucleus.com");
				powerUser.setFirstName("Power");
				powerUser.setLastName("User");
				powerUser.setInitalPassword(1);
				powerUser.setRole(Arrays.asList(roleService.getRoleByName("Admin")));
				userService.save(powerUser);
				return "Power User Added";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "unable to create power user";
	}
	
	

}
