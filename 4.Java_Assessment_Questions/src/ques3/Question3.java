package ques3;

class Rectangle
{
	int length;
	int width;
	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public int area() throws InvalidDimensionException
	{
		if(length<=0 || width<=0)
		{
			throw new InvalidDimensionException("length or width can not less than or equal to zero");
		}
		else
		return length*width;
		
		
	}
}
public class Question3 {
	public static void main(String[] args) throws InvalidDimensionException {
		Rectangle r = new Rectangle(5, -4);
		try {
			System.out.println(r.area());
		}
		catch (Exception e) {
			
		}
		System.out.println("Area");
		
		
	}
	
}
