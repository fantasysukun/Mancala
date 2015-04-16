import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Controller: Front Side
public class PitPanel extends JPanel implements ChangeListener
{
	private ChangeListener model;
	private Pit[] myPits;

	private final static int DEFAULT_ROWS_NUMBER = 2;
	private final static int DEFAULT_COLS_NUMBER = 6;
	private final static int DEFAULT_PITS_NUMBER = 12;
	private final static int FIRST_LOWER_PIT = 0;
	private final static int LAST_LOWER_PIT = 5;
	private final static int FIRST_UPPER_PIT = 6;
	private final static int LAST_UPPER_PIT = 11;

	public PitPanel() 
	{	
		setLayout(new GridLayout(PitPanel.DEFAULT_ROWS_NUMBER, 
			PitPanel.DEFAULT_COLS_NUMBER));

		addMouseListener(new MouseAdapter() 
		{	
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("pitpanel x: " + e.getX());
				System.out.println("pitpanel y: " + e.getY());
				
				myPits[0].contains(e.getX(), e.getY());
			}
		});

		myPits = new Pit[PitPanel.DEFAULT_PITS_NUMBER];

		for(int i = PitPanel.LAST_LOWER_PIT; i >= PitPanel.FIRST_LOWER_PIT; i--)
		{
			myPits[i] = new Pit(i);
			add(myPits[i]);
		}

		for(int i = PitPanel.FIRST_UPPER_PIT; i <= PitPanel.LAST_UPPER_PIT; i++)
		{
			myPits[i] = new Pit(i);
			add(myPits[i]);
		}
	}

	public void stateChanged(ChangeEvent e)
	{

	}

	public void update()
	{

	}
}
