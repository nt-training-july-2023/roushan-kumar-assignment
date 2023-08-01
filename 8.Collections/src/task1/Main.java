package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		List<Integer>  numbers = new ArrayList<Integer>();
		Random r = new Random();
		for(int i=0;i<20;i++)
			numbers.add(r.nextInt(100));
		
		System.out.println("numbes");
		for(Integer x : numbers)
			System.out.print(x+" ");
		
		System.out.println();
		System.out.println("After Reverse");
		Collections.reverse(numbers);
		for(Integer x : numbers)
			System.out.print(x+" ");
		
		for(int i=0;i<20;i++)
		{
			if(numbers.get(i)>50)
				numbers.set(i, numbers.get(i)+5);
		}
		
		System.out.println();
		System.out.println("After Updating with 5");
		
		for(Integer x : numbers)
			System.out.print(x+" ");
		
		System.out.println();
		System.out.println("Number less than 60");	
		for(Integer x : numbers) {
			if(x<60)
			System.out.print(x+" ");
		}
		
		
		
	}
}
