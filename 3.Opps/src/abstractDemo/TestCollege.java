package abstractDemo;

public class TestCollege {
	public static void main(String[] args) {
		College admerit = new Admerit();
		College anCollege = new ANCollege();
		
		System.out.println("Admerit Course:");
		admerit.course();
		System.out.println("ANCollege Course:");
		anCollege.course();
		
	}
}
