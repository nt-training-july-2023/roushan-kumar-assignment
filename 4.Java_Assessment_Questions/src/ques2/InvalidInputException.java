package ques2;

public class InvalidInputException extends RuntimeException {
	InvalidInputException(String message)
	{
		super(message);
		System.out.println(message);
	}
}
