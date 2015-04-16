import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

//Controller: Back side -> see PitPanel (Controller: Front side)
public class Pit extends JComponent
{
	private int stones;
	private int id;
	private ChangeListener model;
	private static final int DEFAULT_X = 0;
	private static final int DEFAULT_Y = 0;
	private static final int DEFAULT_WIDTH = 50;
	private static final int DEFAULT_HEIGHT = 50;
	private static final int DEFAULT_MARGIN = 5;
	
	private static final int DEFAULT_STONES_NUM = 3;
	private final static int DEFAULT_STONE_X = 0;
	private final static int DEFAULT_STONE_Y = 0;
	private final static int DEFAULT_STONE_SIZE = 10;

	public Pit(int id)
	{	
		stones = DEFAULT_STONES_NUM;
		this.id = id;
	}

	public void attach(ChangeListener model)
	{
		this.model = model;
	}

	public void update()
	{
		model.stateChanged(new ChangeEvent(this));
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Rectangle body = new Rectangle(
			Pit.DEFAULT_X, 
			Pit.DEFAULT_Y, 
			Pit.DEFAULT_WIDTH, 
			Pit.DEFAULT_HEIGHT
		);

		setPreferredSize(new Dimension(
			Pit.DEFAULT_WIDTH + Pit.DEFAULT_MARGIN, 
			Pit.DEFAULT_HEIGHT + Pit.DEFAULT_MARGIN
		));

		g2.draw(body);

		// Create the parts of this car and draw them here.
		int Xcircle = Pit.DEFAULT_STONE_X;
		int Ycircle = Pit.DEFAULT_STONE_Y;
		for(int i=0; i<stones; i++)
		{
			//create Pit inside the Rectangle, MAX Pit will be 36.
			Ellipse2D.Double circle = new Ellipse2D.Double ( 
				Pit.DEFAULT_X + Xcircle, 
				Pit.DEFAULT_Y + Ycircle, 
				Pit.DEFAULT_STONE_SIZE, 
				Pit.DEFAULT_STONE_SIZE
			); 

			g2.fill(circle);

			Xcircle += Pit.DEFAULT_STONE_SIZE;

			if(Xcircle == Pit.DEFAULT_WIDTH)
			{
				Xcircle = Pit.DEFAULT_X;
				Ycircle += Pit.DEFAULT_STONE_SIZE;
			}
		}
	}

	public boolean contains(int x, int y)
	{
		return true;
	}

	public void setStones(int s) 
	{ 
		stones = s;
	}
	
	public int getStones() 
	{ 
		return stones;
	}
	
	public void clearPit() 
	{ 
		stones = 0;
	}
	
	public void addStone() 
	{ 
		stones++; 
	}
}
