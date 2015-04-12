
public class Player {
	private boolean myTurn;
	
	public Player() {
		myTurn = false;
	}
	
	public Player(boolean myTurn){
		this.myTurn = myTurn;
	}
	
	public boolean isMyTurn(){
		return myTurn;
	}
	
	public void setMyTurn(boolean myTurn){
		this.myTurn = myTurn;
	}
}
