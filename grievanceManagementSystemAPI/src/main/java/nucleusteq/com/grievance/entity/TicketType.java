package nucleusteq.com.grievance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets_type")
public class TicketType {
  /**
   * The unique identifier for the ticket type.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketTypeId;

  /**
   * The name of the ticket type.
   */
  private String ticketName;

  /**
   * Default constructor for TicketType.
   */
  public TicketType() {
  }

  /**
   * Parameterized constructor for TicketType.
   *
   * @param ticketTypeIdParam The unique identifier for the ticket type.
   * @param ticketNameParam   The name of the ticket type.
   */
  public TicketType(
      final Integer ticketTypeIdParam,
  		final String ticketNameParam) {
      super();
      this.ticketTypeId = ticketTypeIdParam;
      this.ticketName = ticketNameParam;
  }

  /**
   * Get the ticket type's unique identifier.
   *
   * @return The ticket type's unique identifier.
   */
  public Integer getTicketTypeId() {
      return ticketTypeId;
  }

  /**
   * Set the ticket type's unique identifier.
   *
   * @param ticketTypeIdParam The ticket type's unique identifier (final).
   */
  public void setTicketTypeId(final Integer ticketTypeIdParam) {
      this.ticketTypeId = ticketTypeIdParam;
  }

  /**
   * Get the name of the ticket type.
   *
   * @return The name of the ticket type.
   */
  public String getTicketName() {
      return ticketName;
  }

  /**
   * Set the name of the ticket type.
   *
   * @param ticketNameParam The name of the ticket type (final).
   */
  public void setTicketName(final String ticketNameParam) {
      this.ticketName = ticketNameParam;
  }
}
