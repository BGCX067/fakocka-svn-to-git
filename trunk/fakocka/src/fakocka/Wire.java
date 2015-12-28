package fakocka;

/**
 * Egy vezetéket megtestesítő digitális komponens, amely képes tárolni a
 * rajta lévő logikai értéket, ezen kívül eltárolja a kapcsolatait
 * és továbbítja a jel értékét a bemenetéről a kimenetére.
 *
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Wire extends ComponentBase 
{
	/**
	 * A "kimenő" lábára kapcsolt komponens.
	 */
	private DigitalComponent outConnection;
	
	/**
	 * A "bemenő" lábára kapcsolt komponens.
	 */
	private DigitalComponent inConnection;
	
	/**
	 * A bemeneti oldalon lévő komponens lábának indexe.
	 */
	private int outConnectionPoint;
	
	/**
	 * A kimeneti oldalon lévő komponens lábának indexe.
	 */
	private int inConnectionPoint;

	/**
	 * @param id komponens azonosítója
	 */
        /**
         * Konstruktor
         */
	public Wire(int id) 
	{
		 // ősosztály konstruktora
		super(id);
                // komponens nevének beregisztrálása
		NameChooser.addName(this,new String("w" + id));
                // konstruktor kiíratása
		System.out.println( NameChooser.getName(this) + " = new Wire(" + id + ")");
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
        /**
         * A "bemenetén" lévő komponens csatlakozó lábán lévő értéket továbbítja
         * a "kimenetére" kötött komponens megfelelő lábára.
         */
	public boolean doFunction() 
	{
		// behúzás növelése
		Tabber.increaseIndent();
		// tabulátor elhelyezése
		Tabber.doIndent();
        		// metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".doFunction() : false");
		// lekérdezi a bejövő kapcsolat kapcsolódási pontján tárolt üzenetet
		boolean signal = inConnection.getSignal(inConnectionPoint);
		// beállítja a jelet a kimenő kapcsolata kapcsolódási pontján
		outConnection.setSignal(outConnectionPoint,signal);
		// működésbe hozza a kimenetre kapcsolódó komponenst és lekérdezi, hogy történt -e változás
		boolean result = outConnection.doFunction();
		// behúzás csökkentése
		Tabber.decreaseIndent();
		// visszaadja, hogy történt -e változas
		return false;
	}

	/**
	 * @return kimeneten lévő komponens
	 */
        /**
         * A kimeneten lévő komponenssel tér vissza
         */
	public DigitalComponent getOutConnection() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".getOutConnection()");
                // komponens visszaadása
		return outConnection;
	}

	/**
	 * @param outConnection a kimentként beállítandó komponens
         * @param pin a paraméterként kapott komponens lábának indexe
	 */
        /**
         * Beállítja a  paraméterként kapott komponenst kimenetként,
         * és eltárolja a csatlakozó láb indexét.
         */
	public void setOutConnection(DigitalComponent outConnection, int pin) 
	{
                // tárolás
		this.outConnection = outConnection;
		this.outConnectionPoint = pin;
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".setOutConnection(" + NameChooser.getName(outConnection) + "," + pin + ")");
	}

	/**
	 * @return bemenő lábán lévő komponens
	 */
        /**
         * A bemeneten lévő komponenssel tér vissza.
         */
	public DigitalComponent getInConnection() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".getInConnection()");
                // komponens visszaadása
		return inConnection;
	}

	/**
	 * @param inConnection a bementként beállítandó komponens
         * @param pin a paraméterként kapott komponens lábának indexe
	 */
        /**
         * Beállítja a paraméterként kapott komponenst bemenetként,
         * és eltárolja a csatlakozó láb indexét.
         */
	public void setInConnection(DigitalComponent inConnection, int pin) 
	{
                // tárolás
		this.inConnection = inConnection;
		this.inConnectionPoint = pin;
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".setInConnection(" + NameChooser.getName(inConnection) + "," + pin + ")");
	}

	/**
	 * @return kimenő lábán lévő komponens csatlakozó lábának indexe
	 */
        /**
         * A kimenet csatlakozó lábának indexét adja vissza.
         */
	public int getOutConnectionPoint() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".getOutConnectionPoint()");
                // index visszaadása
		return outConnectionPoint;
	}

	/**
	 * @return bemenő lábán lévő komponens csatlakozó lábának indexe
	 */
        /**
         * A bemenet csatlakozó lábának indexét adja vissza.
         */
	public int getInConnectionPoint() 
	{
                // metódus kiíratasa
		System.out.println( NameChooser.getName(this) + ".getInConnectionPoint()");
                // index visszaadása
		return inConnectionPoint;
	}
}
