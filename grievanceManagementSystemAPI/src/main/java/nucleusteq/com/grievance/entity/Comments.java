package nucleusteq.com.grievance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_comments")
public class Comments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  private String comments;

  /**
   * @param commentsId
   * @param comments
   */public Comments(Integer commentsId, String comments) {
    super();
    this.commentId = commentsId;
    this.comments = comments;
  }

  /**
   * @return the commentsId
   */
  public Integer getCommentsId() {
    return commentId;
  }

  /**
   * @param commentsId the commentsId to set
   */
  public void setCommentsId(Integer commentsId) {
    this.commentId = commentsId;
  }

  /**
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * @param comments the comments to set
   */
  public void setComments(String comments) {
    this.comments = comments;
  }
}
