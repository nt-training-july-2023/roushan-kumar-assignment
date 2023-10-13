package nucleusteq.com.grievance.exception;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import nucleusteq.com.grievance.controller.UsersController;

public class ExceptionHandlerTest {
  @InjectMocks
  private ExceptionHandler exceptionHandler;

  @InjectMocks
  private UsersController userController;
  
  @Mock
  private MethodArgumentNotValidException exception;

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

  @Test
  public void testHandleMethodArgsNotValidExceptionMy() {

      FieldError fieldError1 = new FieldError("objectName", "field1", "Error message 1");
      FieldError fieldError2 = new FieldError("objectName", "field2", "Error message 2");
      List<ObjectError> fieldErrors = Arrays.asList(fieldError1, fieldError2);

      when(exception.getAllErrors()).thenReturn(fieldErrors);

      ResponseEntity<Map<String, String>> response = exceptionHandler.handleMethodArgsNotValidExceptionMy(exception);

      assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

      Map<String, String> responseBody = response.getBody();
      assertEquals(2, responseBody.size());
      assertEquals("Error message 1", responseBody.get("field1"));
      assertEquals("Error message 2", responseBody.get("field2"));
  }
}

