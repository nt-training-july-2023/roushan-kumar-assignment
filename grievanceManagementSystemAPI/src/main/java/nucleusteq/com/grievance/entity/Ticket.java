package nucleusteq.com.grievance.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Ticket Entity.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

  /**
   * ticket id as integer.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  /**
   * ticket titel as string.
   */
  private String title;

  /**
   * description as string.
   */
  private String description;

  /**
   * creationTime as LocalDateTime.
   */
  private LocalDateTime creationTime;

  /**
   * lastUpdateTime as LocalDateTime.
   */
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;

  /**
   * department class.
   */
  @OneToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
      })
  @JoinColumn(name = "department_id")
  private Department department;

  /**
   * ticket Type.
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
   * ticket Status.
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
  @JoinColumn(name = "comments_id")//need to change to ticket tid.
  private Collection<Comments> comments;

  /**
   * user entity.
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

//  /**
//   * @param ticketId
//   * @param title
//   * @param description
//   * @param creationTime
//   * @param lastUpdateTime
//   * @param department
//   * @param ticketType
//   * @param ticketStatus
//   * @param comments
//   */
//    public Ticket(
//    Integer ticketId,
//    String title,
//    String description,
//    LocalDateTime creationTime,
//    LocalDateTime lastUpdateTime,
//    Department department,
//    TicketType ticketType,
//    TicketStatus ticketStatus,
//    Collection<Comments> comments,
//    Users user
//  )
//   {
//    super();
//    this.ticketId = ticketId;
//    this.title = title;
//    this.description = description;
//    this.creationTime = creationTime; // Defensive copy
//    this.lastUpdateTime = lastUpdateTime;// Defensive copy
//    this.department = department;
//    this.ticketType = ticketType;
//    this.ticketStatus = ticketStatus;
//    this.comments = comments;
//    this.user = user;
//}

  /**
   * Get ticket Id.
   *
   * @return the ticketId
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * set Ticket id.
   *
   * @param ticketIdParam the ticketId to set
   */
  public void setTicketId(final Integer ticketIdParam) {
    this.ticketId = ticketIdParam;
  }

  /**
   * Get tilte.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * set Tilte.
   *
   * @param titleParam the title to set
   */
  public void setTitle(final String titleParam) {
    this.title = titleParam;
  }

  /**
   * get description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * set description.
   *
   * @param descriptionParam the description to set
   */
  public void setDescription(final String descriptionParam) {
    this.description = descriptionParam;
  }

  /**
   * get CreationTime.
   *
   * @return the creationTime
   */
  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  /**
   * set CreationTime.
   *
   * @param creationTimeParam the creationTime to set
   */
  public void setCreationTime(final LocalDateTime creationTimeParam) {
    this.creationTime = creationTimeParam;
  }

  /**
   * get Last Update Time.
   *
   * @return the lastUpdateTime
   */
  public LocalDateTime getLastUpdateTime() {
    return lastUpdateTime;
  }

  /**
   * set Last Update Time.
   *
   * @param lastUpdateTimeParam the lastUpdateTime to set
   */
  public void setLastUpdateTime(final LocalDateTime lastUpdateTimeParam) {
    this.lastUpdateTime = lastUpdateTimeParam;
  }

  /**
   * Get department.
   *
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * set department.
   *
   * @param departmentParam the department to set
   */
  public void setDepartment(final Department departmentParam) {
    this.department = departmentParam;
  }

  /**
   * get Ticket Type.
   *
   * @return the ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * set Ticket Type.
   *
   * @param ticketTypeParam the ticketType to set
   */
  public void setTicketType(final TicketType ticketTypeParam) {
    this.ticketType = ticketTypeParam;
  }

  /**
   * get Ticket Status.
   *
   * @return the ticketStatus
   */
  public TicketStatus getTicketStatus() {
    return ticketStatus;
  }

  /**
   * set Ticket Status.
   *
   * @param ticketStatusParam the ticketStatus to set
   */
  public void setTicketStatus(final TicketStatus ticketStatusParam) {
    this.ticketStatus = ticketStatusParam;
  }

  /**
   * get Comments.
   *
   * @return the comments
   */
  public Collection<Comments> getComments() {
    return comments;
  }

  /**
   * set Comments.
   *
   * @param commentsParam the comments to set
   */
  public void setComments(final Collection<Comments> commentsParam) {
    this.comments = commentsParam;
  }

  /**
  * getUser.
  *
  * @return the user
  */
  public Users getUser() {
    return user;
  }

  /**
   * set User.
   *
   * @param userParam the user to set
   */
  public void setUser(final Users userParam) {
    this.user = userParam;
  }
  
  
  public void addComments(final Comments commentsParam)
  {
  	if(comments==null)
  	{
  		this.comments = new ArrayList<>();
  	}
  	else 
  	{
  		this.comments.add(commentsParam);
  	}
  }

  /**
   * ticket details.
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

//  /**
//   * hashcode.
//   */
// @Override
// public int hashCode() {
// return Objects.hash(
//			comments,
//			creationTime,
//			department,
//			description,
//			lastUpdateTime,
//			ticketId,
//			ticketStatus,
//			ticketType,
//			title,
//			user);
//	}
//
//  @Override public boolean equals(Object obj){
//	if (this == obj) {
//		return true;
//	}
//	if (obj == null) {
//		return false;
//	}
//	if (getClass() != obj.getClass()) {
//		return false;
//	}
//
//	Ticket other = (Ticket)obj;
//	return Objects.equals(comments, other.comments)
//			&& Objects.equals(creationTime, other.creationTime)
//			&& Objects.equals(department, other.department)
//			&& Objects.equals(description, other.description)
//			&& Objects.equals(lastUpdateTime, other.lastUpdateTime)
//			&& Objects.equals(ticketId, other.ticketId)
//			&& Objects.equals(ticketStatus, other.ticketStatus)
//			&& Objects.equals(ticketType, other.ticketType)
//			&& Objects.equals(title, other.title)
//			&& Objects.equals(user, other.user);
//	}
}

