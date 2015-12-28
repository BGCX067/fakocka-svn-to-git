/**
 * 
 */
package fakocka.gui;

import fakocka.model.CircuitLoader;
import fakocka.model.DigitalCircuit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * @author fakocka
 *
 */
public class GUIController implements ActionListener{
	
	/**
	 * 
	 */
	private GraphicView view;
	
	/**
	 * 
	 */
	private DigitalCircuit digitalCircuit;
	
	/**
	 * 
	 */
	private CircuitLoader circuitLoader;
	
	/**
	 * 
	 */
	private GraphicLoader graphicLoader;
	
	/**
	 * 
	 */
	private JFrame frame;
	
	/**
	 * 
	 */
	private JMenuBar menuBar;
	
	/**
	 * 
	 */
	private JMenu menuFile;
	
	/**
	 * 
	 */
	private JMenu menuSimulation;
	
	/**
	 * 
	 */
	private JMenu menuOptions;
	
	/**
	 * 
	 */
	private JMenu menuHelp;
	
	/**
	 * 
	 */
	private JMenuItem menuItemLoadCircuit;
	
	/**
	 * 
	 */
	private JMenuItem menuItemQuit;
	
	/**
	 * 
	 */
	private JMenuItem menuItemStartSimulation;
	
	/**
	 * 
	 */
	private JMenuItem menuItemStepSimulation;
	
	/**
	 * 
	 */
	private JMenuItem menuItemStopSimulation;
	
	/**
	 * 
	 */
	private JMenuItem menuItemSimulationSpeed;
	
	/*
	 * 
	 */
	private JMenuItem menuItemAbout;

	/*
	 * 
	 */
	private HashMap<String, ImageIcon> resources;
	
	/*
	 * @author fakocka
	 * 
	 */
	public class Simulation implements Runnable {
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// jelezzuk, hogy szimulacio kezdodik
			digitalCircuit.startSimulation();
			do {
				try {
					// leptetjuk a szimulaciot
					digitalCircuit.stepSimulation();
					// elaltatjuk a szalat deltatTime ideig
					Thread.sleep(digitalCircuit.getDeltaTime());
					// kirajzoljuk az uj allapotnak megfeleloen
					view.display();
				} catch (Exception e) {
					// hiba eseten leallitjuk a szimulaciot
					digitalCircuit.stopSimulation();
					// hibauzenet kiiratasa dialogboxban
					JOptionPane.showMessageDialog(
							frame,
						    e.getMessage(),
						    "Simulation Error",
						    JOptionPane.ERROR_MESSAGE);
					// vegul visszaallitjuk a megfelelo menugombokat
					menuItemStartSimulation.setEnabled(true);
					menuItemStepSimulation.setEnabled(true);
					menuItemStopSimulation.setEnabled(false);
				}			
			}
			while(digitalCircuit.isSimulating());		
		}
	}
	
	/**
	 * 
	 */
	public GUIController()
	{
		reset();
	}
	
	private void reset() {
		// Model letrehozasa
	    digitalCircuit = new DigitalCircuit();
	}
	
	/**
	 * 
	 */
	public void createAndShowGUI()
    {	        
		// eroforrasok betoltese
		loadResources();
	    // vew letrehozasa
	    view = new GraphicView(digitalCircuit);
	    // clickListener hozzaadasa a view-hoz
	    view.addMouseListener(new ClickListener(view));
	    // frame letrehozasa
	    frame = new JFrame("Fakocka Circuit Simulator");
		// menuBar letrehozasa es feltoltese
		createMenuBar();
		// menubar hozzadasa a framehez
	    frame.setJMenuBar(menuBar);
	    // alap kilepesi funkcio beallitasa
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // atmeretezhetoseg letiltasa
	    frame.setResizable(false);
	    // view hozzaadasa a framehez
	    frame.add(view);
	    // frame hozzaigazitasa a view-hoz
        frame.pack();      
        // frame kezdopoziciojanak beallitasa kozepre
        frame.setLocationRelativeTo(null);
        // frame lathatova tetele
        frame.setVisible(true);
    }
	
	/**
	 * @return
	 */
	private void createMenuBar()
    {
		// menuBar inicializalasa
		menuBar = new JMenuBar();
		
        // menu-k inicializalasa
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        menuSimulation = new JMenu("Simulation");
        menuSimulation.setMnemonic(KeyEvent.VK_S);
        menuSimulation.setEnabled(false);

        menuOptions = new JMenu("Options");
        menuOptions.setMnemonic(KeyEvent.VK_O);
        
        // Help menu inicializalasa
        menuHelp = new JMenu("About");
        menuHelp.setMnemonic(KeyEvent.VK_H);

        // File menu menuItem-einek inicializalasa
        menuItemLoadCircuit = new JMenuItem("Load Circuit",resources.get("load"));
        menuItemLoadCircuit.setAccelerator( KeyStroke.getKeyStroke("L") );
        menuItemLoadCircuit.addActionListener(this);
        menuFile.add(menuItemLoadCircuit);
        
        // menuItemSeparator
        menuFile.addSeparator();
        
        menuItemQuit = new JMenuItem("Quit",resources.get("quit"));
        menuItemQuit.setAccelerator( KeyStroke.getKeyStroke("Q") );
        menuItemQuit.addActionListener(this);
        menuFile.add(menuItemQuit);
        
        // Simulation menu menuItem-einek inicializalasa
        menuItemStartSimulation = new JMenuItem("Start Simulation",resources.get("start_simulation"));
        menuItemStartSimulation.setAccelerator( KeyStroke.getKeyStroke("S") );
        menuItemStartSimulation.addActionListener(this);
        menuSimulation.add(menuItemStartSimulation);
        
        menuItemStepSimulation = new JMenuItem("Step Simulation",resources.get("step_simulation"));
        menuItemStepSimulation.setAccelerator( KeyStroke.getKeyStroke("E") );
        menuItemStepSimulation.addActionListener(this);
        menuSimulation.add(menuItemStepSimulation);
        
        menuItemStopSimulation = new JMenuItem("Stop Simulation",resources.get("stop_simulation"));
        menuItemStopSimulation.setAccelerator( KeyStroke.getKeyStroke("T") );
        menuItemStopSimulation.addActionListener(this);
        menuItemStopSimulation.setEnabled(false);
        menuSimulation.add(menuItemStopSimulation);
        
        // Options menu menuItem-einek inicializalasa
        menuItemSimulationSpeed = new JMenuItem("Simulation Speed",resources.get("options"));
        menuItemSimulationSpeed.setAccelerator( KeyStroke.getKeyStroke("I") );
        menuItemSimulationSpeed.addActionListener(this);
        menuItemSimulationSpeed.setEnabled(false);
        menuOptions.add(menuItemSimulationSpeed);
        
        // Help menu menuItem-einek inicializalasa
        menuItemAbout = new JMenuItem("About",resources.get("about"));
        menuItemAbout.setAccelerator( KeyStroke.getKeyStroke("A") );
        menuItemAbout.addActionListener(this);
        menuHelp.add(menuItemAbout);

        // menuBar feltoltese
        menuBar.add(menuFile);
        menuBar.add(menuSimulation);
        menuBar.add(menuOptions);
        menuBar.add(menuHelp);
    }
	
	/*
	 * 
	 */
    private void loadResources()
    {
    	// eroforras tarolo inicializalasa
        resources = new HashMap<String, ImageIcon>();
        // munkakonyvtar lekerdezese
        String workingDir = System.getProperty("user.dir");
        // eroforras
        ImageIcon resource;
        
        resource = new ImageIcon(workingDir + "\\resources\\load.png");
        resources.put("load", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\quit.png");
        resources.put("quit", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\start_simulation.png");
        resources.put("start_simulation", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\step_simulation.png");
        resources.put("step_simulation", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\stop_simulation.png");
        resources.put("stop_simulation", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\options.png");
        resources.put("options", resource);

        resource = new ImageIcon(workingDir + "\\resources\\about.png");
        resources.put("about", resource);
        
        resource = new ImageIcon(workingDir + "\\resources\\about_logo.gif");
        resources.put("about_logo", resource);
    }
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String  command = e.getActionCommand();

        if(command.equals("Load Circuit")) {
        	loadCircuitPerformed();
        }
        else if(command.equals("Quit")) {
        	quitPerformed();
        } 
        else if(command.equals("Start Simulation")) {
        	startSimulationPerformed();
        } 
        else if(command.equals("Step Simulation")) {
        	stepSimulationPerformed();
        } 
        else if(command.equals("Stop Simulation")) {
        	stopSimulationPerformed();
        } 
        else if(command.equals("Simulation Speed")) {
        	simulationSpeedPerformed();	
        }
        else if(command.equals("About")) {
        	aboutPerformed();
        }
	}

	/*
	 * 
	 */
	private void aboutPerformed() {
		// aboutbox tartalma
		StringBuilder sb = new StringBuilder();
		sb.append("Team:\n");
		sb.append("    Fakocka\n\n");
		sb.append("Members:\n");
		sb.append("    Gubics Zoltan\n");
		sb.append("    Kuzdi Tamas\n");
		sb.append("    Laszlo Balazs\n");
		sb.append("    Morva Farkas Zsolt\n\n");
		sb.append("BME - VIK - 2011\n");
		sb.append("(fakocka@googlegroups.com)");
		// about box megjelenitese
		JOptionPane.showMessageDialog(
			frame,
            sb.toString(),
            "About Circuit Simulator",
            JOptionPane.PLAIN_MESSAGE,
            resources.get("about_logo")
            );
	}

	/**
	 * 
	 */
	private void simulationSpeedPerformed() {
		// felhasznalotol bekerni a delta time-ot
    	// lehetseges tesztesetek
    	Object[] possibilities = {
    			"200",
    			"500",
    			"1000",
    			"2000",
    			"5000"};
    	// file nev bekerese a felhasznalotol
    	String dt = (String)JOptionPane.showInputDialog(
        			frame,
                    "Set simulation speed (milliseconds)",
                    "Simulation Speed",
                    JOptionPane.QUESTION_MESSAGE,
                    resources.get("options"),			// icon
                    possibilities,  // possibilities
                    "1000");			// the one from the possibilities
    	// ha a felhasznalo cancelt-t valasztott
    	if(dt == null)
    		return;
    	
    	int deltaTime = Integer.parseInt(dt);
    	// deltaTime beallitasa
    	digitalCircuit.setDeltaTime(deltaTime);
	}

	/**
	 * 
	 */
	private void stopSimulationPerformed() {
		// szimulacio megallitasa
    	digitalCircuit.stopSimulation();
    	view.display();
    	this.menuItemStartSimulation.setEnabled(true);
    	this.menuItemStepSimulation.setEnabled(true);
    	this.menuItemStopSimulation.setEnabled(false);
	}

	/**
	 * 
	 */
	private void stepSimulationPerformed() {
		try {
    		// szimulacio leptetese
			digitalCircuit.stepSimulation();
			view.display();
		} catch (Exception e1) {
			// hibauzenet kiiratasa dialogboxban
			JOptionPane.showMessageDialog(
					frame,
				    e1.getMessage(),
				    "Simulation Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void startSimulationPerformed() {
		// simulacio futtatasa
    	//digitalCircuit.startSimulation();
		new Thread(new Simulation()).start();
    	this.menuItemStopSimulation.setEnabled(true);
    	this.menuItemStepSimulation.setEnabled(false);
    	this.menuItemStartSimulation.setEnabled(false);
	}

	/**
	 * 
	 */
	private void quitPerformed() {
		// kilepes
    	System.exit(0);
	}

	/**
	 * 
	 */
	private void loadCircuitPerformed() {
		// lehetseges tesztesetek
    	Object[] possibilities = {
    			"01_SignalGenerator_Scope",
    			"02_Switch_Display",
    			"03_Inverter",
    			"03_Inverter_v2",
    			"04_ANDGate",
    			"04_ANDGate_v2",
    			"05_ORGate",
    			"05_ORGate_v2",
    			"06_Node",
    			"06_Node_v2",
    			"07_NANDGate",
    			"07_NANDGate_v2",
    			"08_RSFF",
    			"08_RSFF_v2",
    			"09_Invalid_Circuit",
    			"10_Instable_State",
    			"11_1_bit_MPX",
    			"12_4_bit_MPX",
    			"13_4_bit_adder",
    			"13_4_bit_adder_v2",
    			"14_RS_Latch",
    			"15_D_Latch",
    			"16_DFF",
    			"17_4_bit_DFF",
    			"18_Fibonacci"
    			};
    	// file nev bekerese a felhasznalotol
    	String testCase = (String)JOptionPane.showInputDialog(
        			frame,
                    "Choose test case:",
                    "Load Circuit",
                    JOptionPane.QUESTION_MESSAGE,
                    resources.get("load"),	// icon
                    possibilities,  // possibilities
                    "");			// the one from the possibilities
    	// ha a felhasznalo cancelt-t valasztott
    	if(testCase == null) {
    		return;
    	} 		

    	// controller resetelese
    	reset();
    	// drawerManager inicializalasa
		DrawerManager.initialize();
		// clickListener initializalasa
		ClickListener.initialize();
    	// aramkor betolto letrehozasa
    	circuitLoader = new CircuitLoader(digitalCircuit,"xml\\" + testCase + ".xml");
		// aramkor betoltese
		circuitLoader.loadCircuit();		
		try {
			// betoltott digitalis aramkor validalasa
			digitalCircuit.validateCircuit();
		} catch (Exception e1) {
			// hibauzenet kiiratasa dialogboxban
			JOptionPane.showMessageDialog(
					frame,
				    e1.getMessage(),
				    "Validation Error",
				    JOptionPane.ERROR_MESSAGE);
			return;
		}
    	// grafika betolto letrehozasa
    	graphicLoader = new GraphicLoader("graphic\\" + testCase + ".txt");
    	// grafika betoltese
    	graphicLoader.loadGraphic();
    	// view resetelese
    	view.reset(digitalCircuit);
    	// view kirajzolasa
    	view.display();
    	this.menuSimulation.setEnabled(true);
		this.menuItemSimulationSpeed.setEnabled(true);	
		this.menuItemStartSimulation.setEnabled(true);
		this.menuItemStepSimulation.setEnabled(true);
		this.menuItemStopSimulation.setEnabled(false);
	}
}
