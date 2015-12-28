package fakocka;

/**
 * Egy VAGY kaput megtestesítő  digitális komponens, amely képes
 * tárolni a lábain lévő logikai értékeket, ezen kívül elő tudja állítani
 * a bemenetein lévő értékek logikai VAGY kapcsolatából a kimenet értékét.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class ORGate extends ComponentBase 
{
	/**
	 * @param pins lábak
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public ORGate(int pins, int id) 
	{
                // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("o" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new ORGate(" + pins + "," + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * Előállítja a bemenő lábain lévő értékek logikai VAGY kapcsolatából a kimenetének értékét.
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
}
