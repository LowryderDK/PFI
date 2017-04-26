//This class is for the food or 'token' the snake eats
//Test
package snake02;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
	private int xPos, yPos, score;
	private Snake snake;
	
	public Food(Snake s)	//
	{
		xPos = (int) (Math.random() * 395);
		yPos = (int) (Math.random() * 395);
		snake = s;
		
	}
	
	public void changePosition() 
	{
		xPos = (int) (Math.random() * 395);
		yPos = (int) (Math.random() * 395);
		
	}

	//acccesser for score
	public int getScore() 
	{
		return score;
	}
	
	public void draw (Graphics g) 
	{
		g.setColor(Color.green);
		g.fillRect(xPos, yPos, 6, 6);
	}

	public boolean snakeCollision() 
	{
		int snakeX = snake.getX() +2;	//Returns x position of head of snake
		int snakeY = snake.getY() +2;
		
		if (snakeX >= xPos-1 && snakeX <= (xPos + 7))	//Comparing x value of snake to x value of token
		
			if (snakeY >= yPos-1 && snakeY <= (yPos + 7))
			{
				changePosition();
				score++;
				snake.setCanAddSquare(true);
				return true;
			
		}
				return false;
		
	}
}




