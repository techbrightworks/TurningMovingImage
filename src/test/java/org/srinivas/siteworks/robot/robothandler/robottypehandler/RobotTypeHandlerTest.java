package org.srinivas.siteworks.robot.robothandler.robottypehandler;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.robothandler.implementations.TurningRobotHandler;
import org.srinivas.siteworks.robot.robothandler.robotypehandler.RobotTypeHandler;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;

import junit.framework.TestCase;

/**
 * The Class RobotTypeHandlerTest.
 */
public class RobotTypeHandlerTest extends TestCase {

	private RobotTypeHandler turningRobotTypeHandler;
	private TurningRobot turningRobot;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		turningRobotTypeHandler = new RobotTypeHandler();
		turningRobot = new TurningRobot();
	}

	/**
	 * Test get RobotTypeHandler.
	 */
	@Test
	public final void testGetRobotTypeHandler() {
		assertTrue(turningRobotTypeHandler.getRobotTypeHandler(turningRobot) instanceof TurningRobotHandler);

	}

}
