package nucleusteq.com.grievance.controller;

import nucleusteq.com.grievance.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Admin Controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  /**
   * Logger instance for the TicketServiceImpl class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(AdminController.class);

  /**
  * Class variables.
  */
  @Autowired
  private UserService userService;

  /**
  * Admin Controller constructor.
  *
  * @param userServiceParam UserService as interface.
  */
  public AdminController(final UserService userServiceParam) {
    super();
    this.userService = userServiceParam;
  }

  /**
   * Create a power user.
   *
   * @param key key as a integer
   * @return string.
   */
  @PutMapping("/create/poweruser/{key}")
  public String createPowerUser(@PathVariable final Integer key) {
    LOGGER.info("Creating a power user.");
    return userService.savePowerUser(key);
  }
}
