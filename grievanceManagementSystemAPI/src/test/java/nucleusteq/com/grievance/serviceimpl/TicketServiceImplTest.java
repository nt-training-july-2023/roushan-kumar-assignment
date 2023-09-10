package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Collection;

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
    		1);//userId
//    {
//      
//      "title":"Feedback of sessions",
//      "description":"description 45",
//      "department":{
//         "deptName":"HR"
//       },
//     "ticketType":{
//         "ticketName":"FEEDBACK"
//     },
//     "userId":"33"
//    }
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
  
//  @Test
//  public void testUpdate() {
//    // Create a mock TicketDto
//    TicketDto ticketDto = new TicketDto(/* initialize with necessary data */);
//
//    // Mock ticketRepo.findById() behavior
//    when(ticketRepo.findById(anyLong()))
//      .thenReturn(Optional.of(new Ticket(/* initialize with necessary data */)));
//
//    // Call the update method
//    ResponseDto response = ticketService.update(ticketDto);
//    // Perform assertions on the response or verify interactions as needed
//  }
}