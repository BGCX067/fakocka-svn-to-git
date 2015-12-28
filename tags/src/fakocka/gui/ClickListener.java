/**
 * 
 */
package fakocka.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import fakocka.model.DigitalCircuit;
import fakocka.model.Switch;

/**
 * @author fakocka
 *
 */
public class ClickListener extends MouseAdapter {

	/**
	 * 
	 */
	private static HashMap<Coordinate,Integer> ids;
	
	/**
	 * 
	 */
	private static ArrayList<Coordinate> coordinates;
	
	/**
	 * 
	 */
	private static DigitalCircuit digitalCircuit;
	
	/**
	 * 
	 */
	private GraphicView view;
	
	public ClickListener(GraphicView view) {
		this.view = view;
	}
	
	/**
	 * 
	 */
	public static void initialize() {
		ids = new HashMap<Coordinate,Integer>();
		coordinates = new ArrayList<Coordinate>();
		digitalCircuit = null;
	}
	
	public static void addDigitalCircuit(DigitalCircuit dc) {
		digitalCircuit = dc;	
	}
	
	/**
	 * @param coordinate
	 * @param id
	 */
	public static void putCoordinateAndId(Coordinate coordinate, int id) {
		ids.put(coordinate, id);
		coordinates.add(coordinate);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// ha mar hozza lett adva a figyelendo digitalis aramkor
		if(digitalCircuit != null && coordinates != null) {
			// vegigmegyunk az eltarolt koordinatakon
			for(Coordinate coordinate : coordinates) {
				// ha a megadott koordinatan talalhato switch-re kattuntunk
				if(	(e.getX() >= coordinate.getX()) &&
					(e.getY() >= coordinate.getY()) &&
					(e.getX() <= coordinate.getX()+10) &&
					(e.getY() <= coordinate.getY()+10)) {
					// a koordinatahoz tartozo switch id-janak lekerdezese
					int id = ids.get(coordinate);
					// switch lekerdezese az id alapjan
					Switch sw = (Switch)digitalCircuit.getSignalSource(id);
					// a switch regi allapotanak lekerdezese
					boolean oldState = sw.isStateOn();
					// uj allapot eloallitasa
					boolean newState = !oldState;
					// switch uj allapotanak beallitasa
					sw.setState(newState);
					// valtozas kijelzese a view-n (csak az adott teruletet rajzoljuk ujra)
					view.display(
							coordinate.getX(),
							coordinate.getY(),
							10,
							10);
				}
			}
		}
	}
}
