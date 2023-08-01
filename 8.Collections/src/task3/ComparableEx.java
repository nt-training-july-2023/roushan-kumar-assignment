package task3;

import java.util.Arrays;

class Student implements Comparable<Student>
{
	private int id;
	private String name;
	private int age;
	
	

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}



	@Override
	public int compareTo(Student s) {
		
		//compare with id
		if(id==s.id)
			return 0;
		else if(id>s.id)
		{
			return 1;
		}
		else 
			return -1;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}

public class ComparableEx {
	public static void main(String[] args) {
		int n=4;
		Student s[] = new Student[n];
		s[0]= new Student(2,"Roushan",23);
		s[1]= new Student(4,"Alok",22);
		s[2]= new Student(1,"Jagat",24);
		s[3]= new Student(3,"Asutosh",25);
		
		for(int i=0;i<n;i++)
			System.out.println(s[i].toString());
		
		System.out.println();
		
		System.out.println("After sorting");
		
		Arrays.sort(s);
		for(int i=0;i<n;i++)
			System.out.println(s[i].toString());
			
		
	}
}
