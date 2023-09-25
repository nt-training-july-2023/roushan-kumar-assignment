package nucleusteq.com.grievance.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import nucleusteq.com.grievance.dto.ChangePassword;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
  @Mock
  private UserService userService;
  @Mock 
  private BindingResult errors;

  @InjectMocks
  private UsersController usersController;
  
  @Test
  public void saveUserTest()
  {
    UserDto userDto = new UserDto();
    BindingResult errors = new  BeanPropertyBindingResult(null, null);
    userDto.setUserId(1);
    userDto.setUsername("Roushan559");
    userDto.setPassword("123");
    userDto.setFullName("Roushan Kumar");
    userDto.setEmail("roushan@gmail.com");
    userDto.setDepartment(new Department(1,"HR"));
    userDto.setRole(new Role(1,"Admin"));
    when(userService.save(userDto)).thenReturn(userDto);

    ResponseEntity<?> res = usersController.saveUser(userDto,errors );
    
    System.out.println(res.toString());

  }
  @Test
  public void saveUserTestEmptyFields()
  {
    UserDto userDto = new UserDto();
    BindingResult errors = new  BeanPropertyBindingResult(null, null);
    ObjectError error = new ObjectError("email","Email Filed required");
    errors.addError(error);
    userDto.setUserId(1);
    userDto.setUsername("Roushan559");
    userDto.setPassword("123");
    userDto.setFullName("Roushan Kumar");
    userDto.setDepartment(new Department(1,"HR"));
    userDto.setRole(new Role(1,"Admin"));

    ResponseEntity<?> res = usersController.saveUser(userDto,errors );
    
    System.out.println(res.getBody());
    if(res.getBody().equals("Fields required"))
     assertTrue(true);

  }
 
  @Test
  public void testChangePassword() {
    ChangePassword changePassword = new ChangePassword();
    changePassword.setUserId(1); 
    changePassword.setOldPassword("oldPassword"); 
    changePassword.setNewPassword("newPassword"); 
    
    ResponseDto response = new ResponseDto("Passwrod changed", "UPDATE");
    
    when(userService.changePassword(changePassword)).thenReturn(response);
    
    ResponseDto response2 =  usersController.changePassword(changePassword);
    
    assertEquals(response2, response);
  }
  
  @Test
  public void testGetByUsername()
  {
    UserDto userDto = new UserDto();
    userDto.setUserId(1);
    userDto.setUsername("Roushan559");
    userDto.setPassword("123");
    userDto.setFullName("Roushan Kumar");
    userDto.setEmail("roushan@gmail.com");
    userDto.setDepartment(new Department(1,"HR"));
    userDto.setRole(new Role(1,"Admin"));
    when(userService.getByUsername("Roushank559")).thenReturn(userDto);
    
    UserDto user = usersController.getUserByUsername("Roushank559");
    
    assertEquals(userDto.getUsername(), user.getUsername());
    
  }
}

