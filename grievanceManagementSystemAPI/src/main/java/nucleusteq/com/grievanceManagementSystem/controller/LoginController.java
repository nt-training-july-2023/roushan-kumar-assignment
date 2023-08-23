package nucleusteq.com.grievanceManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.service.UserService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private UserService userService;
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/login/authorization/data")
	public  Users login(@RequestBody UserDto userDto)
	{
		return userService.login(userDto);
	}
	
	@PostMapping("login/authorization")
	public ResponseEntity<?> authenticateUser(@RequestBody UserDto userDto)
	{
		boolean auth =  userService.authenticate(userDto);
		if(auth==true)
			return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
		else
			return new ResponseEntity<>("Invalid credantial", HttpStatus.OK);
	}
	
}
