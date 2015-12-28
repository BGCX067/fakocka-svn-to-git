/**
 * 
 */
package fakocka.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author fakocka
 *
 */
public class GraphicLoader {

	/**
	 * 
	 */
	private String fileName;
	
	/**
	 * 
	 */
	private String type;
	
	/**
	 * 
	 */
	private String compositeLabel;
	
	/**
	 * 
	 */
	private int id;
	
	/**
	 * 
	 */
	private ArrayList<Coordinate> coordinates;
	
	/**
	 * @param fileName
	 */
	public GraphicLoader(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 
	 */
	public void loadGraphic() {		
		try {
			// ebbe a sorba olvasunk be
			String line = null;
			// buffer letrehozasa
			BufferedReader buffer = new BufferedReader(new FileReader(new File(fileName)));
			// amig minden sort be nem olvastunk...
			while((line = buffer.readLine()) != null) {
				// string tokenizer letrehozasa
				StringTokenizer tokens = new StringTokenizer(line);
				// tipus kiolvasasa
				type = tokens.nextToken();
				//System.out.println("Type: " + type);
				// composite label kiolvasasa
				if(type.equals("composite"))
					compositeLabel = tokens.nextToken();
				// id kiolvasas
				id = Integer.parseInt(tokens.nextToken());
				//System.out.println("ID: " + id);
				// koordinatakat tarolo lista letrehozasa
				coordinates = new ArrayList<Coordinate>();
				// coordinatak kiolvasas
				for(int i = 0; tokens.hasMoreTokens(); i++) {
					// x koordinata kiolvasasa
					int x = Integer.parseInt(tokens.nextToken());
					//System.out.println("X: " + x);
					// y koordinata kiolvasasa
					int y = Integer.parseInt(tokens.nextToken());
					//System.out.println("Y: " + y);
					// coordinate letrehozasa
					Coordinate coordinate = new Coordinate(x,y);
					// eltaroloasa a listaban
					coordinates.add(i, coordinate);
				}
				
				// drawer letrehozasa a tipus alapjan
				createDrawerByType();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	private void createDrawerByType() {
		if(type.equals("andgate")) {
			createANDGateDrawer();
		}
		else if(type.equals("orgate")) {
			createORGateDrawer();
		}
		else if(type.equals("inverter")) {
			createInverterDrawer();
		}
		else if(type.equals("node")) {
			createNodeDrawer();
		}
		else if(type.equals("switch")) {
			createSwitchDrawer();
		}
		else if(type.equals("signalgenerator")) {
			createSignalGeneratorDrawer();
		}
		else if(type.equals("display")) {
			createDisplayDrawer();
		}
		else if(type.equals("scope")) {
			createScopeDrawer();
		}
		else if(type.equals("wire")) {
			createWireDrawer();
		}
		else if(type.equals("composite")) {
			createCompositeDrawer();
		}
		else {
			System.out.println("IO: Invalid type");
		}
	}

	/**
	 * 
	 */
	private void createCompositeDrawer() {
		// compositeDrawer letrehozasa a kiolvasott coordinata alapjan
		CompositeDrawer compositeDrawer = new CompositeDrawer(coordinates.get(0),compositeLabel);
		// compositeDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,compositeDrawer);
	}

	/**
	 * 
	 */
	private void createWireDrawer() {
		// wireDrawer letrehozasa a kiolvasott coordinata(k) alapjan
		WireDrawer wireDrawer = new WireDrawer(coordinates);
		// scopeDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,wireDrawer);
	}

	/**
	 * 
	 */
	private void createScopeDrawer() {
		// scopeDrawer letrehozasa a kiolvasott coordinata alapjan
		ScopeDrawer scopeDrawer = new ScopeDrawer(coordinates.get(0));
		// scopeDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,scopeDrawer);
	}

	/**
	 * 
	 */
	private void createDisplayDrawer() {
		// displayDrawer letrehozasa a kiolvasott coordinata alapjan
		DisplayDrawer displayDrawer = new DisplayDrawer(coordinates.get(0));
		// displayDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,displayDrawer);
	}

	/**
	 * 
	 */
	private void createSignalGeneratorDrawer() {
		// signalGeneratorDrawer letrehozasa a kiolvasott coordinata alapjan
		SignalGeneratorDrawer signalGeneratorDrawer = new SignalGeneratorDrawer(coordinates.get(0));
		// signalGeneratorDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,signalGeneratorDrawer);
	}

	/**
	 * 
	 */
	private void createSwitchDrawer() {
		// switchDrawer letrehozasa a kiolvasott coordinata alapjan
		SwitchDrawer switchDrawer = new SwitchDrawer(coordinates.get(0));
		// siwtchDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,switchDrawer);
		// switch koordinatajanak eltarolasa
		ClickListener.putCoordinateAndId(coordinates.get(0), id);
	}

	/**
	 * 
	 */
	private void createNodeDrawer() {
		// nodeDrawer letrehozasa a kiolvasott coordinata alapjan
		NodeDrawer nodeDrawer = new NodeDrawer(coordinates.get(0));
		// nodeDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,nodeDrawer);
	}

	/**
	 * 
	 */
	private void createORGateDrawer() {
		// orGateDrawer letrehozasa a kiolvasott coordinata alapjan
		ORGateDrawer orGateDrawer = new ORGateDrawer(coordinates.get(0));
		// orGateDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,orGateDrawer);	
	}

	/**
	 * 
	 */
	private void createInverterDrawer() {
		// inverterDrawer letrehozasa a kiolvasott coordinata alapjan
		InverterDrawer inverterDrawer = new InverterDrawer(coordinates.get(0));
		// inverterDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,inverterDrawer);
	}

	/**
	 * 
	 */
	private void createANDGateDrawer() {
		// andGateDrawer letrehozasa a kiolvasott coordinata alapjan
		ANDGateDrawer andGateDrawer = new ANDGateDrawer(coordinates.get(0));
		// andGateDrawer eltarolasa az id alapjan
		DrawerManager.putDrawer(id,andGateDrawer);
	}
}
