package nucleusteq.com.grievance.exception;

import org.springframework.http.HttpStatus;
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
}

