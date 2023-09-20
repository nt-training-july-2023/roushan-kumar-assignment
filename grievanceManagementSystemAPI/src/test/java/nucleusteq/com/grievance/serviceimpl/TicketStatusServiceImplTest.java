package nucleusteq.com.grievance.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.repository.TicketStatusRepo;

public class TicketStatusServiceImplTest {
	
  @Mock
  private TicketStatusRepo ticketStatusRepo;

  @InjectMocks
  private TicketStatusServiceImpl ticketStatusService;

  @BeforeEach
  void setUp() {
      MockitoAnnotations.openMocks(this);
  }

  @Test
  void testGetByName() {
     
      String sampleName = "open";
      TicketStatus ticketStatus = new TicketStatus();
      ticketStatus.setTicketStatusName(sampleName);

     
      when(ticketStatusRepo.getTicketStatsByName(sampleName)).thenReturn(ticketStatus);

      
      TicketStatus result = ticketStatusService.getByName(sampleName);

      
      assertEquals(sampleName, result.getTicketStatusName());

     
      verify(ticketStatusRepo).getTicketStatsByName(sampleName);

     
      verifyNoMoreInteractions(ticketStatusRepo);
  }
}

