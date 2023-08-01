package task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee 
{
	private int id;
	private String name;
	private int age;
	
	

	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}



	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
	
}
class SortById implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2) {
		
		if(e1.getId()==e2.getId())
			return 0;
		else if(e1.getId()>=e2.getId())
			return 1;
		else 
			return -1;
	}
}

public class ComparatorEx {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		
		//add in empList
		empList.add(new Employee(2,"Roushan",23));
		empList.add(new Employee(3,"Alok",22));
		empList.add(new Employee(4,"Jagat",23));
		empList.add(new Employee(1,"Asutosh",24));
		
		for(Employee e :empList)
		{
			System.out.println(e.toString());
		}
		
		//empList.sort(new SortById());
		Collections.sort(empList,new SortById());
		
		System.out.println();
		System.out.println("After Soring By Id");
		System.out.println();
		
		for(Employee e :empList)
		{
			System.out.println(e.toString());
		}
	}
}
