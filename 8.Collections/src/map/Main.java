package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Map<Integer,String> emp = new HashMap<Integer, String>();
		
		//Calling add method
		add(emp,1,"Roushan");
		add(emp,2,"Jagat");
		add(emp,3,"Alok");
		add(emp,4,"Alok");
		//print emp 
		System.out.println(emp);
		
		for(int i:emp.keySet())
		{
			System.out.println(i+" -> "+emp.get(i));	
		}
		
		for(Map.Entry<Integer, String> m: emp.entrySet())
		{
				System.out.println(m.getKey()+" "+m.getValue());
		}
		
		
		String name="";
		System.out.println("Enter name for remove: ");
		Scanner sc  = new Scanner(System.in);
		name = sc.nextLine();
		
		remove(emp,name);
		for(Map.Entry<Integer, String> m: emp.entrySet())
		{
				System.out.println(m.getKey()+" "+m.getValue());
		}
		sc.close();
	}

	private static void remove(Map<Integer, String> emp, String name) {
		
		List<Integer> keys = new ArrayList<Integer>();
		
		for(Map.Entry<Integer, String> m: emp.entrySet())
		{
				if(m.getValue().equals(name))
				{
					keys.add(m.getKey());
				}
		}
		
		for(Integer k : keys)
		{
			emp.remove(k);
		}
		
	}

	private static void add(Map<Integer, String> emp, int key, String value) {
		emp.put(key, value);
		
	}
}
