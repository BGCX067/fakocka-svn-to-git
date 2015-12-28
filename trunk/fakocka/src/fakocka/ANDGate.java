package fakocka;

/**
 * Egy ÉS kaput megtestesítő  digitális komponens, amely képes tárolni
 * a lábain lévő logikai értékeket, ezen kívül elő tudja állítani a
 * bemenetein lévő  értékek logikai ÉS kapcsolatából a kimenet értékét.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class ANDGate extends ComponentBase 
{

	/**
	 * @param pins lábak
	 * @param id komponens azonosítója
	 */
	public ANDGate(int pins, int id) 
	{
		// ősosztály konstruktora
		super(id);
		// komponens nevének beregisztrálása
		NameChooser.addName(this,new String("a" + id));
		// konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new ANDGate(" + pins + "," + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	/**
	 * előállítja a bemenő lábain lévő értékek logikai ÉS kapcsolatából a kimenetének értékét.
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
