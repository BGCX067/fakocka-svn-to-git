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
abstract class DrawerBase implements Drawer {
	
	/**
	 * 
	 */
	protected Coordinate position;
	
	/**
	 * 
	 */
	protected DigitalComponent digitalComponent;

	public DrawerBase(Coordinate position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.Drawer#draw(java.awt.Graphics)
	 */
	public abstract void draw(Graphics g);
	
	/* (non-Javadoc)
	 * @see fakocka.gui.Drawer#getPositon()
	 */
	@Override
	public Coordinate getPositon() {
		return position;
	}
	
	/* (non-Javadoc)
	 * @see fakocka.gui.Drawer#setPosition(fakocka.gui.Coordinate)
	 */
	@Override
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	
	/**
	 * @return
	 */
	@Override
	public DigitalComponent getDigitalComponent() {
		return digitalComponent;
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.Drawer#setDigitalComponent(fakocka.model.DigitalComponent)
	 */
	@Override
	public void setDigitalComponent(DigitalComponent digitalComponent) {
		this.digitalComponent = digitalComponent;
	}
}
