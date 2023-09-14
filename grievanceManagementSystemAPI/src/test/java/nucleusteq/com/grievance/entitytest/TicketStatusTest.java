package nucleusteq.com.grievance.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.TicketStatus;

public class TicketStatusTest {
  
	private TicketStatus ticketStatus;
  @Test
  public void testGettersAndSetters()
  {
  	ticketStatus = new TicketStatus();
  	ticketStatus.setTicketStatusId(1);
  	assertEquals(new Integer(1),ticketStatus.getTicketStatusId() );
  }
}

