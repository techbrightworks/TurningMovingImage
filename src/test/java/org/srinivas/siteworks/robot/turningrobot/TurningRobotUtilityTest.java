package org.srinivas.siteworks.robot.turningrobot;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.enums.Orientation;
import org.srinivas.siteworks.robot.robotimage.RobotImage;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;
import org.srinivas.siteworks.robot.turningrobot.TurningRobotUtility;


import junit.framework.TestCase;

/**
 * The Class TurningRobotUtilityTest.
 */
public class TurningRobotUtilityTest extends TestCase {
	private TurningRobot turningRobot;
	private RobotImage robotImage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		turningRobot = new TurningRobot();
		robotImage = new RobotImage();
		robotImage.setImageXPosition(0);
		robotImage.setImageYPosition(0);
		robotImage.setImageRelativeGapXPosition(50);
		robotImage.setImageRelativeGapYPosition(50);
		turningRobot.setRobotImage(robotImage);
		turningRobot.setX(0);
		turningRobot.setY(0);
		turningRobot.getMovementErrors().getErrorList().clear();
	}

	/**
	 * Test determine rotation angle.
	 */
	@Test
	public final void testDetermineRotationAngle() {
		turningRobot.setAngle(270);
		assertEquals(270, turningRobot.getAngle());
		TurningRobotUtility.determineRotationAngle(turningRobot, Orientation.RIGHT);
		assertEquals(360, turningRobot.getAngle());

		turningRobot.setAngle(180);
		assertEquals(180, turningRobot.getAngle());
		TurningRobotUtility.determineRotationAngle(turningRobot, Orientation.LEFT);
		assertEquals(90, turningRobot.getAngle());
	}

	/**
	 * Test determine image position.
	 */
	@Test
	public final void testDetermineImagePosition() {
		turningRobot.setX(1);
		TurningRobotUtility.determineImagePosition(turningRobot, 1, 0);
		assertEquals(1, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

		turningRobot.setY(9);
		turningRobot.getRobotImage().setImageYPosition(100);
		TurningRobotUtility.determineImagePosition(turningRobot, 0, -1);
		assertEquals(1, turningRobot.getX());
		assertEquals(9, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

}
