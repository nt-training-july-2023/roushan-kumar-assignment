package nucleusteq.com.grievanceManagementSystem.serviceImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import nucleusteq.com.grievanceManagementSystem.dto.UserDto;
import nucleusteq.com.grievanceManagementSystem.entity.Users;
import nucleusteq.com.grievanceManagementSystem.repository.UserRepo;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
	
	@MockBean
	private UserRepo userRepo;
	@InjectMocks
	private UsersServiceImpl userServiceImpl;
  
	@Test
	void authenticateWhenPasswordOrUsernameWorng()
	{
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
	void authenticateWhenPasswordOrUsernameCorrect()
	{
		UserDto userDto = new UserDto();
		
		Users tempUser = new Users();
		//5	"roushan559@gmail.com"	"Roushan"	1	"Kumar"	"123"	"roushan11"
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
}
