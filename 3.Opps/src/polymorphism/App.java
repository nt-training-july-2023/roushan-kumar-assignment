package polymorphism;

public class App {
	public static void main(String[] args) {
		int val1=34;
		int val2=34;
		
		//compile time Polymorphism 
		System.out.println("Demo of compile time Polymorphism");
		int sum1 = Helper.sum(val1, val2);
		float sum2 = Helper.sum((float)val1, (float)val2);
		
		System.out.println(sum1);
		System.out.println(sum2);
		
		//runtime Polymorphism
		System.out.println("Demo of runtime Polymorphism");
		Animal a = new Animal();
		a.sound();
		
		Animal b = new Dog();
		b.sound();
		
		
		
	}
}
