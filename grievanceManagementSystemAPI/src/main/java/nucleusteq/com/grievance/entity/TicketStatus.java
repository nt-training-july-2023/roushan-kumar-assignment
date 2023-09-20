package nucleusteq.com.grievance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_status")
public class TicketStatus {
  /**
   * The unique identifier for the ticket status.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer ticketStatusId;

  /**
   * The name of the ticket status.
   */
  private  String ticketStatusName;

  /**
   * Constructs a new TicketStatus instance.
   */
  public TicketStatus() {
  }
  /**
   * Constructs a new TicketStatus instance.
   *
   * @param ticketStatusIdParam   The unique identifier for the ticket status.
   * @param ticketStatusNameParam The name of the ticket status.
   */
  public TicketStatus(final Integer ticketStatusIdParam,
     final String ticketStatusNameParam) {
      super();
      this.ticketStatusId = ticketStatusIdParam;
      this.ticketStatusName = ticketStatusNameParam;
  }

  /**
   * Retrieves the unique identifier for the ticket status.
   *
   * @return The ticket status ID.
   */
  public Integer getTicketStatusId() {
      return ticketStatusId;
  }

  /**
   * Retrieves the name of the ticket status.
   *
   * @return The ticket status name.
   */
  public String getTicketStatusName() {
      return ticketStatusName;
  }

  /**
   * Sets the unique identifier for the ticket status.
   *
   * @param ticketStatusIdParam The ticket status ID to set.
   */
  public void setTicketStatusId(final Integer ticketStatusIdParam) {
      this.ticketStatusId = ticketStatusIdParam;
  }

  /**
   * Sets the name of the ticket status.
   *
   * @param ticketStatusNameParam The ticket status name to set.
   */
  public void setTicketStatusName(final String ticketStatusNameParam) {
      this.ticketStatusName = ticketStatusNameParam;
  }
}
