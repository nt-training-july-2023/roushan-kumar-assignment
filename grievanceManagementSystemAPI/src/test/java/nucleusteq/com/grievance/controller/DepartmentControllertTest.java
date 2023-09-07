package nucleusteq.com.grievance.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
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
    // Create a list of departments for testing
    List<Department> departments = Arrays.asList(
      new Department(1, "Department 1"),
      new Department(2, "Department 2")
    );

    // Mock the behavior of the departmentService to return the list of departments
    when(departmentService.getAllDepartment()).thenReturn(departments);

    // Perform a GET request to the "/api/department/all" endpoint
    mockMvc
      .perform(get("/api/department/all"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$[0].deptId").value(1))
      .andExpect(jsonPath("$[0].deptName").value("Department 1"))
      .andExpect(jsonPath("$[1].deptId").value(2))
      .andExpect(jsonPath("$[1].deptName").value("Department 2"));

    // Verify that the departmentService's getAllDepartment method was called
    verify(departmentService, times(1)).getAllDepartment();
    verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void testSaveDepartment() throws Exception {
    // Create a department for testing
    Department department = new Department(1, "Department 1");

    // Mock the behavior of the departmentService to return the saved department
    when(departmentService.save(any(Integer.class),any(Department.class))).thenReturn(department);

    // Perform a POST request to the "/api/department/save" endpoint with JSON data
    mockMvc
      .perform(
        post("/api/department/save/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"deptId\": 1, \"deptName\": \"Department 1\"}")
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.deptId").value(1))
      .andExpect(jsonPath("$.deptName").value("Department 1"));

    // Verify that the departmentService's save method was called with the department object
    verify(departmentService, times(1)).save(any(Integer.class),any(Department.class));
    verifyNoMoreInteractions(departmentService);
  }

  @Test
  public void testDeleteDepartment() throws Exception {
    // Perform a DELETE request to the "/api/department/delete/{deptId}" endpoint
    mockMvc
      .perform(delete("/api/department/delete/{deptId}/{userId}",1,1))
      .andExpect(status().isOk());

    // Verify that the departmentService's delete method was called with the specified department ID
    verify(departmentService, times(1)).delete(1,1);
    verifyNoMoreInteractions(departmentService);
  }
}
