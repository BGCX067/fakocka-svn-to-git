package fakocka;

/**
 * @author fakocka
 *
 */
public class ORGate extends ComponentBase 
{

	/**
	 * @param pins
	 * @param id
	 */
	public ORGate(int pins, int id) 
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
		boolean outputSignal = false;
		// vegigmegy az osszes bemeneten es eloallitja a logikai vagy kapcsolatukat
		for(int i = 1; i < signals.length; i++)
		{
			boolean inputSignal = signals[i];
			outputSignal |= inputSignal;
		}
		// valtozas detektalasa
		boolean result = outputSignal != signals[0];
		// kimenet beallitasa
		signals[0] = outputSignal;
		// visszadja hogy tertent e valtozas
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ORGate";
	}
}
