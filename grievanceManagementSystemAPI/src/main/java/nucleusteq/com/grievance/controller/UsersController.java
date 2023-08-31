package nucleusteq.com.grievanceManagementSystem.controller;

import java.util.List;
import javax.validation.Valid;
import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author roush
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/user")
public class UsersController {
	@Autowired
	private UserService userService;

	/**
	 * @param userService userservice
	 * @param roleService roleservice
	 */
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
		
	}

	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return userService.getAllUser();
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDto userDto, BindingResult errors) {
		// return ResponseEntity.ok(userService.save(userDto));
		if (errors.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fields required");
		}
		try {
			return ResponseEntity.ok(userService.save(userDto));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
