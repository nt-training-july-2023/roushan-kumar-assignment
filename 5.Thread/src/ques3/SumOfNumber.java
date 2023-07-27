package ques3;

import java.util.ArrayList;
import java.util.List;

public class SumOfNumber implements  Runnable {
	List<Integer> list = new ArrayList<Integer>();
	
	
	
	public SumOfNumber(List<Integer> list) {
		super();
		this.list = list;
	}

	public void run() {
		int sum=0;
		
		for (Integer integer : list) {
			sum+=integer;
		}
		
		System.out.println("Sum of number "+sum);
	}
} 
