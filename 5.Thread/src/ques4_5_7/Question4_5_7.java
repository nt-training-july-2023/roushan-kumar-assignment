package ques4_5_7;

public class Question4_5_7 {
	
  public static void main(String[] args) {
	ThreadMessage tm1 =  new ThreadMessage("Hello everyone!");
	ThreadMessage tm2 =  new ThreadMessage("Good morning everyone!");
	ThreadMessage tm3 =  new ThreadMessage("good evening everyone!");
	ThreadMessage tm4 =  new ThreadMessage("good night everyone!");
	
	tm1.setPriority(1);
	tm2.setPriority(9);
	tm3.setPriority(8);
	tm4.setPriority(7);
	
	System.out.println("tm1.getPriority() :"+tm1.getPriority());
	System.out.println("tm1.getName()     : "+tm1.getName());
	System.out.println("tm1.getState()    :"+tm1.getState());
	
	
	tm1.start();
	tm3.start();
	tm4.start();
	tm2.start();
	

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println("after 5 sec :");
	System.out.println("tm1.getPriority() :"+tm1.getPriority());
	System.out.println("tm1.getName()     : "+tm1.getName());
	System.out.println("tm1.getState()    :"+tm1.getState());
	
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	System.out.println("after 5 sec :");
	System.out.println("tm1.getPriority() :"+tm2.getPriority());
	System.out.println("tm1.getName()     : "+tm2.getName());
	System.out.println("tm1.getState()    :"+tm2.getState());
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	System.out.println("after 5 sec :");
	System.out.println("tm1.getPriority() :"+tm3.getPriority());
	System.out.println("tm1.getName()     : "+tm3.getName());
	System.out.println("tm1.getState()    :"+tm3.getState());
	
}
}
