/**
 * 
 */
package fakocka;

import java.util.LinkedList;

/**
 * @author fakocka
 *
 */
public class Composite extends ComponentBase 
{	
	/*
	 * 
	 */
	private DigitalCircuit internalCircuit;

	/**
	 * 
	 */
	private int inPins;
	
	/**
	 * 
	 */
	private int outPins;
	
	public Composite(int inPins, int outPins, int id) 
	{
		super(id);
		
		this.inPins = inPins;
		this.outPins = outPins;
		
		internalCircuit = new DigitalCircuit();
		
		signals = new boolean[inPins + outPins];
		// az osszes bejovo lab erteket logikai hamis ertekre allitja
		for(int i = 0; i < signals.length; i ++)
		{
			signals[i] = false;
		}
	}

	/**
	 * @param internalDigitalComponent
	 */
	public void addInternalDigitalComponent(DigitalComponent internalDigitalComponent) 
	{
		internalCircuit.addDigitalComponent(internalDigitalComponent);
	}
	
	/**
	 * @param internalSignalSource
	 */
	public void addInternalSignalSource(SignalSource internalSignalSource) 
	{
		internalCircuit.addSignalSource(internalSignalSource);
	}
	
	/**
	 * @param internalWire
	 */
	public void addInternalWire(Wire internalWire) 
	{
		internalCircuit.addWire(internalWire);
	}
	
	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	@Override
	public boolean doFunction()
	{
		// bemeneteket tartalmazo lista lekerdezese
		LinkedList<SignalSource> internalSignalSources = internalCircuit.getSignalSources();
		// belső jelforrások inicializálása a kompozit elem bemenetei alapján
		for(int i = 0; i < inPins; i ++)
		{
			// adott bementi lábhoz tartozó jelforrás lekérdezése
			Switch s = (Switch)internalSignalSources.get(i);
			// a kompozit elem jelforráshoz tartozó bemenetének lekérdezése
			boolean inSignal = signals[i];
			// jelforrás értékének beállítása
			s.setState(inSignal);
		}
		
//		// belső jelforrások inicializálása a kompozit elem bemenetei alapján
//		for(int i = 0; i < internalSignalSources.size(); i++)
//		{
//			// adott bementi lábhoz tartozó jelforrás lekérdezése
//			SignalSource iss = internalSignalSources.get(i);
//			// a kompozit elem jelforráshoz tartozó bemenetének lekérdezése
//			boolean inSignal = signals[i];
//			// jelforrás értékének beállítása
//			iss.setSignal(0,inSignal);
//		}
		
		// vegigmegy az osszes belso jelforrason...
//		for(SignalSource signalSource : internalSignalSources)
//		{
//			// .. es inicializalja oket
//			signalSource.initialize();
//		}
//		
//		// belső "halozat" valtozasa...
//		boolean changed;		
//		// a belso halozat (kompzit elem) kiertekelese
//		do
//		{
//			// alapbol nem valtozott
//			changed = false;
//			// vegigmegy az osszes belso vezeteken...
//			for(Wire wire : internalWires)
//			{
//				// tovabbitja a jelet es jelzi, hogy tortent e valtozas
//				changed |= wire.doFunction();
//			}
//			// iteracio vizsgalat kell ide??
//		}
//		// addig fut, amig nem tortent valtozas...
//		while(changed);
		
		// belso halozat szimulacioja
		try
		{
			internalCircuit.stepSimulation();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		// alapból nem változott
		boolean result = false;
		// a komponenseket tartalmazo lista lekerdezese
		LinkedList<DigitalComponent> internalComponents = internalCircuit.getDigitalComponents();
		// a kompozit elem kimeneteinek beállítása a belső kijelzők alapján (ezek a komponenseket tartalmazo lista vegen helyezkednek el)
		for(int i = internalComponents.size()-outPins, j = 0; i < internalComponents.size(); i++, j++)
		{
			// adott kimeneti lábhoz tartozó kijelző lekérdezése
			Display d = (Display)internalComponents.get(i);
			// kijelző értékének lekérdezése
			boolean outSignal = d.getSignal(0);
			// változás detektálása (akkor változik a kompozit elem, ha bármely kimenete változott)
			result |= signals[j+inPins] != outSignal;
			// a kompzit elem megfelelő kimeneti lábának beállítása
			signals[j+inPins] = outSignal;
		}
		return result;
	}
	
	/**
	 * @return
	 */
	public int getInPins()
	{
		return inPins;
	}
	
	/**
	 * @return
	 */
	public int getOutPins()
	{
		return outPins;
	}
	
	public DigitalCircuit getInternalCircuit() 
	{
		return internalCircuit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Composite";
	}
}
