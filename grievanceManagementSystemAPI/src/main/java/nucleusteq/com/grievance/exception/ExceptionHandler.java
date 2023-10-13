package nucleusteq.com.grievance.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Globle Exception Handler.
 */
@RestControllerAdvice
public class ExceptionHandler {

  /**
   * UserNotFoundException.
   *
   * @param ex UserNotFoundException.
   * @return UserNotFoundException.
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @org.springframework.web.bind.annotation.ExceptionHandler(
      UserNotFoundException.class)
  public String userNotFoundException2(
      final UserNotFoundException ex) {
    return ex.getMessage();
  }

  /**
   * InternalServerError handler.
   *
   * @param ex InternalServerError.
   * @return InternalServerError.
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @org.springframework.web.bind.annotation.ExceptionHandler(
      InternalServerError.class)
  public String internalServerError(
      final InternalServerError ex) {
    return ex.getMessage();
  }

  /**
   * BadRequestError handler.
   *
   * @param ex BadRequestError.
   * @return BadRequestError.
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @org.springframework.web.bind.annotation.ExceptionHandler(
      BadRequestError.class)
  public String internalServerError(final BadRequestError ex) {
    return ex.getMessage();
  }

  /**
   * Method Argument Not Valid Exception.
   *
   * @param errors
   * @return Errors details.
   */
  @org.springframework.web.bind.annotation.ExceptionHandler(
      MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>>
  handleMethodArgsNotValidExceptionMy(
      final MethodArgumentNotValidException errors) {
    Map<String, String> res = new HashMap<>();
    errors.getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      res.put(fieldName, message);
    });
    return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
  }

  /**
   * No content handler.
   *
   * @param ex No Content Exception.
   * @return No Content Exception.
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @org.springframework.web.bind.annotation.ExceptionHandler(
      NotFoundException.class)
  public String notFoundException(
      final NotFoundException ex) {
    return ex.getMessage();
  }
}

