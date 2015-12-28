/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;

import fakocka.model.Display;

/**
 * @author fakocka
 *
 */
public class DisplayDrawer extends DrawerBase {

	public DisplayDrawer(Coordinate position) {
		super(position);
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		Display display = (Display)digitalComponent;
		if(display.isLightOn()) {
			g.setColor(Color.BLUE);
			g.fillOval(
					position.getX(),
					position.getY(),
					10,
					10);
		}
		else {
			g.setColor(Color.WHITE);
			g.fillOval(
					position.getX(),
					position.getY(),
					10,
					10);
		}
		g.setColor(Color.BLACK);
		g.drawOval(
				position.getX(),
				position.getY(),
				10,
				10);
	}

}
