package nucleusteq.com.grievance.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.service.TicketService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TicketControllerTest {

	 private MockMvc mockMvc;

   @Mock
   private TicketService ticketService;

   @InjectMocks
   private TicketController ticketController;

   TicketDto validTicket;
   
   @BeforeEach
   public void setup() {
       MockitoAnnotations.openMocks(this);
       mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
       validTicket = new TicketDto();
       validTicket.setTitle("Valid Ticket");
       validTicket.setDescription("Description 1");
       validTicket.setDepartment(new Department(1,"HR"));
       validTicket.setTicketType(new TicketType(1,"FEEDBACK"));
       validTicket.setUserId(1);
       System.out.println("setUp");
   }

   @Test
   public void testSaveTicketValidTicket() throws Exception {
     

       when(ticketService.save(validTicket)).thenReturn(new ResponseDto(1,"message","Success"));

       ObjectMapper objectMapper = new ObjectMapper();
       String jsonRequest = objectMapper.writeValueAsString(validTicket);

        mockMvc.perform(post("/api/ticket/save")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonRequest))
               .andExpect(status().isOk())
               .andReturn();

    
       ResponseDto response = ticketService.save(validTicket);

       verify(ticketService, times(1)).save(validTicket);
       assertEquals("Success", response.getStatus());
   }

   @Test
   public void testSaveTicket_InvalidTicket() throws Exception {

       // This ticket is intentionally left invalid
       TicketDto invalidTicket = new TicketDto(); 
       ObjectMapper objectMapper = new ObjectMapper();
       String jsonRequest = objectMapper.writeValueAsString(invalidTicket);

       MvcResult result = mockMvc.perform(post("/api/ticket/save")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonRequest))
               .andExpect(status().isBadRequest())
               .andReturn();

       verify(ticketService, never()).save(any(TicketDto.class));
   }

   @Test
   public void testUpdateTicket() throws Exception {

       validTicket.setTicketId(1);
       when(ticketService.update(any(TicketDto.class)))
           .thenReturn(new ResponseDto(1,"message","Updated"));

       ObjectMapper objectMapper = new ObjectMapper();
       String jsonRequest = objectMapper.writeValueAsString(validTicket);

       mockMvc.perform(put("/api/ticket/update")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonRequest))
               .andExpect(status().isOk())
               .andReturn();

       ResponseDto response = ticketController.updateTicket(validTicket);

       System.out.println(response.getMessage());
      // verify(ticketService, times(1)).update(validTicket);
       assertEquals("Updated", response.getStatus());
   }
}

