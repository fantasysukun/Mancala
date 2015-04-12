import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;


public class Mancala{
	private int x;
	private int y;
	private int width;
	private int height;
	private int stones;
	public Mancala(int width, int height){
		this.x = 0; this.y = 0;
		this.width = width; 
		this.height = height; 
		stones = 0;
	}
	
	
	public void draw(Graphics2D g2){
		Rectangle body = new Rectangle(x,y,width, height);
		g2.draw(body);
	// Create the parts of this car and draw them here.
		g2.drawString(stones + "", x + width / 2, y + 20);
	}
	
	public int getWidth() { return width; }
	
	public int getHeight() { return height; }
	
	public void addStone() { stones++; }

}
