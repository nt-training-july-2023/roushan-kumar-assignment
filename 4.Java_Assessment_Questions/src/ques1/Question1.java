package ques1;
/**
 * 
 * @author roushan
 * @version 1.0
 * 
 */


public class Question1 {
	public static void main(String[] args) {
		Circle c = new Circle(5);
		System.out.println("Area Of circle "+c.areaOfCircle(c.radius));
		
		Rectangle r = new Rectangle(5,4);
		System.out.println("Area of Rectangle "+r.areaOfRectangle(5, 4));
		
		Triangle t = new Triangle(4, 5);
		System.out.println("Area of Triangle "+t.areaOfTriangle(4, 5));
	}
}
