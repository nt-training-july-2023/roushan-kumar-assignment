package nucleusteq.com.grievance.exception;

  /**
  * User not found exception.
  */
  public class UserNotFoundException extends RuntimeException {

    /**
     * Handle user not found exception.
     *
     * @param message Message given by function.
     */
    public UserNotFoundException(final String message) {
      super(message);
      System.out.println(message);
    }
}

