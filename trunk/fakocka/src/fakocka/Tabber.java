/**
 * 
 */
package fakocka;

/**
 * Segédosztály, amely számontartja az egyes metódusok egymásbaágyazódásának
 * mélységét és ennek megfelelően behúzásokat helyez el tabulátor(ok) segítségével.
 * Statikus metódusokat tartalmaz a könnyebb használhatóság kedvéért.
 * 
 * @author fakocka
 *
 * @version Szkeleton
 */
public class Tabber 
{
	/**
	 * behúzások száma
	 */
	private static int tabs = 0;
	
	/**
	 * Konstruktor
	 */
	public Tabber()
	{
		
	}
	
	/**
	 * @param t behúzások száma
	 */
	public static void setIndent(int t)
	{
		tabs = t;
	}
	
	/**
	 * @return tabs
	 */
	public static int getIndent()
	{
		return tabs;
	}
	
	/**
	 * növeli a behúzások számat
	 */
	public static void increaseIndent()
	{
		tabs++;
	}
	
	/**
	 * csökkenti a behúzasok számat
	 */
	public static void decreaseIndent()
	{
		tabs--;
	}
	
	/**
	 * annyi tabulátort helyez el, ahány behúzas volt
	 */
	public static void doIndent()
	{
		for(int i = 0; i < tabs; i++)
		{
			System.out.print("\t");
		}
	}
}
