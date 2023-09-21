package nucleusteq.com.grievance.exception;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerTest {
  @InjectMocks
  private ExceptionHandler exceptionHandler;

  @BeforeEach
  public void setUp() {
      MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testUserNotFoundException() {
      UserNotFoundException exception = new UserNotFoundException("User not found");
      String response = exceptionHandler.userNotFoundException2(exception);
      //assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
      assertEquals("User not found", response);
  }

  @Test
  public void testInternalServerError() {
      InternalServerError exception = new InternalServerError("Internal server error");
      String response = exceptionHandler.internalServerError(exception);
      //assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
      assertEquals("Internal server error", response);
  }

  @Test
  public void testBadRequestError() {
      BadRequestError exception = new BadRequestError("Bad request error");
      String response = exceptionHandler.internalServerError(exception);
      //assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
      assertEquals("Bad request error", response);
  }
}

