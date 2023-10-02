package nucleusteq.com.grievance.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginDtoTest {
  
 private LoginDto loginDto;
 
 @BeforeEach
 public void setUp() {
   loginDto = new LoginDto("roushank559","password");
 }
 
 @Test
 public void testToString() {
   String loginDtoToString = "LoginDto [username=roushank559, password=password]";
   assertEquals(loginDtoToString, loginDto.toString());
 }
 
}

