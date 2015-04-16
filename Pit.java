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
	private static final int DEFAULT_WIDTH = 50;
	private static final int DEFAULT_HEIGHT = 50;
	
	private static final int DEFAULT_STONES_NUM = 3;
	private final static int DEFAULT_STONE_X = 0;
	private final static int DEFAULT_STONE_Y = 0;
	private final static int DEFAULT_STONE_SIZE = 10;

	public Pit(int id)
	{	
		stones = DEFAULT_STONES_NUM;
		this.id = id;
		setBorder(BorderFactory.createLineBorder(Color.black));
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

		int x_centered = getWidth()/2 - Pit.DEFAULT_WIDTH/2;
		int y_centered = getHeight()/2 - Pit.DEFAULT_HEIGHT/2;

		Rectangle body = new Rectangle(
			x_centered,
			y_centered,
			Pit.DEFAULT_WIDTH, 
			Pit.DEFAULT_HEIGHT
		);

		setPreferredSize(new Dimension(
			Pit.DEFAULT_WIDTH, 
			Pit.DEFAULT_HEIGHT
		));

		g2.draw(body);

		// Create the parts of this car and draw them here.
		int Xcircle = Pit.DEFAULT_STONE_X;
		int Ycircle = Pit.DEFAULT_STONE_Y;
		for(int i=0; i<stones; i++)
		{
			//create Pit inside the Rectangle, MAX Pit will be 36.
			Ellipse2D.Double circle = new Ellipse2D.Double ( 
				x_centered + Xcircle, 
				y_centered + Ycircle, 
				Pit.DEFAULT_STONE_SIZE, 
				Pit.DEFAULT_STONE_SIZE
			); 

			g2.fill(circle);

			Xcircle += Pit.DEFAULT_STONE_SIZE;

			if(Xcircle == Pit.DEFAULT_WIDTH)
			{
				Xcircle = x_centered;
				Ycircle += Pit.DEFAULT_STONE_SIZE;
			}
		}

		g2.drawString(String.valueOf(id), 10, 30);
		contains(0, 0);
	}

	public boolean contains(int x, int y)
	{
		// int x0;
		// int y0;

		// if(id > PitPanel.LAST_LOWER_PIT)
		// {
		// 	x0 = PitPanel.LAST_LOWER_PIT - (id % PitPanel.DEFAULT_COLS_NUMBER) + 
		// 		 getWidth()/2 - Pit.DEFAULT_WIDTH/2.
		// }
		// else
		// {

		// }
		//  = id*getWidth() + getWidth()/2 - Pit.DEFAULT_WIDTH/2;

		// System.out.println(id + ": " + x0_component);
		// System.out.println("pit width: " + getWidth());

		return true;
		// int y0_component = getHeight()/2 - Pit.DEFAULT_HEIGHT/2;

		// return x >= x0_component &&
		// 	   x <= x0_component + Pit.DEFAULT_WIDTH &&
		// 	   y >= y0_component &&
		// 	   y <= y0_component + Pit.DEFAULT_HEIGHT;
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
