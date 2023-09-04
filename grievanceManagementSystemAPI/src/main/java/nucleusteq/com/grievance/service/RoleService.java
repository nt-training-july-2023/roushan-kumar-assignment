package nucleusteq.com.grievance.service;

import java.util.List;

import nucleusteq.com.grievance.entity.Role;

/**
 * RoleService.
 *
 * @author roush
 * @version 1.0.0
 */

public interface RoleService {

  /**
   * get role by role type.
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
