package ques2;

public class Question2 {
	public static void main(String[] args) {
		Thread1  t1 = new Thread1();
		Thread2  t2 = new Thread2();
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t1.getState());
		t1.start();
		t2.start();
		
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());
	}
}
