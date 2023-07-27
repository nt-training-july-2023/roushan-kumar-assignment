package lamda;

interface Sbi{
	public void display();
	//public void print();
}


public class LamdaDemo {
	public static void main(String[] args) {
		String message="Hello ";
		String name = "roushan" ;
		Sbi b = new Sbi() {
			public void display()
			{
				System.out.println(message+name);
			}

//			@Override
//			public void print() {
//				System.out.println("message+name");
//				
//			}
		}; 
		b.display();
		
		
		Sbi s = ()->{
		
			System.out.println("name : "+name);
		};
		s.display();
	}
}
