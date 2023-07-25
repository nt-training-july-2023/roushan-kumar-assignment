package staticClass;

class Outer
{
	static int number=10;
	
	static class Inner{
		
		void print()
		{
			// nested class can access the static members of the outer class
			System.out.println("Number "+number);
		}
		
	}
	
}

public class StaticClass {
	public static void main(String[] args) {
		Outer.Inner i = new Outer.Inner();
		i.print();
	}
}
