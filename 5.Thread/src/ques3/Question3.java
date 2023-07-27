package ques3;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
 public static void main(String[] args) {
	
	 Number number = new Number(10);
	 
	 
	 List<Integer> list = new  ArrayList<Integer>();
	 
	 list.add(2);
	 list.add(3);
	 list.add(4);
	 list.add(5);
	 list.add(6);
	 list.add(7);
	 list.add(8);
	 list.add(9);
	 
	 SumOfNumber son = new SumOfNumber(list);
	 
	 Reverse reverse = new Reverse(list);
	 
	 Fabonacci f = new Fabonacci(10);
	 
	 f.run();
	 number.run();
	 reverse.run();
	 son.run();
	 
}
}
