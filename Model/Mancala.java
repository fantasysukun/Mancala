public class Mancala
{
	public static final int P1 = 1;
	public static final int P2 = 2;

	private Pit[] pits; // circular array
	private int turn; // P1 when it's p1's turn, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
	private static final int NUM_PITS = 13;
	private static final int P1_MANCALA = 0;
	private static final int P2_MANCALA = 7;

	public Mancala()
	{

	}

	public boolean selectPit(int player, int pitNum)
	{
		// if this is p1's turn and he selected the right pit, 
		// print out (i.e: "P1 selects pitNum"), do the logic, calls print(),
		// and return true.
		// otherwise return false.
		// Either way print out (i.e: "P1's turn now")
	}

	public int whoseTurn()
	{
		// P1 when it's p1's turn, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
	}	

	public void print()
	{
		/*
		 *    3  3  3  3  3  3
		 *  0                  0
		 *    3  3  3  3  3  3 
		 * 
		 */
	}

	public boolean isGameEnded()
	{
		// checks if the game is ended (i.e: when every pit in either row is empty)
		// if T, print out (i.e: "P1 wins the game.")
		// else, print out (i.e: "Game has not ended.")
		// return T if game is ended, F otherwise
	}

	/**
	 * Pre-condition: Game is ended.
	 * @return [description]
	 */
	private int winner()
	{
		// P1 if p1 wins, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
	}

	private int whosePit()
	{
		// P1 if it's p1's pit, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
	}

	/**
	 * Pre-condition: Pit can't be empty, and it has to be on the side of the player 
	 * 				  who's currently playing.
	 * @param pitNum [description]
	 */
	private void moveStone(int pitNum)
	{

	}
}