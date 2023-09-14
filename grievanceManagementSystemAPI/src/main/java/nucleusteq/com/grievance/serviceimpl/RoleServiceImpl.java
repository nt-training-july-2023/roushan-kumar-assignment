package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.repository.RoleRepo;
import nucleusteq.com.grievance.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl.
 *
 * @author roushan
 */
@Service
public class RoleServiceImpl implements RoleService {
  /**
   * variables.
   */
  @Autowired
  private RoleRepo roleRepo;

  /**
   * RoleService Impl.
   *
   * @param roleRepoParam roleRepo class.
   */
  public RoleServiceImpl(final RoleRepo roleRepoParam) {
    super();
    this.roleRepo = roleRepoParam;
  }

  /**
   * get role by role type.
   *
   *@param nameParam roleType.
   */
  @Override
  public Role getRoleByName(final String nameParam) {
    return roleRepo.getRoleByName(nameParam);
  }

  /**
   * list of roles.
   */
  @Override
  public List<Role> getAllRole() {
    return roleRepo.findAll();
  }
}
