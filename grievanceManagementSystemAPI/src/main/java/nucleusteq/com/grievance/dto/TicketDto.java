package nucleusteq.com.grievance.dto;


import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import nucleusteq.com.grievance.entity.Comments;
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
  /**
   * Unique identifier for the ticket.
   */
  private Integer ticketId;  // Unique identifier for the ticket

  /**
   * Title  of the ticket.
   */
  @NotEmpty
  private  String title;      // Title  of the ticket

  /**
   * Description or details of the ticket.
   */
  @NotEmpty
  private  String description;  // Description or details of the ticket

  /**
   * Department associated with the ticket.
   */
  @NotNull
  private  Department department;  // Department associated with the ticket

  /**
   * Type of the ticket.
   */
  @NotNull
  private  TicketType ticketType;  // Type of the ticket

  /**
   * Status of the ticket.
   */
  private TicketStatus ticketStatus;  // Status of the ticket

  /**
   * User identifier associated with the ticket.
   */
  @NotNull
  private  Integer userId;  // User identifier associated with the ticket

  private Collection<Comments> comments; 
  /**
   * no args Constructor.
   */
  public TicketDto() {
  }
  /**
   * Constructor to initialize a TicketDto object.
   *
   * @param ticketIdParam    The unique identifier for the ticket.
   * @param titleParam       The title or name of the ticket.
   * @param descriptionParam The description or details of the ticket.
   * @param departmentParam  The department associated with the ticket.
   * @param ticketTypeParam  The type of the ticket. Must not be null.
   * @param ticketStatusParam The status of the ticket.
   * @param userIdParam      The user identifier associated with the ticket.
   */
  public TicketDto(
          final Integer ticketIdParam,
          final String titleParam,
          final String descriptionParam,
          final Department departmentParam,
          final TicketType ticketTypeParam,
          final TicketStatus ticketStatusParam,
          final Integer userIdParam
  ) {
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
	 * @return the comments
	 */
	public Collection<Comments> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "TicketDto [ticketId=" + ticketId + ", title=" + title + ", description=" + description + ", department="
				+ department + ", ticketType=" + ticketType + ", ticketStatus=" + ticketStatus + ", userId=" + userId
				+ ", comments=" + comments + "]";
	}
	
	

  
}
