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

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.repository.DepartmentRepo;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class DepartmentSeviceImplTest {
  @MockBean
  private DepartmentRepo departmentRepo;
  
  @InjectMocks
  private DepartmentServiceImpl departmentServiceImpl;
  
  @Test
  public void getDepartmentByNameTest()
  {
  	Department dept = new Department(1,"HR");
  	when(departmentRepo.getDepartmentByName("HR")).thenReturn(dept);
  	
  	Department DeptReceived = departmentServiceImpl.getDepartmentByName("HR");
  	//System.out.print(DeptReceived.toString());
  	assertEquals(dept.getDeptId().toString(),DeptReceived.getDeptId().toString());
  	assertEquals(dept.getDeptName().toString(),DeptReceived.getDeptName().toString());
  	
  }
  
  @Test
  public void saveTest()
  {
  	Department dept = new Department();
  	dept.setDeptId(1);
  	dept.setDeptName("HR");
  	when(departmentRepo.save(dept)).thenReturn(dept);
  	when(departmentRepo.isAdmin(1)).thenReturn(1);
  	
  	Department DeptReceived = departmentServiceImpl.save(1,dept);
  	System.out.print(DeptReceived.getDeptName());
  	assertEquals(dept.getDeptId().toString(),DeptReceived.getDeptId().toString());
  	assertEquals(dept.getDeptName().toString(),DeptReceived.getDeptName().toString());
  	
  }
}

