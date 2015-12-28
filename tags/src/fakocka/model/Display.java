package fakocka.model;

/**
 * @author fakocka
 *
 */
public class Display extends ComponentBase 
{
	/**
	 * 
	 */
	private boolean light;

	/**
	 * @param id
	 */
	public Display(int id) 
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[1];
		// a kimeneti lab erteket logikai hamis ertekre allitja
		signals[0] = false;
		// alapbol nem vilagit
		light = false;
		
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	public boolean doFunction()
	{
		// beallitja a megfelelo allapotat a bemenete alapjan.
		light = signals[0];
		// a kijelzon nem szamit ha valtozott, innen ugyse terjed tovabb a jel, ezert false
		return false;
	}

	/**
	 * @return
	 */
	public boolean isLightOn() 
	{
		return light;
	}

	/**
	 * @param light
	 */
	public void setLight(boolean light) 
	{
		this.light = light;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Display";
	}
}
