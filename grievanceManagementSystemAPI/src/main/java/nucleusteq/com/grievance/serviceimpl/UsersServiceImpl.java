package nucleusteq.com.grievance.serviceimpl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import nucleusteq.com.grievance.dto.AllUsersDto;
import nucleusteq.com.grievance.dto.ChangePassword;
import nucleusteq.com.grievance.dto.LoginDto;
import nucleusteq.com.grievance.dto.ResponseDto;
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

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * The UsersServiceImpl class provides methods for managing user accounts.
 * It allows you to create, retrieve, update, and delete user information.
 * This class encapsulates the business logic for user management.
 *
 * @author Roushan kumar
 */
@Service
public class UsersServiceImpl implements UserService {

  /**
   * Logger instance for the UsersServiceImpl class.
   */
  private static final Logger LOGGER = Logger.getLogger(UsersServiceImpl.class);
  /**
   * Autowire.
   */
  @Autowired
  private UserRepo userRepo;

  /**
   * Department Service instance.
   */
  private DepartmentService departmentService;

  /**
   * Role service instance.
   */
  private RoleService roleService;

  /**
   * User service implementation constructor.
   *
   * @param userRepoParam          userRepo .
   * @param roleServiceParam       roleService.
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
   * Get all users.
   */
  @Override
  public Page<AllUsersDto> getAllUser(
      final Integer offSet,
      final Integer pageSize) {
    try {
      AtomicInteger serialNumber = new AtomicInteger(pageSize * offSet + 1);
      LOGGER.info("fetching all users.");
      Page<Users> alluser;
      alluser = userRepo.findAll(PageRequest.of(
          offSet, pageSize).withSort(Sort.by("userId")));
      Page<AllUsersDto> allUsersDto = alluser.map((user) -> {
        AllUsersDto userDto = new AllUsersDto();
        userDto.setSerialNumber(serialNumber.getAndIncrement());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setRole(user.getRole());
        userDto.setDepartment(user.getDepartment());
        userDto.setUserId(user.getUserId());
        return userDto;
      });
      return allUsersDto;
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return null;
  }

  /**
   * Save a user.
   */
  @Override
  public UserDto save(final UserDto userDto) {
    Users tempUser = new Users();
    UserDto userSend = new UserDto();
    tempUser.setUsername(userDto.getUsername());
    tempUser.setFullName(userDto.getFullName());
    tempUser.setEmail(userDto.getEmail());
    byte[] encrypPassByte = Base64.getEncoder().encode(userDto.getPassword()
        .getBytes(StandardCharsets.UTF_8));
    String encryptPass = new String(encrypPassByte, StandardCharsets.UTF_8);
    tempUser.setPassword(encryptPass);
    tempUser.setInitialPassword(1);
    Role role = roleService.getRoleByName(userDto.getRole().getName());
    if (role != null) {
      tempUser.setRole(role);
    } else {
      throw new BadRequestError("Role is not found");
    }
    Department dept = departmentService
        .getDepartmentByName(userDto.getDepartment()
        .getDeptName());
    if (dept != null) {
      tempUser.setDepartment(dept);
    } else {
      throw new BadRequestError("Department is not found");
    }

    if (userRepo.getByUserName(userDto.getUsername()) != null) {
      throw new InternalServerError("Username is already exist.");
    }

    if (userRepo.getByEmail(userDto.getEmail()) != null) {
      throw new InternalServerError("Email is already exist.");
    }

    Users savedUser = userRepo.save(tempUser);

    userSend.setUserId(savedUser.getUserId());
    userSend.setUsername(savedUser.getUsername());
    userSend.setEmail(savedUser.getEmail());
    userSend.setFullName(savedUser.getFullName());
    userSend.setPassword(savedUser.getPassword());
    userSend.setRole(savedUser.getRole());
    userSend.setDepartment(savedUser.getDepartment());
    return userSend;
  }

  /**
   * Authenticate a user.
   */
  @Override
  public boolean authenticate(final LoginDto loginDto) {

    try {
      Users tempUser;
      tempUser = userRepo.getByUserName(loginDto.getUsername());
      if (tempUser.getUserId() != null
          && tempUser.getPassword().equals(loginDto.getPassword())) {
        return true;
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return false;
  }

  /**
   * Authenticate user is Admin.
   * @param userDto user.
   * @return Boolean is admin.
   */
  public boolean authenticateIsAdmin(
      final UserDto userDto) {
    try {
      Users tempUser;
      tempUser = userRepo.getByUserName(userDto.getUsername());
      byte[] decodedBytes = Base64.getDecoder().decode(tempUser.getPassword());
      String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
      if (tempUser.getUserId() != null
          && decodedString.equals(userDto.getPassword())
          && tempUser.getRole().getName().equals("Admin")) {
        return true;
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return false;
  }

  /**
   * Save a power user.
   */
  @Override
  public String savePowerUser(final Integer key) {
    Users powerUser = new Users();
    final Integer keyVal = 987;
    try {
      if (key.equals(keyVal)) {
        powerUser.setUsername("root_user");
        byte[] encryptPassByte = Base64.getEncoder()
            .encode("root".getBytes(StandardCharsets.UTF_8));
        String encryptPass = new String(encryptPassByte,
            StandardCharsets.UTF_8);

        powerUser.setPassword(encryptPass);
        powerUser.setEmail("root.root@nucleusteq.com");
        powerUser.setFullName("Power");
        powerUser.setInitialPassword(1);
        powerUser.setRole(roleService.getRoleByName("Admin"));
        powerUser.setDepartment(departmentService.getDepartmentByName("HR"));
        userRepo.save(powerUser);
        return "Power User Added";
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return "Unable to create power user";
  }

  /**
   * Get user by username.
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
    userSend.setInitialPassword(user.getInitialPassword());
    userSend.setRole(user.getRole());
    userSend.setDepartment(user.getDepartment());
    return userSend;

  }

  /**
   * Get user by user id.
   */
  @Override
  public Users getById(final Integer userId) {
    Optional<Users> user = userRepo.findById(userId);
    if (user.isPresent()) {
      return user.get();
    }
    return null;
  }

  /**
   * Change password.
   *
   * @param changePassword is object.
   * @return response.
   */
  @Override
  public ResponseDto changePassword(
      final ChangePassword changePassword) {

    if (changePassword.getUserId() == null) {
      throw new BadRequestError("User id is emppty");
    }

    Optional<Users> user = userRepo.findById(changePassword.getUserId());
    Users users;
    if (user.isPresent()) {
      users = user.get();
      byte[] encodeNewPassword = Base64.getEncoder()
          .encode(changePassword.getNewPassword()
              .getBytes(StandardCharsets.UTF_8));
      String newPassword = new String(encodeNewPassword,
          StandardCharsets.UTF_8);

      byte[] decodeOldPassword = Base64.getDecoder()
          .decode(users.getPassword());
      String oldPassword = new String(decodeOldPassword,
          StandardCharsets.UTF_8);

      if (oldPassword.equals(changePassword.getOldPassword())) {
        if (oldPassword.equals(changePassword.getNewPassword())) {
          return new ResponseDto(null,
              "New password should not same as old password.", "NOT_UPDATE");
        }
        users.setPassword(newPassword);
        users.setInitialPassword(0);
        userRepo.save(users);
        return new ResponseDto(changePassword.getUserId(),
            "New Password updated ", "UPDATE");
      } else {
        return new ResponseDto(null, "Old Password Not Match", "NOT_UPDATE");
      }
    }

    return new ResponseDto(null, "New Password not updated ", "NOT_UPDATE");
  }

  /**
   * Delete user by user id.
   *
   * @param userId
   */
  @Override
  public boolean deleteById(final Integer userId) {

    if (!userRepo.findById(userId).isPresent()) {
      throw new InternalServerError("User not found to perform delete.");
    } else {
      userRepo.deleteById(userId);
      return true;
    }
  }
}

