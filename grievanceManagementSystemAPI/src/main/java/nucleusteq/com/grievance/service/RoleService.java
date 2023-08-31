package nucleusteq.com.grievance.service;

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
}
