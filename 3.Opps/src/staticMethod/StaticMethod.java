package staticMethod;

class Student{
	
	private int id;
	private String name;
	private static String college="MACT";
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//static method to get the value of static variable  
	public static String getCollege() {
		return college;
	}
	//static method to change the value of static variable  
	public static void setCollege(String clg) {
		college=clg;
		
		try {
			//Cannot make a static reference to the non-static field name
			//name="someone";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	

	@Override
	public String toString() {
		return "Studnet [id=" + id + ", name=" + name +", college = " +college + " ]";
	}
	
	
}

public class StaticMethod {

	public static void main(String[] args) {
		Student s1 = new Student(1, "Roushan");
		Student	s2 = new Student(2,"Ratan");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
		//calling static method 
		Student.setCollege("MANIT Bhopal");
		
		System.out.println();

		System.out.println("After College name change");
		System.out.println();
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}
}
