package org.srinivas.siteworks.robot.robothandler.implementations;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.srinivas.siteworks.robot.Robot;
import org.srinivas.siteworks.robot.enums.Movement;
import org.srinivas.siteworks.robot.enums.Orientation;
import org.srinivas.siteworks.robot.robothandler.RobotHandler;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;
import org.srinivas.siteworks.visual.RobotImageUtility;



/**
 * The Class TurningRobotHandler.
 */
public class TurningRobotHandler implements RobotHandler {
	private static final Logger logger = Logger.getLogger(TurningRobotHandler.class);

	
	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.robothandler.RobotHandler#imageOrientation(java.awt.Graphics, org.srinivas.siteworks.robot.Robot)
	 */
	@Override
	public String imageOrientation(Graphics g, Robot robot) {
		String errors = null;
		TurningRobot turningRobot = null;
		if (robot instanceof TurningRobot) {
			turningRobot = (TurningRobot) robot;
			turningRobot.getMovementErrors().getErrorList().clear();
			rotatePlaceImage(g, turningRobot);
			errors = handleImageOrientationErrors(turningRobot);
		}
		return errors;
	}

	/**
	 * Handle image orientation errors.
	 * 
	 * @param turningRobot the turning robot
	 * @return the string
	 */
	private String handleImageOrientationErrors(TurningRobot turningRobot) {
		String errors = null;
		if (turningRobot.getMovementErrors().getErrorList().size() > 0) {
			StringBuffer errorBuilder = new StringBuffer(EMPTY);
			appendingErrors(turningRobot, errorBuilder);
			errors = errorBuilder.toString();
		}
		return errors;
	}

	
	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.robothandler.RobotHandler#actionCommands(javax.swing.JPanel, org.srinivas.siteworks.robot.Robot, java.lang.String)
	 */
	@Override
	public String actionCommands(JPanel panel, Robot robot, String commands) {
		TurningRobot turningRobot = null;
		String errors = null;
		if (robot instanceof TurningRobot) {
			turningRobot = (TurningRobot) robot;
			turningRobot.getMovementErrors().getErrorList().clear();
			errors = commandInvoke(panel, commands, turningRobot);
		}
		return errors;
	}

	/**
	 * Command invoke.
	 * 
	 * @param panel the panel
	 * @param commands the commands
	 * @param turningRobot the turning robot
	 * @return the string
	 */
	private String commandInvoke(JPanel panel, String commands, TurningRobot turningRobot) {
		String errors = null;		
		for (Character command : commands.toCharArray()) {
			if (errors == null) {
				logger.info(command + SPACE + LOGGER_TEXT_IS_THE_CURRENT_COMMAND);
				errors = invokeEachCommand(panel, turningRobot, command);
			}
		}

		return errors;
	}

	/**
	 * Invoke each command.
	 * 
	 * @param panel  the panel
	 * @param turningRobot  the turning robot
	 * @param command  the command
	 * @return the string
	 */
	private String invokeEachCommand(JPanel panel, TurningRobot turningRobot, Character command) {
		String errors = null;
		switch (command) {
		case 'L':
			turningRobot.turnOrientation(Orientation.LEFT);
			errors = handleErrors(panel, turningRobot);
			break;

		case 'R':
			turningRobot.turnOrientation(Orientation.RIGHT);
			errors = handleErrors(panel, turningRobot);
			break;

		case 'F':
			turningRobot.movementDirection(turningRobot, Movement.FORWARD);
			errors = handleErrors(panel, turningRobot);
			break;

		case 'B':
			turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
			errors = handleErrors(panel, turningRobot);
			break;

		default:
			logger.info(command + SPACE + LOGGER_TEXT_THIS_IS_NOT_A_VALID_COMMAND);
		}
		return errors;
	}

	/**
	 * Handle Errors.
	 * 
	 * @param panel the panel
	 * @param turningRobot the turning robot
	 * @return the string
	 */
	private String handleErrors(JPanel panel, TurningRobot turningRobot) {
		String errors = null;
		if (turningRobot.getMovementErrors().getErrorList().isEmpty()) {
			try {
				panel.repaint();
			} catch (Exception e) {
				logger.info(ERROR_TEXT_GRIDPANEL_DISPLAY_EXCEPTION + SPACE + e.getMessage());
				turningRobot.getMovementErrors().addToErrors(LOGGER_TEXT_EXCEPTION_AT_ROTATE_IMAGE + SPACE + ERROR_TEXT_CHECK_THE_IMAGE_PATH_IS_RIGHT);
			}
		} else {
			StringBuffer errorBuilder = new StringBuffer(EMPTY);
			appendingErrors(turningRobot, errorBuilder);
			errors = errorBuilder.toString();
		}

		return errors;
	}

	/**
	 * Appending Errors to the ErrorBuilder.
	 * 
	 * @param turningRobot  the turning robot
	 * @param errorBuilder  the error builder
	 */
	private void appendingErrors(TurningRobot turningRobot, StringBuffer errorBuilder) {
		for (String error : turningRobot.getMovementErrors().getErrorList()) {
			String newLine = System.getProperty(SYSTEM_PROPERTY_LINE_SEPARATOR);
			errorBuilder.append(newLine + error);
		}
	}

	/**
	 * Rotate image.
	 * 
	 * @param g  the Graphics
	 * @param turningRobot  the turning robot
	 */
	private void rotatePlaceImage(Graphics g, TurningRobot turningRobot) {
		BufferedImage image = null;
		try {		
			image =  RobotImageUtility.create(turningRobot.getRobotImage().getImageLocation());			
		} catch (Exception e) {
			logger.info(LOGGER_TEXT_EXCEPTION_AT_ROTATE_IMAGE + SPACE + e.getMessage());
			turningRobot.getMovementErrors().addToErrors(LOGGER_TEXT_EXCEPTION_AT_ROTATE_IMAGE + SPACE + ERROR_TEXT_CHECK_THE_IMAGE_PATH_IS_RIGHT);
		}

		if (image != null) {
			AffineTransform transform = new AffineTransform();				
			transform.rotate(Math.toRadians(turningRobot.getAngle()), turnBasedImageWidth(turningRobot,image) / 2, turnBasedImageHeight(turningRobot,image) / 2);
			AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			image = op.filter(image, null);
			g.drawImage(image, turningRobot.getRobotImage().getImageXPosition(), turningRobot.getRobotImage().getImageYPosition(), null);
			logger.info("Image Loaded and Orientation Completed");
		}
	}
	
	
	/**
	 * @param turningRobot
	 * @param image
	 */
	private int turnBasedImageHeight(TurningRobot turningRobot, BufferedImage image) {
		//This height Adjustment made to avoid any partial image display you can try for a better one 
		//for now serves the purpose.
		int imgheight = image.getHeight();
		int difference = image.getWidth() - image.getHeight();
		logger.info("Difference between image width and height" + difference);
		if (turningRobot.getAngle() == 270) {
			imgheight = image.getHeight() + difference + difference / 2;
		}
		logger.info("Image Height for the Turn" + imgheight);
		return imgheight;

	}

	/**
	 * @param turningRobot
	 * @param image	
	 */
	private int turnBasedImageWidth(TurningRobot turningRobot, BufferedImage image) {
		//This width Adjustment made to avoid any partial image display you can try for a better one 
		//for now serves the purpose.		
		int imgwidth = image.getWidth();
		int difference = image.getWidth() - image.getHeight();
		logger.info("Difference between image width and height" + difference);
		if (turningRobot.getAngle() == 270) {
			imgwidth = image.getWidth() + difference / 2;
		} else if (turningRobot.getAngle() == 90) {
			imgwidth = image.getWidth() - difference;
		}
		logger.info("Image Width for the Turn" + imgwidth);
		return imgwidth;

	}

}
