package nucleusteq.com.grievance.exception;

public class InternalServerError extends RuntimeException{
	public InternalServerError(String message) {
    super(message);
//    System.out.println(message);
  }
}

