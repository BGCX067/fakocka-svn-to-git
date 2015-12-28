package fakocka.model;

/**
 * @author fakocka
 *
 */
public class Inverter extends ComponentBase 
{

	/**
	 * @param id
	 */
	public Inverter(int id)
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[2];
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
		boolean outputSignal = !signals[0];
		// valtozas detektalasa
		boolean result = outputSignal != signals[1];
		// kimenet beallitasa
		signals[1] = outputSignal;
		// visszadja hogy tertent e valtozas
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Inverter";
	}
}
