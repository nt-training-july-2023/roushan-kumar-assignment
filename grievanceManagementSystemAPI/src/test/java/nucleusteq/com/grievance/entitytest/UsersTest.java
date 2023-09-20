package nucleusteq.com.grievance.entitytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.entity.Users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {
  private Users user;
  private Users user1;
  private Users user2;
  private Users user3;

  @BeforeEach
  public void setUp() {
      // Initialize a Users object for testing
      user = new Users(
          "testuser",
          "Test User",
          "testuser@example.com",
          "password",
          12345,
          new Role(1,"Admin"),
          new Department(1,"HR")
      );
      user.setUserId(1);

      // Create three user objects with the same attributes
      user1 = new Users("user1", "User One", "user1@example.com", "password1", 123, null, null);
      user2 = new Users("user1", "User One", "user1@example.com", "password1", 123, null, null);
      user3 = new Users("user2", "User Two", "user2@example.com", "password2", 456, null, null);
  }

  @Test
  public void testGetters() {
  	
      assertEquals(new Integer(1), user.getUserId());
      assertEquals("testuser", user.getUsername());
      assertEquals("Test User", user.getFullName());
      assertEquals("testuser@example.com", user.getEmail());
      assertEquals("password", user.getPassword());
      assertEquals(new Integer(12345), user.getInitialPassword());
      assertNotNull(user.getRole());
      assertNotNull(user.getDepartment());
  }

  @Test
  public void testSetters() {
      user.setUserId(2);
      user.setUsername("newusername");
      user.setFullName("New User");
      user.setEmail("newuser@example.com");
      user.setPassword("newpassword");
      user.setInitialPassword(67890);
      
      // Create new Role and Department objects for testing
      Role newRole = new Role(1,"Admin");
      Department newDepartment = new Department(1,"HR");
      user.setRole(newRole);
      user.setDepartment(newDepartment);

      assertEquals(new Integer(2), user.getUserId());
      assertEquals("newusername", user.getUsername());
      assertEquals("New User", user.getFullName());
      assertEquals("newuser@example.com", user.getEmail());
      assertEquals("newpassword", user.getPassword());
      assertEquals(new Integer(67890), user.getInitialPassword());
      assertEquals(newRole, user.getRole());
      assertEquals(newDepartment, user.getDepartment());
  }

  @Test
  public void testToString() {
      String expectedToString = "Users [userId=1, username=testuser, fullName=Test User, email=testuser@example.com, password=password, initialPassword=12345, role=Role [roleId=1, name=Admin], department=Department [deptId=1, deptName=HR]]";
      
      assertEquals(expectedToString, user.toString());
  }

  @Test
  public void testConstructors() {
      Users newUser = new Users(
          "newuser",
          "New User",
          "newuser@example.com",
          "newpassword",
          67890,
          new Role(1,"Admin"),
          new Department(1,"HR")
      );

      assertEquals("newuser", newUser.getUsername());
      assertEquals("New User", newUser.getFullName());
      assertEquals("newuser@example.com", newUser.getEmail());
      assertEquals("newpassword", newUser.getPassword());
      assertEquals(new Integer(67890), newUser.getInitialPassword());
      assertNotNull(newUser.getRole());
      assertNotNull(newUser.getDepartment());

      Users newUserWithoutId = new Users(
          "newuser2",
          "New User 2",
          "newuser2@example.com",
          "newpassword2",
          98765,
          new Role(1,"Admin"),
          new Department(1,"HR")
      );
      // As the ID is not specified in the constructor.
      assertNull(newUserWithoutId.getUserId());
  }

  @Test
  public void testHashCode() {
      // Hash code of user1 and user2 should be the same
      assertEquals(user1.hashCode(), user2.hashCode());

      // Hash code of user1 and user3 should be different
      assertNotEquals(user1.hashCode(), user3.hashCode());
  }

  @Test
  public void testEquals() {
      // user1 should be equal to user2 (same attributes)
      assertTrue(user1.equals(user2));

      // user1 should not be equal to user3 (different username and email)
      assertFalse(user1.equals(user3));

      // user1 should not be equal to a null object
      assertFalse(user1.equals(null));

      // user1 should not be equal to an object of a different class
      assertFalse(user1.equals(user));
  }

}
