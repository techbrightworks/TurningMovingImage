package org.srinivas.siteworks.robot.robothandler;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.RESOURCE_PATH_SOMEIMAGE_JPG;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.robothandler.RobotHandler;
import org.srinivas.siteworks.robot.robothandler.implementations.TurningRobotHandler;
import org.srinivas.siteworks.robot.robotimage.RobotImage;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;


import junit.framework.TestCase;

/**
 * The Class RobotHandlerTest.
 */
public class RobotHandlerTest extends TestCase {
	private RobotHandler robotHandler;
	private TurningRobot turningRobot;
	private RobotImage robotImage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		robotHandler = new TurningRobotHandler();
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
	 * Test image orientation.
	 */
	@Test
	public final void testImageOrientation() {
		robotHandler.imageOrientation(null, turningRobot);
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test action commands.
	 */
	@Test
	public final void testActionCommands() {
		robotHandler.actionCommands(null, turningRobot, "F");
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.getRobotImage().setImageLocation(RESOURCE_PATH_SOMEIMAGE_JPG);
	}

}
