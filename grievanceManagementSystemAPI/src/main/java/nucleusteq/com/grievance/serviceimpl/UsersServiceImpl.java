package nucleusteq.com.grievanceManagementSystem.serviceImpl;

import java.util.Arrays;
import java.util.List;
import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.repository.UserRepo;
import nucleusteq.com.grievanceManagementSystem.service.RoleService;
import nucleusteq.com.grievanceManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UserService {
  @Autowired
  private UserRepo userRepo;

  private RoleService roleService;

  public UsersServiceImpl(UserRepo userRepo, RoleService roleService) {
    super();
    this.userRepo = userRepo;
    this.roleService = roleService;
  }

  @Override
  public List<Users> getAllUser() {
    try {
      return userRepo.findAll();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  @Override
  public UserDto save(UserDto userDto) {
    Users tempUser = new Users();
    UserDto userSend = new UserDto();
    try {
      tempUser.setUsername(userDto.getUsername());
      tempUser.setFirstName(userDto.getFirstName());
      tempUser.setLastName(userDto.getLastName());
      tempUser.setEmail(userDto.getEmail());
      tempUser.setPassword(userDto.getPassword());
      tempUser.setInitalPassword(1);
      tempUser.setRole(Arrays.asList(roleService.getRoleByName("Admin")));
      Users savedUser = userRepo.save(tempUser);
      userSend.setUserId(savedUser.getUserId());
      userSend.setFirstName(savedUser.getFirstName());
      userSend.setLastName(savedUser.getLastName());
      userSend.setPassword(savedUser.getPassword());
      userSend.setInitalPassword(savedUser.getInitalPassword());
      userSend.setRole(savedUser.getRole());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return userSend;
  }

  @Override
  public Users login(UserDto userDto) {
    Users tempUser = new Users();

    try {
      tempUser = userRepo.getByUserName(userDto.getUsername());
      if (
        tempUser.getUserId() != null &&
        tempUser.getPassword().equals(userDto.getPassword())
      ) {
        //				if (tempUser.getPassword().equals(userDto.getPassword())) {
        //					return tempUser;
        //				}
        return tempUser;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
  

  @Override
  public boolean authenticate(UserDto userDto) {
    Users tempUser = new Users();

    try {
      tempUser = userRepo.getByUserName(userDto.getUsername());
      if (
        tempUser.getUserId() != null &&
        tempUser.getPassword().equals(userDto.getPassword())
      ) {
        //if (tempUser.getPassword().equals(userDto.getPassword())) {
        //return true;
        //}
        return true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  @Override
  public String savePowerUser(int key) {
    Users powerUser = new Users();
    try {
      if (key == 987) {
        powerUser.setUsername("root");
        powerUser.setPassword("root");
        powerUser.setEmail("root@nucleus.com");
        powerUser.setFirstName("Power");
        powerUser.setLastName("User");
        powerUser.setInitalPassword(1);
        powerUser.setRole(Arrays.asList(roleService.getRoleByName("Admin")));
        userRepo.save(powerUser);
        return "Power User Added";
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "unable to create power user";
  }
}
