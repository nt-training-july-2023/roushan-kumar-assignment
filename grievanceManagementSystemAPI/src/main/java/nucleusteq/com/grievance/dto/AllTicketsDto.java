package nucleusteq.com.grievance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import nucleusteq.com.grievance.entity.Department;
import nucleusteq.com.grievance.entity.TicketStatus;
import nucleusteq.com.grievance.entity.TicketType;

/**
 * AllTicketsDto class without comments.
 *
 * @author Roushan Kumar
 * @version 1.0.0
 */

public class AllTicketsDto {
  /**
   * Serial number for the ticket.
   */
  private Integer serialNumber;
  /**
   * Unique identifier for the ticket.
   */
  private Integer ticketId;

  /**
   * Title of the ticket.
   */
  @NotEmpty
  private String title;

  /**
   * Description or details of the ticket.
   */
  @NotEmpty
  private String description;

  /**
   * Department associated with the ticket.
   */
  @NotNull
  private Department department;

  /**
   * Type of the ticket.
   */
  @NotNull
  private TicketType ticketType;

  /**
   * Status of the ticket.
   */
  private TicketStatus ticketStatus;

  /**
   * User identifier associated with the ticket.
   */
  @NotNull
  private Integer userId;

  /**
   * Fullname of user.
   */
  private String fullName;

  /**
   * last updated date.
   */
  private String date;

  /**
   * Last updated time.
   */
  private String time;

  /**
   * Creation date.
   */
  private String creationDate;

  /**
   * Creation time.
   */
  private String creationTime;

  /**
   * No args Constructor.
   */
  public AllTicketsDto() {
  }

  /**
   * Constructor to initialize a TicketDto object.
   *
   * @param ticketIdParam     The unique identifier for the ticket.
   * @param titleParam        The title or name of the ticket.
   * @param descriptionParam  The description or details of the ticket.
   * @param departmentParam   The department associated with the ticket.
   * @param ticketTypeParam   The type of the ticket. Must not be null.
   * @param ticketStatusParam The status of the ticket.
   * @param userIdParam       The user identifier associated with the ticket.
   */
  public AllTicketsDto(
      final Integer ticketIdParam,
      final String titleParam,
      final String descriptionParam,
      final Department departmentParam,
      final TicketType ticketTypeParam,
      final TicketStatus ticketStatusParam,
      final Integer userIdParam) {
    this.ticketId = ticketIdParam;
    this.title = titleParam;
    this.description = descriptionParam;
    this.department = departmentParam;
    this.ticketType = ticketTypeParam;
    this.ticketStatus = ticketStatusParam;
    this.userId = userIdParam;
  }

  /**
   * Get the unique identifier for the ticket.
   *
   * @return The ticketId.
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * Set the unique identifier for the ticket.
   *
   * @param ticketIdParam The ticketId to set.
   */
  public void setTicketId(final Integer ticketIdParam) {
    this.ticketId = ticketIdParam;
  }

  /**
   * Get the title of the ticket.
   *
   * @return The title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the ticket.
   *
   * @param titleParam The title to set.
   */
  public void setTitle(final String titleParam) {
    this.title = titleParam;
  }

  /**
   * Get the description of the ticket.
   *
   * @return The description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the ticket.
   *
   * @param descriptionParam The description to set.
   */
  public void setDescription(final String descriptionParam) {
    this.description = descriptionParam;
  }

  /**
   * Get the department associated with the ticket.
   *
   * @return The department.
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * Set the department associated with the ticket.
   *
   * @param departmentParam The department to set.
   */
  public void setDepartment(final Department departmentParam) {
    this.department = departmentParam;
  }

  /**
   * Get the type of the ticket.
   *
   * @return The ticketType.
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * Set the type of the ticket.
   *
   * @param ticketTypeParam The ticketType to set.
   */
  public void setTicketType(final TicketType ticketTypeParam) {
    this.ticketType = ticketTypeParam;
  }

  /**
   * Get the status of the ticket.
   *
   * @return The ticketStatus.
   */
  public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  /**
   * Set the status of the ticket.
   *
   * @param ticketStatusParam The ticketStatus to set.
   */
  public void setTicketStatus(final TicketStatus ticketStatusParam) {
    this.ticketStatus = ticketStatusParam;
  }

  /**
   * Get the user identifier associated with the ticket.
   *
   * @return The userId.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the user identifier associated with the ticket.
   *
   * @param userIdParam The userId to set.
   */
  public void setUserId(final Integer userIdParam) {
    this.userId = userIdParam;
  }

  /**
   * Get fulname.
   *
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Set fulname.
   *
   * @param fullNameParam the fullName to set
   */
  public void setFullName(
      final String fullNameParam) {
    this.fullName = fullNameParam;
  }

  /**
   * Get last updated date.
   *
   * @return Date
   */
  public String getDate() {
    return date;
  }

  /**
   * Set last updated date.
   *
   * @param dateParam The date to set.
   */
  public void setDate(
      final String dateParam) {
    this.date = dateParam;
  }

  /**
   * Get last updated time.
   *
   * @return The time
   */
  public String getTime() {
    return time;
  }

  /**
   * Set last updated time.
   *
   * @param timeParam the time to set
   */
  public void setTime(
      final String timeParam) {
    this.time = timeParam;
  }

  /**
   * Get creation time.
   *
   * @return The createrTime
   */
  public String getCreationTime() {
    return creationTime;
  }

  /**
   * Set creation time.
   *
   * @param timeParam the creationTime to set
   */
  public void setCreationTime(
      final String timeParam) {
    this.creationTime = timeParam;
  }

  /**
   * Get creation date.
   *
   * @return the creationDate
   */
  public String getCreationDate() {
    return creationDate;
  }

  /**
   * Set creation date.
   *
   * @param creationDateParam the creationDate to set
   */
  public void setCreationDate(
      final String creationDateParam) {
    this.creationDate = creationDateParam;
  }

  /**
  * @return the sNo
  */
  public Integer getSerialNumber() {
   return serialNumber;
  }

  /**
  * @param sNoParam the sNo to set.
  */
  public void setSerialNumber(final Integer sNoParam) {
  this.serialNumber = sNoParam;
  }

   /**
   * Ticket details.
   */
  @Override
  public String toString() {
    return "TicketDto [ticketId=" + ticketId + ", title="
        + title + ", description=" + description + ", department="
        + department + ", ticketType=" + ticketType + ", ticketStatus="
        + ticketStatus + ", userId=" + userId
        + "]";
  }
}

