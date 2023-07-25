package staticVarialble;

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

	public static String getCollege() {
		return college;
	}

	

	@Override
	public String toString() {
		return "Studnet [id=" + id + ", name=" + name +", college = " +college + " ]";
	}
	
	
}

public class StaticVariable {

	public static void main(String[] args) {
		
		Student s1 = new Student(1, "Roushan");
		Student	s2 = new Student(2,"Ratan");
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
	}
	
}
