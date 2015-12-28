package fakocka;

/**
 * Egy kapcsolót  megtestesítő digitális komponens.
 * Jelforrás, amely képes tárolni a kimenetén lévő logikai értéket.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Switch extends SignalSource
{
	/**
	 * A kapcsoló állása(true = bekapcsolt, false = kikapcsolt).
	 */
	private boolean state;

	/**
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public Switch(int id) 
	{
                // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("s" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new Switch(" + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.SignalSource#initialize()
	 */
        /**
         * Meghívja a doFunction() metódust.
         */
	public void initialize() 
	{
		// behúzás növelése
		Tabber.increaseIndent();
		// tabulátor elhelyezése
		Tabber.doIndent();
		// metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".initialize()");
		// doFunction() függvény meghívása
		doFunction();
		// behúzás csökkentése
		Tabber.decreaseIndent();
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * Az állapotának megfelelően előállítja a kimenetének értékét.
         */
	public boolean doFunction() 
	{
		// behúzás növelése
		Tabber.increaseIndent();
		// tabulátor elhelyezése
		Tabber.doIndent();
		// metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".doFunction() : false");
		// behúzás csökkentése
		Tabber.decreaseIndent();
                // visszaadja, hogy történt -e változás
		return false;
	}

	/**
	 * @return
	 */
        /**
         * Visszaadja a kapcsoló állapotát.
         */
	public boolean isStateOn() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".isStateOn() : boolean");
                // állapot visszaadása
		return state;
	}

	/**
	 * @param state a beállítandó állapot
	 */
        /**
         * beállítja a kapcsoló állapotát.
         */
	public void setState(boolean state) 
	{
                // kapcsoló beállítása
		this.state = state;
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".setState(" + state + ")");
	}
}
