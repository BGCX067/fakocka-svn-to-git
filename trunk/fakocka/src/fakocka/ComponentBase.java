package fakocka;

/**
 * A komponensek absztrakt ősosztálya, amely képes tárolni a bemeneteire adott
 * értékeket, illetve ezek alapján előállítani és eltárolni a kimenetének értékét.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public abstract class ComponentBase implements DigitalComponent
{
	/**
	 * A digitális komponens azonosító száma.
	 */
	protected int id;
	
	/**
	 * A komponens lábaihoz tartozó jelek értékeit tárolja.
	 */
	protected boolean[] signals;

	/**
	 * Konstruktor
	 * 
	 * @param pins lábak
	 * @param id komponens azonosítója
	 */
	public ComponentBase(int id) 
	{
		//azonosító beállítása
		this.id = id;
		//System.out.println("super(" + id + ")");
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
		// metódus kiíratása
		System.out.println(".getId()");
		// azonosító visszaadása
		return id;
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#setId(int)
	 */
	public void setId(int id) 
	{
		// azonosító kiíratása
		this.id = id;
		// metódus kiíratása
		System.out.println(".setId(" + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#getSignal(int)
	 */
	public boolean getSignal(int pin) 
	{
		// behúzás növelés
		Tabber.increaseIndent();
		// tabulátor elhelyezése
		Tabber.doIndent();
		// metódus kiíratása
		System.out.println(NameChooser.getName(this) + ".getSignal(" + pin + ")");
		// behúzás csökkentés
		Tabber.decreaseIndent();
		// visszaadja a megfelelő lábon lévő értéket.
		return false;
	}

	/* (non-Javadoc)
	 * @see fakocka.DigitalComponent#setSignal(int, boolean)
	 */
	public void setSignal(int pin, boolean signal) 
	{
		// behúzas növelés
		Tabber.increaseIndent();
		// tabulátor elhelyezése
		Tabber.doIndent();
		// metódus kiíratása
		System.out.println(NameChooser.getName(this) + ".setSignal(" + pin + "," + signal + ")");
		// behúzás csökkentés
		Tabber.decreaseIndent();
	}
}
