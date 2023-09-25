package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import nucleusteq.com.grievance.dto.AllTicketsDto;
import nucleusteq.com.grievance.dto.AllTicketsDtoTest;
import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Role;
import nucleusteq.com.grievance.entity.Ticket;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.entity.Users;
import nucleusteq.com.grievance.exception.BadRequestError;
import nucleusteq.com.grievance.repository.TicketRepo;
import nucleusteq.com.grievance.service.DepartmentService;
import nucleusteq.com.grievance.service.TicketStatusService;
import nucleusteq.com.grievance.service.TicketTypeService;
import nucleusteq.com.grievance.service.UserService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class TicketServiceImplTest {
  @InjectMocks
  private TicketServiceImpl ticketServiceImpl;

  @Mock
  private TicketRepo ticketRepo;

  @Mock
  private DepartmentService departmentService;

  @Mock
  private TicketTypeService ticketTypeService;

  @Mock
  private TicketStatusService ticketStatusService;

  @Mock
  private UserService userService;
   
  private TicketDto ticketDto;
  
  
  @BeforeEach
  public void setUp() {
  	System.out.println("ticket Servic impl test setUp called.");
    MockitoAnnotations.openMocks(this);
    ticketDto = new TicketDto(1, 
    		"Ticket title", 
    		"Ticket Description", 
    		new Department(1,"HR"), 
    		new TicketType(2,"FEEDBACK"), 
    		new TicketStatus(1,"OPEN"),
    		1);
  }

  @Test
  public void testSave() {
    
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	//creating ticket object for testing result.
  	Ticket ticket = new Ticket();
  	//ticket.setTicketId(1);
  	ticket.setTicketType(ticketType);
  	ticket.setTicketId(ticketDto.getTicketId());
    ticket.setTitle(ticketDto.getTitle());
    ticket.setDescription(ticketDto.getDescription());
    ticket.setCreationTime(LocalDateTime.now());
    ticket.setTicketStatus(ticketStatus);
    ticket.setDepartment(dept);
    ticket.setUser(new Users());
    
    Ticket ticketSaved = new Ticket();
    ticketSaved.setTicketId(1);
    ticketSaved.setTicketType(ticketType);
    ticketSaved.setTicketId(ticketDto.getTicketId());
    ticketSaved.setTitle(ticketDto.getTitle());
    ticketSaved.setDescription(ticketDto.getDescription());
    ticketSaved.setCreationTime(LocalDateTime.now());
   // ticketSaved.setLastUpdateTime(LocalDateTime.now());
    ticketSaved.setTicketStatus(ticketStatus);
    ticketSaved.setDepartment(dept);
    ticketSaved.setUser(new Users());

    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    when(ticketStatusService.getByName("OPEN"))
      .thenReturn(ticketStatus);
    when(departmentService.getDepartmentById(1))
      .thenReturn(dept);
    when(userService.getById(1))
      .thenReturn(new Users());

    when(ticketRepo.save(any(Ticket.class)))
      .thenReturn(ticketSaved);

    ResponseDto response = ticketServiceImpl.save(ticketDto);
     System.out.println(response.toString());

    assertEquals(response.getId(), ticketSaved.getTicketId());
  }

  /**
   * test Save Unsuccess when TicketType is null.
   */
  @Test
  public void testSaveUnSuccessNullTicketType()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	Ticket ticket = new Ticket();
    

    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(null);
    
    assertThrows(BadRequestError.class, ()->{
    	ticketServiceImpl.save(ticketDto);
    });
    verify(ticketRepo, never()).save(ticket);
    
  }
  
  /**
   * test Save Unsuccess when ticket status is null.
   */
  @Test
  public void testSaveUnSuccessNullTicketStatus()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	
  	Ticket ticket = new Ticket();
    
    
    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    
    when(ticketStatusService.getByName("OPEN"))
    .thenReturn(null);
    
    assertThrows(BadRequestError.class, ()->{
    	ticketServiceImpl.save(ticketDto);
    });
    verify(ticketRepo, never()).save(ticket);
    
  }
  
  /**
   * test Save Unsuccess when department is null.
   */
  @Test
  public void testSaveUnSuccessNullDepartment()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	
  	Ticket ticket = new Ticket();
    
    
    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    
    when(ticketStatusService.getByName("OPEN"))
    .thenReturn(ticketStatus);
    
    when(departmentService.getDepartmentById(1))
    .thenReturn(null);
    
    assertThrows(BadRequestError.class, ()->{
    	ticketServiceImpl.save(ticketDto);
    });
    verify(ticketRepo, never()).save(ticket);
    
  }
  
  /**
   * test Save Unsuccess when user is null.
   */
  @Test
  public void testSaveUnSuccessNullUser()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	//creating ticket object for testing result.
  	Ticket ticket = new Ticket();
    
    // Mock dependencies' behavior using when-thenReturn
    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    
    when(ticketStatusService.getByName("OPEN"))
    .thenReturn(ticketStatus);
    
    when(departmentService.getDepartmentById(1))
    .thenReturn(dept);
    
    when(userService.getById(1))
    .thenReturn(null);
    
    assertThrows(BadRequestError.class, ()->{
    	ticketServiceImpl.save(ticketDto);
    });
    verify(ticketRepo, never()).save(ticket);
    
  }
    
  @Test
  public void testGetAllByConditionForAdmin() {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
      // Create a sample user
      Users user = new Users();
      user.setUserId(1);
      user.setRole(new Role(1,"Admin"));
      user.setDepartment(dept);

      // Create some sample tickets
      List<Ticket> sampleTickets = new ArrayList<Ticket>();



      when(ticketStatusService.getByName("OPEN")).thenReturn(ticketStatus);
      when(userService.getById(1)).thenReturn(user);
      when(ticketRepo.findByDepartmentNew(1,0,1,1)).thenReturn(sampleTickets);

      List<AllTicketsDto> result = ticketServiceImpl.getAllByCondition(1, 1, false,0,1,"OPEN");

      assertNull(result);
      verify(userService, times(1)).getById(1);
      verify(ticketRepo, times(1)).findByDepartmentNew(1,0,1,1);
     
  }
  
  
  //retuern all ticket if user is non admin and assign to its department
  @Test
  public void testGetAllByConditionForOtherUser() {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	List<Comments> comments = Arrays.asList(
  			new Comments(1,"comment 1"),
  			new Comments(2,"comment 2"));
      // Create a sample user
      Users user = new Users();
      user.setUserId(1);
      user.setRole(new Role(1,"Member"));
      user.setDepartment(dept);
      user.setFullName("Roushan kumar");

      
      //creating ticket object for testing result.
    	Ticket ticket = new Ticket();
    	ticket.setTicketId(1);
    	ticket.setTicketType(ticketType);
    	ticket.setTicketId(ticketDto.getTicketId());
      ticket.setTitle(ticketDto.getTitle());
      ticket.setDescription(ticketDto.getDescription());
      ticket.setCreationTime(LocalDateTime.now());
      ticket.setTicketStatus(ticketStatus);
      ticket.setDepartment(dept);
      ticket.setUser(user);
      ticket.setComments(comments);
      ticket.setCreationTime(LocalDateTime.now());
      ticket.setLastUpdateTime(LocalDateTime.now());

      
      List<Ticket> allTickets = new ArrayList<Ticket>();
      allTickets.add(ticket);


      when(ticketStatusService.getByName("OPEN")).thenReturn(ticketStatus);
      when(userService.getById(1)).thenReturn(user);
      when(ticketRepo.findByDepartmentNew(1,0,1,1)).thenReturn(allTickets);
      List<AllTicketsDto> result = ticketServiceImpl.getAllByCondition(1, 0, false,0,1,"OPEN");

      assertNotNull(result);
      
      assertEquals(1, result.size()); 
      
      verify(userService, times(1)).getById(1);
      verify(ticketRepo, times(1)).findByDepartmentNew(1,0,1,1);
     
  }
  


  @Test
  public void testUpdateTicketComments()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	List<Comments> comments = Arrays.asList(
  			new Comments(1,"comment 1"),
  			new Comments(2,"comment 2"));
  	
  	Ticket ticketSaved = new Ticket();
    ticketSaved.setTicketId(1);
    ticketSaved.setTicketType(ticketType);
    ticketSaved.setTicketId(ticketDto.getTicketId());
    ticketSaved.setTitle(ticketDto.getTitle());
    ticketSaved.setDescription(ticketDto.getDescription());
    ticketSaved.setTicketStatus(ticketStatus);
    ticketSaved.setDepartment(dept);
    ticketSaved.setUser(new Users());
    ticketSaved.addComments(new Comments(1,"comment 1"));

  	when(ticketRepo.findById(1)).thenReturn(Optional.of(ticketSaved));
  	when(ticketStatusService.getById(1)).thenReturn(ticketStatus);
  	when(ticketRepo.save(any(Ticket.class))).thenReturn(ticketSaved);
  	
  	ResponseDto response = ticketServiceImpl.updateTicketComments(new Comments(1,"comment 1"),1,1);
     System.out.println(response.toString());
    assertEquals(response.getId(), ticketSaved.getTicketId());
  
  }
  
  @Test
  void testGetByTicketIdWhenTicketExists() {
    
    Users user = new Users();
    user.setUserId(1);
    user.setRole(new Role(1,"Member"));
    //user.setDepartment(dept);
    user.setFullName("Roushan kumar");
      // Create a sample Ticket entity
      Ticket sampleTicket = new Ticket();
      sampleTicket.setTicketId(1);
      sampleTicket.setTitle("Sample Ticket");
      sampleTicket.setDescription("Sample Description");
      sampleTicket.setUser(user);
      sampleTicket.setCreationTime(LocalDateTime.now());
      sampleTicket.setLastUpdateTime(LocalDateTime.now());
      // Set other properties as needed

      // Mock the behavior of ticketRepo.findById
      when(ticketRepo.findById(1)).thenReturn(Optional.of(sampleTicket));

      // Call the method to be tested
      TicketDto ticketDto = ticketServiceImpl.getByTicketId(1);

      // Assert that the returned TicketDto matches the sampleTicket
      assertNotNull(ticketDto);
      assertEquals(sampleTicket.getTicketId(), ticketDto.getTicketId());
      assertEquals(sampleTicket.getTitle(), ticketDto.getTitle());
      assertEquals(sampleTicket.getDescription(), ticketDto.getDescription());
      // Assert other properties as needed
  }

  @Test
  void testGetByTicketIdWhenTicketNotExists() {
      // Mock the behavior of ticketRepo.findById when the ticket is not found
      when(ticketRepo.findById(1)).thenReturn(Optional.empty());

      // Call the method to be tested and expect a BadRequestError to be thrown
      assertThrows(BadRequestError.class, () -> {
        ticketServiceImpl.getByTicketId(1);
      });
  }
  
  
}