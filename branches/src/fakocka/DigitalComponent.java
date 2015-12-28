package fakocka;

/**
 * @author fakocka
 *
 */
public interface DigitalComponent 
{

	/**
	 * 
	 */
	boolean doFunction();

	/**
	 * @return
	 */
	int getId();

	/**
	 * @param id
	 */
	void setId(int id);

	/**
	 * @param pin
	 * @return
	 */
	boolean getSignal(int pin);

	/**
	 * @param pin
	 * @param signal
	 */
	void setSignal(int pin, boolean signal);
}
