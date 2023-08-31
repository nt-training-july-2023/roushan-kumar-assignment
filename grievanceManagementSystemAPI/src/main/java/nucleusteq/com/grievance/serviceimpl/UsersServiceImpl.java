package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.repository.UserRepo;
import nucleusteq.com.grievance.service.DepartmentService;
import nucleusteq.com.grievance.service.RoleService;
import nucleusteq.com.grievance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * userServiceImpl class.
 *
 */
@Service
public class UsersServiceImpl implements UserService {

  /**
   * Autowire.
   */
  @Autowired
  private UserRepo userRepo;
  private DepartmentService departmentService;

  /**
   * role servie is class.
   */
  private RoleService roleService;

  /**
   * user service impl.
   *
   * @param userRepoParam userRepo .
   * @param roleServiceParam roleService.
   * @param departmentServiceParam Department service class.
   */
  public UsersServiceImpl(
      final UserRepo userRepoParam,
      final RoleService roleServiceParam,
      final DepartmentService departmentServiceParam) {
    super();
    this.userRepo = userRepoParam;
    this.roleService = roleServiceParam;
    this.departmentService = departmentServiceParam;
  }

  /**
   * Get all user.
   */
  @Override
  public List<Users> getAllUser() {
    try {
      return userRepo.findAll();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  /**
   * save user.
   */
  @Override
  public UserDto save(final UserDto userDto) {
    //System.out.println(userDto.toString());
    //System.out.println(userDto.getEmail() +" "+ userDto.getDepartment());
    Users tempUser = new Users();
    UserDto userSend = new UserDto();
    try {
      tempUser.setUsername(userDto.getUsername());
      tempUser.setFullName(userDto.getFullName());
      tempUser.setEmail(userDto.getEmail());
      tempUser.setPassword(userDto.getPassword());
      tempUser.setInitialPassword(1);
      tempUser.setRole(roleService.getRoleByName(userDto.getRole().getName()));
      tempUser.setDepartment(departmentService.getDepartmentByName(
          userDto.getDepartment().getDeptName()));
      Users savedUser = userRepo.save(tempUser);

      userSend.setUserId(savedUser.getUserId());
      userSend.setUsername(savedUser.getUsername());
      userSend.setEmail(savedUser.getEmail());
      userSend.setFullName(savedUser.getFullName());
      userSend.setPassword(savedUser.getPassword());
      userSend.setInitalPassword(savedUser.getInitialPassword());
      userSend.setRole(savedUser.getRole());
      userSend.setDepartment(savedUser.getDepartment());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return userSend;
  }

  /**
   * Authenticate user.
   */
  @Override
  public boolean authenticate(final UserDto userDto) {

    try {
      Users tempUser;
      tempUser =  userRepo.getByUserName(userDto.getUsername());
      if (
          tempUser.getUserId() != null
          &&
          tempUser.getPassword().equals(userDto.getPassword())
      ) {
        return true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  /**
   * save power user.
   */
  @Override
  public String savePowerUser(final int key) {
    Users powerUser = new Users();
    final int keyVal = 987;
    try {
      if (key == keyVal) {
        powerUser.setUsername("root");
        powerUser.setPassword("root");
        powerUser.setEmail("root@nucleus.com");
        powerUser.setFullName("Power");
        powerUser.setInitialPassword(1);
        powerUser.setRole(roleService.getRoleByName("Admin"));
        userRepo.save(powerUser);
        return "Power User Added";
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "unable to create power user";
  }
}
