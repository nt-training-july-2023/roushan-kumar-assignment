package finalMethod;

class Area{
	
	String shape;
	
	public Area(String shape)
	{
		this.shape=shape;
	}
	
	public final void display()
	{
		System.out.println("Inside display method in Area Class");
		System.out.println("Shape of object "+shape);
	}
	
	public void show()
	{
		System.out.println("inside show method in Area Class");
		System.out.println(" your object is "+shape);
	}
	
}


class Shape extends Area{

	public Shape(String shape) {
		super(shape);
		
	}
	
	public void show()
	{
		System.out.println("Inside show method in Shape Class");
		System.out.println("your object is "+shape);
	}
	
}

public class FinalMethod {

	public static void main(String[] args) {
		Shape c = new Shape("Circle");
		c.show();
		c.display();
	}
}
