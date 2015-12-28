/**
 * 
 */
package fakocka.gui;

import javax.swing.SwingUtilities;

/**
 * @author fakocka
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// uj szalat hoz letre a programnak
        SwingUtilities.invokeLater(
        		new Runnable() {
                // elinditja a szalat
        			public void run() {
        				// letrejon a gui
                        (new GUIController()).createAndShowGUI();
                    }
                } );
	}

}
