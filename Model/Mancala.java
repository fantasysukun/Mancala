public class Mancala
{
	public static final int P1 = 1;
	public static final int P2 = 2;

	private Pit[] pits; // circular array
	private int turn; // P1 when it's p1's turn, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
	private static final int NUM_PITS = 14;
	private static final int P1_MANCALA = 0;
	private static final int P2_MANCALA = 7;
	private static final int EMPTY = 0;

	/**
	 * Constructs a new Mancala board with 14 pits, of which are 2 mancalas for p1 and p2.
	 * Each pit other than mancalas, will be initialized with 3 stones.
	 */
	public Mancala()
	{
		turn = Mancala.P1;
		pits = new Pit[NUM_PITS];

		for(int i = 0; i < pits.length; i++)
		{
			pits[i] = new Pit();
		}

		pits[P1_MANCALA] = EMPTY;
		pits[P2_MANCALA] = EMPTY;
	}

	public boolean selectPit(int player, int pitNum)
	{
		// if this is p1's turn and he selected the right pit, 
		// print out (i.e: "P1 selects pitNum"), do the logic, calls print(),
		// and return true.
		// otherwise return false.
		// Either way print out (i.e: "P1's turn now")
	}

	/**
	 * Returns whose turn is it now.
	 * @return 1 for player1 and 2 for player2.
	 */
	public int whoseTurn()
	{
		// P1 when it's p1's turn, P2 otherwise. See contants P1 & P2 - 1, 2 respectively
		return turn;
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
		// set whose turn next
	}
}