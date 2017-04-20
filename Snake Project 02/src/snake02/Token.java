//This class is for the food or 'token' the snake eats

package snake02;

import java.awt.Color;
import java.awt.Graphics;

public class Token {
	
	private int x, y, score;
	private Snake snake;
	
	public Token(Snake s)	//
	{
		x = (int) (Math.random() * 395);
		y = (int) (Math.random() * 395);
		snake = s;
		
	}
	
	public void changePosition() 
	{
		x = (int) (Math.random() * 395);
		y = (int) (Math.random() * 395);
		
	}

	//acccesser for score
	public int getScore() 
	{
		return score;
	}
	
	public void draw (Graphics g) 
	{
		g.setColor(Color.green);
		g.fillRect(x, y, 6, 6);
	}

	public boolean snakeCollision() 
	{
		int snakeX = snake.getX() +2;	//Returns x position of head of snake
		int snakeY = snake.getY() +2;
		
		if (snakeX >= x-1 && snakeX <= (x + 7))	//Comparing x value of snake to x value of token
		
			if (snakeY >= y-1 && snakeY <= (y + 7))
			{
				changePosition();
				score++;
				snake.setElongate(true);
				return true;
			
		}
				return false;
		
	}
}


