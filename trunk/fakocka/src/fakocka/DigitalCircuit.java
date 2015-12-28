package fakocka;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Az összes digitális komponens tárolásáért felelős, a kialakított kapcsolatok
 * ellenőrzését végzi, továbbá képes különféle módon (lépésenként és folyamatosan)
 * leszimulálni a digitális áramkört.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class DigitalCircuit extends Observable implements Runnable
{
	/**
	 * A vezetékeken és jelforrásokon kívüli komponenseket tároló lista.
	 */
	private LinkedList<DigitalComponent> digitalComponents;
	
	/**
	 * A jelforrásokat tároló lista.
	 */
	private LinkedList<SignalSource> signalSources;
	
	/**
	 * A vezetékeket tároló lista.
	 */
	private LinkedList<Wire> wires;
	
	/**
	 * Az áramkör állapotát jelzi.
	 */
	private boolean simulating;
	
	/**
	 * Az áramkör két léptetése közötti időt határozza meg.
	 */
	private int deltaTime;

	/**
	 * Konstruktor
	 */
	public DigitalCircuit() 
	{
		// konstruktor kiíratása
		System.out.println("digitalCircuit = new DigitalCircuit()");
		// kollekciók inicializálása
		digitalComponents = new LinkedList<DigitalComponent>();
		signalSources = new LinkedList<SignalSource>();
		wires = new LinkedList<Wire>();
	}

	
	/**
	 *  Ellenőrzi a komponensek közötti kapcsolatok helyességét.
	 * 
	 * @throws Exception hibás kapcsolás esetén.
	 */
	public void validateCircuit() throws Exception 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.validateCircuit()");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
        /**
         * A Runnable interface felüldefiniált metódusa, ami a szimulációt végzi a háttérszálban.
         */
	@Override
	public void run()
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.run()");
	}
	
	/**
	 * Addig szimulálja az áramkört lépésenként, amíg le nem állítják.
         * Ehhez egy háttérszálat használ.
	 */
	public void startSimulation()
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.startSimulation()");
	}
	
	/**
	 * Egy lépést szimulál az áramkörön.
	 */
	public void stepSimulation()
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.stepSimulation()");
		
		// végigmegy az összes jelforráson...
		for(SignalSource signalSource : signalSources)
		{
			// .. és inicializálja őket
			signalSource.initialize();
		}
		
		// ide olvassuk be a felhasználó döntését
		boolean changed;
		
		do
		{
			// végigmegy az összes vezetéken...
			for(Wire wire : wires)
			{
				// továbbítja a jelet
				wire.doFunction();
			}
			
			// EZ A RESZ ES A DO-WHILE CIKLUS NEM BIZTOS, HOGY KELL, HA ELEG CSAK 1SZER VEGIGMENNI... 
			System.out.println("Valtozott a digitalis aramkor? (I/N)");
			String choice = UserInput.readConsoleLine();
			if(choice.compareTo("I") == 0)
				changed = true;
			else 
				changed = false;
		}
		// addig fut, amig nem történt változás...
		while(changed);
	}
	
	/**
	 * Leállítja az áramkör szimulációját.
	 */
	public void stopSimulation()
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.stopSimulation()");
	}
	
	/**
	 * @return az áramkör állapotát
	 */
	public boolean isSimulating()
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.isSimulating()");
		return false;
	}
	
	/**
	 * @return a szimuláció lépésközét
	 */
	public int getDeltaTime() 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getDeltaTime()");
		return 0;
	}

	/**
	 * @param deltaTime a szimuláció lépéskoze
	 */
	public void setDeltaTime(int deltaTime) 
	{
		this.deltaTime = deltaTime;
		// metódus kiíratása
		System.out.println("digitalCircuit.setDeltaTime(" + deltaTime + ")");
	}

	/**
	 * @param digitalComponent digitális komponens
	 */
	public void addDigitalComponent(DigitalComponent digitalComponent) 
	{
		digitalComponents.add(digitalComponent);
		// metódus kiíratása
		System.out.println("digitalCircuit.addDigitalComponent(" + NameChooser.getName(digitalComponent) + ")");
	}

	/**
	 * @param id digitális komponens azonosítója
	 * @return azonosítóhoz tartozó digitális komponens
	 */
	public DigitalComponent getDigitalComponent(int id) 
	{
		// metódus kiíratósa
		System.out.println("digitalCircuit.getDigitalComponent(" + id + ")");
		return null;
	}

	/**
	 * @return digitalis komponenseket tartalmazó lista
	 */
	public List<DigitalComponent> getDigitalComponents() 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getDigitalComponents()");
		return null;
	}

	/**
	 * @param signalSource jelforrás
	 */
	public void addSignalSource(SignalSource signalSource) 
	{
		signalSources.add(signalSource);
		// metódus kiíratása
		System.out.println("digitalCircuit.addSignalSource(" + NameChooser.getName(signalSource) + ")");
	}

	/**
	 * @param id jelforrás azonosítója
	 * @return azonosítóhoz tartozó jelforrás
	 */
	public SignalSource getSignalSource(int id) 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getSignalSource(" + id + ")");
		return null;
	}

	/**
	 * @return jelforrásokat tartalmazó lista
	 */
	public List<SignalSource> getSignalSources() 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getSignalSources()");
		return null;
	}

	/**
	 * @param wire vezeték
	 */
	public void addWire(Wire wire) 
	{
		wires.add(wire);
		// metódus kiíratása
		System.out.println("digitalCircuit.addWire(" + NameChooser.getName(wire) + ")");
	}

	/**
	 * @param id vezeték azonosítója
	 * @return azonosítóhoz tartozó vezeték
	 */
	public Wire getWire(int id) 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getWire(" + id + ")");
		return null;
	}

	/**
	 * @return vezetékeket tartalmazó lista
	 */
	public List<Wire> getWires() 
	{
		// metódus kiíratása
		System.out.println("digitalCircuit.getWires()");
		return null;
	}
}
