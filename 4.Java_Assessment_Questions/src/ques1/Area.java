package ques1;

/**
 * @author Roushan
 * @version 1.0
 * @since 2023
 */

public class Area {
	
	final float pi=3.14f;
	
	/**
	 * 
	 * @param radius of circle
	 * @return area of circle
	 */
	
	public float areaOfCircle(int radius)
	{
		
		return  pi*radius*radius;
	}
	
	/**
	 * 
	 * @param length of Rectangle
	 * @param width of Rectangle
	 * @return area  of Rectangle
	 */
	public int areaOfRectangle(int length,int width )
	{
		return length*width;
	}
	
	/**
	 * 
	 * @param height of Triangle
	 * @param base of Triangle
	 * @return area of Triangle
	 */
	public float areaOfTriangle(int height,int base)
	{
		return height*base*(0.5f);
	}
}
