package anonymousInnerClass;

//Java anonymous inner class example using class
abstract class Human{  
	  abstract void eat(); 
	  abstract void play();
}  
//Java anonymous inner class example using interface 
interface Animal{  
	 void eat();  
	 void play();  
}  
	
public class AnonymousInnerClass {
	public static void main(String[] args) {
		Human p=new Human() {
			void eat()
			{
				System.out.println("Eating");
			}
			
			void play()
			{
				System.out.println("Playing");
			}
		};
		
		p.eat();
		p.play();
		
		
	 Animal a = new Animal() {
		 public void eat(){
			 System.out.println("Animal eating");
		 }

		@Override
		public void play() {
			
			System.out.println("Animal Playing");
		}
	 };
	 
	 a.eat();
	 a.play();
		
		
	}
}
