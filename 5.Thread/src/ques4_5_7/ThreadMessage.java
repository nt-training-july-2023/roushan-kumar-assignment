package ques4_5_7;

public class ThreadMessage extends Thread{

	String message;

	public ThreadMessage(String message) {
		super();
		this.message = message;
	}
	
	public void run()
	{
		System.out.println("Reading message : "+message);
		
	}
	
}
