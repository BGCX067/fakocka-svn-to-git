/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author fakocka
 *
 */
public class InverterDrawer extends DrawerBase {

	/**
	 * @param position
	 */
	public InverterDrawer(Coordinate position) {
		super(position);
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// inverter kirajzolasa
		g.setColor(Color.WHITE);
		g.fillRect(
				position.getX(), 
				position.getY(), 
				40, 
				30);
		g.setColor(Color.BLACK);		
		g.drawRect(
				position.getX(), 
				position.getY(), 
				40, 
				30);
		g.drawString(
				"INV",
				position.getX()+11,
				position.getY()+20);
	}

}
