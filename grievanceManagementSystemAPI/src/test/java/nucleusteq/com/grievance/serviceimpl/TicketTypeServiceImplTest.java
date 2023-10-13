package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.repository.TicketTypeRepo;

public class TicketTypeServiceImplTest {
  @Mock
  private TicketTypeRepo ticketTypeRepo;
  
  @InjectMocks
  private TicketTypeServiceImpl ticketTypeServiceImpl;
  
  private TicketType ticketType;
  
  @BeforeEach
  void setUp() {
      MockitoAnnotations.openMocks(this);  
  }
  
  @Test
  public void testGetAllTicketType()
  {
  	List<TicketType> ticketTypes = Arrays.asList(
  			new TicketType(1,"type 1"),
  			new TicketType(2,"type 2")
  			);
  	
  	when(ticketTypeRepo.findAll()).thenReturn(ticketTypes);
  	
  	when(ticketTypeServiceImpl.getAll()).thenReturn(ticketTypes);
  	
  	assertNotNull(ticketTypeServiceImpl.getAll());
  }
  
  @Test
  public void testSave()
  {
  	 ticketType  = new TicketType(1,"type 1");
  	 when(ticketTypeRepo.save(ticketType)).thenReturn(ticketType);
  	 when(ticketTypeServiceImpl.save(ticketType)).thenReturn(ticketType);
  	 assertNotNull(ticketTypeServiceImpl.save(ticketType));
  	 
  }
  
  @Test
  public void testGetTicketByName()
  {
  	 String type = "type 1";
  	 ticketType  = new TicketType(1,"type 1");
  	 when(ticketTypeRepo.getTicketTypeByName(type)).thenReturn(ticketType);
  	 when(ticketTypeServiceImpl.getTicketTypeByName(type)).thenReturn(ticketType);
  	 assertNotNull(ticketTypeServiceImpl.getTicketTypeByName(type));
  	 
  }
  
}

