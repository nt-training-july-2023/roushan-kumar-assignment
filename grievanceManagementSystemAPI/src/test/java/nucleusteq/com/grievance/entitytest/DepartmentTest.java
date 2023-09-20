package nucleusteq.com.grievance.entitytest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.Department;

public class DepartmentTest {

  @Test
  public void testEqualsAndHashCode() {
      
      Department department1 = new Department(1, "HR");
      Department department2 = new Department(1, "HR");

      
      assertTrue(department1.equals(department2));
      assertTrue(department2.equals(department1));
      
      assertNotEquals(department1, null);

      
      assertEquals(department1.hashCode(), department2.hashCode());
  }

  @Test
  public void testNotEquals() {
     
      Department department1 = new Department(1, "HR");
      Department department2 = new Department(2, "IT");

      // Test equals method
      assertFalse(department1.equals(department2));
      assertFalse(department2.equals(department1));
  }
}

