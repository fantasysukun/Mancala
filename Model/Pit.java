public class Pit
{
	private int num_stone;
	private int INITIAL_NUM_STONE = 3;

	/**
	 * Constructs a new Pit with 3 stones.
	 */
	public Pit()
	{
		this(INITIAL_NUM_STONE);
	}

	/**
	 * Constructs a new Pit with custom num_stone.
	 * @param num_stone the number of stones in this Pit to begin with.
	 */
	public Pit(int num_stone)
	{
		this.num_stone = num_stone;
	}

	public void incStone()
	{
	
	}

	public boolean decStone()
	{
		// F if num_stone < 0
	}

	public int getNumStone()
	{

	}
}