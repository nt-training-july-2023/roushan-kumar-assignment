package nucleusteq.com.grievance.exception;

public class BadRequestError extends RuntimeException {

  /**
   * BadRequestError handler.
   *
   * @param message Message given by function.
   */
  public BadRequestError(final String message) {
    super(message);
  }
}

