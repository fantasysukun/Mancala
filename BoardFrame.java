import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class BoardFrame extends JFrame implements ChangeListener
{
	private Board board;
	private MancalaPanel mancalaA;
	private MancalaPanel mancalaB;
	private PitPanel pitController; 

	private final static int DEFAULT_WIDTH = 1000;
	private final static int DEFAULT_HEIGHT = 200;
	

	public BoardFrame(Board board)
	{
		this.board = board;
		setLayout(new BorderLayout());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x_centered = (int) screenSize.getWidth()/2 - BoardFrame.DEFAULT_WIDTH/2;
		int y_centered = (int) screenSize.getHeight()/2 - BoardFrame.DEFAULT_HEIGHT/2;

		setBounds(
			x_centered, 
		  	y_centered, 
		  	BoardFrame.DEFAULT_WIDTH, 
		  	BoardFrame.DEFAULT_HEIGHT
	    );

		pitController = new PitPanel();
		mancalaA = new MancalaPanel();
		mancalaB = new MancalaPanel();
		
		add(pitController, BorderLayout.CENTER);
		add(mancalaA, BorderLayout.WEST);
		add(mancalaB, BorderLayout.EAST); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void stateChanged(ChangeEvent controller)
	{
		
	}
}