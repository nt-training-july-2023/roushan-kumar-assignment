package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.repository.DepartmentRepo;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class DepartmentSeviceImplTest {
  @MockBean
  private DepartmentRepo departmentRepo;

  @InjectMocks
  private DepartmentServiceImpl departmentServiceImpl;

  @Test
  public void getDepartmentByNameTest() {
    Department dept = new Department(1, "HR");
    when(departmentRepo.getDepartmentByName("HR")).thenReturn(dept);

    Department DeptReceived = departmentServiceImpl.getDepartmentByName("HR");
    //System.out.print(DeptReceived.toString());
    assertEquals(dept.getDeptId().toString(), DeptReceived.getDeptId().toString());
    assertEquals(dept.getDeptName().toString(), DeptReceived.getDeptName().toString());
  }

  @Test
  public void saveTest() {
    Department dept = new Department();
    dept.setDeptId(1);
    dept.setDeptName("HR");
    when(departmentRepo.save(dept)).thenReturn(dept);
    when(departmentRepo.isAdmin(1,"password")).thenReturn(1);

    Department DeptReceived = departmentServiceImpl.save(dept);
    System.out.print(DeptReceived.getDeptName());
    assertEquals(dept.getDeptId().toString(), DeptReceived.getDeptId().toString());
    assertEquals(dept.getDeptName().toString(), DeptReceived.getDeptName().toString());
  }
  
  @Test
  public void testGetDepartmentByNameException()
  {
 // Arrange
    String departmentName = "Non Existent Department";
    when(departmentRepo.getDepartmentByName(departmentName)).thenThrow(new RuntimeException("Department not found"));

    // Act
    Department resultDepartment = departmentServiceImpl.getDepartmentByName(departmentName);

    // Assert
    assertNull(resultDepartment);
  }

 
  
  //department already exist
  @Test
  public void saveUnsuccess()
  {
  	 Integer userId = 2;
     Department department = new Department(1,"HR");
  	when(departmentRepo.isAdmin(userId,"password")).thenReturn(1);
    when(departmentRepo.getDepartmentByName("HR")).thenReturn(department);
     // Act and Assert
     assertThrows(BadRequestError.class, () -> {
         departmentServiceImpl.save( department);
     });
     verify(departmentRepo, never()).save(department);
  }
  
  @Test
  public void deleteUnsuccess()
  {
  	Integer deptId = 1;
  	Integer userId = 2;
  	when(departmentRepo.isAdmin(userId,"password")).thenReturn(-1);
    // Act and Assert
    assertThrows(BadRequestError.class, () -> {
        departmentServiceImpl.delete(userId,"password", deptId);
    });
    verify(departmentRepo, never()).deleteById(deptId);
  }
  
  @Test
  public void deleteSuccess()
  {
  	Integer deptId = 1;
  	Integer userId = 2;
  	when(departmentRepo.isAdmin(userId,"password")).thenReturn(1);
  	departmentServiceImpl.delete(userId,"password", deptId);
    verify(departmentRepo,times(1)).deleteById(deptId);
  }
  
  @Test
  public void getAllDepartmentTest()
  {
  	List<Department> departments = java.util.Arrays.asList(
  			new Department(1,"HR"),
  			new Department(2,"MARKETING")
  			);
  	when(departmentRepo.findAll()).thenReturn(departments);
  	
  	List<Department> tempDepatments = departmentServiceImpl.getAllDepartment();
  	assertEquals(departments,tempDepatments);
  }
  
  
  
  
}
