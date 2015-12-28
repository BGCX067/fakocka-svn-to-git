/**
 * 
 */
package fakocka.gui;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import fakocka.model.DigitalCircuit;
import fakocka.model.DigitalComponent;
import fakocka.model.SignalSource;
import fakocka.model.Wire;

/**
 * @author fakocka
 *
 */
public class DrawerManager {
	
	/**
	 * 
	 */
	private static HashMap<Integer,Drawer> drawers = null;
	
	/**
	 * 
	 */
	private static DigitalCircuit digitalCircuit = null;
	
	/**
	 * 
	 */
	//private static DrawerManager instance = null;
	
	/**
	 * 
	 */
//	protected DrawerManager() {
//		
//	}
	
	/**
	 * 
	 */
	public static void initialize() {
		//instance = null;
		digitalCircuit = null;
		drawers = new HashMap<Integer,Drawer>();		
	}
	
	/**
	 * @return
	 */
//	public static DrawerManager getInstance() {
//		if (instance == null)
//			instance = new DrawerManager();
//		return instance;
//	}
	
	/**
	 * @param dc
	 */
	public static void addDigitalCircuit(DigitalCircuit dc) {
		// digitalis aramkor hozzaadasa
		digitalCircuit = dc;
		// jelforrasok listajanak lekerdezese
		LinkedList<SignalSource> signalSources = digitalCircuit.getSignalSources();
		for(SignalSource signalSource : signalSources) {
			// id lekerdezese
			int id = signalSource.getId();
			// drawer lekerdezese id alapjan
			Drawer drawer = drawers.get(id);
			// jelforras hozzadasa a megfelelo drawerhez
			drawer.setDigitalComponent(signalSource);		
		}
		// digitalis komponensek listajanak lekerdezese
		LinkedList<DigitalComponent> digitalComponents = digitalCircuit.getDigitalComponents();
		for(DigitalComponent digitalComponent : digitalComponents) {
			// id lekerdezese
			int id = digitalComponent.getId();
			// drawer lekerdezese id alapjan
			Drawer drawer = drawers.get(id);
			// digitalis komponens hozzadasa a megfelelo drawerhez
			drawer.setDigitalComponent(digitalComponent);		
		}
		// vezetekek listajanak lekerdezese
		LinkedList<Wire> wires = digitalCircuit.getWires();
		for(Wire wire : wires) {
			// id lekerdezese
			int id = wire.getId();
			// drawer lekerdezese id alapjan
			Drawer drawer = drawers.get(id);
			// vezetek hozzadasa a megfelelo drawerhez
			drawer.setDigitalComponent(wire);		
		}
	}
	
	/**
	 * @param g
	 */
	public static void drawAll(Graphics g) {
		if(digitalCircuit!=null) {
			// jelforrasok listajanak lekerdezese
			LinkedList<SignalSource> signalSources = digitalCircuit.getSignalSources();
			for(SignalSource signalSource : signalSources) {
				// id lekerdezese
				int id = signalSource.getId();
				// drawer lekerdezese id alapjan
				Drawer drawer = drawers.get(id);
				// kirajzolas
				drawer.draw(g);			
			}
			// digitalis komponensek listajanak lekerdezese
			LinkedList<DigitalComponent> digitalComponents = digitalCircuit.getDigitalComponents();
			for(DigitalComponent digitalComponent : digitalComponents) {
				// id lekerdezese
				int id = digitalComponent.getId();
				// drawer lekerdezese id alapjan
				Drawer drawer = drawers.get(id);
				// kirajzolas
				drawer.draw(g);			
			}
			// vezetekek listajanak lekerdezese
			LinkedList<Wire> wires = digitalCircuit.getWires();
			for(Wire wire : wires) {
				// id lekerdezese
				int id = wire.getId();
				// drawer lekerdezese id alapjan
				Drawer drawer = drawers.get(id);
				// kirajzolas
				drawer.draw(g);	
			}
		}
	}
	
	/**
	 * @param id
	 * @param drawer
	 */
	public static void putDrawer(int id, Drawer drawer) {
		drawers.put(id, drawer);
	}
	
	/**
	 * @param id
	 * @return
	 */
	public static Drawer getDrawer(int id) {
		return drawers.get(id);
	}
}
