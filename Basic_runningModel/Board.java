import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//serves as model
public class Board {
	private Player playerA;
	private Player playerB;
	private JFrame playFrame;
	private Pit[] pits; // 0-5 is A's pits, 6-11 is B's pits
	private Mancala aMancala;
	private Mancala bMancala;
	
	
	public Board(){
		playerA = new Player(true);
		playerB = new Player();
		
		playFrame = new JFrame();
		pits = new Pit[12];
		for(int i = 0; i < 12; i++){
			pits[i] = new Pit(50, 50, this);
		}
		aMancala = new Mancala( 60, 100);
		bMancala = new Mancala( 60, 100);
		
		playFrame.setLocation(100,100);
		playFrame.setLayout(new BorderLayout());
		playFrame.setBounds(30, 30, 1000, 200);
		
		JPanel pitPan = new JPanel();
		pitPan.setLayout(new GridLayout(2, 6));
		for(int i = 5; i >= 0; i--){
			JPanel tempP = new JPanel();
			tempP.add(new PitPanel(pits[i]));
			pitPan.add(tempP);
		}
		for(int i = 6; i < 12; i++){
			JPanel tempP = new JPanel();
			tempP.add(new PitPanel(pits[i]));
			pitPan.add(tempP);
		}
		
		playFrame.add(new MancalaPanel(aMancala, 80, 100), BorderLayout.WEST);
		playFrame.add(pitPan, BorderLayout.CENTER);
		playFrame.add(new MancalaPanel(bMancala, 80, 100), BorderLayout.EAST);
			
		playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playFrame.setVisible(true);
	}
	
	// //pick up all stones in one pit, and move counter-clock wise
	public void oneMove(Pit selectedPit){
		int i = findPit(selectedPit);
		String whosePit = "";
		if(i >= 0 && i < 6)
			 whosePit = "a";
		if(i >= 6 && i < 12)
			 whosePit = "b";
		int leftStone = pits[i].getStones(); //Stones left in the players hand
		pits[i].clearPit();
		i++;
		//If it is A's turn, and he click on pit[5]
		if(i == 6 && leftStone > 0 && whosePit.equals("a")){
			aMancala.addStone();
			leftStone--;
		}
		//If it is B's turn, and he click on pit[11]
		if(i == 12 && leftStone > 0 && whosePit.equals("b")){
			bMancala.addStone();
			leftStone--;
			i = 0;
		}
		
		while(leftStone > 0){
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
	public int findPit(Pit selectedPit){
		for(int i = 0; i < 12; i++){
			if(pits[i].equals(selectedPit)){
				return i;
			}		
		}
		return -1;
	}
	
	public void update(Pit clickedPit){
		//look for the pit which is clicked
		int whosePit = findPit(clickedPit);
		if(whosePit == -1)
			return;
		if(whosePit >= 0 && whosePit < 6 && playerA.isMyTurn()){
			oneMove(clickedPit);
			playerA.setMyTurn(false);
			playerB.setMyTurn(true);
			
		}
		if(whosePit >= 6 && whosePit < 12 && playerB.isMyTurn()){
			oneMove(clickedPit);
			playerB.setMyTurn(false);
			playerA.setMyTurn(true);
		}
		playFrame.repaint();
	}
}
