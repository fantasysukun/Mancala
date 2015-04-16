import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class MancalaPanel extends JPanel
{
	private int mancalaAStones;
	private int mancalaBStones;
	private final static int MANCALA_A = 1;
	private final static int MANCALA_B = 2;

	private final static int DEFAULT_X = 0;
	private final static int DEFAULT_Y = 0;
	private final static int DEFAULT_WIDTH = 60;
	private final static int DEFAULT_HEIGHT = 100;

	private final static int DEFAULT_PANEL_WIDTH = 80;
	private final static int DEFAULT_PANEL_HEIGHT = 100;

	private final static int STARTING_STONES_NUMBER = 0;
	private final static int DEFAULT_STONE_X = 0;
	private final static int DEFAULT_STONE_Y = 0;
	private final static int DEFAULT_STONE_SIZE = 10;

	public MancalaPanel()
	{
		this(MancalaPanel.DEFAULT_PANEL_WIDTH, MancalaPanel.DEFAULT_PANEL_HEIGHT);
	}

	public MancalaPanel(int width, int height) 
	{
		mancalaAStones = MancalaPanel.STARTING_STONES_NUMBER;
		mancalaBStones = MancalaPanel.STARTING_STONES_NUMBER;
		
		setPreferredSize(new Dimension(
			MancalaPanel.DEFAULT_WIDTH + 10, 
			MancalaPanel.DEFAULT_HEIGHT + 10
		));
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		draw(g2, MancalaPanel.MANCALA_A);
		draw(g2, MancalaPanel.MANCALA_B);
	}

	public void addStone(int whichMancala)
	{
		if(whichMancala == MancalaPanel.MANCALA_A)
		{
			mancalaAStones++;
		}
		else if(whichMancala == MancalaPanel.MANCALA_B)
		{
			mancalaBStones++;
		}
		else
		{
			// will throw error later
			return;
		}
	}

	private void draw(Graphics2D g2, int whichMancala)
	{
		int numStones = 0;

		if(whichMancala == MancalaPanel.MANCALA_A)
		{
			numStones = mancalaAStones;
		}
		else if(whichMancala == MancalaPanel.MANCALA_B)
		{
			numStones = mancalaBStones;
		}
		else 
		{
			// will throw error later
			return;
		}

		Rectangle body = new Rectangle(
			MancalaPanel.DEFAULT_X, 
			MancalaPanel.DEFAULT_Y, 
			MancalaPanel.DEFAULT_WIDTH, 
			MancalaPanel.DEFAULT_HEIGHT
		);

		g2.draw(body);

		int Xcircle = MancalaPanel.DEFAULT_STONE_X;
		int Ycircle = MancalaPanel.DEFAULT_STONE_Y;
		for(int i = 0; i < numStones; i++)
		{
			//create Pit inside the Rectangle, MAX Pit will be 36.
			Ellipse2D.Double circle = new Ellipse2D.Double (
				MancalaPanel.DEFAULT_X + Xcircle, 
				MancalaPanel.DEFAULT_Y + Ycircle, 
				MancalaPanel.DEFAULT_STONE_SIZE, 
				MancalaPanel.DEFAULT_STONE_SIZE
			); 

			g2.fill(circle);

			Xcircle += MancalaPanel.DEFAULT_STONE_SIZE;

			if(Xcircle == MancalaPanel.DEFAULT_WIDTH)
			{
				Xcircle = MancalaPanel.DEFAULT_X;
				Ycircle += MancalaPanel.DEFAULT_STONE_SIZE;
			}
		}
	}
}
