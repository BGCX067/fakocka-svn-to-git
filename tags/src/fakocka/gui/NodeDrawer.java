/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;

import fakocka.model.Node;

/**
 * @author fakcoka
 *
 */
public class NodeDrawer extends DrawerBase {

	/**
	 * @param position
	 */
	public NodeDrawer(Coordinate position) {
		super(position);
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// node lekerdezese
		Node node = (Node)digitalComponent;
		// megfelelo szin beallitasa
		if(node.getSignal(0))
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLACK);
		// node kirajzolasa
		g.fillOval(
				position.getX(),
				position.getY(), 
				7, 
				7);
	}

}
