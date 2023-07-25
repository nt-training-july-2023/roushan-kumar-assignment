package innerClass;

/**
 * Nested Inner Class
 * Method Local Inner Classes 
 * 
 */
public class OuterClass {

	int x = 65;
	int y = 78;
	static int v = 54; 
	public void display()
	{
		System.out.println("Method Display of OuterClass");
	}
	
	public void printY()
	{
		System.out.println("Y: "+y);
	}
	
	//static outer method
	public static void saticOuterMethod()
	{
		//can not access not static variable 
		//x=+1;
		v+=2;
		System.out.println("V: " + v);
	}
	
 	public void outerMethod()
	{
		
		System.out.println("Inside outerMethod class");
		
		//inner class inside outerMetho 
		class inner
		{
			public inner()
			{
				System.out.println("inner Class object created");
			}
			
			public void innerMethod()
			{
				System.out.println("Method innerMethod of inner Class inside outerMethod");
			}
		}
			//create object of inner Class
			inner i = new inner();
			
			//calling method of innerClass
			i.innerMethod();
		
		
	}
	
	
	//Nested Inner Class
	public class InnerClass{
		
		public void display()
		{
			System.out.println("Method Display of nested innerClass");
		}
		
		public void valueX()
		{
			System.out.println("x: "+x);
		}
	}
	
	public static class staticInnerClass
	{
		public void displayV()
		{
			System.out.println("V: "+v);
		}
		
		public static void printV()
		{
			System.out.println("V: "+v);
		}
		
	}
	
	
	
}
