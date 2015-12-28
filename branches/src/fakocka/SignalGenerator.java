package fakocka;

import java.util.ArrayList;

/**
 * @author fakocka
 *
 */
public class SignalGenerator extends SignalSource
{
	/**
	 * 
	 */
	private ArrayList<Boolean> signalSequence;
	
	/**
	 * 
	 */
	private int sequenceIndex;

	/**
	 * @param pins
	 * @param id
	 */
	public SignalGenerator(int id) 
	{
		// ososztaly konstruktora
		super(id);
		signals = new boolean[1];
		// a kimeneti lab erteket logikai hamis ertekre allitja
		signals[0] = false;
		// tomb inicializalasa
		signalSequence = new ArrayList<Boolean>();
		// alapbol 0-as index
		sequenceIndex = 0;
	}

	/* (non-Javadoc)
	 * @see fakocka.SignalSource#initialize()
	 */
	public void initialize() 
	{
		doFunction();
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	public boolean doFunction() 
	{
		// a kimenetre beallitja az aktualis indexnek megfelelo logikai erteket
		signals[0] = signalSequence.get(sequenceIndex);
		// noveli az indexet
		incrementSequenceIndex();
		// a jelgenerator csak beallitja a kimeneten az erteket, nem o donti el hogy tertent e valtozas
		return false;
	}

	/**
	 * @param signal
	 */
	public void addSignal(Boolean signal) 
	{
		signalSequence.add(signal);
	}

	/**
	 * @return
	 */
	public int getSequenceIndex() 
	{
		return sequenceIndex;
	}

	/**
	 * 
	 */
	public void incrementSequenceIndex() 
	{
		// index novelese
		sequenceIndex++;
		// korbefordul
		if(sequenceIndex >= signalSequence.size())
			sequenceIndex = 0; 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SignalGenerator";
	}
}
