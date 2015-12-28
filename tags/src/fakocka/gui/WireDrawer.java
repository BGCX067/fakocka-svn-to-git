/**
 * 
 */
package fakocka.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import fakocka.model.Wire;

/**
 * @author fakocka
 *
 */
public class WireDrawer extends DrawerBase {

	private ArrayList<Coordinate> coordinates;
	
	/**
	 * @param position
	 */
	public WireDrawer(ArrayList<Coordinate> coordinates) {
		super(coordinates.get(0));
		this.coordinates = coordinates;
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.DrawerBase#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// vezetek lekerdezese
		Wire wire = (Wire)digitalComponent;
		// x koordinatak taroloja
		int[] xPoints = new int[coordinates.size()];
		// y koordinatak taroloja
		int[] yPoints = new int[coordinates.size()];
		// kezdo x koordinata hozzaadasa
		xPoints[0] = position.getX();
		// kezdo y koordinata hozzaadasa
		yPoints[0] = position.getY();
		// koordinatak lekerdezese
		for(int i = 1; i < coordinates.size(); i++) {
			// koordinata lekerdezese
			Coordinate coordinate = coordinates.get(i);
			// x koordinata eltarolasa
			xPoints[i] = coordinate.getX();
			// y koordinata eltarolasa
			yPoints[i] = coordinate.getY();
		}
		// megfelelo szin beallitasa
		if(wire.getSignal(0)) {
			// ha 1 akkor szurke
			g.setColor(Color.RED);
		}
		else {
			// ha 0 akkor fekete
			g.setColor(Color.BLACK);
		}	
		// vezetek kirajzolasa
		g.drawPolyline(xPoints, yPoints, coordinates.size());
	}

}
