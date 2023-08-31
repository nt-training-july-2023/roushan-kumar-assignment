package nucleusteq.com.grievance.controller;

import java.util.List;
import javax.validation.Valid;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.service.UserService;
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
 * UserController.
 *
 * @author roush
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/user")
public class UsersController {

  /**
   * userService interface.
   */
  @Autowired
  private UserService userService;

  /**
   * UserController.
   *
   * @param userServiceParam userservice.
   *
   *
   *
   */
  public UsersController(final UserService userServiceParam) {
    super();
    this.userService = userServiceParam;
  }

  /**
   * Get all users.
   *
   * @return all users.
   */
  @GetMapping("/all")
  public List<Users> getAllUsers() {
    return userService.getAllUser();
  }

  /**
   * save user.
   *
   * @param userDto userDto.
   * @param errors BindingResult error.
   * @return response.
   */
  @PostMapping("/save")
  public ResponseEntity<?> saveUser(
      @RequestBody @Valid final UserDto userDto,
      final BindingResult errors) {
    // return ResponseEntity.ok(userService.save(userDto));
    if (errors.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body("Fields required");
    }
    try {
      return ResponseEntity.ok(userService.save(userDto));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}
