package nucleusteq.com.grievance.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import nucleusteq.com.grievance.dto.DepartmentDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class DepartmentControllertTest {
  private MockMvc mockMvc;

  @InjectMocks
  private DepartmentController departmentController;

  @Mock
  private DepartmentService departmentService;

  @BeforeEach
  public void setUp() {
  	System.out.println("setUp() method executed");
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
  }

  @Test
  public void testGetAllDepartment() throws Exception {
    
    List<DepartmentDto> departmentsDto = Arrays.asList(
        new DepartmentDto(1,1, "Department 1"),
        new DepartmentDto(2,2, "Department 2")
      );

    when(departmentService.getAllDepartment(0,2)).thenReturn(departmentsDto);

    // Perform a GET request to the "/department/all" endpoint
    mockMvc
      .perform(get("/department/all?offSet=0&pageSize=2"))
      
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$[0].deptId").value(1))
      .andExpect(jsonPath("$[0].deptName").value("Department 1"))
      .andExpect(jsonPath("$[1].deptId").value(2))
      .andExpect(jsonPath("$[1].deptName").value("Department 2"));

    
    verify(departmentService, times(1)).getAllDepartment(0,2);
    verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void testSaveDepartment() throws Exception {
    
    Department department = new Department(1, "Department 1");

    
    when(departmentService.save(any(Department.class))).thenReturn(department);

   
    mockMvc
      .perform(
        post("/department/admin/save/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"deptId\": 1, \"deptName\": \"Department 1\"}")
          .header("password","password")
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.deptId").value(1))
      .andExpect(jsonPath("$.deptName").value("Department 1"));

    
    verify(departmentService, times(1)).save(any(Department.class));
    verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void testDeleteDepartment() throws Exception {
    
    mockMvc
      .perform(
      		delete("/department/admin/delete/{deptId}",1)
      		.header("password","password"))
      .andExpect(status().isOk());

    
    verify(departmentService, times(1)).delete(1);
    verifyNoMoreInteractions(departmentService);
  }
}
