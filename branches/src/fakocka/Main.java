/**
 * 
 */
package fakocka;

/**
 * @author fakocka
 *
 */
public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		///////////////////////////////////////////////////////////////////////////////////
		// 1. feladat: Switch + Wire + Display
		///////////////////////////////////////////////////////////////////////////////////
		
		// digitalis aramkor letrehozasa
		//DigitalCircuit digitalCircuit = new DigitalCircuit();
		
//		// komponensek letrehozasa
//		Switch switch01 = new Switch(0);
//		Wire wire01 = new Wire(1);
//		Display display01 = new Display(2);
//		
//		// komponensek osszekapcslasa vezetekekkel
//		wire01.setInConnection(switch01, 0);
//		wire01.setOutConnection(display01, 0);
//		
//		// switch01 beallitasa
//		switch01.setState(true);
//		
//		// komponensek hozzaadasa az aramkorhoz
//		digitalCircuit.addDigitalComponent(display01);
//		digitalCircuit.addSignalSource(switch01);
//		digitalCircuit.addWire(wire01);
//		
//		///////////////////////////////////////////////////////////////////////////////////
//		// 2. feladat: Switch + Wire + Inverter + Wire + Node + 2Wire + 2Display
//		///////////////////////////////////////////////////////////////////////////////////
//		
//		// komponensek letrehozasa
//		Switch switch02 = new Switch(3);
//		Wire wire02 = new Wire(4);
//		Inverter inverter01 = new Inverter(5);
//		Wire wire03 = new Wire(6);
//		Node node01 = new Node(3,7);
//		Wire wire04 = new Wire(8);
//		Wire wire05 = new Wire(9);
//		Display display02 = new Display(10);
//		Display display03 = new Display(11);
//		
//		// komponensek osszekapcslasa vezetekekkel
//		wire02.setInConnection(switch02, 0);
//		wire02.setOutConnection(inverter01, 0);
//		wire03.setInConnection(inverter01, 1);
//		wire03.setOutConnection(node01, 0);
//		wire04.setInConnection(node01, 1);
//		wire04.setOutConnection(display02, 0);
//		wire05.setInConnection(node01, 2);
//		wire05.setOutConnection(display03, 0);
//		
//		// switch01 beallitasa
//		switch02.setState(false);
//		
//		// komponensek hozzaadasa az aramkorhoz
//		digitalCircuit.addDigitalComponent(inverter01);
//		digitalCircuit.addDigitalComponent(node01);
//		digitalCircuit.addDigitalComponent(display02);
//		digitalCircuit.addDigitalComponent(display03);		
//		digitalCircuit.addSignalSource(switch02);
//		digitalCircuit.addWire(wire02);
//		digitalCircuit.addWire(wire03);
//		digitalCircuit.addWire(wire04);
//		digitalCircuit.addWire(wire05);	
//			
//		///////////////////////////////////////////////////////////////////////////////////
//		// 3. feladat: 2Switch + 2Wire + ANDGate + Wire + Display
//		///////////////////////////////////////////////////////////////////////////////////
//		
//		// komponensek letrehozasa
//		Switch switch03 = new Switch(12);
//		Switch switch04 = new Switch(13);
//		Wire wire06 = new Wire(14);
//		Wire wire07 = new Wire(15);
//		ANDGate andGate01 = new ANDGate(3,16);
//		Wire wire08 = new Wire(17);
//		Display display04 = new Display(18);
//		
//		// komponensek osszekapcslasa vezetekekkel
//		wire06.setInConnection(switch03, 0);
//		wire06.setOutConnection(andGate01, 1);
//		wire07.setInConnection(switch04, 0);
//		wire07.setOutConnection(andGate01, 2);
//		wire08.setInConnection(andGate01, 0);
//		wire08.setOutConnection(display04, 0);
//		
//		// switch01 beallitasa
//		switch03.setState(true);
//		switch04.setState(true);
//		
//		// komponensek hozzaadasa az aramkorhoz
//		digitalCircuit.addDigitalComponent(andGate01);
//		digitalCircuit.addDigitalComponent(display04);		
//		digitalCircuit.addSignalSource(switch03);
//		digitalCircuit.addSignalSource(switch04);
//		digitalCircuit.addWire(wire06);
//		digitalCircuit.addWire(wire07);
//		digitalCircuit.addWire(wire08);		
		
		///////////////////////////////////////////////////////////////////////////////////
		// 4. feladat: 2Switch + 2Wire + NANDGate + Wire + Display
		///////////////////////////////////////////////////////////////////////////////////
		
//		DigitalCircuit digitalCircuit = new DigitalCircuit();
//		
//		// komponensek letrehozasa
//		Switch switch05 = new Switch(19);
//		Switch switch06 = new Switch(20);
//		Wire wire09 = new Wire(21);
//		Wire wire10 = new Wire(22);
//		Composite nandGate = new Composite(2,1,23);
//		Wire wire11 = new Wire(24);
//		Display display05 = new Display(25);
//		
//		// nandGate feltoltese
//		Switch s1 = new Switch(0);
//		Switch s2 = new Switch(1);	
//		ANDGate a1 = new ANDGate(3,2);	
//		Inverter i1 = new Inverter(3);
//		Display d1 = new Display(4);
//		Wire w1 = new Wire(5);
//		Wire w2 = new Wire(6);
//		Wire w3 = new Wire(7);
//		Wire w4 = new Wire(8);
//		
//		// nandGate elemeinek osszekapcsolasa
//		w1.setInConnection(s1, 0);
//		w1.setOutConnection(a1, 1);
//		w2.setInConnection(s2, 0);
//		w2.setOutConnection(a1, 2);
//		w3.setInConnection(a1, 0);
//		w3.setOutConnection(i1, 0);
//		w4.setInConnection(i1, 1);
//		w4.setOutConnection(d1, 0);
//		
//		// nandGate feltoltese
//		nandGate.addInternalSignalSource(s1);
//		nandGate.addInternalSignalSource(s2);
//		nandGate.addInternalDigitalComponent(a1);
//		nandGate.addInternalDigitalComponent(i1);
//		nandGate.addInternalDigitalComponent(d1);
//		nandGate.addInternalWire(w1);
//		nandGate.addInternalWire(w2);
//		nandGate.addInternalWire(w3);
//		nandGate.addInternalWire(w4);
//		
//		// komponensek osszekapcslasa vezetekekkel
//		wire09.setInConnection(switch05, 0);
//		wire09.setOutConnection(nandGate, 0);
//		wire10.setInConnection(switch06, 0);
//		wire10.setOutConnection(nandGate, 1);
//		wire11.setInConnection(nandGate, 2);
//		wire11.setOutConnection(display05, 0);
//		
//		// switch01 beallitasa
//		switch05.setState(true);
//		switch06.setState(true);
//		
//		// komponensek hozzaadasa az aramkorhoz
//		digitalCircuit.addDigitalComponent(nandGate);
//		digitalCircuit.addDigitalComponent(display05);		
//		digitalCircuit.addSignalSource(switch05);
//		digitalCircuit.addSignalSource(switch06);
//		digitalCircuit.addWire(wire09);
//		digitalCircuit.addWire(wire10);
//		digitalCircuit.addWire(wire11);
//		
//		// digitalis aramkor ellenorzes
//		try
//		{
//			digitalCircuit.validateCircuit();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Hibas kapcsolas: " + e.getMessage());
//		}
//		
//		// digitalis aramkor szimulacioja leptetessel	
//		try
//		{
//			digitalCircuit.stepSimulation();
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		
		
		//RS flip-flop

		DigitalCircuit digitalCircuit = new DigitalCircuit();

		// komponensek letrehozasa
		Switch switch00 = new Switch(0);
		Switch switch01 = new Switch(1);
		Wire wire02 = new Wire(2);
		Wire wire03 = new Wire(3);
		Composite rsflipflop = new Composite(2,2,4);
		Wire wire05 = new Wire(5);
		Wire wire06 = new Wire(6);
		Display display07 = new Display(7);
		Display display08 = new Display(8);

			//rs flip-flop feltoltesse
			Switch s00 = new Switch(0);
			Switch s01 = new Switch(1);
			Composite nandGate02 = new Composite(2,1,2);
			Composite nandGate03 = new Composite(2,1,3);
			Wire w04 = new Wire(4);
			Wire w05 = new Wire(5);
			Node n06 = new Node(3,6);
			Node n07 = new Node(3,7);
			Wire w08 = new Wire(8);
			Wire w09 = new Wire(9);
			Wire w10 = new Wire(10);
			Wire w11 = new Wire(11);
			Display d12 = new Display(12);
			Display d13 = new Display(13);
			Wire w14 = new Wire(14);
			Wire w15 = new Wire(15);

				// nandGate02 feltoltese
				Switch s1 = new Switch(0);
				Switch s2 = new Switch(1);      
				ANDGate a1 = new ANDGate(3,2);  
				Inverter i1 = new Inverter(3);
				Display d1 = new Display(4);
				Wire w1 = new Wire(5);
				Wire w2 = new Wire(6);
				Wire w3 = new Wire(7);
				Wire w4 = new Wire(8);

				// nandGate02 elemeinek osszekapcsolasa
				w1.setInConnection(s1, 0);
				w1.setOutConnection(a1, 1);
				w2.setInConnection(s2, 0);
				w2.setOutConnection(a1, 2);
				w3.setInConnection(a1, 0);
				w3.setOutConnection(i1, 0);
				w4.setInConnection(i1, 1);
				w4.setOutConnection(d1, 0);

				// nandGate02 feltoltese
				nandGate02.addInternalSignalSource(s1);
				nandGate02.addInternalSignalSource(s2);
				nandGate02.addInternalDigitalComponent(a1);
				nandGate02.addInternalDigitalComponent(i1);
				nandGate02.addInternalDigitalComponent(d1);
				nandGate02.addInternalWire(w1);
				nandGate02.addInternalWire(w2);
				nandGate02.addInternalWire(w3);
				nandGate02.addInternalWire(w4);

				// nandGate03 feltoltese
				Switch s3 = new Switch(0);
				Switch s4 = new Switch(1);      
				ANDGate a2 = new ANDGate(3,2);  
				Inverter i2 = new Inverter(3);
				Display d2 = new Display(4);
				Wire w5 = new Wire(5);
				Wire w6 = new Wire(6);
				Wire w7 = new Wire(7);
				Wire w8 = new Wire(8);

				// nandGate03 elemeinek osszekapcsolasa
				w5.setInConnection(s3, 0);
				w5.setOutConnection(a2, 1);
				w6.setInConnection(s4, 0);
				w6.setOutConnection(a2, 2);
				w7.setInConnection(a2, 0);
				w7.setOutConnection(i2, 0);
				w8.setInConnection(i2, 1);
				w8.setOutConnection(d2, 0);

				// nandGate03 feltoltese
				nandGate03.addInternalSignalSource(s3);
				nandGate03.addInternalSignalSource(s4);
				nandGate03.addInternalDigitalComponent(a2);
				nandGate03.addInternalDigitalComponent(i2);
				nandGate03.addInternalDigitalComponent(d2);
				nandGate03.addInternalWire(w5);
				nandGate03.addInternalWire(w6);
				nandGate03.addInternalWire(w7);
				nandGate03.addInternalWire(w8);

			//rs flip-flop elemeinek osszekapcsolasa
			w04.setInConnection(s00, 0);
			w04.setOutConnection(nandGate02, 0);
			w05.setInConnection(s01, 0);
			w05.setOutConnection(nandGate03, 1);
			w08.setInConnection(nandGate02, 2);
			w08.setOutConnection(n06, 0);
			w09.setInConnection(nandGate03, 2);
			w09.setOutConnection(n07, 0);
			w10.setInConnection(n06, 1);
			w10.setOutConnection(nandGate03, 0);
			w11.setInConnection(n07, 1);
			w11.setOutConnection(nandGate02, 1);
			w14.setInConnection(n06, 2);
			w14.setOutConnection(d12, 0);
			w15.setInConnection(n07, 2);
			w15.setOutConnection(d13, 0);

			//rs flip-flop feltoltese
			rsflipflop.addInternalSignalSource(s00);
			rsflipflop.addInternalSignalSource(s01);
			rsflipflop.addInternalDigitalComponent(nandGate02);
			rsflipflop.addInternalDigitalComponent(nandGate03);
			rsflipflop.addInternalDigitalComponent(n06);
			rsflipflop.addInternalDigitalComponent(n07);
			rsflipflop.addInternalDigitalComponent(d12);
			rsflipflop.addInternalDigitalComponent(d13);
			rsflipflop.addInternalWire(w04);
			rsflipflop.addInternalWire(w05);
			rsflipflop.addInternalWire(w08);
			rsflipflop.addInternalWire(w09);
			rsflipflop.addInternalWire(w10);
			rsflipflop.addInternalWire(w11);
			rsflipflop.addInternalWire(w14);
			rsflipflop.addInternalWire(w15);

		// komponensek osszekapcslasa vezetekekkel
		wire02.setInConnection(switch00, 0);
		wire02.setOutConnection(rsflipflop, 0);
		wire03.setInConnection(switch01, 0);
		wire03.setOutConnection(rsflipflop, 1);
		wire05.setInConnection(rsflipflop, 2);
		wire05.setOutConnection(display07, 0);
		wire06.setInConnection(rsflipflop, 3);
		wire06.setOutConnection(display08, 0);

		// switch01 beallitasa
		switch00.setState(false);
		switch01.setState(true);

		// komponensek hozzaadasa az aramkorhoz
		digitalCircuit.addDigitalComponent(rsflipflop);
		digitalCircuit.addDigitalComponent(display07);     
		digitalCircuit.addDigitalComponent(display08);     
		digitalCircuit.addSignalSource(switch00);
		digitalCircuit.addSignalSource(switch01);
		digitalCircuit.addWire(wire02);
		digitalCircuit.addWire(wire03);
		digitalCircuit.addWire(wire05);
		digitalCircuit.addWire(wire06);

		// digitalis aramkor ellenorzes
		try
		{
			digitalCircuit.validateCircuit();
		}
		catch(Exception e)
		{
			System.out.println("Hibas kapcsolas: " + e.getMessage());
		}

		// digitalis aramkor szimulacioja leptetessel   
		try
		{
			digitalCircuit.stepSimulation();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		// switch01 beallitasa
		switch00.setState(true);
		switch01.setState(true);
		
		// digitalis aramkor szimulacioja leptetessel   
		try
		{
			digitalCircuit.stepSimulation();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}


		// digitalis aramkor szimulacioja futtatassal
//		digitalCircuit.startSimulation();
//		
//		try
//		{
//			Thread.sleep(1500);
//			switch01.setState(false);
//			Thread.sleep(2000);
//		}
//		catch(InterruptedException ie)
//		{
//			System.out.println(ie.getMessage());
//		}	
//		
//		digitalCircuit.stopSimulation();
		
	}

}
