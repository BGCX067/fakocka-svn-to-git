package fakocka;

/**
 * Absztrakt ősosztály, amely a jelforrások szolgáltatásait definiálja.
 * Ezzel megkülönböztetjük a jelforrást a többi digitális komponenstől,
 * hiszen ezek értékeit közvetlenül a felhasználó is szabályozhatja.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public abstract class SignalSource extends ComponentBase 
{
	/**
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public SignalSource(int id)
	{
                // ősosztály konstruktora
		super(id);
		//System.out.println("super(" + id + ")");
	}
	
	/**
	 * Meghívja a jelforrás működtetését végző metódust.
	 */
	public abstract void initialize();
}
