//Denne klasse styrer pointers!

package snake02;

//Test

public class Point 
{
	
	private int xPos, yPos;
	
	//Default Point constructor
	public Point() 
	{
		xPos = 0;
		yPos = 0;
	}
	
	//Additional Point constructor
	public Point(int xPos, int yPos)
	{
		//assigning to instance variables
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	//creating access
	public void setX(int xPos)
	{
		this.xPos = xPos;
	}
	
	public void setY(int yPos)
	{
		this.yPos = yPos;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
}
