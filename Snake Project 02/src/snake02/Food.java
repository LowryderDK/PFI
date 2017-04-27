package snake02;

import java.awt.Color;
import java.awt.Graphics;

public class Food {	//This class is for the food objects the snake eats

	
	private int xPos, yPos, score;	//Variables controlling position of food and score
	private Snake snake;			//A reference to the snake Class to use in this code, I presume
	
	public Food(Snake s)	//This method is used to fetch a random location for foodspawns in the SnakeGame class
	{
		xPos = (int) (Math.random() * 395);
		yPos = (int) (Math.random() * 395);
		snake = s;
		
	}
	
	public void changePosition() //This method is used to change position of a food object when snake hits (eats) it
	{
		xPos = (int) (Math.random() * 395);
		yPos = (int) (Math.random() * 395);
		
	}


	public int getScore() 	//access or "getter" for score variable shown after game is over
	{
		return score;		//used in SnakeGame class to display a score value to user
	}
	
	public void draw (Graphics g) //Method defines green color and size 6*6 pixels of food
	{
		g.setColor(Color.green);
		g.fillRect(xPos, yPos, 6, 6);
	}

	public boolean snakeCollision() //The "hit" function when snake collides with food
	{
		int snakeX = snake.getX() +2;	//Returns x position of head of snake
		int snakeY = snake.getY() +2;	//Returnx y position of head of snake
		
		if (snakeX >= xPos-1 && snakeX <= (xPos + 7))	//Comparing x position of snake to x position of food object
		
			if (snakeY >= yPos-1 && snakeY <= (yPos + 7)) //And y position of snake to y position of food object
			{
				changePosition();						//Runs the method for a new random food position
				score++;								//Increments the score value used in SnakeGame class
				snake.setCanAddSquare(true);			//Tells Snake class to increase by one square after collision
				return true;		
			
		}
				return false;
		
	}
}




