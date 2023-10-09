package nucleusteq.com.grievance.exception;

public class NotFoundException extends RuntimeException {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * @param message
   */
  public NotFoundException(final String message) {
    super(message);
  }
}
