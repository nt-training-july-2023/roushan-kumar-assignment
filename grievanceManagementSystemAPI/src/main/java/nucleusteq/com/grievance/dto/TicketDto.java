package nucleusteq.com.grievance.dto;

import java.sql.Date;
import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;

/**
 * TicketDto class.
 *
 * @author roushan Kumar
 *
 */

public class TicketDto {
  private Integer ticketId;

  private String title;

  private String description;

  private Department department;

  private TicketType ticketType;

  private TicketStatus ticketStatus;

  private Integer userId;

  /**
   * @param ticketId
   * @param title
   * @param description
   * @param department
   * @param ticketType
   * @param ticketStatus
   */public TicketDto(
    Integer ticketId,
    String title,
    String description,
    Department department,
    TicketType ticketType,
    TicketStatus ticketStatus,
    Integer userId
  ) {
    super();
    this.ticketId = ticketId;
    this.title = title;
    this.description = description;
    this.department = department;
    this.ticketType = ticketType;
    this.ticketStatus = ticketStatus;
    this.userId = userId;
  }

  /**
   * @return the ticketId
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * @param ticketId the ticketId to set
   */
  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * @param department the department to set
   */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   * @return the ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * @param ticketType the ticketType to set
   */
  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  /**
   * @return the ticketStatus
   */
  public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  /**
   * @param ticketStatus the ticketStatus to set
   */
  public void setTicketStatus(TicketStatus ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  /**
   * @return the userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
