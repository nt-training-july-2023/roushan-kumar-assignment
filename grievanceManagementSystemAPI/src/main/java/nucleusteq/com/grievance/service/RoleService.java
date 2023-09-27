package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.Role;

/**
 * Role Service.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

public interface RoleService {

  /**
   * Get role by role type.
   *
   * @param name role type.
   * @return role.
   */
  Role getRoleByName(String name);

  /**
   * Get all role.
   *
   * @return all role.
   */
   List<Role> getAllRole();
}
