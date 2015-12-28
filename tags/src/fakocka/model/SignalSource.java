package fakocka.model;

/**
 * @author fakcoka
 *
 */
public abstract class SignalSource extends ComponentBase 
{
	/**
	 * @param pins
	 * @param id
	 */
	public SignalSource(int id)
	{
		// ososztaly konstruktora
		super(id);
	}
	
	/**
	 * 
	 */
	public abstract void initialize();
}
