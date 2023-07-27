package ques7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question7 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<Integer> s1 = new ArrayList<Integer>();
		int n;
		System.out.println("Enter Number for string");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 0 ; i<n;i++)
		{
			s1.add(sc.nextInt());
		}
		System.out.println("List Of Integer");
		for(int i=0;i<n;i++)
		{
			 System.out.println(i +"-> "+s1.get(i));
		}
		System.out.println("Enter index for Integer");
		int index;
		index = sc.nextInt();
		try {
			if(s1.size()==0)
			{
				throw new NullPointerException("List is null");
			}
			else if(index>=0 && index<s1.size()) {
			 System.out.println("Integer at index "+index + " is "+ s1.get(index));
			 
			}
			else
			{
				throw new IndexOutOfBoundsException("Input index "+index+ " is out of length");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			//sc.close();
		}
		
		
		
		
		
		
		
		sc.close();
		return ;
	}
}
