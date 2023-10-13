package nucleusteq.com.grievance.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.service.TicketStatusService;

public class TicketStatusControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private TicketStatusService ticketStatusService;

  @InjectMocks
  private TicketStatusController ticketStatusController;

  @BeforeEach
  public void setUp() {
      MockitoAnnotations.openMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(ticketStatusController).build();
  }
  
  @Test
  public void testGetAllStatus() throws Exception {
      
      List<TicketStatus> ticketStatusList = new ArrayList<>();
     
      ticketStatusList.add(new TicketStatus(1,"OPEN"));
      ticketStatusList.add(new TicketStatus(2,"CLOSE"));


      when(ticketStatusService.getAll()).thenReturn(ticketStatusList);


        mockMvc.perform(get("/ticket-status/all"))
                .andExpect(status().isOk())
                 .andReturn();
        
        List<TicketStatus> ticketStatusListRes = ticketStatusController.getAllStatus();
        assertNotNull(ticketStatusListRes);
  }
}

