import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;

//serves as model
public class Board
{
	
	private Player playerA;
	private Player playerB;
	private Mancala aMancala;
	private Mancala bMancala;
	
	private Pit[] pits; // 0-5 is A's pits, 6-11 is B's pits
	private List<ChangeListener> observers;
	
	public Board()
	{
		playerA = new Player(true);
		playerB = new Player();
	}

	/**
	 * Adds a change listener to the Model. 
	 * @param observer the change listener to add 
	 */
	public void attach(ChangeListener observer)
	{
		observers.add(observer);
	}

	//Model class only passing data
	/*
	public void stateChanged(ChangeEvent controller)
	{
		
	}
	*/

	/**
	 * setup the update method for Pit
	 * then Pit can use this method pass through data from Views to Model
	 * @param clickedPit
	 */
	public void update(Pit clickedPit)
	{
		//look for the pit which is clicked
		int whosePit = findPit(clickedPit);

		if(whosePit == -1)
		{
			return;
		}
			
		if(whosePit >= 0 && whosePit < 6 && playerA.isMyTurn())
		{
			oneMove(clickedPit);
			playerA.setMyTurn(false);
			playerB.setMyTurn(true);
		}

		if(whosePit >= 6 && whosePit < 12 && playerB.isMyTurn())
		{
			oneMove(clickedPit);
			playerB.setMyTurn(false);
			playerA.setMyTurn(true);
		}

		for(ChangeListener observer : observers)
		{
			observer.stateChanged(new ChangeEvent(this));
		}
	}

	
	// //pick up all stones in one pit, and move counter-clock wise
	public void oneMove(Pit selectedPit)
	{
		int i = findPit(selectedPit);
		String whosePit = "";
		if(i >= 0 && i < 6)
		{
			whosePit = "a";
		}
			 
		if(i >= 6 && i < 12)
		{
			whosePit = "b";
		}
			 
		int leftStone = pits[i].getStones(); //Stones left in the players hand
		pits[i].clearPit();
		i++;

		//If it is A's turn, and he click on pit[5]
		if(i == 6 && leftStone > 0 && whosePit.equals("a"))
		{
			aMancala.addStone();
			leftStone--;
		}
		//If it is B's turn, and he click on pit[11]
		if(i == 12 && leftStone > 0 && whosePit.equals("b"))
		{
			bMancala.addStone();
			leftStone--;
			i = 0;
		}
		
		while(leftStone > 0)
		{
			pits[i].addStone();
			leftStone--;
			i++;
			if(i == 6 && leftStone > 0 && whosePit.equals("a")){
				aMancala.addStone();
				leftStone--;
			}
			
			if(i == 12 && leftStone > 0 && whosePit.equals("b")){
				bMancala.addStone();
				leftStone--;
			}
			if(i == 12)
				i = 0;
		}

		return;
	}
	
	//helper methods
	public int findPit(Pit selectedPit)
	{
		for(int i = 0; i < 12; i++)
		{
			if(pits[i].equals(selectedPit))
			{
				return i;
			}		
		}
		return -1;
	}
	
	
}
