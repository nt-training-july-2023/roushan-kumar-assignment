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

    userDto.setUsername("testUser");
    assertEquals("testUser", userDto.getUsername());

    userDto.setFullName("Roushan Kumar");
    assertEquals("Roushan Kumar", userDto.getFullName());

    userDto.setEmail("roushan.kumar@example.com");
    assertEquals("roushan.kumar@example.com", userDto.getEmail());

    userDto.setPassword("password123");
    assertEquals("password123", userDto.getPassword());

    userDto.setInitalPassword(123456);
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
}

