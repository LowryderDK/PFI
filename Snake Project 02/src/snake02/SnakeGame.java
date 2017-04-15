package snake02;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;		//Image class
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//This application controls size of the application, its background and controls


public class SnakeGame extends Applet implements Runnable, KeyListener
{
	
	Graphics gfx;
	Image img;		//Image class instance img
	Thread thread;
	Snake snake;
	Token token;
	boolean gameOver;
	
	
	public void init() //Initiates window
	{	
		this.resize(400, 400); //Setting window size
		img = createImage(400, 400);	//Creating image with same size as application
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snake = new Snake();
		thread = new Thread(this);
		thread.start();
		gameOver = false;
	}
	
	//this one has graphics
	public void paint (Graphics g)
	{
		g.setColor(Color.black);	//Sets color of background to black
		g.fillRect(0, 0, 400, 400);	//Fills whole window with black from top left
		snake.draw(gfx);
		
		if(!gameOver)
		{
			snake.move();
			this.checkGameOVer();
			
			snake.draw(gfx);
		}
		
		else{
			gfx.setColor(Color.RED);
			gfx.drawString("Game Over",  180, 150);
			gfx.drawString("Score:" + token.getScore(), 180, 170);
		}
		
		g.drawImage(img, 0, 0, null);
		
		
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
			
			if(!gameOver) {
				snake.move();
				this.checkGameOVer();
				token.snakeCollision();

				
			}
			
			this.repaint();
			
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
	
	
	public void keyPressed(KeyEvent e) 	//Enables the keypressed functionality in program
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
				snake.setYdir(1);
				snake.setXdir(0);
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
	