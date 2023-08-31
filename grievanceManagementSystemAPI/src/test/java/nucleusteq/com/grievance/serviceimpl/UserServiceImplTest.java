package nucleusteq.com.grievance.serviceimpl;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.repository.DepartmentRepo;
import nucleusteq.com.grievance.repository.RoleRepo;
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
    UserDto userDto = new UserDto();
    Users tempUser = new Users();
    tempUser.setUsername("roushan11");

    userDto.setUsername("roushan11");
    userDto.setPassword("1234");
    when(userRepo.getByUserName(userDto.getUsername())).thenReturn(null);
    boolean res = userServiceImpl.authenticate(userDto);
    assertFalse(res);
  }

  @Test
  void authenticateWhenPasswordOrUsernameCorrect() {

    UserDto userDto = new UserDto();
    Users tempUser = new Users();
    tempUser.setUsername("roushan11");
    tempUser.setUserId(5);
    //tempUser.setEmail("roushan559@gmail.com");
    //tempUser.setFirstName("Roushan");
    //tempUser.setInitalPassword(1);
    //tempUser.setLastName("kumar");
    tempUser.setPassword("123");

    userDto.setUsername("roushan11");
    userDto.setPassword("123");
    when(userRepo.getByUserName(userDto.getUsername())).thenReturn(tempUser);

    boolean res = userServiceImpl.authenticate(userDto);
    assertTrue(res);
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
    System.out.println("user dto get "+userDtoGet.toString());
    //if(tempUser2.getUserId()==userDtoGet.getUserId())
    //	assertTrue(true);
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
  
  
}
