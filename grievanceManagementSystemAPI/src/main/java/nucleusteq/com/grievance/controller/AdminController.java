package nucleusteq.com.grievanceManagementSystem.controller;

import nucleusteq.com.grievanceManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
  @Autowired
  private UserService userService;


  public AdminController(UserService userService) {
    super();
    this.userService = userService;
  }

  @PutMapping("/create/poweruser/{key}")
  public String createPowerUser(@PathVariable int key) {
    return userService.savePowerUser(key);
  }
}
