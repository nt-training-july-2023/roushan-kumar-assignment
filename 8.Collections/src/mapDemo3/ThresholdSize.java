package mapDemo3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThresholdSize {
	public static void main(String[] args) {
		Map<Integer,String> data = new HashMap<Integer, String>();
		data.put(1, "one");
		data.put(2, "two");
		data.put(3, "three");
		data.put(4, "four");
		data.put(5, "five");
		data.put(6, "six");
		data.put(7, "seven");
		data.put(8, "eight");
		data.put(9, "nine");
		data.put(10, "ten");
		
		int thresHoledSize = 0;
		
		printMap(data);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter threshold size : ");
		thresHoledSize = sc.nextInt();
		sc.close();
		
		if(thresHoledSize>=data.size())
		{
			data.clear();
		}
		
		printMap(data);
		addData(data,11,"Eleven");
		printMap(data);
	}

	private static void addData(Map<Integer, String> data,int key,String value) {
		
		data.put(key, value);
		return ;
	}

	private static void printMap(Map<Integer, String> data) {
		
		if(data.size()==0)
		{
			System.out.println("No data found!");
			return;
		}
		
		for(Map.Entry<Integer, String> entity : data.entrySet())
		{
			
			 System.out.println("Key "+entity.getKey() + ", value "+entity.getValue());
			
		}
		
	}
}
