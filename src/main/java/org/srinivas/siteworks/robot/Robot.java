package org.srinivas.siteworks.robot;

/**
 * The Class Robot.
 */
public class Robot {
	private int x; 
	private int y; 

	/**
	 * Instantiates a new robot.
	 */
	public Robot() {
		x = 1;
		y = 1;
	}

	/**
	 * Instantiates a new robot.
	 * 
	 * @param xPos the x pos
	 * @param yPos  the y pos
	 */
	public Robot(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}

	/**
	 * Move north.
	 */
	public void moveNorth() {
		y = y + 1;
	}

	/**
	 * Move south.
	 */
	public void moveSouth() {
		y = y - 1;
	}

	/**
	 * Move east.
	 */
	public void moveEast() {
		x = x + 1;
	}

	/**
	 * Move west.
	 */
	public void moveWest() {
		x = x - 1;
	}

	/**
	 * Sets the x.
	 * 
	 * @param xPos the new x
	 */
	public void setX(int xPos) {
		x = xPos;
	}

	/**
	 * Sets the y.
	 * 
	 * @param yPos the new y
	 */
	public void setY(int yPos) {
		y = yPos;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;

	}

	/**
	 * Move to.
	 * 
	 * @param xPos  the x pos
	 * @param yPos the y pos
	 */
	public void moveTo(int xPos, int yPos) {
		x = xPos;
		y = yPos;

	}

}
