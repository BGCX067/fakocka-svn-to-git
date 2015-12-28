/**
 * 
 */
package fakocka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * @author fakocka
 *
 */
public class Proto 
{
	/**
	 * 
	 */
	private static DigitalCircuit digitalCircuit;
	
	/**
	 * 
	 */
	private static String command;
	
	/**
	 * 
	 */
	private static ArrayList<String> parameters;
	
	/**
	 * 
	 */
	private static boolean run;
	
	/**
	 * 
	 */
	private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// addig...
		do
		{
			// futo allapot
			run = true;
			// parancsok beolvasas
			readCommand();
			// parancsok ertelmezese
			processCommand();
		} // amig futo allapotban vagyunk
		while(run);
	}

	/**
	 * parancsok es parameterek beolvasasaert felelos metodus
	 */
	private static void readCommand() 
	{	
		try 
		{
			// egy sor beolvasas
			String line = buffer.readLine();
			// sor tokenekre bontasa
			if(line != null)
			{
				StringTokenizer tokens = new StringTokenizer(line);
				// elso token eltarolasa parancskent
				if(tokens.hasMoreTokens())
					command = tokens.nextToken();	
				// parametereket tarolo tomb inicializalasa
				parameters = new ArrayList<String>();
				// maradek token eltarolasa parameterkent
				for(int i = 0; tokens.hasMoreTokens(); i++)
				{
					String parameter = tokens.nextToken();
					parameters.add(i, parameter);
				}
			}
			else
				run = false;
		} // kivetelek lekezelese
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
			System.out.println(ioe.getMessage());
		}
		catch (NoSuchElementException nsee)
		{
			
		}
	}
	
	/**
	 * a beolvasott parancsok es parameterek ertelmezeseert felelos. Meghivja a megadott parancsot vegrehajto metodust
	 */
	private static void processCommand() 
	{
		if(command == null)
			return;
		if(command.equals("getComponent"))
		{
			commandGetComponent();
		}
		else if(command.equals("getDisplay"))
		{
			commandGetDisplay();
		}
		else if(command.equals("getScope"))
		{
			commandGetScope();
		}
		else if(command.equals("help"))
		{
			commandHelp();
		}
		else if(command.equals("loadCircuit"))
		{
			commandLoadCircuit();
		}
		else if(command.equals("loadCommands"))
		{
			commandLoadCommands();
		}
		else if(command.equals("setDeltaTime"))
		{
			commandSetDeltaTime();
		}
		else if(command.equals("setSignalGenerator"))
		{
			commandSetSignalGenerator();
		}
		else if(command.equals("setSwitch"))
		{
			commandSetSwitch();
		}
		else if(command.equals("startScope"))
		{
			commandStartScope();
		}
		else if(command.equals("startSimulation"))
		{
			commandStartSimulation();
		}
		else if(command.equals("stepSimulation"))
		{
			commandStepSimulation();
		}
		else if(command.equals("stopScope"))
		{
			commandStopScope();
		}
		else if(command.equals("stopSimulation"))
		{
			commandStopSimulation();
		}
		else if(command.equals("quit"))
		{
			commandQuit();
		}
		else
		{
			commandInvalid();	
		}
	}

	/**
	 * nem letezo parancs
	 */
	private static void commandInvalid() 
	{
		// parancs kiiratasa
		System.out.println("Invalid command");
	}

	/**
	 * kilepes
	 */
	private static void commandQuit()
	{
		// futas leallitasa
		run = false;
		// parancs kiiratasa
		System.out.println("Quit proto");
	}

	/**
	 * szimulacio leallitasa
	 */
	private static void commandStopSimulation() 
	{
		// szimulacio leallitasa
		digitalCircuit.stopSimulation();
		// parancs kiiratasa
		System.out.println("Simulation stopped");
	}

	/**
	 * a parameterben megadott azonositoju oszcilloszkop leallitasa
	 */
	private static void commandStopScope() 
	{
		// oszcilloszkop id-ja
		int id = Integer.parseInt(parameters.get(0));
		// oszcilloszkop lekerdezese id alapjan
		Scope scope = (Scope)digitalCircuit.getDigitalComponent(id);
		// ha nem talalhato ilyen komponens...
		if(scope == null)
		{
			System.out.println("Scope" + id + " cannot be found: Invalid id");
		} // ha letezik ilyen komponens
		else
		{
			// oszcilloszkop leallitasa
			scope.setMeasuring(false);
			// parancs kiiratasa
			System.out.println("Scope" + id + " has been set to default state");
		}
	}

	/**
	 * szimulacio lepetese a parameterben megadott szamu lepessel
	 */
	private static void commandStepSimulation() 
	{
		// lepesszam lekerdezese
		int steps = Integer.parseInt(parameters.get(0));
		boolean instable = false;
		try 
		{
			for(int i = 0; i < steps; i ++)
			{
				// szimulacio leptetese
				digitalCircuit.stepSimulation();
			}
		} // instabil allapotkor keletkezo kivetel elkapasa
		catch (Exception e) 
		{
			instable = true;
			System.out.println(e.getMessage());
		}
		// parancs kiiratasa
		if(!instable)
			System.out.println("Simulation stepped by " + steps);
	}

	/**
	 * szimulacio inditasa
	 */
	private static void commandStartSimulation() 
	{
		// szimulacio inditasa
		digitalCircuit.startSimulation();
		// parancs kiiratasa
		System.out.println("Simulation started");
	}

	/**
	 * a parameterben megadott azonositoju oszcilloszkop mero allapotba helyezese
	 */
	private static void commandStartScope() 
	{
		// oszcilloszkop id-ja
		int id = Integer.parseInt(parameters.get(0));
		// oszcilloszkop lekerdezese id alapjan
		Scope scope = (Scope)digitalCircuit.getDigitalComponent(id);
		// ha nem talalhato ilyen komponens...
		if(scope == null)
		{
			System.out.println("Scope" + id + " cannot be found: Invalid id");
		} // ha letezik ilyen komponens
		else
		{
			// oszcilloszkop leallitasa
			scope.setMeasuring(true);
			// parancs kiiratasa
			System.out.println("Scope" + id + " has been set to measure state");
		}
	}

	/**
	 * a parameterben megadott azonositoju kapcsolo ertekenek beallitasa
	 */
	private static void commandSetSwitch() 
	{
		// kapcsolo id-ja
		int id = Integer.parseInt(parameters.get(0));
		// kapcsolo erteke
		boolean state = Boolean.parseBoolean(parameters.get(1));
		// kapcsolo lekerdezese id alapjan
		Switch sw = (Switch)digitalCircuit.getSignalSource(id);
		// ha nem talalhato ilyen komponens...
		if(sw == null)
		{
			System.out.println("Switch" + id + " cannot be found: Invalid id");
		} // ha letezik ilyen komponens
		else
		{
			// kapcsolo ertekenek beallitasa
			sw.setState(state);
			// parancs kiiratasa
			System.out.println("Switch" + id + " has been set " + state);
		}
	}

	/**
	 * a parameterben megadott azonositoju jelgenerator erteke(i)nek beallitasa
	 */
	private static void commandSetSignalGenerator()
	{
		// jelgenerator id-ja
		int id = Integer.parseInt(parameters.get(0));
		// jelgenerator erteke(i)
		ArrayList<Boolean> signalSequence = new ArrayList<Boolean>();
		for(int i = 1; i < parameters.size(); i++)
		{
			Boolean signal = Boolean.parseBoolean(parameters.get(i));
			signalSequence.add(i-1,signal);
		}
		// jelgenerator lekerdezese id alapjan
//		SignalGenerator sg = (SignalGenerator)digitalCircuit.getDigitalComponent(id);
/*fafix_begin*/		
		SignalGenerator sg = (SignalGenerator)digitalCircuit.getSignalSource(id);
/*fafix_end*/		
		// ha nem talalhato ilyen komponens...
		if(sg == null)
		{
			System.out.println("SignalGenerator" + id + " cannot be found: Invalid id");
		} // ha letezik ilyen komponens
		else
		{
			// jelgenerator erteke(i)nek beallitasa
			for(int i = 0; i < signalSequence.size(); i++)
			{
				Boolean signal = signalSequence.get(i);
				sg.addSignal(signal);
			}
			
			// parancsnak megfelelo kimenet eloallitasa (hatekonysag miatt StringBuilderrel)
			StringBuilder sb = new StringBuilder();
			sb.append("SignalGenerator");
			sb.append(id);
			sb.append(" has been set ");
			for(int i = 0; i < signalSequence.size(); i++)
			{
				sb.append(signalSequence.get(i));
				sb.append(" ");
			}
			// parancs kiiratasa
			System.out.println(sb.toString());
		}
	}

	/**
	 * a szimulacio ket leptetese kozott eltelt ido beallitasa
	 */
	private static void commandSetDeltaTime() 
	{
		// kapcsolo id-ja
		int deltaTime = Integer.parseInt(parameters.get(0));
		// digitalis aramkor beallitasa
		digitalCircuit.setDeltaTime(deltaTime);
		// parancs kiiratasa
		System.out.println("DeltaTime has been set " + deltaTime);
	}

	/**
	 * 
	 */
	private static void commandLoadCommands() 
	{
		// jobban atgondolva erre a parancsra nem igen van szukseg, mivel pontosan ugyan azt csinalna,
		// mintha csak siman atiranyitanank egy .txt file tartalmat a standard inputra, ezert szerintem
		// ez felesleges.
	}

	/**
	 * digitalis aramkor feltoltese a megadott .xml filebol
	 */
	private static void commandLoadCircuit() 
	{
		// DigitalCircuit peldanyositasa
		digitalCircuit = new DigitalCircuit();
		// file nev lekerdezese
		String fileName = parameters.get(0);
		// betolto osztaly inicializalasa
		CircuitLoader circuitLoader = new CircuitLoader(digitalCircuit,fileName);
		// betoltes
		circuitLoader.loadCircuit();		
		// parancs kiiratasa
		System.out.println("DigitalCircuit has been loaded from " + fileName);
		// digitalis aramkor ellenorzese
		try 
		{
			digitalCircuit.validateCircuit();
		} 
		catch (Exception e) 
		{
			// hibauzenet kiiratas hibas kapcsolas eseten
			System.out.println(e.getMessage());
		}
	}

	/**
	 * parancsertelmezo menu kiiratasa
	 */
	private static void commandHelp() 
	{
		// parancsnak megfelelo kimenet eloallitasa (hatekonysag miatt StringBuilderrel)
		StringBuilder sb = new StringBuilder();
		sb.append("getComponent [id] [pin] - return component pin's value\n");
		sb.append("getDisplay [id] - return display state\n");
		sb.append("getScope [id] - return scope results\n");
		sb.append("help - display commands\n");
		sb.append("loadCircuit [file.xml] - load circuit from file\n");
		sb.append("loadCommands [file.txt] - load commands from file\n");
		sb.append("setDeltaTime [miliseconds] - set time between steps\n");
		sb.append("setSignalGenerator [id] [signal1] … [signaln] - set generator values\n");
		sb.append("setSwitch [id] [signal] - set switch state\n");
		sb.append("startScope [id] - starts measuring\n");
		sb.append("startSimulation - start simulation\n");
		sb.append("stepSimulation [number] - step simulation param times\n");
		sb.append("stopScope [id] - stops measuring\n");
		sb.append("stopSimulation - stop simulation\n");
		sb.append("quit - quit proto");	
		// parancs kiiratasa
		System.out.println(sb.toString());
	}

	/**
	 * a parameterben megadott azonositoju oszcilloszkop erteke(i)nek lekerdezese
	 */
	private static void commandGetScope() 
	{
		// oszcilloszkop id-ja
		int id = Integer.parseInt(parameters.get(0));
		// oszcilloszkop lekerdezese id alapjan
		Scope scope = (Scope)digitalCircuit.getDigitalComponent(id);
		// ha nem talalhato ilyen komponens...
		if(scope == null)
		{
			System.out.println("Scope" + id + " cannot be found: Invalid id");
		} // ha letezik ilyen komponens
		else
		{
			// oszcilloszkop erteke(i)nek lekerdezese
			List<Boolean> signalHistory = scope.getSignalHistory();		
			// parancsnak megfelelo kimenet eloallitasa (hatekonysag miatt StringBuilderrel)
			StringBuilder sb = new StringBuilder();
			sb.append("Scope");
			sb.append(id);
			sb.append(" has measured ");
			for(int i = 0; i < signalHistory.size(); i++)
			{
				sb.append(signalHistory.get(i));
				sb.append(" ");
			}
			// parancs kiiratasa
			System.out.println(sb.toString());
		}
	}

	/**
	 * a parameterben megadott azonositoju kijelzo ertekenek lekerdezese
	 */
	private static void commandGetDisplay() 
	{
		// kijelzo id-ja
		int id = Integer.parseInt(parameters.get(0));
		// kijelzo lekerdezese id alapjan
		Display display = (Display)digitalCircuit.getDigitalComponent(id);
		// ha nem talalhato ilyen komponens...
		if(display == null)
		{
			System.out.println("Display" + id + " cannot be found: Invalid id");

		} // ha letezik ilyen komponens
		else
		{
			// kijelzo ertekenek lekerdezese
			boolean state = display.isLightOn();	
			// parancs kiiratasa
			System.out.println("Display" + id + " has " + state + " state");
		}
	}

	/**
	 * a parameterben megadott azonositoju komponens, megadott labanak lekerdezese
	 */
	private static void commandGetComponent() 
	{
		// komponens id-ja
		int id = Integer.parseInt(parameters.get(0));
		// komponens laba
		int pin = Integer.parseInt(parameters.get(1));
		// komponens lekerdezese id alapjan
		DigitalComponent digitalComponent = digitalCircuit.getDigitalComponent(id);
/*fafix_begin*/
		DigitalComponent digitalSource = digitalCircuit.getSignalSource(id);
		DigitalComponent digitalWire = digitalCircuit.getWire(id);
		
		// megnezzuk, hogy jelforras-e
		if(digitalSource != null){digitalComponent = digitalSource;}
		// megnezzuk, hogy vezetek-e
		else if(digitalWire != null){digitalComponent = digitalWire;}
/*fafix_end*/		
		// ha nem talalhato ilyen komponens...
		if(digitalComponent == null)
		{
			System.out.println("DigitalComponent" + id + " cannot be found: Invalid id");

		} // ha letezik ilyen komponens
		else
		{
			// komponens megadott labanak lekerdezese
			boolean signal = digitalComponent.getSignal(pin);
			// parancs kiiratasa
			StringBuilder sb = new StringBuilder();
			sb.append(digitalComponent.toString());
			sb.append(id);
			sb.append(" pin");
			sb.append(pin);
			sb.append(" is ");
			sb.append(signal);
			// parancs kiiratasa
			System.out.println(sb.toString());
		}
	}
}
