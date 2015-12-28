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
public class CompositeDrawer extends DrawerBase {
	
	private String compositeLabel;

	/**
	 * @param position
	 */
	public CompositeDrawer(Coordinate position, String compositeLabel) {
		super(position);
		this.compositeLabel = compositeLabel;
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// composite kirajzolasa
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
				compositeLabel,
				position.getX()+3,
				position.getY()+20);
	}

}
