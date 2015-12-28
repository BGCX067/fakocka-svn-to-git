/**
 * 
 */
package fakocka.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fakocka
 *
 */
public class Scope extends ComponentBase 
{
	/*
	 * 
	 */
	private boolean measuring;
	
	/**
	 * 
	 */
	private LinkedList<Boolean> signalHistory;	
	
	/**
	 * @param id
	 */
	public Scope(int id) 
	{
		super(id);
		signalHistory = new LinkedList<Boolean>();
		signals = new boolean[1];
		// a kimeneti lab erteket logikai hamis ertekre allitja
		signals[0] = false;
		// kezdetben mintavételez
		measuring = true;
	}

	/* (non-Javadoc)
	 * @see fakocka.ComponentBase#doFunction()
	 */
	@Override
	public boolean doFunction() 
	{
		if(measuring)
		{
			Boolean measuredSignal = signals[0];
			signalHistory.add(measuredSignal);
		}
		return false;
	}
	
	/**
	 * @param index
	 * @return
	 */
	public boolean getMeasuredSignal(int index)
	{
		boolean measuredSignal = signalHistory.get(index);
		return measuredSignal;
	}
	
	/**
	 * @return
	 */
	public List<Boolean> getSignalHistory() 
	{
		return Collections.unmodifiableList(signalHistory);
	}

	/**
	 * @return
	 */
	public boolean isMeasuring() 
	{
		return measuring;
	}

	/**
	 * @param measuring
	 */
	public void setMeasuring(boolean measuring) 
	{
		this.measuring = measuring;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Scope";
	}
}
