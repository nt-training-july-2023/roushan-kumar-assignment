package nucleusteq.com.grievance.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.service.TicketTypeService;

public class TicketTypeControllerTest {
  private MockMvc mockMvc;

  @Mock
  private TicketTypeService ticketTypeService;

  @InjectMocks
  private TicketTypeController ticketTypeController;

  @BeforeEach
  public void setUp() {
    System.out.println("setUp() method executed");
      MockitoAnnotations.openMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(ticketTypeController).build();
  }

  @Test
  public void testGetAllTicketType() throws Exception {
    
      List<TicketType> ticketTypes = new ArrayList<>();
      ticketTypes.add(new TicketType(1, "Type A"));
      ticketTypes.add(new TicketType(2, "Type B"));

      when(ticketTypeService.getAll()).thenReturn(ticketTypes);

      mockMvc.perform(get("/ticket-type/all"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$[0].ticketTypeId").value(1))
              .andExpect(jsonPath("$[0].ticketName").value("Type A"))
              .andExpect(jsonPath("$[1].ticketTypeId").value(2))
              .andExpect(jsonPath("$[1].ticketName").value("Type B"));

      verify(ticketTypeService, times(1)).getAll();
      verifyNoMoreInteractions(ticketTypeService);
  }

  @Test
  public void testSaveTicketType() throws Exception {
      TicketType ticketType = new TicketType(1, "Type A");
      
      ObjectMapper objectMapper = new ObjectMapper();
      String ticketTypeJson = objectMapper.writeValueAsString(ticketType);
      
      when(ticketTypeService.save(any(TicketType.class))).thenReturn(ticketType);

      // Perform the POST request
      mockMvc.perform(post("/ticket-type/save")
          .contentType(MediaType.APPLICATION_JSON)
          .content(ticketTypeJson))
          .andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.ticketTypeId").value(1))
          .andExpect(jsonPath("$.ticketName").value("Type A"));

      verify(ticketTypeService, times(1)).save(any(TicketType.class));
      verifyNoMoreInteractions(ticketTypeService);
  }
}

