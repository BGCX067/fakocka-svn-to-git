package fakocka;

/**
 * Interface, amely a digitális komponensek szolgáltatásait definiálja.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public interface DigitalComponent 
{
	/**
	 * a komponens működését határozza meg
	 */
	boolean doFunction();

	/**
	 * @return a komponens azonosítója
	 */
	int getId();

	/**
	 * @param id a komponens azonosítója
	 */
	void setId(int id);

	/**
	 * @param pin a komponens egy lába
	 * @return lábon lévő jel értéke
	 */
	boolean getSignal(int pin);

	/**
	 * @param pin a komponens egy lába
	 * @param signal a labon értéke
	 */
	void setSignal(int pin, boolean signal);
}
