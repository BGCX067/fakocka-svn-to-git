package fakocka;

/**
 * Egy csomópontot megtestesítő digitális komponens, amely képes
 * tárolni a lábain lévő logikai értékeket, ezen kívül
 * a bementének értékét továbbítja a kimenetekre.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Node extends ComponentBase 
{
	/**
	 * @param pins lábak
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public Node(int pins, int id) 
	{
                // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("n" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new Node(" + pins + "," + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * A bementén lévő értéket továbbítja az összes kimenetére.
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
