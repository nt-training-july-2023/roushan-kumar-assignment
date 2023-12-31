package nucleusteq.com.grievance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.service.RoleService;

/**
 * Role controller.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {

  /**
   * RoleService.
   */
  @Autowired
  private RoleService roleService;

  /**
   * Get all role.
   *
   * @return return all roles.
   */
  @GetMapping("/all")
  public List<Role> getAllRole() {
    return roleService.getAllRole();
  }
}
