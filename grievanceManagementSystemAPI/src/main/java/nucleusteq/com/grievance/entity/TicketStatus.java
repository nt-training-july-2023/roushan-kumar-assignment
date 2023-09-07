package nucleusteq.com.grievance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_status")
public class TicketStatus {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketStatusId;

  private String ticketStatusName;

  public TicketStatus() {
  }
  /**
 * @param ticketStatusId
 * @param ticketStatusName
 */public TicketStatus(Integer ticketStatusId,String ticketStatusName){super();this.ticketStatusId=ticketStatusId;this.ticketStatusName=ticketStatusName;}

/**
   * @return the ticketStatusId
   */
  public Integer getTicketStatusId() {
    return ticketStatusId;
  }

  /**
   * @param ticketStatusId the ticketStatusId to set
   */
  public void setTicketStatusId(Integer ticketStatusId) {
    this.ticketStatusId = ticketStatusId;
  }

  /**
   * @return the ticketStatusName
   */
  public String getTicketStatusName() {
    return ticketStatusName;
  }

  /**
   * @param ticketStatusName the ticketStatusName to set
   */
  public void setTicketStatusName(String ticketStatusName) {
    this.ticketStatusName = ticketStatusName;
  }
}
