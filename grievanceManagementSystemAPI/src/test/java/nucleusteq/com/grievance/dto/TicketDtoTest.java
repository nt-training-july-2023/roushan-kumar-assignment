package nucleusteq.com.grievance.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;

public class TicketDtoTest {
	
	private TicketDto ticketDto;

  @BeforeEach
  public void setUp() {
      // Create a new TicketDto instance before each test
      ticketDto = new TicketDto(1, "Test Ticket", "Test Description", new Department(), new TicketType(), new TicketStatus(),1);
  }

  @Test
  public void testConstructor() {
      assertNotNull(ticketDto);
  }
  
  @Test
  public void testGetUserId() {
      assertEquals(new Integer(1), ticketDto.getUserId());
  }

  @Test
  public void testSetUserId() {
      ticketDto.setUserId(2);
      assertEquals(new Integer(2), ticketDto.getUserId());
  }

  @Test
  public void testGetTicketId() {
      assertEquals(new Integer(1), ticketDto.getTicketId());
  }

  @Test
  public void testSetTicketId() {
      ticketDto.setTicketId(2);
      assertEquals(new Integer(2), ticketDto.getTicketId());
  }

  @Test
  public void testGetTitle() {
      assertEquals("Test Ticket", ticketDto.getTitle());
  }

  @Test
  public void testSetTitle() {
      ticketDto.setTitle("New Title");
      assertEquals("New Title", ticketDto.getTitle());
  }

  @Test
  public void testGetDescription() {
      assertEquals("Test Description", ticketDto.getDescription());
  }

  @Test
  public void testSetDescription() {
      ticketDto.setDescription("New Description");
      assertEquals("New Description", ticketDto.getDescription());
  }

  @Test
  public void testGetDepartment() {
      assertNotNull(ticketDto.getDepartment());
  }

  @Test
  public void testSetDepartment() {
      Department newDepartment = new Department();
      ticketDto.setDepartment(newDepartment);
      assertEquals(newDepartment, ticketDto.getDepartment());
  }

  @Test
  public void testGetTicketType() {
      assertNotNull(ticketDto.getTicketType());
  }

  @Test
  public void testSetTicketType() {
      TicketType newTicketType = new TicketType();
      ticketDto.setTicketType(newTicketType);
      assertEquals(newTicketType, ticketDto.getTicketType());
  }

  @Test
  public void testGetTicketStatus() {
      assertNotNull(ticketDto.getTicketStatus());
  }

  @Test
  public void testSetTicketStatus() {
      TicketStatus newTicketStatus = new TicketStatus();
      ticketDto.setTicketStatus(newTicketStatus);
      assertEquals(newTicketStatus, ticketDto.getTicketStatus());
  }
}

