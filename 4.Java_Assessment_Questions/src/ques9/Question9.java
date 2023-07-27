package ques9;

import java.util.Scanner;

public class Question9 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int number=1;
		
		System.out.println("Enter a number :");
		Scanner sc = new Scanner(System.in);
		
		number = sc.nextInt();
			
		
		
		
		try {
			
			if(number%2==0)
			{
				System.out.println("Even Number");
			}
			else if (number%2==1)
				throw new NotEvenNumberException("Your input " + number+" is not even");
			else if(number != (int)number)
				throw new NotEvenNumberException("Your input " + number+" is invalid");
		} catch (Exception e) {
			
		}
		sc.close();
	}
}
