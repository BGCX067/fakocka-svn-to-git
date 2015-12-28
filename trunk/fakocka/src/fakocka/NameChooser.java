/**
 * 
 */
package fakocka;

import java.util.HashMap;

/**
 * Segédosztály, amely képes tárolni az egyes digitális komponens referenciákhoz
 * tartozó elnevezéseket. Ezt egy HashMap-pel oldja meg, amely kulcsként Digitális
 * komponenseket, értékként pedig Stringeket tárol. Statikus metódusokat tartalmaz
 * a könnyebb használhatóság kedvéért.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class NameChooser 
{
	/**
	 * Kulcs(DigitalComponent) értékpárokat(String) tároló hashmap
	 */
	private static HashMap<DigitalComponent,String> names = new HashMap<DigitalComponent,String>();
	
	/**
	 * Konstruktor
	 */
	public NameChooser()
	{
		
	}

	/**
	 * @param key digitális komponens
	 * @param value név
	 */
	public static void addName(DigitalComponent key, String value)
	{
                // értékpár hozzáadása
		names.put(key, value);
	}
        
	/**
	 * @param key digitális komponens
	 * @return név
	 */
	public static String getName(DigitalComponent key)
	{
		return names.get(key);
	}
}
