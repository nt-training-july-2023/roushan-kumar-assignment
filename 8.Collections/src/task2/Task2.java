package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
	@SuppressWarnings("serial")
	public static void main(String[] args) throws FileNotFoundException {
		Set<String> s = new LinkedHashSet<String>() ;
		
		
		File f = new File("D:\\NucleusTeq-Traning\\8.Collections\\src\\task2\\word.txt");
		Scanner sc= new Scanner(f);
		
		while(sc.hasNext())
		{
			if(s.size()>20)
				break;
			s.add(sc.nextLine());
		}
		for(String word:s)
			System.out.print(word+" ");
		
		//Add all
		List<String> l = new ArrayList<String>() {
			{
				add("people");
				add("human");
				add("world");
			}
		};
		s.addAll(l);
		System.out.println();
		System.out.println(s);
		
		//Contains
		if(s.contains("hello"))
			System.out.println("it's contain \"hello\"");
		
		//size of LinkedHashSet
		System.out.println("Size :"+s.size());
		
		//remove
		s.remove("hello");
		System.out.println(s);
		
		//remove all
		s.removeAll(l);
		System.out.println(s);
		
		//Hashcode
		System.out.println("Hashcode of this set :"+s.hashCode());
		sc.close();
	}
}
