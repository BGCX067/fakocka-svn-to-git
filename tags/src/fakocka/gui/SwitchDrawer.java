/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;

import fakocka.model.Switch;

/**
 * @author fakocka
 *
 */
public class SwitchDrawer extends DrawerBase {

	public SwitchDrawer(Coordinate position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		Switch sw = (Switch)digitalComponent;
		g.setColor(Color.WHITE);
		g.fillRect(
				position.getX(),
				position.getY(),
				10,
				10);
		g.setColor(Color.BLACK);
		g.drawRect(
				position.getX(),
				position.getY(),
				10,
				10);		
		if(sw.isStateOn()) {
			g.setColor(Color.RED);
			g.fillOval(
					position.getX()+1,
					position.getY()+1,
					8,
					8);
		}
		else {
			g.setColor(Color.WHITE);
			g.fillOval(
					position.getX()+1,
					position.getY()+1,
					8,
					8);
		}
		g.setColor(Color.BLACK);
		g.drawOval(
				position.getX()+1,
				position.getY()+1,
				8,
				8);
	}

}
