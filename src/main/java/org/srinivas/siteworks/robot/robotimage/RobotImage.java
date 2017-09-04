package org.srinivas.siteworks.robot.robotimage;


/**
 * The Class RobotImage.
 */
public class RobotImage {
	private String imageLocation;
	private int imageXPosition;	
	private int imageYPosition;
	private int imageRelativeGapXPosition;
	private int imageRelativeGapYPosition;

	/**
	 * Instantiates a new Robot Image.
	 */
	public RobotImage() {
		this.imageRelativeGapXPosition = 1;
		this.imageRelativeGapYPosition = 1;
	}

	/**
	 * Instantiates a new Robot Image with two arguments.
	 *
	 * @param imageRelativeGapXPosition the image relative gap x position
	 * @param imageRelativeGapYPosition the image relative gap y position
	 */
	public RobotImage(int imageRelativeGapXPosition, int imageRelativeGapYPosition) {
		this.imageRelativeGapXPosition = imageRelativeGapXPosition;
		this.imageRelativeGapYPosition = imageRelativeGapYPosition;
	}

	/**
	 * Gets the image location.
	 *
	 * @return the image location
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * Sets the image location.
	 *
	 * @param imageLocation the new image location
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	/**
	 * Gets the image x position.
	 *
	 * @return the image x position
	 */
	public int getImageXPosition() {
		return imageXPosition;
	}

	/**
	 * Sets the image x position.
	 *
	 * @param imageXPosition the new image x position
	 */
	public void setImageXPosition(int imageXPosition) {
		this.imageXPosition = imageXPosition;
	}

	/**
	 * Gets the image y position.
	 *
	 * @return the image y position
	 */
	public int getImageYPosition() {
		return imageYPosition;
	}

	/**
	 * Sets the image y position.
	 *
	 * @param imageYPosition the new image y position
	 */
	public void setImageYPosition(int imageYPosition) {
		this.imageYPosition = imageYPosition;
	}

	/**
	 * Gets the image relative gap x position.
	 *
	 * @return the image relative gap x position
	 */
	public int getImageRelativeGapXPosition() {
		return imageRelativeGapXPosition;
	}

	/**
	 * Sets the image relative gap x position.
	 *
	 * @param imageRelativeGapXPosition the new image relative gap x position
	 */
	public void setImageRelativeGapXPosition(int imageRelativeGapXPosition) {
		this.imageRelativeGapXPosition = imageRelativeGapXPosition;
	}

	/**
	 * Gets the image relative gap y position.
	 *
	 * @return the image relative gap y position
	 */
	public int getImageRelativeGapYPosition() {
		return imageRelativeGapYPosition;
	}

	/**
	 * Sets the image relative gap y position.
	 *
	 * @param imageRelativeGapYPosition the new image relative gap y position
	 */
	public void setImageRelativeGapYPosition(int imageRelativeGapYPosition) {
		this.imageRelativeGapYPosition = imageRelativeGapYPosition;
	}

}
