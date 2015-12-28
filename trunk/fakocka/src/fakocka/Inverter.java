package fakocka;

/**
 * Egy invertert megtestesítő digitális komponens, amely képes
 * tárolni a lábain lévő logikai értéket, a kimenetet pedig
 * az inverter működése alapján állítja elő bemenetének értékéből.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Inverter extends ComponentBase 
{
	/**
	 * @param id A komponens azonosítója.
	 */
        /**
         * Konstruktor
         */
	public Inverter(int id)
        {
                // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("i" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new Inverter(" + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * Előállítja a bemenetén lévő jel értékének invertálásával  kimenetének értékét.
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
