package fakocka.model;

/**
 * @author fakcoka
 *
 */
public class Switch extends SignalSource
{
	/**
	 * 
	 */
	private boolean state;

	/**
	 * @param pins
	 * @param id
	 */
	public Switch(int id) 
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[1];
		// a kimeneti lab erteket logikai hamis ertekre allitja
		signals[0] = false;
		// alapbol ki van kapcsolva
		state = false;
	}

	/* (non-Javadoc)
	 * @see fakocka.SignalSource#initialize()
	 */
	public void initialize() 
	{
		doFunction();
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	public boolean doFunction() 
	{
		// ha bekapcsolt allapotban van...
		if(state)
			// logikai igaz erteket allit be a kimenetre
			signals[0] = true;
		// ha kikapcsolt allapotban van...
		else
			// logikai hamis erteket allit be a kimenetre
			signals[0] = false;
		
		// a kapcsolo csak beallitja a kimeneten az erteket, nem o donti el hogy tertent e valtozas
		return false;
	}

	/**
	 * @return
	 */
	public boolean isStateOn() 
	{
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(boolean state) 
	{
		this.state = state;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Switch";
	}
}
