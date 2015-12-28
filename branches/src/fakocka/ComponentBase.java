package fakocka;

/**
 * @author fakocka
 *
 */
public abstract class ComponentBase implements DigitalComponent
{
	/**
	 * 
	 */
	protected int id;
	
	/**
	 * 
	 */
	protected boolean[] signals;

	/**
	 * @param pins
	 * @param id
	 */
	public ComponentBase(int id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#doFunction()
	 */
	public abstract boolean doFunction();

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#getId()
	 */
	public int getId() 
	{
		return this.id;
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#setId(int)
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#getSignal(int)
	 */
	public boolean getSignal(int pin) 
	{
		return signals[pin];
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#setSignal(int, boolean)
	 */
	public void setSignal(int pin, boolean signal) 
	{
		signals[pin] = signal;
	}
}
