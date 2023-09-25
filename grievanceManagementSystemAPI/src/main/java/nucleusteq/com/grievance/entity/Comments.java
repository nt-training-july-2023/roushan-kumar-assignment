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
   * coments Id.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  /**
   * comments.
   */
  @Column
  private String comments;
  /**
   * Commented by.
   */
  private String commentedBy;

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
   * @return the commentsId
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
   * return comment.
   *
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * set comments.
   *
   * @param commentsParam the comments to set
   */
  public void setComments(final String commentsParam) {
    this.comments = commentsParam;
  }

  /**
  * @return the commentedBy
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
   * Detail of single comment.
   */
  @Override
  public String toString() {
    return "Comments [commentId="
          + commentId + ", comments=" + comments + "]";
  }
}

