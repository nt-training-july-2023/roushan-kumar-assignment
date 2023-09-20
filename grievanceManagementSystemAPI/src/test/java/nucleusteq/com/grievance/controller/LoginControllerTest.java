package nucleusteq.com.grievance.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

/**
 * Login Controller Test class.
 */

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import nucleusteq.com.grievance.dto.UserDto;
import nucleusteq.com.grievance.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {
	 @Mock
	 private UserService userService;
   @InjectMocks
  private LoginController loginController;

  @org.junit.jupiter.api.Test
  public void testAuthenticateUser() throws Exception {
    
    UserDto userDto2 = new UserDto();
    userDto2.setUsername("root");
    userDto2.setPassword("root");
    userDto2.setUserId(1);
    
    when(userService.authenticate(userDto2)).thenReturn(true);


    ResponseEntity<?> res = loginController.authenticateUser(userDto2);
    System.err.println(res.getBody());
    boolean result = false;
    if(res.getBody().equals("User login successfully!."))
    {
      result=true;
    }
    assertTrue(result);
  }

  @org.junit.jupiter.api.Test
  public void testAuthenticateWorngUser() throws Exception {
    //prepare a userDto for the request body.
    UserDto userDto = new UserDto();
    userDto.setUsername("roott");
    userDto.setPassword("roott");
    //mock the behavior of service.
    when(userService.authenticate(userDto)).thenReturn(false);


    ResponseEntity<?> res = loginController.authenticateUser(userDto);
    System.err.println(res.getBody());
    boolean result = false;
    if(res.getBody().equals("Invalid credential"))
    {
      result=true;
    }
    assertTrue(result);
  }

}
