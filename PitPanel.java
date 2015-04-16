import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Controller: Front Side
public class PitPanel extends JPanel implements ChangeListener
{
	public final static int DEFAULT_ROWS_NUMBER = 2;
	public final static int DEFAULT_COLS_NUMBER = 6;
	public final static int DEFAULT_PITS_NUMBER = 12;

	public final static int FIRST_LOWER_PIT = 0;
	public final static int LAST_LOWER_PIT = 5;
	public final static int FIRST_UPPER_PIT = 6;
	public final static int LAST_UPPER_PIT = 11;

	private ChangeListener model;
	private Pit[] myPits;

	public PitPanel() 
	{	
		setLayout(new GridLayout(
			PitPanel.DEFAULT_ROWS_NUMBER, 
			PitPanel.DEFAULT_COLS_NUMBER
		));

		addMouseListener(new MouseAdapter() 
		{	

		});

		initializePits();
	}

	public void stateChanged(ChangeEvent e)
	{

	}

	public void update()
	{

	}

	private void initializePits()
	{
		myPits = new Pit[PitPanel.DEFAULT_PITS_NUMBER];

		for(int i = PitPanel.LAST_UPPER_PIT; i >= PitPanel.FIRST_UPPER_PIT; i--)
		{
			myPits[i] = new Pit(i);
			add(myPits[i]);
		}

		for(int i = PitPanel.FIRST_LOWER_PIT; i <= PitPanel.LAST_LOWER_PIT; i++)
		{
			myPits[i] = new Pit(i);
			add(myPits[i]);
		}
	}
}
