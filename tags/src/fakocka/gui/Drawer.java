/**
 * 
 */
package fakocka.gui;

import java.awt.Graphics;

import fakocka.model.DigitalComponent;

/**
 * @author fakocka
 *
 */
public interface Drawer {

	/**
	 * @param g
	 */
	public void draw(Graphics g);
	
	/**
	 * @return
	 */
	public Coordinate getPositon();
	
	/**
	 * @param position
	 */
	public void setPosition(Coordinate position);
	
	/**
	 * @return
	 */
	public DigitalComponent getDigitalComponent();
	
	/**
	 * @param digitalComponent
	 */
	public void setDigitalComponent(DigitalComponent digitalComponent);
}
