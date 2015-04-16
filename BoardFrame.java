import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class BoardFrame extends JFrame implements ChangeListener
{
	private Board board;
	private MancalaPanel mancalaA;
	private MancalaPanel mancalaB;
	private PitPanel pitController; 

	public BoardFrame(Board board)
	{
		this.board = board;

		setLocation(100,100);
		setLayout(new BorderLayout());
		setBounds(30, 30, 1000, 200);

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