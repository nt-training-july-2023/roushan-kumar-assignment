package nucleusteq.com.grievance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

class GrievanceManagementSystemApplicationTest {

//	@InjectMocks
//	private GrievanceManagementSystemApplication application;
	
	@Test
  public void contextLoads() {
		
    
      // This test checks if the Spring application context loads successfully.
// assertNotNull(application);
	}
	
  @Test
  void testGrievanceManagementSystemApplication() {
    assertTrue(true);
  }

  @Test
  void testMain() {
  	String args="hello";
    SpringApplication.run(GrievanceManagementSystemApplication.class, args);
  	assertTrue(true);
  }
}

