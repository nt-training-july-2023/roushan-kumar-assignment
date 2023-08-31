package nucleusteq.com.grievance.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.service.UserService;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
	 @Mock
	 private UserService userService;
   @InjectMocks
   private AdminController adminController;
   
   @Test
	void testCreatePowerUser()
	{
		
		final int keyVal = 987;
		
    when(userService.savePowerUser(keyVal)).thenReturn("Power User Added");
    
    String powerUserReceived = adminController.createPowerUser(keyVal);;
    
    assertEquals("Power User Added", powerUserReceived);
    
	}
	
}

