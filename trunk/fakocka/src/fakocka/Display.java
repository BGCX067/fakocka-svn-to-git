package fakocka;

/**
 * Egy LED-et megtestesítő digitális komponens, amely képes
 * tárolni és jelezni a bejövő lábán lévő jel logikai értékét.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Display extends ComponentBase 
{
        /**
         * A kijelző aktuális állapotát jelzi. Igaz, ha világít, hamis, ha nem világít.
         */
	private boolean light;

	/**
	 * @param id a komponens azonosítója
	 */
	public Display(int id) 
	{
                // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("d" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new Display(" + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * A bejövő jel logikai értékének megfelelően változtatja a light változó értékét.
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
	 * @return a kijelző aktuális állapotát.
	 */
	public boolean isLightOn() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".isLightOn() : boolean");
                // a kijelző aktuális állapotának visszaadása
		return light;
	}

	/**
	 * @param light a kívánt állapot
	 */
        /**
         * beállítja a kijelző állapotát.
         */
	public void setLight(boolean light) 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".setLight(" + light + ")");
	}
}
