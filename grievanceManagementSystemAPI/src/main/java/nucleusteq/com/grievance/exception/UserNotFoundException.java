package nucleusteq.com.grievance.exception;

  public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
      super(message);
      System.out.println(message);
    }
}

