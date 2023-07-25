package MultipleInheritance;

public class Child implements Parent1, Parent2 {

	@Override
	public void strong() {
		System.out.println("Strong child");
		
	}

	@Override
	public void tall() {
		System.out.println("tall child");
		
	}
	
	

}
