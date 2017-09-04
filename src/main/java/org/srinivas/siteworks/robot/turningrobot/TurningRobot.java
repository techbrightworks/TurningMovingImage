package org.srinivas.siteworks.robot.turningrobot;

import org.apache.log4j.Logger;
import org.srinivas.siteworks.robot.Robot;
import org.srinivas.siteworks.robot.enums.Movement;
import org.srinivas.siteworks.robot.enums.Orientation;
import org.srinivas.siteworks.robot.errors.Errors;
import org.srinivas.siteworks.robot.robotimage.RobotImage;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

/**
 * The Class TurningRobot.
 */
/**
 * @author SrinivasJasti
 *
 */
/**
 * @author SrinivasJasti
 *
 */
public class TurningRobot extends Robot {
	private int angle;
	private RobotImage robotImage;
	private Errors movementErrors;
	private static final Logger logger = Logger.getLogger(TurningRobot.class);

	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.Robot#moveNorth()
	 */
	public void moveNorth() {
		int previousXValue = getX();
		int x = getX() + 1;

		if (x > ROBOT_MAXIMUM_ALLOWED_X_POSITION_400 || x < ROBOT_MINIMUM_ALLOED_X_POSITION_0) {
			getMovementErrors().addToErrors(x + SPACE + ERROR_TEXT_ROBOT_X_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			logger.info(x + SPACE + ERROR_TEXT_ROBOT_X_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
		} else {
			setX(x);
		}

		TurningRobotUtility.determineImagePosition(this, getX() - previousXValue, 0);

	}

	
	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.Robot#moveSouth()
	 */
	public void moveSouth() {
		int previousXValue = getX();
		int x = getX() - 1;
		if (x > ROBOT_MAXIMUM_ALLOWED_X_POSITION_400 || x < ROBOT_MINIMUM_ALLOED_X_POSITION_0) {
			getMovementErrors().addToErrors(x + SPACE + ERROR_TEXT_ROBOT_X_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			logger.info(x + SPACE + ERROR_TEXT_ROBOT_X_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
		} else {
			setX(x);
		}

		TurningRobotUtility.determineImagePosition(this, getX() - previousXValue, 0);
	}

	
	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.Robot#moveEast()
	 */
	public void moveEast() {
		int previousYValue = getY();
		int y = getY() + 1;

		if (y > ROBOT_MAXIMUM_ALLOWED_Y_POSTION_400 || y < ROBOT_MINIMUM_ALLOWED_Y_POSITION_0) {
			getMovementErrors().addToErrors(y + SPACE + ERROR_TEXT_ROBOT_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			logger.info(y + SPACE + ERROR_TEXT_ROBOT_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
		} else {
			setY(y);

		}

		TurningRobotUtility.determineImagePosition(this, 0, getY() - previousYValue);

	}

	
	/* (non-Javadoc)
	 * @see org.srinivas.siteworks.robot.Robot#moveWest()
	 */
	public void moveWest() {
		int previousYValue = getY();
		int y = getY() - 1;

		if (y > ROBOT_MAXIMUM_ALLOWED_Y_POSTION_400 || y < ROBOT_MINIMUM_ALLOWED_Y_POSITION_0) {
			getMovementErrors().addToErrors(y + SPACE + ERROR_TEXT_ROBOT_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
			logger.info(y + SPACE + ERROR_TEXT_ROBOT_Y_POSITION_IS_OUT_OF_RANGE_SO_MOVEMENT_DID_NOT_PROCEED);
		} else {
			setY(y);

		}

		TurningRobotUtility.determineImagePosition(this, 0, getY() - previousYValue);
	}

	/**
	 * Gets the angle.
	 * 
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Sets the angle.
	 * 
	 * @param angle the new angle
	 */
	public void setAngle(int angle) {
		if (angle > ROTATING_ANGLE_360 || angle < ROTATING_ANGLE_0) {
			logger.info(angle + SPACE + EXCEPTION_TEXT_ANGLE_IS_NOT_BETWEEN_0_AND_360);
			throw new RuntimeException(angle + SPACE + EXCEPTION_TEXT_ANGLE_IS_NOT_BETWEEN_0_AND_360);
		}
		this.angle = angle;
	}

	/**
	 * Gets the Robot image.
	 * 
	 * @return the robot image
	 */
	public RobotImage getRobotImage() {
		return robotImage;
	}

	/**
	 * Sets the Robot image.
	 * 
	 * @param robotImage the new robot image
	 */
	public void setRobotImage(RobotImage robotImage) {
		this.robotImage = robotImage;
	}

	/**
	 * Movement direction.
	 * 
	 * @param turningRobot the turning robot
	 * @param movement the movement
	 */
	public void movementDirection(TurningRobot turningRobot, Movement movement) {
		switch (movement) {
		case FORWARD:
			if (turningRobot.getAngle() == ROTATING_ANGLE_0 || turningRobot.getAngle() == ROTATING_ANGLE_360) {
				moveNorth();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_90) {

				moveEast();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_180) {
				moveSouth();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_270) {
				moveWest();
			}

			break;
		case BACKWARD:
			if (turningRobot.getAngle() == ROTATING_ANGLE_0 || turningRobot.getAngle() == ROTATING_ANGLE_360) {
				moveSouth();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_90) {

				moveWest();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_180) {
				moveNorth();
			} else if (turningRobot.getAngle() == ROTATING_ANGLE_270) {
				moveEast();
			}
			break;
		default:
			logger.info(EXCEPTION_TEXT_UNKNOW_MOVEMENT_DIRECTION + SPACE + movement);
			throw new RuntimeException(EXCEPTION_TEXT_UNKNOW_MOVEMENT_DIRECTION + SPACE + movement);

		}
	}

	/**
	 * Turn orientation.
	 * 
	 * @param turn the turn
	 */
	public void turnOrientation(Orientation turn) {

		switch (turn) {
		case LEFT:
			TurningRobotUtility.determineRotationAngle(this, Orientation.LEFT);
			break;
		case RIGHT:
			TurningRobotUtility.determineRotationAngle(this, Orientation.RIGHT);
			break;
		default:
			logger.info(EXCEPTION_TEXT_UNKNOW_TURN_ORIENTATION + SPACE + turn);
			throw new RuntimeException(EXCEPTION_TEXT_UNKNOW_TURN_ORIENTATION + SPACE + turn);

		}

	}

	/**
	 * Gets the movement errors.
	 * 
	 * @return the movement errors
	 */
	public Errors getMovementErrors() {
		if (movementErrors == null) {
			movementErrors = new Errors();
		}
		return movementErrors;
	}

}
