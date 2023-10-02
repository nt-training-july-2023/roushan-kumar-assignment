package nucleusteq.com.grievance.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.TicketType;

public class TicketTypeTest {
	 TicketType ticketType;
	 @BeforeEach
	 public void setUp(){
		 Integer id = 1;
     String name = "Feedback";
     ticketType = new TicketType(id, name);
	 }
	 
	 @Test
	 public void testGetter()
	 {
		 assertEquals(new Integer(1), ticketType.getTicketTypeId());
		 assertEquals("Feedback", ticketType.getTicketName());
	 }
	 
	 @Test
	 public void testSetter()
	 {
		 ticketType.setTicketTypeId(1);
		 ticketType.setTicketName("Grievance");
		 
		 assertEquals(new Integer(1), ticketType.getTicketTypeId());
		 assertEquals("Grievance", ticketType.getTicketName());
		 
	 }
	 
	
	 @Test
   public void testConstructor() {
       // Create an instance of TicketType using the constructor to be tested
       Integer id = 1;
       String name = "Feedback";
       TicketType ticketType = new TicketType(id, name);

       // Perform assertions to verify that the object was constructed correctly
       assertEquals(id, ticketType.getTicketTypeId());
       assertEquals(name, ticketType.getTicketName());
   }
}

