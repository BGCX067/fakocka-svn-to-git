package fakocka;

import java.util.ArrayList;

/**
 * Egy programozható  jelforrást megtestesítő digitális komponens, amely képes
 * tárolni a kimenetén lévő logikai értéket, ezen kívül egy előre beprogramozott
 * szekvencia megfelelő indexű értékét állítja be a kimenetén.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class SignalGenerator extends SignalSource
{
	/**
	 * A felhasználó által előre definiált jelsorozat.
	 */
	private ArrayList<Boolean> signalSequence;
	
	/**
	 * A jelsorozat aktuális indexét tárolja. A szimuláció során az egyes
         * ütemek után inkrementálódik, így a következő ütemben már a
         * szekvencia következő értékét küldi el a kimeneten. 0-ról indul.
	 */
	private int sequenceIndex;

	/**
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public SignalGenerator(int id) 
	{
                // ősosztály konstruktora
		super(id);
                // A tároló létrehozása.
		signalSequence = new ArrayList<Boolean>();
                // 0-ról indul az index.
		sequenceIndex = 0;
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("sg" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new SignalGenerator(" + id + ")");
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
         * A jelsorozat aktuális indexű értékéből előállítja a kimenetének értékét,
         * növeli a szekvencia indexet.
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
	 * @param signal új érték a szekvenciába
	 */
        /**
         * A jelsorozat végére helyez egy jelet.
         */
	public void addSignal(Boolean signal) 
	{
                // jel hozzáadása a szekvenciához
		signalSequence.add(signal);
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".addSignal(" + signal + ")");
	}

	/**
	 * @return aktuális index
	 */
        /**
         * Visszaadja az aktuális szekvencia indexet.
         */
	public int getSequenceIndex() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".getSequenceIndex() : int");
                // visszaadja az indexet
		return sequenceIndex;
	}

	/**
	 * Növeli a szekvencia indexet. Ha az eléri a szekvencia végét,
         * akkor körbefordul, hogy a következő ütemnél újra az elejéről 
         * indulhasson, így biztosítva a periódikusságot.
	 */
	public void incrementSequenceIndex() 
	{
                // index növelése
		sequenceIndex++;
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".incrementSequenceIndex()");
	}
}
