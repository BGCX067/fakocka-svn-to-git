package fakocka;

/**
 * @author fakocka
 *
 */
public class Node extends ComponentBase 
{

	/**
	 * @param pins
	 * @param id
	 */
	public Node(int pins, int id) 
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[pins];
		// az osszes lab erteket logikai hamis ertekre allitja
		for(int i = 0; i < signals.length; i ++)
		{
			signals[i] = false;
		}
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	public boolean doFunction() 
	{
		// kimeneti jel ertek eloallitasa
		boolean outputSignal = signals[0];
		// valtozas detektalasa (megnézi az egyik kimenetét, hogy hozzá képest változott e a bemenet)
		boolean result = outputSignal != signals[1];
		// vegigmegy az osszes kimeneten es beallitja a kimeneti erteket
		for(int i = 1; i < signals.length; i++)
		{
			signals[i] = outputSignal;
		}
		// visszadja hogy tertent e valtozas
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Node";
	}
}
