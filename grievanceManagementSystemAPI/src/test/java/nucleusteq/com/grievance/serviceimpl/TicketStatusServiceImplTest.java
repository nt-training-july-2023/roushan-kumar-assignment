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
      MockitoAnnotations.openMocks(this); // Initialize mocks
  }

  @Test
  void testGetByName() {
      // Define a sample name and a mock TicketStatus object
      String sampleName = "open";
      TicketStatus ticketStatus = new TicketStatus();
      ticketStatus.setTicketStatusName(sampleName);

      // Define the behavior of the mocked repository
      when(ticketStatusRepo.getTicketStatsByName(sampleName)).thenReturn(ticketStatus);

      // Call the method to be tested
      TicketStatus result = ticketStatusService.getByName(sampleName);

      // Verify that the method behaved as expected
      assertEquals(sampleName, result.getTicketStatusName());

      // Verify that the repository method was called with the correct parameter
      verify(ticketStatusRepo).getTicketStatsByName(sampleName);

      // Verify that there were no other interactions with the mocked repository
      verifyNoMoreInteractions(ticketStatusRepo);
  }
}

