package nucleusteq.com.grievanceManagementSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nucleusteq.com.grievanceManagementSystem.entity.Role;
import nucleusteq.com.grievanceManagementSystem.repository.RoleRepo;
import nucleusteq.com.grievanceManagementSystem.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	public RoleServiceImpl(RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}
	@Override
	public Role getRoleByName(String name) {
		return roleRepo.getRoleByName(name);
	}
	


}
