package nucleusteq.com.grievance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets_type")
public class TicketType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketTypeId;

  private String ticketName;

  
  
 /**
 * 
 */
  public TicketType() {
	 }

/**
 * @param ticketTypeId
 * @param ticketName
 */public TicketType(Integer ticketTypeId,String ticketName){super();this.ticketTypeId=ticketTypeId;this.ticketName=ticketName;}

/**
   * @return the ticketTypeId
   */
  public Integer getTicketTypeId() {
    return ticketTypeId;
  }

  /**
   * @param ticketTypeId the ticketTypeId to set
   */
  public void setTicketTypeId(Integer ticketTypeId) {
    this.ticketTypeId = ticketTypeId;
  }

  /**
   * @return the ticketName
   */
  public String getTicketName() {
    return ticketName;
  }

  /**
   * @param ticketName the ticketName to set
   */
  public void setTicketName(String ticketName) {
    this.ticketName = ticketName;
  }
}
