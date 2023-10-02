package nucleusteq.com.grievance.controller;

import nucleusteq.com.grievance.dto.LoginDto;
import nucleusteq.com.grievance.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * login controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(LoginController.class);

  /**
  * Autowired.
  */
  @Autowired
  private UserService userService;

  /**
   * Authenticate a User.
   *
   * @param loginDto Requestbody
   * @return response
   */
  @PostMapping("login/authorization")
  public ResponseEntity<?> authenticateUser(@RequestBody
      final LoginDto loginDto) {
    if (userService.authenticate(loginDto)) {
      LOGGER.info("Login.");
      return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Invalid credential", HttpStatus.OK);
    }
  }
}
