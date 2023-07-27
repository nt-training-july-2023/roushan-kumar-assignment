package ques2;

interface Shape{
	
	public void area();
	
}


public class Question2 {
	public static void main(String[] args) {
		int radius=3;
		int l=2;
		int b=4;
		final float pi=3.14f;
		int height=10;
		
		Shape circle = ()->{
			float area=0.0f;
			area = (3.14f)*radius*radius;
			System.out.println("Radius of circle "+radius);
			System.out.println("area of circle "+area);
		};
		circle.area();
		
		System.out.println();
		Shape rectangle = ()->{
			int area=0;
			area = l*b;
			System.out.println("Length : "+l+", width : "+b);
			System.out.println("area of rectangle "+area);
		};
		rectangle.area();
		
		
		System.out.println();
		Shape square = ()->{
			int area=0;
			area = l*l;
			System.out.println("Length : "+l);
			System.out.println("area of square "+area);
		};
		square.area();
		
		System.out.println();
		Shape cube = ()->{
			int area=0;
			area = l*l*l;
			System.out.println("Length : "+l);
			System.out.println("area of cube "+area);
		};
		cube.area();
		
		System.out.println();
		Shape sphere = ()->{
			float area=0.0f;
			area = (float) (((float)4/3)*(3.14d)*radius*radius*radius);
			System.out.println("radius : "+l);
			System.out.println("area of sphere "+area);
		};
		sphere.area();
		
		
		System.out.println();
		Shape cylinder = ()->{
			float area=0.0f;
			area = 2*pi*radius*height;
			System.out.println("radius : "+radius+", height: "+height);
			System.out.println("area of cylinder "+area);
		};
		cylinder.area();
		
		
		
	}
}
