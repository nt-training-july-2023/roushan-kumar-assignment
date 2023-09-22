package nucleusteq.com.grievance.controller;

import nucleusteq.com.grievance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminController.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  /**
  * userservice class.
  */
  @Autowired

  private UserService userService;

  /**
  * AdminController.
  *
  * @param userServiceParam userService as interface.
  */
  public AdminController(final UserService userServiceParam) {
    super();
    this.userService = userServiceParam;
  }

  /**
   * createPowerUser.
   *
   * @param key key as a integer
   * @return string.
   */
  @PutMapping("/create/poweruser/{key}")
  public String createPowerUser(@PathVariable final int key) {
    return userService.savePowerUser(key);
  }
}
