package nucleusteq.com.grievance.controller;

import javax.validation.Valid;

import nucleusteq.com.grievance.dto.AllUsersDto;
import nucleusteq.com.grievance.dto.ChangePassword;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(UsersController.class);

  /**
   * Class variable.
   */
  @Autowired
  private UserService userService;

  /**
   * UserController.
   *
   * @param userServiceParam userservice.
   */
  public UsersController(final UserService userServiceParam) {
    super();
    this.userService = userServiceParam;
  }

  /**
   * Get all users.
   *
   * @param offSet
   * @param pageSize
   * @return All users.
   */
  @GetMapping("/all")
  public Page<AllUsersDto> getAllUsers(
      @RequestParam(name = "offSet") final int offSet,
      @RequestParam(name = "pageSize") final int pageSize
      ) {
    LOGGER.info("Fetching all users.");
    return userService.getAllUser(offSet, pageSize);
  }

  /**
   * Save a user.
   *
   * @param userDto userDto.
   * @param errors BindingResult error.
   * @return Response.
   */
  @PostMapping("/admin/save")
  public ResponseEntity<?> saveUser(
      @RequestBody @Valid final UserDto userDto,
      final BindingResult errors) {
    if (errors.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body(errors.getAllErrors());
    }

    if (userService.save(userDto) != null) {
    ResponseDto response = new ResponseDto(1, "New user created", "SAVE");
    LOGGER.info("Saving new user.");
    return ResponseEntity.ok(response);
    } else {
      ResponseDto response = new ResponseDto(0, "User not created", "NOT_SAVE");
      return ResponseEntity.ok(response);
    }

  }

  /**
   * Find by username.
   *
   * @param username username to find.
   * @return User.
   */
  @GetMapping("/byUsername/{username}")
  public UserDto getUserByUsername(
      @PathVariable("username") final String username) {
    return userService.getByUsername(username);
  }

  /**
   * Change password.
   *
   * @param changePassword object.
   * @return Response.
   */
  @PutMapping("/changepassword")
  public ResponseDto changePassword(
      @RequestBody final ChangePassword changePassword) {
      return userService.changePassword(changePassword);
  }

  /**
   * Delete a particular user.
   *
   * @param userId
   * @return Response
   */
  @DeleteMapping("/admin/delete/{userId}")
  public ResponseEntity<?> deteleUser(
      @PathVariable("userId") final Integer userId) {
    boolean result = userService.deleteById(userId);
    if (result) {
      LOGGER.info("Deleting a user.");
      return ResponseEntity.ok(new ResponseDto(1,
          "User deleted successfully.", "DELETE"));
    }
    return ResponseEntity.ok(new ResponseDto(0,
        "Unable to delete user.", "NOT_DELETE"));
  }
}
