package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
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

import nucleusteq.com.grievance.dto.ResponseDto;
import nucleusteq.com.grievance.dto.TicketDto;
import nucleusteq.com.grievance.entity.Comments;
import nucleusteq.com.grievance.entity.Department;
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
  
//  @Mock
//  private ResponseDto response;
//  
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
    
   // assertTrue(true);
    
    // Mock dependencies' behavior using when-thenReturn
    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    when(ticketStatusService.getByName("OPEN"))
      .thenReturn(ticketStatus);
    when(departmentService.getDepartmentByName("HR"))
      .thenReturn(dept);
    when(userService.getById(1))
      .thenReturn(new Users());

    // Mock ticketRepo.save() behavior
    when(ticketRepo.save(any(Ticket.class)))
      .thenReturn(ticketSaved);

    // Call the save method
    ResponseDto response = ticketServiceImpl.save(ticketDto);
     System.out.println(response.toString());
    // Perform assertions on the response or verify interactions as needed
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
  	
  	//creating ticket object for testing result.
  	Ticket ticket = new Ticket();
    
    // Mock dependencies' behavior using when-thenReturn
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
  	
  	//creating ticket object for testing result.
  	Ticket ticket = new Ticket();
    
    // Mock dependencies' behavior using when-thenReturn
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
  	
  	//creating ticket object for testing result.
  	Ticket ticket = new Ticket();
    
    // Mock dependencies' behavior using when-thenReturn
    when(ticketTypeService.getTicketTypeByName("FEEDBACK"))
      .thenReturn(ticketType);
    
    when(ticketStatusService.getByName("OPEN"))
    .thenReturn(ticketStatus);
    
    when(departmentService.getDepartmentByName("HR"))
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
    
    when(departmentService.getDepartmentByName("HR"))
    .thenReturn(dept);
    
    when(userService.getById(1))
    .thenReturn(null);
    
    assertThrows(BadRequestError.class, ()->{
    	ticketServiceImpl.save(ticketDto);
    });
    verify(ticketRepo, never()).save(ticket);
    
  }
    
  @Test
  public void testGetAllTicket()
  {
    	
    	List<Comments> comments = Arrays.asList(
    			new Comments(1,"comment 1"),
    			new Comments(2,"comment 2"));
    	
    	Ticket ticket1 = new Ticket();
    	ticket1.setTicketId(1);
    	ticket1.setTitle("title 1");
    	ticket1.setComments(comments);
    	ticket1.setTicketType(new TicketType(1,"Feeback"));
    	ticket1.setDepartment(new Department(1,"HR"));
    	ticket1.setUser(new Users());
    	
    	Ticket ticket2 = new Ticket();
    	ticket2.setTicketId(2);
    	ticket2.setTitle("title 2");
    	ticket2.setComments(comments);
    	ticket2.setTicketType(new TicketType(1,"Feeback"));
    	ticket2.setDepartment(new Department(1,"HR"));
    	ticket2.setUser(new Users());
    	
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
    	
    	
    	
    	List<Ticket> allTickets  = Arrays.asList(
    			ticket1,
    			ticket2
    			);
    	
    	List<TicketDto> allTicketsDto = Arrays.asList(
    			ticketDto1,
    			ticketDto2
    			);
    	
    	
    	when(ticketRepo.findAll()).thenReturn(allTickets);
    	//when(ticketServiceImpl.getAll()).thenReturn(allTicketsDto);
    	
//    	assertNotNull(ticketServiceImpl.getAll());
    	//assertEquals(allTickets.get(0).getComments(), allTicketsDto.get(1).getComments());
    	List<TicketDto> allTicketsDto2 = ticketServiceImpl.getAll();

      // Assert that the result is not null and has the expected size
      assertNotNull(allTicketsDto2);
      assertEquals(2, allTicketsDto2.size());
    }
  
  @Test
  public void testUdpateTicket()
  {
  	Department dept = new Department(1,"HR");
		TicketType ticketType = new TicketType(2,"FEEDBACK"); 
  	TicketStatus ticketStatus = new TicketStatus(1,"OPEN");
  	
  	Ticket ticketSaved = new Ticket();
    ticketSaved.setTicketId(1);
    ticketSaved.setTicketType(ticketType);
    ticketSaved.setTicketId(ticketDto.getTicketId());
    ticketSaved.setTitle(ticketDto.getTitle());
    ticketSaved.setDescription(ticketDto.getDescription());
  //ticketSaved.setCreationTime(LocalDateTime.now());
  //ticketSaved.setLastUpdateTime(LocalDateTime.now());
    ticketSaved.setTicketStatus(ticketStatus);
    ticketSaved.setDepartment(dept);
    ticketSaved.setUser(new Users());
    
    when(ticketStatusService.getByName("OPEN"))
    .thenReturn(ticketStatus);
    
    when(departmentService.getDepartmentByName("HR"))
    .thenReturn(dept);
    
  	when(ticketRepo.findById(1)).thenReturn(Optional.of(ticketSaved));
  	
  	when(ticketRepo.save(any(Ticket.class))).thenReturn(ticketSaved);
  	
  	ResponseDto response = ticketServiceImpl.update(ticketDto);
     System.out.println(response.toString());
    // Perform assertions on the response or verify interactions as needed
    assertEquals(response.getId(), ticketSaved.getTicketId());
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
  //ticketSaved.setCreationTime(LocalDateTime.now());
  //ticketSaved.setLastUpdateTime(LocalDateTime.now());
    ticketSaved.setTicketStatus(ticketStatus);
    ticketSaved.setDepartment(dept);
    ticketSaved.setUser(new Users());
    ticketSaved.addComments(new Comments(1,"comment 1"));
    
  
  	when(ticketRepo.findById(1)).thenReturn(Optional.of(ticketSaved));
  	
  	when(ticketRepo.save(any(Ticket.class))).thenReturn(ticketSaved);
  	
  	ResponseDto response = ticketServiceImpl.updateTicketComments(new Comments(1,"comment 1"),1);
     System.out.println(response.toString());
    // Perform assertions on the response or verify interactions as needed
    assertEquals(response.getId(), ticketSaved.getTicketId());
  }
}