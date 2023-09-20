package nucleusteq.com.grievance.entitytest;

import nucleusteq.com.grievance.entity.Comments;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.Ticket;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;
import nucleusteq.com.grievance.entity.Users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
	private Ticket ticket;
	private Ticket ticket1;
  private Ticket ticket2;
  private Ticket ticket3;
	List<Comments> comments = Arrays.asList(
			new Comments(null,null));
  @BeforeEach
  public void setUp() {
      // Create a Ticket object before each test
      ticket = new Ticket();
      ticket.setTicketId(1);
      ticket.setTitle("Test Ticket");
      ticket.setDescription("Test Description");
      ticket.setDepartment(new Department(1,"HR"));
      ticket.setComments(comments);  
      ticket.setTicketType(new TicketType(1,"FEEDBACK"));
      ticket.setTicketStatus(new TicketStatus());
      ticket.setUser(new Users());
      ticket.setCreationTime(null);
      ticket.setLastUpdateTime(null);
      
   // Create three different ticket instances
      ticket1 = new Ticket();
      ticket1.setTicketId(1);

      ticket2 = new Ticket();
      ticket2.setTicketId(2);

      ticket3 = new Ticket();
      ticket3.setTicketId(1); 
  }

  @Test
  public void testGettersAndSetters() {
      
      assertEquals(1, ticket.getTicketId().intValue());
      assertEquals("Test Ticket", ticket.getTitle());
      assertEquals("Test Description", ticket.getDescription());
      
      assertNotNull(ticket.getDepartment());
      assertNotNull(ticket.getTicketType());
      assertNotNull(ticket.getTicketStatus());
      assertNotNull(ticket.getComments());
      assertNotNull(ticket.getUser());
      
      ticket.setTicketId(2);
      assertEquals(2, ticket.getTicketId().intValue());

      ticket.setTitle("New Test Ticket");
      assertEquals("New Test Ticket", ticket.getTitle());

      ticket.setDescription("New Test Description");
      assertEquals("New Test Description", ticket.getDescription());

      LocalDateTime newCreationTime = LocalDateTime.now();
      ticket.setCreationTime(newCreationTime);
      assertEquals(newCreationTime, ticket.getCreationTime());

      LocalDateTime newUpdateTime = LocalDateTime.now();
      ticket.setLastUpdateTime(newUpdateTime);
      assertEquals(newUpdateTime, ticket.getLastUpdateTime());

      Department newDepartment = new Department();
      ticket.setDepartment(newDepartment);
      assertEquals(newDepartment, ticket.getDepartment());

      TicketType newTicketType = new TicketType();
      ticket.setTicketType(newTicketType);
      assertEquals(newTicketType, ticket.getTicketType());

      TicketStatus newTicketStatus = new TicketStatus();
      ticket.setTicketStatus(newTicketStatus);
      assertEquals(newTicketStatus, ticket.getTicketStatus());

      //Comments newComments = new Comments(null,null);
      ticket.setComments(comments);
      assertEquals(comments, ticket.getComments());
  }

  @Test
  public void testToString() {
      String expectedToString = "Ticket [ticketId=1, title=Test Ticket, description=Test Description, " +
              "creationTime=" + ticket.getCreationTime() + ", lastUpdateTime=" + ticket.getLastUpdateTime() +
              ", department=" + ticket.getDepartment() + ", ticketType=" + ticket.getTicketType() +
              ", ticketStatus=" + ticket.getTicketStatus() + ", comments=" + ticket.getComments() + "]";
      assertEquals(expectedToString, ticket.toString());
  }
  
  @Test
  public void testHashCode() {
      
      assertEquals(ticket1.hashCode(), ticket3.hashCode());

      
      assertNotEquals(ticket1.hashCode(), ticket2.hashCode());
  }

  @Test
  public void testEquals() {
      assertEquals(ticket1, ticket1);

      assertEquals(ticket1, ticket3);

      assertNotEquals(ticket1, ticket2);

      assertNotEquals(ticket1, null);

      assertNotEquals(ticket1, "SomeString");

      ticket1.setTicketId(null);
      ticket3.setTicketId(1);
      assertNotEquals(ticket1, ticket3);
  }
}

