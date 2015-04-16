import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class Mancala
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int stones;

	public Mancala(int width, int height)
	{
		this.x = 0; 
		this.y = 0;
		this.width = width; 
		this.height = height; 
		stones = 0;
	}
	
	public int getWidth() 
	{ 
		return width; 
	}
	
	public int getHeight() 
	{ 
		return height; 
	}
	
	public void addStone() 
	{ 
		stones++; 
	}
}
