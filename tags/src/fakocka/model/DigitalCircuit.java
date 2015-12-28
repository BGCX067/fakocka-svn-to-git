package fakocka.model;

import java.util.LinkedList;
import java.util.Observable;

/**
 * @author fakocka
 *
 */
public class DigitalCircuit extends Observable
{
	/**
	 * 
	 */
	private LinkedList<DigitalComponent> digitalComponents;
	
	/**
	 * 
	 */
	private LinkedList<SignalSource> signalSources;
	
	/**
	 * 
	 */
	private LinkedList<Wire> wires;
	
	/**
	 * 
	 */
	private boolean simulating;
	
	/**
	 * 
	 */
	private int deltaTime;

	/**
	 * 
	 */
	public DigitalCircuit() 
	{
		digitalComponents = new LinkedList<DigitalComponent>();
		signalSources = new LinkedList<SignalSource>();
		wires = new LinkedList<Wire>();
		simulating = false;
		deltaTime = 1000;
	}

	/**
	 * @return
	 */
	public void validateCircuit() throws Exception
	{	
		for(int i = 0; i < wires.size(); i ++)
		{
			// kivalasztja a vizsgalando vezeteket
			Wire wire = wires.get(i);
			// lekerdezi a kimenetere kapcsolodo komponenst
			DigitalComponent outConnection = wire.getOutConnection();
			// lekerdezi, hogy a kimenetere kapcsolodo komponens melyik labara csatlakozik
			int outConnectionPoint = wire.getOutConnectionPoint();
			
			for(int j = 0; j < wires.size(); j++)
			{
				// ha nem vizsgalando komponensrol van szo.
				if(j != i)
				{
					// kivalasztja az osszehasonlitando vezeteket
					Wire w = wires.get(j);
					// lekerdezi a kimenetere kapcsolodo komponenst
					DigitalComponent connection = w.getOutConnection();
					// lekerdezi, hogy a kimenetere kapcsolodo komponens melyik labara csatlakozik
					int connectionPoint = w.getOutConnectionPoint();
					// ha ket vezetek kimenetere kapcsolodo komponensek es a kapcsolodasi pontok is megegyeznek...
					if( outConnection.getId() == connection.getId() &&
							outConnectionPoint == connectionPoint)
					{
						// baj van
						throw new Exception("A(z) " + 
											wire.getId() + 
											" es a(z) " + 
											w.getId() + 
											" ID-ju vezetekek is a(z) " + 
											connection.getId() + 
											" ID-ju komponens " +
											connectionPoint + 
											" indexu labara csatlakoznak!");
					}
				}
			}		
		}
	}
	
	/**
	 * 
	 */
	public void startSimulation()
	{
		// jelezzuk, hogy a szimulacio fut
		simulating = true;
	}
	
	/**
	 * @throws Exception
	 */
	public void stepSimulation() throws Exception
	{
		// vegigmegy az osszes jelforrason...
		for(SignalSource signalSource : signalSources)
		{
			// .. es inicializalja oket
			signalSource.initialize();
		}
		
		int iterationCounter = 0;
		boolean changed;
		
		do
		{
			// alapbol nem valtozott
			changed = false;
			// vegigmegy az osszes vezeteken...
			for(Wire wire : wires)
			{
				// tovabbitja a jelet es jelzi, hogy tortent e valtozas
				changed |= wire.doFunction();
				// noveli az iteracios szamlalot
				iterationCounter++;
			}
			// az iteracio szamlalo tul magas erteket ert el...
			if(iterationCounter >= 1000)
			{
				// kivetel dobodik
				throw new Exception("Instabil allapot!");
			}
		}
		// addig fut, amig nem tortent valtozas...
		while(changed);
		
		// jelezzuk az Observernek, hogy valtozott az aramkor allapota
		setChanged();	
	}
	
	/**
	 * 
	 */
	public void stopSimulation()
	{
		// jelezzuk hogy a szimulacio le lett allitva
		simulating = false;
	}
	
	/**
	 * @return
	 */
	public boolean isSimulating()
	{
		return simulating;
	}
	
	/**
	 * @return
	 */
	public int getDeltaTime() 
	{
		return deltaTime;
	}

	/**
	 * @param deltaTime
	 */
	public void setDeltaTime(int deltaTime) 
	{
		this.deltaTime = deltaTime;
	}

	/**
	 * @param digitalComponent
	 */
	public void addDigitalComponent(DigitalComponent digitalComponent) 
	{
		digitalComponents.add(digitalComponent);
	}

	/**
	 * @param id
	 * @return
	 */
	public DigitalComponent getDigitalComponent(int id) 
	{
		// vegigmegyek a komponenseket tartalmazo tombon
		for(DigitalComponent digitalComponent : digitalComponents)
		{
			// ha az id megeegyezik
			if(digitalComponent.getId() == id)
			{
				// visszaadja a komponenst
				return digitalComponent;
			}
		}
		// ha nem talalta null-t ad vissza
		return null;
	}

	/**
	 * @return
	 */
	public LinkedList<DigitalComponent> getDigitalComponents() 
	{
		return digitalComponents;
	}

	/**
	 * @param signalSource
	 */
	public void addSignalSource(SignalSource signalSource) 
	{
		signalSources.add(signalSource);
	}

	/**
	 * @param id
	 * @return
	 */
	public SignalSource getSignalSource(int id) 
	{
		// vegigmegyek a komponenseket tartalmazo tombon
		for(SignalSource signalSource : signalSources)
		{
			// ha az id megeegyezik
			if(signalSource.getId() == id)
			{
				// visszaadja a komponenst
				return signalSource;
			}
		}
		// ha nem talalta null-t ad vissza
		return null;
	}

	/**
	 * @return
	 */
	public LinkedList<SignalSource> getSignalSources() 
	{
		return signalSources;
	}

	/**
	 * @param wire
	 */
	public void addWire(Wire wire) 
	{
		wires.add(wire);
	}

	/**
	 * @param id
	 * @return
	 */
	public Wire getWire(int id) 
	{
		// vegigmegyek a komponenseket tartalmazo tombon
		for(Wire wire : wires)
		{
			// ha az id megeegyezik
			if(wire.getId() == id)
			{
				// visszaadja a komponenst
				return wire;
			}
		}
		// ha nem talalta null-t ad vissza
		return null;
	}

	/**
	 * @return
	 */
	public LinkedList<Wire> getWires() 
	{
		return wires;
	}
}
