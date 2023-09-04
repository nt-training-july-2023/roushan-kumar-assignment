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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTest {
	private Ticket ticket;
	List<Comments> comments = Arrays.asList(
			new Comments(null,null));
  @BeforeEach
  public void setUp() {
      // Create a Ticket object before each test
      ticket = new Ticket(
          1,
          "Test Ticket",
          "Test Description",
          new Date(System.currentTimeMillis()),
          new Date(System.currentTimeMillis()),
          new Department(),
          new TicketType(),
          new TicketStatus(),
          comments,
          new Users()
      );
  }
  
  @Test
  public void testConstructor() {
      // Create a Ticket object using the constructor
      Ticket ticket = new Ticket(
          1,
          "Test Ticket",
          "Test Description",
          new Date(System.currentTimeMillis()),
          new Date(System.currentTimeMillis()),
          new Department(),
          new TicketType(),
          new TicketStatus(),
          comments,
          new Users()
      );

      // Verify that the object is not null
      assertNotNull(ticket);

      // Verify that the fields have been initialized correctly
      assertEquals(1, ticket.getTicketId().intValue());
      assertEquals("Test Ticket", ticket.getTitle());
      assertEquals("Test Description", ticket.getDescription());
      assertNotNull(ticket.getCreationTime());
      assertNotNull(ticket.getLastUpdateTime());
      assertNotNull(ticket.getDepartment());
      assertNotNull(ticket.getTicketType());
      assertNotNull(ticket.getTicketStatus());
      assertNotNull(ticket.getComments());
  }

  @Test
  public void testGettersAndSetters() {
      // Test getters
      assertEquals(1, ticket.getTicketId().intValue());
      assertEquals("Test Ticket", ticket.getTitle());
      assertEquals("Test Description", ticket.getDescription());
      assertNotNull(ticket.getCreationTime());
      assertNotNull(ticket.getLastUpdateTime());
      assertNotNull(ticket.getDepartment());
      assertNotNull(ticket.getTicketType());
      assertNotNull(ticket.getTicketStatus());
      assertNotNull(ticket.getComments());

      // Test setters
      ticket.setTicketId(2);
      assertEquals(2, ticket.getTicketId().intValue());

      ticket.setTitle("New Test Ticket");
      assertEquals("New Test Ticket", ticket.getTitle());

      ticket.setDescription("New Test Description");
      assertEquals("New Test Description", ticket.getDescription());

      Date newCreationTime = new Date(System.currentTimeMillis() - 1000);
      ticket.setCreationTime(newCreationTime);
      assertEquals(newCreationTime, ticket.getCreationTime());

      Date newUpdateTime = new Date(System.currentTimeMillis() - 500);
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
}

