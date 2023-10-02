package nucleusteq.com.grievance.entitytest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import nucleusteq.com.grievance.entity.Comments;

public class CommentsTest {
  private Comments comments;
  
  @Test
  public void testGettersAndSetters()
  {
  	comments = new Comments();
  	comments.setCommentsId(1);
  	comments.setComments("Comments");
  	assertEquals(new Integer(1), comments.getCommentsId());
  	assertEquals("Comments", comments.getComments());
  }
}

