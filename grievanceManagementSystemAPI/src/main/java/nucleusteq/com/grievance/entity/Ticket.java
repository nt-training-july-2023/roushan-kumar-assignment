package nucleusteq.com.grievance.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Represents a Ticket entity for the grievance management system.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

  /**
   * Ticket id as integer.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  /**
   * Ticket title as string.
   */
  private String title;

  /**
   * Description as string.
   */
  private String description;

  /**
   * CreationTime as LocalDateTime.
   */
  private LocalDateTime creationTime;

  /**
   * LastUpdateTime as LocalDateTime.
   */
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;

  /**
   * Department.
   */
  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "department_id")
  private Department department;

  /**
   * Ticket Type.
   */
  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "ticket_type_id")
  private TicketType ticketType;

  /**
   * Ticket Status.
   */
  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "ticket_status_id")
  private TicketStatus ticketStatus;

  /**
   * Tickets Comments.
   */
  @OneToMany(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "ticket_id")
  private Collection<Comments> comments;

  /**
   * User entity.
   */
  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "user_id")
  private Users user;

  /**
   * No args constructor.
   */
  public Ticket() {
  }

  /**
   * Get ticket Id.
   *
   * @return The ticket id
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * Set Ticket id.
   *
   * @param ticketIdParam the ticketId to set
   */
  public void setTicketId(final Integer ticketIdParam) {
    this.ticketId = ticketIdParam;
  }

  /**
   * Get tilte.
   *
   * @return The title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set Tilte.
   *
   * @param titleParam the title to set
   */
  public void setTitle(final String titleParam) {
    this.title = titleParam;
  }

  /**
   * Get description.
   *
   * @return The description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set description.
   *
   * @param descriptionParam the description to set
   */
  public void setDescription(final String descriptionParam) {
    this.description = descriptionParam;
  }

  /**
   * Get creation time.
   *
   * @return The creation time
   */
  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  /**
   * Set creation time.
   *
   * @param creationTimeParam the creationTime to set
   */
  public void setCreationTime(final LocalDateTime creationTimeParam) {
    this.creationTime = creationTimeParam;
  }

  /**
   * Get Last Update Time.
   *
   * @return The last updated time
   */
  public LocalDateTime getLastUpdateTime() {
    return lastUpdateTime;
  }

  /**
   * Set last update time.
   *
   * @param lastUpdateTimeParam the lastUpdateTime to set
   */
  public void setLastUpdateTime(final LocalDateTime lastUpdateTimeParam) {
    this.lastUpdateTime = lastUpdateTimeParam;
  }

  /**
   * Get department.
   *
   * @return The department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * Set department.
   *
   * @param departmentParam the department to set
   */
  public void setDepartment(final Department departmentParam) {
    this.department = departmentParam;
  }

  /**
   * Get Ticket Type.
   *
   * @return The ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * Set Ticket Type.
   *
   * @param ticketTypeParam the ticketType to set
   */
  public void setTicketType(final TicketType ticketTypeParam) {
    this.ticketType = ticketTypeParam;
  }

  /**
   * Get Ticket Status.
   *
   * @return The ticketStatus
   */
  public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  /**
   * Set Ticket Status.
   *
   * @param ticketStatusParam the ticketStatus to set
   */
  public void setTicketStatus(final TicketStatus ticketStatusParam) {
    this.ticketStatus = ticketStatusParam;
  }

  /**
   * Get Comments.
   *
   * @return The list of comments
   */
  public Collection<Comments> getComments() {
    return comments;
  }

  /**
   * Set Comment.
   *
   * @param commentsParam the comments to set
   */
  public void setComments(final Collection<Comments> commentsParam) {
    this.comments = commentsParam;
  }

  /**
  * Get User.
  *
  * @return the user
  */
  public Users getUser() {
    return user;
  }

  /**
   * Set User.
   *
   * @param userParam the user to set
   */
  public void setUser(final Users userParam) {
    this.user = userParam;
  }

  /**
   * Add comment.
   *
   * @param commentsParam
   */
  public void addComments(final Comments commentsParam) {
    if (comments == null) {
      this.comments = new ArrayList<>();
    } else {
      this.comments.add(commentsParam);
    }
  }

  /**
   * Ticket details.
   */
  @Override
  public String toString() {
    return "Ticket [ticketId=" + ticketId + ", title=" + title
        + ", description=" + description + ", creationTime="
        + creationTime + ", lastUpdateTime=" + lastUpdateTime
        + ", department=" + department + ", ticketType=" + ticketType
        + ", ticketStatus=" + ticketStatus + ", comments=" + comments
        + "]";
  }

  /**
   * Returns a hash code value for the object.
   *
   * The hash code is calculated based on the following fields:
   * - ticketId
   * - title
   * - description
   * - creationTime
   * - lastUpdateTime
   * - department
   * - ticketType
   * - ticketStatus
   * - comments
   * - user
   *
   * @return A hash code value for this object.
   */
 @Override
  public int hashCode() {
   return Objects.hash(
      comments,
      creationTime,
      department,
      description,
      lastUpdateTime,
      ticketId,
      ticketStatus,
      ticketType,
      title,
      user);
  }

  /**
  * Indicates whether some other object is "equal to" this one.
  * The comparison is based on the
  * following fields:
  * - ticketId
  * - title
  * - description
  * - creationTime
  * - lastUpdateTime
  * - department
  * - ticketType
  * - ticketStatus
  * - comments
  * - user
  *
  * @param obj The reference object with which to compare.
  * @return true if this object is the same as the obj argument;
  *         false otherwise.
  */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
    return false;
    }

    Ticket other = (Ticket) obj;
    return Objects.equals(comments, other.comments)
        && Objects.equals(creationTime, other.creationTime)
        && Objects.equals(department, other.department)
        && Objects.equals(description, other.description)
        && Objects.equals(lastUpdateTime, other.lastUpdateTime)
        && Objects.equals(ticketId, other.ticketId)
        && Objects.equals(ticketStatus, other.ticketStatus)
        && Objects.equals(ticketType, other.ticketType)
        && Objects.equals(title, other.title)
        && Objects.equals(user, other.user);
  }
}

