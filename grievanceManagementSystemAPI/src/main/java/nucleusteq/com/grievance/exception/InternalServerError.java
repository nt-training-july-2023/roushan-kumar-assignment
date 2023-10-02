package nucleusteq.com.grievance.exception;

public class InternalServerError extends RuntimeException {

  /**
  * serialVersionUID.
  */
  private static final long serialVersionUID = 1L;

/**
   * Internal server error handler.
   *
   * @param message Message given by function.
   */
  public InternalServerError(final String message) {
    super(message);
  }
}

