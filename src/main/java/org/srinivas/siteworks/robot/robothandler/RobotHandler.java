package org.srinivas.siteworks.robot.robothandler;

import java.awt.Graphics;
import javax.swing.JPanel;

import org.srinivas.siteworks.robot.Robot;


/**
 * The Interface RobotHandler.
 */
public interface RobotHandler {

	/**
	 * Image orientation.
	 *
	 * @param g the g
	 * @param robot the robot
	 * @return the string
	 */
	public String imageOrientation(Graphics g, Robot robot);

	/**
	 * Action commands.
	 *
	 * @param panel the panel
	 * @param robot the robot
	 * @param commands the commands
	 * @return the string
	 */
	public String actionCommands(JPanel panel, Robot robot, String commands);

}