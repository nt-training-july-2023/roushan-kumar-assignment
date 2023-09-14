package nucleusteq.com.grievance.controller;

import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * loginController.
 *
 * @author roush
 * @version 1.0.0
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

  /**
  * Autowired.
  */
  @Autowired
  private UserService userService;

  /**
   * authenticalUser.
   *
   * @param userDto Requestbody
   * @return response
   */
  @PostMapping("login/authorization")
  public ResponseEntity<?> authenticateUser(@RequestBody
      final UserDto userDto) {
    if (userService.authenticate(userDto)) {
      return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Invalid credantial", HttpStatus.OK);
    }
  }
}
