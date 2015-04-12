import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

//serves as controller 
public class Pit extends MouseAdapter{
	private Board myBoard;
	private int x;
	private int y;
	private int width;
	private int height;
	private int stones;

	public Pit(int width,int height, Board board){
		this.x = 0; this.y = 0;
		this.width = width; this.height = height;
		stones = 3;
		myBoard = board;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		myBoard.update(this);
	}
	
	public void draw(Graphics2D g2){
		Rectangle body = new Rectangle(x,y,width,height);
		g2.draw(body);
	// Create the parts of this car and draw them here.
		g2.drawString(stones + "", x + width / 2, y + 20);
	}
	
	public void setStones(int s) { stones = s;};
	
	public int getHeight(){ return height;}
	
	public int getWidth(){ return width; }
	
	public int getStones() { return stones;}
	
	public void clearPit() { stones = 0;}
	
	public void addStone() { stones++; }

}
