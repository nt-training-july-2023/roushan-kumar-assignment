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
    assertEquals(new Integer(123456), userDto.getInitalPassword());

    Role role = new Role(); // Create a Role instance for testing
    userDto.setRole(role);
    assertEquals(role, userDto.getRole());

    Department department = new Department(); // Create a Department instance for testing
    userDto.setDepartment(department);
    assertEquals(department, userDto.getDepartment());
  }

  @Test
  public void testNoArgsConstructor() {
    UserDto userDto = new UserDto();

    // Verify that the userDto object is not null
    assertNotNull(userDto);

    // Verify that all fields of the userDto object are initialized to default values (null or 0)
    assertNull(userDto.getUserId());
    assertNull(userDto.getUsername());
    assertNull(userDto.getFullName());
    assertNull(userDto.getEmail());
    assertNull(userDto.getPassword());
    assertNull(userDto.getInitalPassword());
    assertNull(userDto.getRole());
    assertNull(userDto.getDepartment());
  }

//  @Test
//  public void testParameterizedConstructor() {
//    Role role = new Role(); // Create a Role instance for testing
//    Department department = new Department(); // Create a Department instance for testing
//
//    UserDto userDto = new UserDto(
//      1,
//      "testUser",
//      "Roushan kumar",
//      "roushan.kumar@example.com",
//      "password123",
//      123456,
//      role,
//      department
//    );
//
//    // Verify that the userDto object is not null
//    assertNotNull(userDto);
//
//    // Verify that the fields of the userDto object are correctly initialized with the provided values
//    assertEquals(new Integer(1), userDto.getUserId());
//    assertEquals("testUser", userDto.getUsername());
//    assertEquals("Roushan kumar", userDto.getFullName());
//    assertEquals("roushan.kumar@example.com", userDto.getEmail());
//    assertEquals("password123", userDto.getPassword());
//    assertEquals(new Integer(123456), userDto.getInitalPassword());
//    assertEquals(role, userDto.getRole());
//    assertEquals(department, userDto.getDepartment());
//  }
}

