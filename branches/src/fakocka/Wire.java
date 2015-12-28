package fakocka;

/**
 * @author fakcoka
 *
 */
public class Wire extends ComponentBase 
{
	/**
	 * 
	 */
	private DigitalComponent outConnection;
	
	/**
	 * 
	 */
	private DigitalComponent inConnection;
	
	/**
	 * 
	 */
	private int outConnectionPoint;
	
	/**
	 * 
	 */
	private int inConnectionPoint;

	/**
	 * @param pins
	 * @param id
	 */
	public Wire(int id) 
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[1];
		// a kimeneti lab erteket logikai hamis ertekre allitja
		signals[0] = false;
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	public boolean doFunction() 
	{
		// lekerdezi a bejovo kapcsolat kapcsolodasi pontjan tarolt uzenetet
		boolean signal = inConnection.getSignal(inConnectionPoint);
		// eltarolja a jelet
		signals[0] = signal;
		// beallitja a jelet a kimeno kapcsolata kapcsolodasi pontjan
		outConnection.setSignal(outConnectionPoint,signal);
		// mukodesbe hozza a kimenetre kapcsolodo komponenst es lekerdezi, hogy tortent e valtozas
		boolean result = outConnection.doFunction();
		// visszaadja, hogy tortent e valtozas
		return result;
	}

	/**
	 * @return
	 */
	public DigitalComponent getOutConnection() 
	{
		return outConnection;
	}

	/**
	 * @param outConnection
	 * @param pin
	 */
	public void setOutConnection(DigitalComponent outConnection, int pin) 
	{
		this.outConnection = outConnection;
		this.outConnectionPoint = pin;
	}

	/**
	 * @return
	 */
	public DigitalComponent getInConnection() 
	{
		return inConnection;
	}

	/**
	 * @param inConnection
	 * @param pin
	 */
	public void setInConnection(DigitalComponent inConnection, int pin) 
	{
		this.inConnection = inConnection;
		this.inConnectionPoint = pin;
	}

	/**
	 * @return
	 */
	public int getOutConnectionPoint() 
	{
		return outConnectionPoint;
	}

	/**
	 * @return
	 */
	public int getInConnectionPoint() 
	{
		return inConnectionPoint;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Wire";
	}
}
