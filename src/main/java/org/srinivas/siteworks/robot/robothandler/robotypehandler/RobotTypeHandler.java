package org.srinivas.siteworks.robot.robothandler.robotypehandler;

import org.srinivas.siteworks.robot.Robot;
import org.srinivas.siteworks.robot.robothandler.RobotHandler;
import org.srinivas.siteworks.robot.robothandler.implementations.TurningRobotHandler;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;


/**
 * The Class RobotTypeHandler.
 */
public class RobotTypeHandler {

	/**
	 * Gets the RobotTypeHandler.
	 * 
	 * @param robot the robot
	 * @return the RobotHandler of Type
	 */
	public RobotHandler getRobotTypeHandler(Robot robot) {

		RobotHandler robotHandler = null;
		if (robot instanceof TurningRobot) {
			robotHandler = new TurningRobotHandler();
		}
		return robotHandler;

	}

}
