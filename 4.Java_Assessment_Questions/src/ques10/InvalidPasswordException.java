package ques10;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {

	public InvalidPasswordException(String message) {
		System.out.println(message);
	}

}
