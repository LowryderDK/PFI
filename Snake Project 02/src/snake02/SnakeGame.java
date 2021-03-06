//based on tutorial: https://www.youtube.com/watch?v=9eQJAWhRHQg&t=1617s

package snake02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;	//Graphics class library
import java.awt.Image;		//Image class library
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Vicky er for sej
//yiiiiir

//This application controls size of the application, its background and controls

//implements runnable means using thread
public class SnakeGame extends Applet implements Runnable, KeyListener		
{
	
	Graphics graphics;	//Using library to create a graphics variable
	Image canvas;		//Image class instance canvas
	Thread thread;
	Snake snake;
	boolean gameOver;
	Food food;
	
	public void init() //Initiates window,  method from the Applet class
	{	
		this.resize(600, 400); //Setting window size
		gameOver = false;
		canvas = createImage(400, 400);	//Creating image with same size as application
		graphics = canvas.getGraphics();
		this.addKeyListener(this);
		snake = new Snake();
		food = new Food(snake);
		thread = new Thread(this);
		thread.start();
		
	}
	
	//this one has graphics. 
	public void paint (Graphics g) //
	{
		graphics.setColor(Color.black);	//Sets color of background to black
		graphics.fillRect(0, 0, 400, 400);	//Fills whole window with black from top left
		g.setColor(Color.GREEN);
		g.fillRect(400, 0, 200, 400);
		
		if(!gameOver)
		{
			snake.draw(graphics);
			food.draw(graphics);
			
		}
		else
		{
			graphics.setColor(Color.RED);
			graphics.drawString("Game Over",  180, 150);
			graphics.drawString("Score:" + food.getScore(), 180, 170);
		}
		
		g.drawImage(canvas, 0, 0, null);		
		
	}
	
	
	public void update (Graphics g)
	{
		paint(g);
	}
	
	
	public void repaint (Graphics g)
	{
		paint(g);
	}
	
	
	public void run()		//the game is run by an infinite for-loop
	{
		for(;;)		//Infinite for-loop
		{
			
			if(!gameOver) 
			{
				snake.move();
				this.checkGameOVer();
				food.snakeCollision();
				this.repaint(); //Updates the window graphics

			}
			
			try
			{
				Thread.sleep(40);	//setting the speed of the snake
			}
			
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void checkGameOVer()
	{
		if (snake.getX() < 0 || snake.getX() > 396)
			gameOver = true;
		if (snake.getY() < 0 || snake.getY() > 396)
			gameOver = true;
		
		if (snake.snakeCollision())
		{
			gameOver = true;
		}
	}
	
	
	public void keyPressed(KeyEvent e) 	//Enables the keyPressed functionality in program
	{
		if(!snake.isMoving()) //If snake is not moving, we are going to start moving it
		{
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			snake.setIsMoving(true);
		}
		}
						
			
		if(e.getKeyCode() == KeyEvent.VK_UP)	//If snake not going down, allow snake to go up
		{
			if(snake.getYdir() != 1) 
			{
				snake.setYdir(-1);
				snake.setXdir(0);
			}	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)	//If snake not going up, allow snake to go down
		{
			if(snake.getYdir() != -1) 
			{
				snake.setYdir(1);
				snake.setXdir(0);
			}	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)	//If snake not going right in x axis, go left
		{
			if(snake.getXdir() != 1) 
			{
				snake.setXdir(-1);
				snake.setYdir(0);
			}	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(snake.getXdir() != -1)
			{
				snake.setXdir(1);
				snake.setYdir(0);
			}
		}
		

		}

	
	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	
	public void keyTyped(KeyEvent arg0) 
	{
		
	}
	
	
}

	