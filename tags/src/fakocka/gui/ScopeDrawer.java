/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import fakocka.model.Scope;

/**
 * @author fakocka
 *
 */
public class ScopeDrawer extends DrawerBase {

	/*
	 * 
	 */

	
	/**
	 * @param position
	 */
	public ScopeDrawer(Coordinate position) {
		super(position);
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		Scope scope = (Scope)digitalComponent;
		if(scope.getSignal(0)) {
			g.setColor(Color.GREEN);
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
		// mintavételezett jelsorozat kirajzolasa a scope melle
		List<Boolean> signalHistory = scope.getSignalHistory();
		int i = 0;
		if(signalHistory.size() > 8)
			i = signalHistory.size() - 8;
		for(int j = 0; i < signalHistory.size(); i++, j++) {
			if(i == (signalHistory.size()-1))
				g.setColor(new Color(0,220,0));
			else
				g.setColor(Color.BLACK);	
			Boolean signal = signalHistory.get(i);
			String character = signal.toString();
			character = character.replace("true","1");
			character = character.replace("false","0");
			g.drawString(
					character, 
					position.getX()+15+j*6,
					position.getY()+10);
		}
	}

}
