package org.srinivas.siteworks.visual;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;
import org.srinivas.siteworks.robot.Robot;
import org.srinivas.siteworks.robot.robothandler.robotypehandler.RobotTypeHandler;
import org.srinivas.siteworks.robot.robotimage.RobotImage;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;
/**
 * @author SrinivasJasti
 *
 */

/**
 * The Class VisualGrid.
 */
@SuppressWarnings("serial")
public class VisualGrid extends JFrame {

	private static final Logger logger = Logger.getLogger(VisualGrid.class);	
	private final class GridPanel extends JPanel {

		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paint(java.awt.Graphics)
		 */
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			turnPanel270Degrees(g, GRIDPANEL_WIDTH_500, GRIDPANEL_HEIGHT_500, gridPanel);
			handleImageOrientation(g);
			drawGridLines(g, GRIDPANEL_WIDTH_500, GRIDPANEL_HEIGHT_500, 0);
		}
	}

	JTextArea displayTextArea;
	JScrollPane scrollPane;
	JPanel gridPanel;
	JPanel textPanel;

	private Robot[] robots;

	/**
	 * Gets the Robots.
	 * 
	 * @return the Robots
	 */
	public Robot[] getRobots() {
		return robots;
	}

	/**
	 * Sets the Robots.
	 * 
	 * @param robots  the new Robots
	 */
	public void setRobots(Robot[] robots) {
		this.robots = robots;
	}

	// Constructor
	/**
	 * Instantiates a new org.srinivas.siteworks.visual grid.
	 * 
	 * @param robots  the Robots
	 */
	public VisualGrid(Robot[] robots) {
		setTitle(JFRAME_TITLE_VISUAL_GRID_GUI);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.robots = robots;
		setResizable(false);

		setPreferredSize(new Dimension(VISUAL_GUI_WIDTH_500, VISUAL_GUI_HEIGHT_600));
		// the container
		Container content = getContentPane();
		content.setLayout(new BorderLayout());

		gridPanel = gridPanel();
		gridPanel.setPreferredSize(new Dimension(GRIDPANEL_WIDTH_500, GRIDPANEL_HEIGHT_500));
		gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		textPanel = new JPanel();
		// the text field props
		displayTextArea = new JTextArea();
		displayTextArea.setEditable(false);
		displayTextArea.setLineWrap(true);
		displayTextArea.setWrapStyleWord(true);
		// scroll pane
		scrollPane = new JScrollPane(displayTextArea);
		textPanel.setLayout(new BorderLayout());
		textPanel.add(scrollPane);

		displayTextArea.append(TEXTAREA_TEXT_PLEASE_PROVIDE_COMMANDS_FROM_COMMAND_LINE);
		JPanel lowerPanel = new JPanel();
		content.add(gridPanel, BorderLayout.NORTH);
		content.add(textPanel, BorderLayout.CENTER);
		content.add(lowerPanel, BorderLayout.SOUTH);
		lowerPanel.setVisible(false);
		pack();
		setVisible(true);
	}

	/**
	 * Grid panel.
	 * 
	 * @return the j panel
	 */
	private JPanel gridPanel() {
		return new GridPanel();
	}

	/**
	 * Turn frame270 degrees.
	 * 
	 * @param g  the Graphics
	 * @param frameWidth the frame width
	 * @param frameHeight the frame height
	 * @param panel  the panel
	 */
	private void turnPanel270Degrees(Graphics g, int frameWidth, int frameHeight, JPanel panel) {
		Graphics2D g2d = (Graphics2D) g;
		int width = frameWidth / 2;
		int hieght = frameHeight / 2;
		g2d.rotate(Math.toRadians(GRIDPANEL_ROTATED_TO_DEGREES_270), width, hieght);
		panel.paintComponents(g);
	}

	/**
	 * Draw grid lines.
	 * 
	 * @param g the Graphics
	 * @param frameWidth  the frame width
	 * @param frameHeight the frame height
	 * @param point the temp
	 */
	private void drawGridLines(Graphics g, int frameWidth, int frameHeight, int point) {
		// vertical grid lines 
		while (point < frameWidth) {
			point = point + SPACING_BETWEEN_GRID_LINES_50;
			g.drawLine(point, 0, point, frameHeight);
		}

		point = 0;

		// horizontal grid lines		
		while (point < frameHeight) {
			point = point + SPACING_BETWEEN_GRID_LINES_50;
			g.drawLine(0, point, frameWidth, point);
		}
	}

	/**
	 * Refresh.
	 */
	public void refresh() {

		repaint();
	}

	/**
	 * Handle image orientation.
	 * 
	 * @param g the Graphics
	 */
	private void handleImageOrientation(Graphics g) {
		for (Robot robot : getRobots()) {
			RobotTypeHandler robotTypeHandler = new RobotTypeHandler();
			String errors = robotTypeHandler.getRobotTypeHandler(robot).imageOrientation(g, robot);
			logger.info(LOGGER_TEXT_IMAGE_ORIENTATION_ERRORS + SPACE + errors);
			if (errors != null) {
				String newLine = System.getProperty(SYSTEM_PROPERTY_LINE_SEPARATOR);
				displayTextArea.append(errors);
				displayTextArea.append(newLine + LOGGER_TEXT_EXCEPTION_AT_ROTATE_IMAGE + SPACE + ERROR_TEXT_CHECK_THE_IMAGE_PATH_IS_RIGHT);
			}
		}
	}

	/**
	 * Run commands.
	 * 
	 * @param commands the commands
	 */
	public void runCommands(String commands) {

		for (Robot robot : getRobots()) {
			RobotTypeHandler robotTypeHandler = new RobotTypeHandler();
			String errors = robotTypeHandler.getRobotTypeHandler(robot).actionCommands(gridPanel, robot, commands);
			logger.info(LOGGING_TEXT_THE_COMMANDS_ERRORS + SPACE + errors);
			if (errors != null) {
				String newLine = System.getProperty(SYSTEM_PROPERTY_LINE_SEPARATOR);
				displayTextArea.append(errors);
				displayTextArea.append(newLine + TEXTAREA_TEXT_TRY_TURNING + SPACE + TEXTAREA_TEXT_PLEASE_PROVIDE_COMMANDS_FROM_COMMAND_LINE);
			}
		}
	}
	
	
	/**
	 * Forward commands.
	 * 
	 * @param visualGrid the org.srinivas.siteworks.visual grid
	 * @param commands the commands
	 */
	private static void forwardCommands(VisualGrid visualGrid, String commands) {
		String newLine = System.getProperty(SYSTEM_PROPERTY_LINE_SEPARATOR);
		if (commands.isEmpty()) {
			visualGrid.displayTextArea.append(newLine + commands + SPACE + LOGGER_TEXT_THIS_IS_NOT_A_VALID_COMMAND);
			logger.info(commands + SPACE + LOGGER_TEXT_THIS_IS_NOT_A_VALID_COMMAND);
		} else {
			visualGrid.displayTextArea.append(newLine + TTEXTAREA_TEXT_HE_COMMAND_IS + SPACE + commands.trim());
			visualGrid.runCommands(commands);
		}
	}

	/**
	 * Handle Exit.
	 * 
	 * @param commands the commands
	 */
	private static void handleExit(String commands) {
		if (commands.equals(EXIT)) {
			logger.info(LOGGING_TEXT_THE_GUI_IS_EXITING);
			System.exit(0);
		}
	}

	// Main method
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		TurningRobot robot = new TurningRobot();
		robot.setX(ROBOT_XPOS_0);
		robot.setY(ROBOT_YPOS_0);
		RobotImage robotImage = new RobotImage();
		robotImage.setImageXPosition(ROBOTIMAGE_XPOS_0);
		robotImage.setImageYPosition(ROBOTIMAGE_YPOS_0);		
		robotImage.setImageLocation(RESOURCE_PATH_SOMEIMAGE_JPG);
		robot.setRobotImage(robotImage);
		VisualGrid visualGrid = new VisualGrid(new Robot[] { robot });
		Scanner in = new Scanner(System.in);
		in.useDelimiter(SCANNER_DELIMITER_ENTER_COMMA);
		while (in.hasNext()) {
			String commands = in.next();
			commands = commands.trim();
			handleExit(commands);
			forwardCommands(visualGrid, commands);
		}

	}

	
}
