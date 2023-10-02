package nucleusteq.com.grievance.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;

public class UserDtoTest {
  private UserDto userDto;

  @BeforeEach
  public void setUp() {
    userDto = new UserDto();
  }

  @Test
  public void testGetterAndSetterMethods() {
    userDto.setUserId(1);
    assertEquals(new Integer(1), userDto.getUserId());

    userDto.setUsername("Roushan");
    assertEquals("Roushan", userDto.getUsername());

    userDto.setFullName("Roushan Kumar");
    assertEquals("Roushan Kumar", userDto.getFullName());

    userDto.setEmail("roushan.kumar@example.com");
    assertEquals("roushan.kumar@example.com", userDto.getEmail());

    userDto.setPassword("password123");
    assertEquals("password123", userDto.getPassword());

    userDto.setInitialPassword(123456);
    assertEquals(new Integer(123456), userDto.getInitialPassword());

    // Create a Role instance for testing
    Role role = new Role();
    userDto.setRole(role);
    assertEquals(role, userDto.getRole());

    // Create a Department instance for testing
    Department department = new Department();
    userDto.setDepartment(department);
    assertEquals(department, userDto.getDepartment());
  }

  @Test
  public void testNoArgsConstructor() {
    UserDto userDto = new UserDto();

    // Verify that the userDto object is not null
    assertNotNull(userDto);

    assertNull(userDto.getUserId());
    assertNull(userDto.getUsername());
    assertNull(userDto.getFullName());
    assertNull(userDto.getEmail());
    assertNull(userDto.getPassword());
    assertNull(userDto.getInitialPassword());
    assertNull(userDto.getRole());
    assertNull(userDto.getDepartment());
  }
  
  
  @Test
  public void testToString() {
      // Create a UserDto object with sample data
      UserDto userDto = new UserDto();
      userDto.setUserId(1);
      userDto.setUsername("Roushan");
      userDto.setFullName("John Doe");
      userDto.setEmail("johndoe@example.com");
      userDto.setPassword("password123");
      userDto.setInitialPassword(123456);
     
      userDto.setRole(new Role());
      userDto.setDepartment(new Department());

     
      
      String expectedToString = "UserDto [userId=1, username=Roushan, fullName=John Doe, email=johndoe@example.com, password=password123, initalPassword=123456, role=Role [roleId=null, name=null], department=Department [deptId=null, deptName=null]]";

      
      assertEquals(expectedToString, userDto.toString());
  }

 
}

