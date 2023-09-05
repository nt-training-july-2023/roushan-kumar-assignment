package nucleusteq.com.grievance.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;

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

@Entity
@Table(name = "ticket")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  private String title;
  private String description;
  
  private LocalDateTime creationTime;
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;

  @OneToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name = "ticket_type_id")
  private TicketType ticketType;

  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name = "ticket_status_id")
  private TicketStatus ticketStatus;

  @OneToMany(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name = "comments_id")
  private Collection<Comments> comments;
  
  @ManyToOne(
      cascade = {
          CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH
        })
  @JoinColumn(name = "user_id")
  private Users user;
  
  public Ticket() {
  }
  
  /**
   * @param ticketId
   * @param title
   * @param description
   * @param creationTime
   * @param lastUpdateTime
   * @param department
   * @param ticketType
   * @param ticketStatus
   * @param comments
   */
    public Ticket(
    Integer ticketId,
    String title,
    String description,
    LocalDateTime creationTime,
    LocalDateTime lastUpdateTime,
    Department department,
    TicketType ticketType,
    TicketStatus ticketStatus,
    Collection<Comments> comments,
    Users user
  ) {
    super();
    this.ticketId = ticketId;
    this.title = title;
    this.description = description;
    this.creationTime = creationTime; // Defensive copy
    this.lastUpdateTime = lastUpdateTime;// Defensive copy
    this.department = department;
    this.ticketType = ticketType;
    this.ticketStatus = ticketStatus;
    this.comments = comments;
    this.user = user;
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
   * @return the creationTime
   */
  
  public LocalDateTime getCreationTime() {
   // return new Date(creationTime.getTime());
  	return creationTime;
  }

  /**
   * @param creationTime the creationTime to set
   */
  public void setCreationTime(LocalDateTime creationTime) {
    //if (creationTime != null) this.creationTime = new Date(creationTime.getTime());
  	this.creationTime = creationTime;
  }

  /**
   * @return the lastUpdateTime
   */
  public LocalDateTime getLastUpdateTime() {
   // return new Date(lastUpdateTime.getTime());
  	return lastUpdateTime;
  	
  }

  /**
   * @param lastUpdateTime the lastUpdateTime to set
   */
  public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
   // this.lastUpdateTime = new Date(lastUpdateTime.getTime());
  	this.lastUpdateTime = lastUpdateTime;
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

  
  
  /**
 * @return the user
 */
public Users getUser() {
return user;}

/**
 * @param user the user to set
 */
public void setUser(Users user) {
this.user = user;}

@Override
  public String toString() {
    return "Ticket [ticketId=" + ticketId + ", title=" + title
        + ", description=" + description + ", creationTime="
        + creationTime + ", lastUpdateTime=" + lastUpdateTime
        + ", department=" + department + ", ticketType=" + ticketType
        + ", ticketStatus=" + ticketStatus + ", comments=" + comments
        +"]";
    }
}

