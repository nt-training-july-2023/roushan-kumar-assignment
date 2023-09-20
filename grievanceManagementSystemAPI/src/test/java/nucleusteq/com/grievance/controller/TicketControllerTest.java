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
import nucleusteq.com.grievance.entity.Comments;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Ticket;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.service.TicketService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

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

        mockMvc.perform(post("/ticket/save")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonRequest))
               .andExpect(status().isOk())
               .andReturn();

    
       ResponseDto response = ticketService.save(validTicket);

       verify(ticketService, times(1)).save(validTicket);
       assertEquals("Success", response.getStatus());
   }

   @Test
   public void testSaveTicketInvalidTicket() throws Exception {

       // This ticket is intentionally left invalid
       TicketDto invalidTicket = new TicketDto(); 
       ObjectMapper objectMapper = new ObjectMapper();
       String jsonRequest = objectMapper.writeValueAsString(invalidTicket);

       MvcResult result = mockMvc.perform(post("/ticket/save")
               .contentType(MediaType.APPLICATION_JSON)
               .content(jsonRequest))
               .andExpect(status().isBadRequest())
               .andReturn();

       verify(ticketService, never()).save(any(TicketDto.class));
   }


   
   @Test
   public void testGetAllTickets() throws Exception
   {
  	 List<Comments> comments = Arrays.asList(
   			new Comments(1,"comment 1"),
   			new Comments(2,"comment 2"));
  	 
  		TicketDto ticketDto1 = new TicketDto();
    	ticketDto1.setTicketId(1);
    	ticketDto1.setTitle("title 1");
    	ticketDto1.setComments(comments);
    	ticketDto1.setTicketType(new TicketType(1,"Feeback"));
    	ticketDto1.setDepartment(new Department(1,"HR"));
    	ticketDto1.setUserId(1);
    	
    	TicketDto ticketDto2 = new TicketDto();
    	ticketDto2.setTicketId(2);
    	ticketDto2.setTitle("title 2");
    	ticketDto2.setComments(comments);
    	ticketDto2.setTicketType(new TicketType(1,"Feeback"));
    	ticketDto2.setDepartment(new Department(1,"HR"));
    	ticketDto2.setUserId(1);
    	  	
    	List<TicketDto> allTicketsDto = Arrays.asList(
    			ticketDto1,
    			ticketDto2
    			);
    	when(ticketService.getAllByCondition(10, 0, false,0,1,"OPEN"))
    	    .thenReturn(allTicketsDto);
    	
       mockMvc.perform(get("/ticket/all/new/10?departId=0&createdByMe=false&offset=0&pageSize=1&status=OPEN"))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$[0].ticketId").value(1))
              .andExpect(jsonPath("$[0].title").value("title 1"));
              //.andExpect(jsonPath("$[1].deptId").value(2))
              //.andExpect(jsonPath("$[1].deptName").value("Department 2"));
       verify(ticketService, times(1)).getAllByCondition(10, 0, false,0,1,"OPEN");
       verifyNoMoreInteractions(ticketService);
    	
   }
   
}

