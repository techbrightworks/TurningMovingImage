package org.srinivas.siteworks.robot.turningrobot;

import org.apache.log4j.Logger;
import org.srinivas.siteworks.robot.enums.Orientation;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

/**
 * The Class TurningRobotUtility.
 */
public class TurningRobotUtility {
	private static final Logger logger = Logger.getLogger(TurningRobotUtility.class);

	/**
	 * Determine rotation angle.
	 * 
	 * @param turningRobot the Turning Robot
	 * @param turn the turn
	 * @return the int
	 */
	public static int determineRotationAngle(TurningRobot turningRobot, Orientation turn) {
		int angle = 0;
		logger.info(LOGGER_TEXT_ANGLE_BEFORE_DETERMINE_ROTATION_ANGLE_WAS + SPACE + turningRobot.getAngle());

		if (Orientation.LEFT.equals(turn)) {

			angle = (turningRobot.getAngle() == ROTATING_ANGLE_0) ? ROTATING_ANGLE_270 : turningRobot.getAngle() - ROTATING_ANGLE_90;

		} else {
			angle = (turningRobot.getAngle() == ROTATING_ANGLE_360) ? ROTATING_ANGLE_90 : turningRobot.getAngle() + ROTATING_ANGLE_90;
		}
		turningRobot.setAngle(angle);
		logger.info(LOGGER_TEXT_ANGLE_AFTER_DETERMINE_ROTATION_ANGLE + SPACE + angle);
		return angle;
	}

	/**
	 * Determine image position.
	 * 
	 * @param turningRobot the Turning Robot
	 * @param xValueChange the x value change
	 * @param yValueChange the y value change
	 */
	public static void determineImagePosition(TurningRobot turningRobot, int xValueChange, int yValueChange) {

		logger.info(LOGGER_TEXT_ROBOT_X_POSTION_VALUE_BEFORE_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getX());
		logger.info(LOGGER_TEXT_ROBOT_IMAGE_X_POSITION_VALUE_BEFORE_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getRobotImage().getImageXPosition());

		if (xValueChange == 0) {

		} else {
			int x = turningRobot.getRobotImage().getImageXPosition() + (xValueChange * turningRobot.getRobotImage().getImageRelativeGapXPosition());
			if (x > ROBOTIMAGE_MAXIMUM_ALLOWED_X_POSITION_400 || x < ROBOTIMAGE_MINIMUM_ALLOWED_X_POSITION_0) {
				turningRobot.getMovementErrors().addToErrors(x + SPACE + ERROR_TEXT_IMAGE_X_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
				turningRobot.setX(turningRobot.getX() - xValueChange);

				logger.info(x + SPACE + ERROR_TEXT_IMAGE_X_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			} else {
				turningRobot.getRobotImage().setImageXPosition(x);
			}
		}

		logger.info(LOGGER_TEXT_ROBOT_IMAGE_X_POSITION_VALUE_AFTER_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getRobotImage().getImageXPosition());
		logger.info(LOGGER_TEXT_ROBOT_Y_VALUE_BEFORE_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getY());
		logger.info(LOGGER_TEXT_ROBOT_IMAGE_Y_VALUE_BEFORE_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getRobotImage().getImageYPosition());

		if (yValueChange == 0) {

		} else {
			int y = turningRobot.getRobotImage().getImageYPosition() + (yValueChange * turningRobot.getRobotImage().getImageRelativeGapYPosition());
			if (y > ROBOTIMAGE_MAXIMUM_ALLOWED_Y_POSITION_400 || y < ROBOTIMAGE_MINIMUM_ALLOWED_Y_POSITION_0) {
				turningRobot.getMovementErrors().addToErrors(y + SPACE + ERROR_TEXT_IMAGE_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
				turningRobot.setY(turningRobot.getY() - yValueChange);
				logger.info(y + SPACE + ERROR_TEXT_IMAGE_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			} else {

				turningRobot.getRobotImage().setImageYPosition(y);
			}
		}

		logger.info(LOGGER_TEXT_ROBOT_IMAGE_Y_POSITION_AFTER_DETERMINING_IMAGE_POSITION + SPACE + turningRobot.getRobotImage().getImageYPosition());

	}

}
