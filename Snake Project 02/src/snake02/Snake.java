//Snake is a list of points that can be modified, when snake runs over target, a point is added and
//whole list is drawn
//test

package snake02;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Snake 
{
	
	List<Point> snakePoints; 
	int xDir, yDir;
	boolean isMoving, CanAddSquare;	//setting direction with booleans so snake can only move in one dir at once
	final int STARTSIZESIZE = 20, STARTX = 150, STARTY = 150;	//Setting start size and position of snake
	
	
	public Snake()		//Constructor - starts by snake not moving
	{
		snakePoints = new ArrayList<Point>();
		xDir = 0;
		yDir = 0;
		isMoving = false;
		CanAddSquare = false;
		snakePoints.add (new Point(STARTX, STARTY));
		for( int i = 1; i < STARTSIZESIZE; i++)
		{
			snakePoints.add(new Point(STARTX - i * 4, STARTY));
		}
	}
	

	public void draw(Graphics g)	//Instantiates the player controlled snake object
	{
		g.setColor(Color.white);
		
		for(Point p : snakePoints) {	//Snake is made up of several small rectangles
		g.fillRect(p.getX(), p.getY(), 4, 4);	//and filled up with colors
		}
	}
	
	public void move() 
	{
		
		if  (isMoving) 
		{	
		Point temp = snakePoints.get(0);
		Point last = snakePoints.get(snakePoints.size() - 1);
		Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4); 
		
		for(int i = snakePoints.size() - 1; i >= 1; i--)	//Snake point becomes the point it was before
		{
			snakePoints.set(i, snakePoints.get(i - 1));
		}
		snakePoints.set(0, newStart);
		if (CanAddSquare) {
			snakePoints.add(last); //adds another snakePoint to the last Point
			CanAddSquare = false;	   // and resets CanAddSquare to false.
		}
		

		}
		
		
	}
	
	
	
	public boolean snakeCollision() 
	{
		int x = this.getX();
		int y = this.getY();
		for (int i = 1; i < snakePoints.size(); i++) 		//looping through each pixel on the snake?
		{
			if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)	//if any pixel on the snake, is the same as the 
				return true;														//current x position of the head of the snake -> collision
		}
				return false;
	}
	
	//control if snake is currently moving
	public boolean isMoving()  //So it can be accessed from snake game
	{
		return isMoving;
	}
	
	public void setIsMoving(boolean b) //if b is true then isMoving is set to true 
	{								   //(which happens in the SnakeGameClass, whenever a key is pressed)
		isMoving = b;
		
	}
	
	public int getXdir()
	{
		return xDir;
	}
	
	
	
	public int getYdir()
	{
		return yDir;
	}
	
	public void setXdir(int x) //xDir and yDir is set in the snakeGame class when pressing a key. 
	{							//The value is 0 when it is not moving on that axis
		xDir = x;
	}
	
	public void setYdir(int y)
	{
		yDir = y;
	}

	
	public int getX() //X position of head of snake
	{
		return snakePoints.get(0).getX();
	}
	
	public int getY() //Y Position of head of snake
	{
		return snakePoints.get(0).getY();
	}
	
	public void setCanAddSquare(boolean b) // If b is true - CanAddSquare is true (which happens in the Food class, when there is collision)
	{
		CanAddSquare = b;
	}

}
