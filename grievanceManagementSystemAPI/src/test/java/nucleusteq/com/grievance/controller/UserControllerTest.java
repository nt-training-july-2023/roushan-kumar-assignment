package nucleusteq.com.grievance.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import nucleusteq.com.grievance.dto.AllUsersDto;
import nucleusteq.com.grievance.dto.ChangePassword;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
  
  private MockMvc mockMvc;
  @Mock
  private UserService userService;
  @Mock 
  private BindingResult errors;

  @InjectMocks
  private UsersController usersController;
  
  @BeforeEach
  public void setUp()
  {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
  }
  
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

  @Test
  public void testGetAllUser() throws Exception
  {
    List<AllUsersDto> allUsersdto = new ArrayList<AllUsersDto>();
    allUsersdto.add(new AllUsersDto(
        1,
        1,
        "roushan",
        "Roushan kumar",
        "email.example@nucleusteq.com",
        new Role(1, "Admin"),
        new Department(1, "HR")));

    Page<AllUsersDto> page = new PageImpl<>(allUsersdto);
    when(userService.getAllUser(0,1)).thenReturn(page);
    mockMvc.perform(get("/user/all")
            .param("offSet", "0")
            .param("pageSize", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").isArray())
            .andExpect(jsonPath("$.content[0].serialNumber").value(1))
            .andExpect(jsonPath("$.content[0].userId").value(1))
            .andExpect(jsonPath("$.content[0].email").value("email.example@nucleusteq.com"));
  }

  @Test
  public void testDeleteUserById() throws Exception
  {
    when(userService.deleteById(1)).thenReturn(true);
    
    ResponseEntity<?> response = usersController.deteleUser(1);
     System.out.println(response.getBody());
  }
  
  @Test
  public void testDeleteUserByIdUnsuccess() throws Exception
  {
    when(userService.deleteById(1)).thenReturn(false);
    
    ResponseEntity<?> response = usersController.deteleUser(1);
     System.out.println(response.getBody());
  }
}

