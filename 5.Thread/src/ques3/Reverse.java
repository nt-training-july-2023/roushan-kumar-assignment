package ques3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reverse implements Runnable {
	
	List<Integer>  list = new ArrayList<Integer>();

	public Reverse(List<Integer> l) {
		super();
		list = l;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Collections.reverse(list);
		System.out.println(list);
		
	} 
			
}
