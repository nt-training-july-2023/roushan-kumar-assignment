package nucleusteq.com.grievance.serviceimpl;

import java.util.List;
import java.util.Optional;

import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.exception.InternalServerError;
import nucleusteq.com.grievance.exception.UserNotFoundException;
import nucleusteq.com.grievance.repository.UserRepo;
import nucleusteq.com.grievance.service.DepartmentService;
import nucleusteq.com.grievance.service.RoleService;
import nucleusteq.com.grievance.service.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;

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

  /**
   * Department Service.
   */
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
    //System.out.println(userDto.getRole().toString()
    //+ " " + userDto.getDepartment());
    Users tempUser = new Users();
    UserDto userSend = new UserDto();
    //try {
      tempUser.setUsername(userDto.getUsername());
      tempUser.setFullName(userDto.getFullName());
      tempUser.setEmail(userDto.getEmail());
      //save encrypted password
      //String encryptPass = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());
      byte[] encrypPassByte = Base64.getEncoder().encode(userDto.getPassword().getBytes(StandardCharsets.UTF_8));
      String encryptPass = new String(encrypPassByte,StandardCharsets.UTF_8);
      //System.out.println("EncryptePassword "+encryptPass);
      tempUser.setPassword(encryptPass);
      tempUser.setInitialPassword(1);
      Role role = roleService.getRoleByName(userDto.getRole().getName());
      if(role != null) {
        tempUser.setRole(role);
      } else {
        throw new BadRequestError("Role is not found");
      }
      Department dept = departmentService.getDepartmentByName(
          userDto.getDepartment().getDeptName());
      if (dept != null) {
      tempUser.setDepartment(dept);
      } else {
        throw new BadRequestError("Department is not found");
      }

      if (userRepo.getByUserName(userDto.getUsername()) != null) {
        throw new InternalServerError("Username is already exist.");
      }

      Users savedUser = userRepo.save(tempUser);

      userSend.setUserId(savedUser.getUserId());
      userSend.setUsername(savedUser.getUsername());
      userSend.setEmail(savedUser.getEmail());
      userSend.setFullName(savedUser.getFullName());
      userSend.setPassword(savedUser.getPassword());
      //userSend.setInitalPassword(savedUser.getInitialPassword());
      userSend.setRole(savedUser.getRole());
      userSend.setDepartment(savedUser.getDepartment());
    //} catch (Exception e) {
    //  System.out.println(e.getMessage());
    //}

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
      //System.out.println("pass "+tempUser.getPassword());
      byte[] decodedBytes = Base64.getDecoder().decode(tempUser.getPassword());
      String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
      //System.out.println("passMatch "+decodedString);
      if (
          tempUser.getUserId() != null
          &&
          decodedString.equals(userDto.getPassword())
      ) {
        return true;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }
	
  /**
   * Authenticate user is Admin.
   */
	public boolean authenticateIsAdmin(final UserDto userDto) {

  	
    try {
      Users tempUser;
      tempUser =  userRepo.getByUserName(userDto.getUsername());
      System.out.println("pass "+tempUser.getRole().getName());
      byte[] decodedBytes = Base64.getDecoder().decode(tempUser.getPassword());
      String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
      //System.out.println("passMatch "+decodedString);
      if (
          tempUser.getUserId() != null
          &&
          decodedString.equals(userDto.getPassword())
          &&
          tempUser.getRole().getName().equals("Admin")
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
      //save encrypted password
       // String encryptPass = Base64.getEncoder().encodeToString("root".getBytes());
        byte[] encryptPassByte = Base64.getEncoder().encode("root".getBytes(StandardCharsets.UTF_8));
        String encryptPass = new String(encryptPassByte,StandardCharsets.UTF_8);
        
        powerUser.setPassword(encryptPass);
        powerUser.setEmail("root.root@nucleus.com");
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

  /**
   * get user by username.
   *
   * @param username as string.
   */
  @Override
  public UserDto getByUsername(final String username) {
    UserDto userSend = new UserDto();
    Users user;
       user = userRepo.getByUserName(username);
       if (user == null) {
         throw new UserNotFoundException("User not found : " + username);
       }
       userSend.setUserId(user.getUserId());
       userSend.setUsername(user.getUsername());
       userSend.setEmail(user.getEmail());
       userSend.setFullName(user.getFullName());
       userSend.setPassword(user.getPassword());
       userSend.setInitalPassword(user.getInitialPassword());
       userSend.setRole(user.getRole());
       userSend.setDepartment(user.getDepartment());
       return userSend;

  }

 /**
 * get by id.
 */
@Override
public Users getById(final Integer userId) {
  Optional<Users> user = userRepo.findById(userId);
  if (user.isPresent()) {
   return user.get();
  }
  return null;
 }
}
