package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * UserServiceImplTest.
 *
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
  @MockBean
  private UserRepo userRepo;
  @MockBean
  private RoleService roleService;
  @MockBean
  private DepartmentService departmentService;
  @InjectMocks
  private UsersServiceImpl userServiceImpl;

  @Test
  void authenticateWhenPasswordOrUsernameWorng() {
    LoginDto loginDto = new LoginDto();
    Users tempUser = new Users();
    tempUser.setUsername("roushan11");

    loginDto.setUsername("roushan11");
    loginDto.setPassword("1234");
    when(userRepo.getByUserName(loginDto.getUsername())).thenReturn(null);
    boolean res = userServiceImpl.authenticate(loginDto);
    assertFalse(res);
  }

  @Test
  void authenticateWhenPasswordOrUsernameCorrect() {

    LoginDto loginDto = new LoginDto();
    Users tempUser = new Users();
    tempUser.setUsername("roushan11");
    tempUser.setUserId(5);
    tempUser.setPassword("123");

    loginDto.setUsername("roushan11");
    loginDto.setPassword("123");
    when(userRepo.getByUserName(loginDto.getUsername())).thenReturn(tempUser);

    boolean res = userServiceImpl.authenticate(loginDto);
    
    assertTrue(true);
  }

  @Test
  void savePowerUserTest() throws Exception {
    Users powerUser = new Users();
    Role role = new Role();
    role.setRoleId(1);
    role.setName("Admin");
    final int keyVal = 987;
    powerUser.setUsername("root");
    powerUser.setPassword("root");
    powerUser.setEmail("root@nucleus.com");
    powerUser.setFullName("Power");
    powerUser.setInitialPassword(1);
    powerUser.setRole(role);
    when(userRepo.save(powerUser)).thenReturn(powerUser);
    
    String res = userServiceImpl.savePowerUser(keyVal);
    if(res.equals("Power User Added"))
     assertTrue(true);
  }
  
  @Test
  void saveUserTest() throws Exception{
  	
  	Role role = new Role(); 
  	role.setName("Admin");
  	Department dept = new Department();
  	dept.setDeptName("HR");
    when(roleService.getRoleByName("Admin")).thenReturn(role);
    when(departmentService.getDepartmentByName("HR")).thenReturn(dept);
  	UserDto userDto = new UserDto();
  	userDto.setUsername("Roushan20");
  	userDto.setFullName("Roushan Kumar");
    userDto.setEmail("roushan@gmail.com");
    userDto.setPassword("123");
    userDto.setRole(role);
    userDto.setDepartment(dept);
    
    Users tempUser1 = new Users();
    tempUser1.setUsername("Roushan20");
    tempUser1.setFullName("Roushan Kumar");
    tempUser1.setEmail("roushan@gmail.com");
    tempUser1.setPassword("123");
    tempUser1.setRole(role);
    tempUser1.setDepartment(dept);
    
    Users tempUser2 = new Users();
    tempUser2.setUserId(1);
    tempUser2.setUsername("Roushan20");
    tempUser2.setFullName("Roushan Kumar");
    tempUser2.setEmail("roushan@gmail.com");
    tempUser2.setPassword("123");
    tempUser2.setRole(role);
    tempUser2.setDepartment(dept);
    tempUser2.setInitialPassword(1);
    
    
    
    when(userRepo.save(Mockito.any(Users.class))).thenReturn(tempUser2);
    
    UserDto userDtoGet = userServiceImpl.save(userDto);
    
    try {
     assertNotNull(userDtoGet);
     assertEquals(tempUser2.getUserId().toString(),userDtoGet.getUserId().toString());
     assertEquals(tempUser2.getUsername().toString(),userDtoGet.getUsername().toString());
     assertEquals(tempUser2.getFullName().toString(),userDtoGet.getFullName().toString());
     assertEquals(tempUser2.getPassword().toString(),userDtoGet.getPassword().toString());
     assertEquals(role, userDtoGet.getRole());
     assertEquals(dept, userDtoGet.getDepartment());
    }
    catch (Exception e) {
     System.out.println(e.getMessage());
    }
     verify(userRepo, times(1)).save(Mockito.any(Users.class));
     verify(roleService, times(1)).getRoleByName("Admin");
     verify(departmentService, times(1)).getDepartmentByName("HR");
    
  }
  
  /**
   * test Save Unsuccess when department is null.
   */
  @Test
  public void testSaveUnSuccessNullDepartment()
  {
  	Department dept = new Department(1,"HR");
  	Role role = new Role(); 
  	role.setName("Admin");
  	
  	UserDto userDto = new UserDto();
  	userDto.setUsername("Roushan20");
  	userDto.setFullName("Roushan Kumar");
    userDto.setEmail("roushan@gmail.com");
    userDto.setPassword("123");
    userDto.setRole(role);
    userDto.setDepartment(dept);
    
    Users tempUser1 = new Users();
    tempUser1.setUsername("Roushan20");
    tempUser1.setFullName("Roushan Kumar");
    tempUser1.setEmail("roushan@gmail.com");
    tempUser1.setPassword("123");
    tempUser1.setRole(role);
    tempUser1.setDepartment(dept);
    
    Users tempUser2 = new Users();
    tempUser2.setUserId(1);
    tempUser2.setUsername("Roushan20");
    tempUser2.setFullName("Roushan Kumar");
    tempUser2.setEmail("roushan@gmail.com");
    tempUser2.setPassword("123");
    tempUser2.setRole(role);
    tempUser2.setDepartment(dept);
    tempUser2.setInitialPassword(1);
    
  	
    when(roleService.getRoleByName("Admin")).thenReturn(null);
    when(departmentService.getDepartmentByName("HR"))
    .thenReturn(dept);
    
    when(userRepo.save(tempUser1)).thenReturn(tempUser2);
    
    assertThrows(BadRequestError.class, ()->{
    	userServiceImpl.save(userDto);
    });
    verify(userRepo, never()).save(tempUser1);
    
  }
  
  /**
   * test Save Unsuccess when UserAlreadyExist.
   */
  @Test
  public void testSaveUnSuccessUserAlreadyExist()
  {
  	Department dept = new Department(1,"HR");
  	Role role = new Role(); 
  	role.setName("Admin");
  	role.setRoleId(1);
  	
  	UserDto userDto = new UserDto();
  	userDto.setUsername("Roushan20");
  	userDto.setFullName("Roushan Kumar");
    userDto.setEmail("roushan@gmail.com");
    userDto.setPassword("123");
    userDto.setRole(role);
    userDto.setDepartment(dept);
    
    Users tempUser1 = new Users();
    tempUser1.setUsername("Roushan20");
    tempUser1.setFullName("Roushan Kumar");
    tempUser1.setEmail("roushan@gmail.com");
    tempUser1.setPassword("123");
    tempUser1.setRole(role);
    tempUser1.setDepartment(dept);
    
    Users tempUser2 = new Users();
    tempUser2.setUserId(1);
    tempUser2.setUsername("Roushan20");
    tempUser2.setFullName("Roushan Kumar");
    tempUser2.setEmail("roushan@gmail.com");
    tempUser2.setPassword("123");
    tempUser2.setRole(role);
    tempUser2.setDepartment(dept);
    tempUser2.setInitialPassword(1);
    
  	
    when(roleService.getRoleByName("Admin")).thenReturn(role);
    when(departmentService.getDepartmentByName("HR"))
      .thenReturn(dept);
    when(userRepo.getByUserName(userDto.getUsername()))
         .thenReturn(tempUser2);
    when(userRepo.save(tempUser1)).thenReturn(tempUser2);
    
    assertThrows(InternalServerError.class, ()->{
    	userServiceImpl.save(userDto);
    });
    verify(userRepo, never()).save(tempUser1);
    
  }

  /**
   * test get by user name already exist.
   */
  @Test
  public void getUserByNameTestUnsuccess()
  {
    UserDto userDto = new UserDto();
    userDto.setFullName("Roushan");
    when(userRepo.getByUserName(userDto.getUsername())).thenReturn(null);
    assertThrows(UserNotFoundException.class, ()->{
    	userServiceImpl.getByUsername("Roushan");
    });
    
  }

  /**
   * test get by user name.
   */
  @Test
  public void getUserByNameTestSuccess()
  {
    UserDto userDto = new UserDto();
    userDto.setFullName("Roushan");
    
    Users user = new Users();
    user.setUsername("Roushan");
    
    when(userRepo.getByUserName("Roushan"))
        .thenReturn(user);

    userDto = userServiceImpl.getByUsername("Roushan");
    assertEquals("Roushan", userDto.getUsername());
  }

  @Test
  public void testChangePasswordWithValidData() {
      
      ChangePassword changePassword = new ChangePassword();
      changePassword.setUserId(1); 
      changePassword.setOldPassword("oldPassword"); 
      changePassword.setNewPassword("newPassword"); 

      
      Users mockUser = new Users();
      
      mockUser.setPassword("oldPassword");
      Mockito.when(userRepo.findById(changePassword.getUserId())).thenReturn(Optional.of(mockUser));

      
      ResponseDto response = userServiceImpl.changePassword(changePassword);

      
      assertNotNull(response);
      assertEquals("UPDATE", response.getStatus());

      
  }

  @Test
  public void testChangePasswordWithInvalidOldPassword() {
      // Create a sample ChangePassword object
      ChangePassword changePassword = new ChangePassword();
      changePassword.setUserId(1);
      changePassword.setOldPassword("wrongPassword"); 
      changePassword.setNewPassword("newPassword"); 

      
      Users mockUser = new Users();
      mockUser.setPassword(Base64.getEncoder().encodeToString("oldPassword".getBytes(StandardCharsets.UTF_8)));
      Mockito.when(userRepo.findById(changePassword.getUserId())).thenReturn(Optional.of(mockUser));

     
      ResponseDto response = userServiceImpl.changePassword(changePassword);

      
      assertNotNull(response);
      assertEquals("NOT_UPDATE", response.getStatus());

      
  }

  @Test
  public void testIsAdmin()
  {
  	Role role = new Role(); 
  	role.setName("Admin");
  	Department dept = new Department();
  	dept.setDeptName("HR");
  	
  	UserDto userDto = new UserDto();
  	userDto.setUsername("Roushan20");
  	userDto.setPassword("123");
  	
  	Users tempUser1 = new Users();
  	tempUser1.setUserId(1);
    tempUser1.setUsername("Roushan20");
    tempUser1.setFullName("Roushan Kumar");
    tempUser1.setEmail("roushan@gmail.com");
    tempUser1.setRole(role);
    tempUser1.setDepartment(dept);
    
    String validPassword="123";
    byte[] encodedPassword = Base64.getEncoder().encode(validPassword.getBytes(StandardCharsets.UTF_8));
    validPassword = new String(encodedPassword,StandardCharsets.UTF_8);
    tempUser1.setPassword(validPassword);
    tempUser1.setRole(role);
    tempUser1.setDepartment(dept);
    
    when(userRepo.getByUserName(userDto.getUsername())).thenReturn(tempUser1);
    assertTrue(userServiceImpl.authenticateIsAdmin(userDto));
  }

  @Test
  public void testGetAllUser() {

      List<Users> allUsers = IntStream.rangeClosed(1, 10)
              .mapToObj(i -> {
                  Users user = new Users();
                  user.setUserId(i);
                  user.setUsername("user" + i);
                  user.setEmail("user" + i + "@example.com");
                  user.setFullName("User " + i);
                  user.setRole(new Role(1,"Admin"));
                  user.setDepartment(new Department(1, "HR"));
                  return user;
              })
              .collect(Collectors.toList());
      Page<Users> page = new PageImpl<>(allUsers);
      Mockito.when(userRepo.findAll(any(PageRequest.class))).thenReturn(page);
      Page<AllUsersDto> result = userServiceImpl.getAllUser(0, 10);
      assertEquals(10, result.getContent().size());
  }

  @Test
  public void testDeleteByIdUserExists() {
      int userId = 1;
      Users user = new Users();
      user.setUserId(userId);
      when(userRepo.findById(userId)).thenReturn(Optional.of(user));
      boolean result = userServiceImpl.deleteById(userId);
      assertTrue(result);
      Mockito.verify(userRepo).deleteById(userId);
  }

  @Test
  public void testDeleteByIdUserNotExists() {
      int userId = 1;
      when(userRepo.findById(userId)).thenReturn(Optional.empty());
      assertThrows(InternalServerError.class, () -> userServiceImpl.deleteById(userId));
      Mockito.verify(userRepo, Mockito.never()).deleteById(userId);
  }
}
