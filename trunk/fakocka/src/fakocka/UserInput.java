/**
 * 
 */
package fakocka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Segédosztály, amely a döntési helyzetekben hivatott bekérni
 * a felhasználó válaszát. A konzolról (standard input) képes
 * beolvasni egy sort. Statikus metódusokat tartalmaz a könnyebb
 * használhatóság kedvéért.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class UserInput 
{
	/**
	 * A konzol olvasását teszi lehetővé
	 */
	private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Konstruktor
	 */
	public UserInput()
	{
		
	}
	
	/**
	 * Beolvas egy sort a konzolról, majd visszaadja azt.
	 * 
	 * @return consoleLine
	 */
	public static String readConsoleLine()
	{
		// a konzol egy sora
		String consoleLine = null;
		try
		{
			// beolvassa a sort
			consoleLine = console.readLine();
		}
		catch(IOException ioe)
		{
			// ha hiba van...
			System.err.println(ioe.getMessage());
		}
		// visszaadja a beolvasott sort, null, ha nem sikerült.
		return consoleLine;
	}
}
