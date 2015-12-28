/**
 * 
 */
package fakocka.gui;

import fakocka.model.DigitalCircuit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * @author fakocka
 *
 */
@SuppressWarnings("serial")
public class GraphicView extends JPanel implements Observer, View {

	/**
	 * 
	 */
	private DigitalCircuit digitalCircuit;
	
	/**
	 * @param digitalCircuit
	 */
	public GraphicView(DigitalCircuit digitalCircuit) {
		
		reset(digitalCircuit);
	}
	
	/* (non-Javadoc)
	 * @see fakocka.gui.View#reset(fakocka.model.DigitalCircuit)
	 */
	@Override
	public void reset(DigitalCircuit digitalCircuit)
	{
		this.digitalCircuit = digitalCircuit;
		// digitalis aramkor hozzaadasa a drawermanagerhez
		DrawerManager.addDigitalCircuit(digitalCircuit);
		// digitalis aramkor hozzaadasa a clickListenerhez
		ClickListener.addDigitalCircuit(digitalCircuit);
		// feliratkozas a digitalis aramkor megfigyelesere
		digitalCircuit.addObserver(this);
		// hatter beallitasa feherre
		this.setBackground(Color.WHITE);
	}
	
	/* (non-Javadoc)
	 * @see fakocka.gui.View#display()
	 */
	@Override
	public void display() {
		repaint();
	}

	/* (non-Javadoc)
	 * @see fakocka.gui.View#display(int, int, int, int)
	 */
	@Override
	public void display(int x, int y, int width, int height) {
		repaint(x,y,width,height);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// ha valtozas tortenik, ujra kirajzolunk mindent
		display();
		System.out.println("repainted");
	}
		
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // felulet kirajzolasa
        drawInterface(g);
        // digitalis aramkor kirajzolasa
        DrawerManager.drawAll(g);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(500,500);
    }
    
    /**
     * @param g
     */
    private void drawInterface(Graphics g) {
    	// hatter kirajzolasa
        g.setColor(new Color(240,240,240));
        for(int i = 10; i < this.getWidth(); i+=10) {
        	g.drawLine(i, 0, i, this.getHeight());
        }
        for(int i = 10; i < this.getHeight(); i+=10) {
        	g.drawLine(0, i, this.getWidth(), i);
        }
        // ha szimulacios allapotban vagyunk akkor az ennek megfelelo szoveg kiiratasa
        if(digitalCircuit.isSimulating()) {
        	g.setColor(Color.RED);
        	g.drawString(
        			"Simulating @ " + digitalCircuit.getDeltaTime() + "ms",
        			getWidth()-140,
        			getHeight()-10);
        }
    }
}
