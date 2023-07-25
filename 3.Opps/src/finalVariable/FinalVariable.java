package finalVariable;

import java.util.Scanner;

public class FinalVariable {
	public static void main(String[] args) {
		
		//declaring and initializing final pi value
		final double pi = 3.14;
		int radius;
		double area = 0.0d;
		System.out.println("Value of pi "+pi);
		
		System.out.println("Value of pi "+pi);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius of circle :");
		radius = sc.nextInt();
		
		//area of circle;
		area = pi*radius*radius;
		
		System.out.println("Area of circle of radius "+radius+" is "+area );
		sc.close();
		
	}
}
