package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.repository.RoleRepo;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class RoleServiceImplTest {
  @MockBean
  private RoleRepo roleRepo;
  
  @InjectMocks
  private RoleServiceImpl roleServiceImpl;
  
  @Test
  public void getRoleByNameTest()
  {
  	Role role = new Role(1,"Admin");
  	when(roleRepo.getRoleByName("Admin")).thenReturn(role);
  	
  	Role roleReceievd = roleServiceImpl.getRoleByName("Admin");
  	System.out.print(roleReceievd.toString());
  	assertEquals(role.getRoleId().toString(),roleReceievd.getRoleId().toString());
  	assertEquals(role.getName().toString(),roleReceievd.getName().toString());
  	
  	
  }
  
}

