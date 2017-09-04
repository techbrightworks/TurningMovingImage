package org.srinivas.siteworks.visual;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;
import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

/**
 * The Class RobotImageUtility.
 */
public class RobotImageUtility {

	private static final Logger logger = Logger.getLogger(RobotImageUtility.class);

	/**
	 * Creates the Image
	 * 
	 * @param path the path
	 * @return the image
	 */
	public static BufferedImage create(String path) {
		java.net.URL imageURL = null;
		BufferedImage bufferedImage = null;
		try {
			imageURL = RobotImageUtility.class.getResource(path);
			logger.info(LOGGER_TEXT_IMAGE_URL_IS + SPACE + imageURL.getPath());
		} catch (Exception e) {
			logger.info(LOGGER_TEXT_IMAGE_PATH_IS_NOT_VALID + SPACE + path + SPACE + e.getMessage());
		}
		Image icon = null;
		if (imageURL != null ) {
			icon = new ImageIcon(imageURL).getImage();			
			bufferedImage = toBufferedImage(icon);			
		}
		return  bufferedImage;
	}	
	
	
	/**
	 * @param Image providedImage
	 * @return BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image providedImage) {
		BufferedImage bufferedImage = null;
		if (providedImage instanceof BufferedImage) {
			return (BufferedImage) providedImage;
		}

		if ((providedImage.getWidth(null) <= 0) || (providedImage.getHeight(null) <= 0)) {

			InvalidBufferedImage(EMPTY);
		} else {			
			bufferedImage = new BufferedImage(providedImage.getWidth(null), providedImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			// Draw the image on to the buffered image
			Graphics2D bGr = bufferedImage.createGraphics();
			bGr.drawImage(providedImage, 0, 0, null);
			bGr.dispose();			
		}

		return bufferedImage;
	}

	/**
	 * @param path the path
	 * @return null to BufferedImage
	 */
	private static BufferedImage InvalidBufferedImage(String path) {
		logger.info(LOGGER_TEXT_IMAGE_PATH_IS_NOT_VALID + SPACE + path);
		return null;
	}

}
