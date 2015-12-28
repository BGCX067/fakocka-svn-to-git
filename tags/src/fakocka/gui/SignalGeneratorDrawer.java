/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import fakocka.model.SignalGenerator;

/**
 * @author fakocka
 *
 */
public class SignalGeneratorDrawer extends DrawerBase {

	
	/**
	 * @param position
	 */
	public SignalGeneratorDrawer(Coordinate position) {
		super(position);
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// jelgenerator kirajzolasa
		SignalGenerator signalGenerator = (SignalGenerator)digitalComponent;
		// kor kirajzolasa az allapotnak megfeleloen
		// piros, ha 1es
		if(signalGenerator.getSignal(0)) {
			g.setColor(Color.RED);
			g.fillOval(
					position.getX(),
					position.getY(),
					10,
					10);
		}
		// feher, ha 0
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
		// jelsorozat kirajzolasa a jelgenerator melle
		ArrayList<Boolean> signalSequence = signalGenerator.getSignalSequence();	
		for(int i = 0; i < signalSequence.size(); i++) {
			if((i == signalGenerator.getSequenceIndex()-1) )
				g.setColor(Color.RED);
			else
				g.setColor(Color.BLACK);
			
			Boolean signal = signalSequence.get(i);
			String character = signal.toString();
			character = character.replace("true","1");
			character = character.replace("false","0");
			g.drawString(
					character, 
					position.getX()-35+i*6,
					position.getY()+10);
		}
	}

}
