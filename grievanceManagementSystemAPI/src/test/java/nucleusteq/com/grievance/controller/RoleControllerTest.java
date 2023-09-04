package nucleusteq.com.grievance.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.service.RoleService;

public class RoleControllerTest {
  
	@InjectMocks
	private RoleController roleController;
	
	@Mock
	private RoleService roleService;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
	}
	
	@Test
	public void getAllRoleTest() throws Exception
	{
		//create a list of role for testing
		List<Role>  roles =   Arrays.asList(
				new Role(1,"Role 1"),
				new Role(2,"Role 2")
				);
		when(roleService.getAllRole()).thenReturn(roles);
		
		mockMvc.perform(get("/api/role/all"))
					 .andExpect(status().isOk())
					 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
					 .andExpect(jsonPath("$[0].roleId").value(1))
			      .andExpect(jsonPath("$[0].name").value("Role 1"))
			      .andExpect(jsonPath("$[1].roleId").value(2))
			      .andExpect(jsonPath("$[1].name").value("Role 2"));
	// Verify that the departmentService's getAllDepartment method was called
    verify(roleService, times(1)).getAllRole();
    verifyNoMoreInteractions(roleService);
		
	}
	
}

