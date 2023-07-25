package staticBlock;


class StaticDemo
{
	//constructor 
	public StaticDemo()
	{
		System.out.println("I am in StaticDemo Constructor");
	}
	//static block 
	static {
		
		System.out.println("i am in static block");
		
	}
}

public class StaticBlock {

	public static void main(String[] args) {
		
		//static block invoke first;
		//constructor invoke after static block
		StaticDemo sd = new StaticDemo();
	}
}
