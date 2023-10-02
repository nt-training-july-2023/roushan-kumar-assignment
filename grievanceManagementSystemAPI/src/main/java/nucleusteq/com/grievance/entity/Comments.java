package nucleusteq.com.grievance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Ticket Comments entity for the grievance management system.
 */
@Entity
@Table(name = "ticket_comments")
public class Comments {

  /**
   * Comments Id.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  /**
   * Comments.
   */
  @Column
  private String comments;
  /**
   * Commented by.
   */
  private String commentedBy;

  /**
   * Commented Time.
   */
  private String time;
  /**
   * No args constructor.
   */
  public Comments() {
  }

  /**
   * All arg constructor.
   *
   * @param commentsIdParam id.
   * @param commentsParam comments.
   */
   public Comments(
     final Integer commentsIdParam,
     final String commentsParam) {
    super();
    this.commentId = commentsIdParam;
    this.comments = commentsParam;
  }

  /**
   * return comment id.
   *
   * @return The commentsId
   */
  public Integer getCommentsId() {
    return commentId;
  }

  /**
   * set Comments id.
   *
   * @param commentsIdParam the commentsId to set
   */
  public void setCommentsId(final Integer commentsIdParam) {
    this.commentId = commentsIdParam;
  }

  /**
   * Return comment.
   *
   * @return The comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * Set comments.
   *
   * @param commentsParam the comments to set
   */
  public void setComments(final String commentsParam) {
    this.comments = commentsParam;
  }

  /**
  * @return The commented by
  */
  public String getCommentedBy() {
   return commentedBy;
  }

  /**
   * @param commentedByParam the commentedBy to set
   */
  public void setCommentedBy(final String commentedByParam) {
   this.commentedBy = commentedByParam;
  }

  /**
  * @return the time
  */
  public String getTime() {
  return time;
  }

  /**
  * @param dateTime the time to set
  */
  public void setTime(final String dateTime) {
  this.time = dateTime;
  }

  /**
   * Detail of single comment.
   */
  @Override
  public String toString() {
    return "Comments [commentId="
          + commentId + ", comments=" + comments + "]";
  }
}

