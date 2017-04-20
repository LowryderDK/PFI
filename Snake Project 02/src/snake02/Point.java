package snake02;



public class Point 
{
	
	private int x, y;
	
	//Default Point constructor
	public Point() 
	{
		x = 0;
		y = 0;
	}
	
	//Additional Point constructor
	public Point(int x, int y)
	{
		//assigning to instance variables
		this.x = x;
		this.y = y;
	}
	
	//creating access
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
