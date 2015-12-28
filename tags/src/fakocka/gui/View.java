/**
 * 
 */
package fakocka.gui;

import fakocka.model.DigitalCircuit;

/**
 * @author fakocka
 *
 */
public interface View {
	
	/**
	 * 
	 */
	public void display();
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void display(int x, int y, int width, int height);
	
	/**
	 * @param digitalCircuit
	 */
	public void reset(DigitalCircuit digitalCircuit);
}
