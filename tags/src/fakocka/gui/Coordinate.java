/**
 * 
 */
package fakocka.gui;

/**
 * @author fakocka
 *
 */
public class Coordinate {

	/**
	 * 
	 */
	private int x;
	
	/**
	 * 
	 */
	private int y;

	/**
	 * @param x
	 * @param y
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
