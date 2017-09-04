package org.srinivas.siteworks.robot.turningrobot;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.enums.Movement;
import org.srinivas.siteworks.robot.enums.Orientation;
import org.srinivas.siteworks.robot.robotimage.RobotImage;
import org.srinivas.siteworks.robot.turningrobot.TurningRobot;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

import junit.framework.TestCase;

/**
 * The Class TurningRobotTest.
 */
public class TurningRobotTest extends TestCase {
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
	 * Test move north.
	 */
	@Test
	public final void testMoveNorth() {
		turningRobot.moveNorth();
		assertEquals(1, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(ROBOT_MAXIMUM_ALLOWED_X_POSITION_400);
		turningRobot.moveNorth();
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(-3);
		turningRobot.moveNorth();
		assertEquals(2, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(15);
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();
		turningRobot.moveNorth();		
		assertEquals(3, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test move south.
	 */
	@Test
	public final void testMoveSouth() {
		turningRobot.setX(10);
		turningRobot.getRobotImage().setImageXPosition(100);
		turningRobot.moveSouth();
		assertEquals(9, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(ROBOT_MAXIMUM_ALLOWED_X_POSITION_400+2);
		turningRobot.moveSouth();
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(-3);
		turningRobot.moveSouth();
		assertEquals(2, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(15);
		turningRobot.moveSouth();
		turningRobot.moveSouth();
		assertEquals(3, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test move east.
	 */
	@Test
	public final void testMoveEast() {
		turningRobot.moveEast();
		assertEquals(0, turningRobot.getX());
		assertEquals(1, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setY(ROBOT_MAXIMUM_ALLOWED_Y_POSTION_400);
		turningRobot.moveEast();
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(-3);
		turningRobot.moveEast();
		assertEquals(2, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setY(15);
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();
		turningRobot.moveEast();	
		assertEquals(3, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test move west.
	 */
	@Test
	public final void testMoveWest() {
		turningRobot.setY(10);
		turningRobot.getRobotImage().setImageYPosition(100);
		turningRobot.moveWest();
		assertEquals(0, turningRobot.getX());
		assertEquals(9, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setY(ROBOT_MAXIMUM_ALLOWED_Y_POSTION_400+2);
		turningRobot.moveWest();
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setY(-3);
		turningRobot.moveWest();
		assertEquals(2, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setY(15);
		turningRobot.moveWest();
		turningRobot.moveWest();
		assertEquals(3, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test get angle.
	 */
	@Test
	public final void testGetAngle() {
		turningRobot.setAngle(100);
		assertEquals(100, turningRobot.getAngle());
		try {
			turningRobot.setAngle(500);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains(EXCEPTION_TEXT_ANGLE_IS_NOT_BETWEEN_0_AND_360));
		}

	}

	/**
	 * Test set angle.
	 */
	@Test
	public final void testSetAngle() {
		turningRobot.setAngle(0);
		assertEquals(0, turningRobot.getAngle());
	}

	/**
	 * Test get robot image.
	 */
	@Test
	public final void testGetRobotImage() {
		turningRobot.getRobotImage().setImageLocation("/desktop");
		turningRobot.getRobotImage().setImageXPosition(200);
		turningRobot.getRobotImage().setImageYPosition(300);
		turningRobot.getRobotImage().setImageRelativeGapXPosition(1);
		turningRobot.getRobotImage().setImageRelativeGapYPosition(10);
		assertEquals(200, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(300, turningRobot.getRobotImage().getImageYPosition());
		assertEquals("/desktop", turningRobot.getRobotImage().getImageLocation());
		assertEquals(1, turningRobot.getRobotImage().getImageRelativeGapXPosition());
		assertEquals(10, turningRobot.getRobotImage().getImageRelativeGapYPosition());
	}

	/**
	 * Test set robot image.
	 */
	@Test
	public final void testSetRobotImage() {
		turningRobot.getRobotImage().setImageLocation("/desktop");
		turningRobot.getRobotImage().setImageXPosition(100);
		turningRobot.getRobotImage().setImageYPosition(100);
		turningRobot.getRobotImage().setImageRelativeGapXPosition(10);
		turningRobot.getRobotImage().setImageRelativeGapYPosition(1);
		assertEquals(100, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(100, turningRobot.getRobotImage().getImageYPosition());
		assertEquals("/desktop", turningRobot.getRobotImage().getImageLocation());
		assertEquals(10, turningRobot.getRobotImage().getImageRelativeGapXPosition());
		assertEquals(1, turningRobot.getRobotImage().getImageRelativeGapYPosition());
	}

	/**
	 * Test movement direction forward angle zero.
	 */
	@Test
	public final void testMovementDirectionForwardAngleZero() {
		turningRobot.setAngle(0);
		assertEquals(0, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.FORWARD);
		assertEquals(1, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

	}

	/**
	 * Test movement direction forward angle360.
	 */
	@Test
	public final void testMovementDirectionForwardAngle360() {
		turningRobot.setAngle(360);
		assertEquals(360, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.FORWARD);
		assertEquals(1, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

	}

	/**
	 * Test movement direction forward angle90.
	 */
	@Test
	public final void testMovementDirectionForwardAngle90() {
		turningRobot.setAngle(90);
		assertEquals(90, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.FORWARD);
		assertEquals(0, turningRobot.getX());
		assertEquals(1, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test movement direction forward angle180.
	 */
	@Test
	public final void testMovementDirectionForwardAngle180() {
		turningRobot.setX(10);
		turningRobot.getRobotImage().setImageXPosition(100);
		turningRobot.setAngle(180);
		assertEquals(180, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.FORWARD);
		assertEquals(9, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test movement direction forward angle270.
	 */
	@Test
	public final void testMovementDirectionForwardAngle270() {
		turningRobot.setY(10);
		turningRobot.getRobotImage().setImageYPosition(100);
		turningRobot.setAngle(270);
		assertEquals(270, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.FORWARD);
		assertEquals(0, turningRobot.getX());
		assertEquals(9, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test movement direction backward angle zero.
	 */
	@Test
	public final void testMovementDirectionBackwardAngleZero() {
		turningRobot.setX(10);
		turningRobot.getRobotImage().setImageXPosition(100);
		turningRobot.setAngle(0);
		assertEquals(0, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
		assertEquals(9, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

	}

	/**
	 * Test movement direction backward angle360.
	 */
	@Test
	public final void testMovementDirectionBackwardAngle360() {
		turningRobot.setX(10);
		turningRobot.getRobotImage().setImageXPosition(100);
		turningRobot.setAngle(360);
		assertEquals(360, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
		assertEquals(9, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

	}

	/**
	 * Test movement direction backward angle90.
	 */
	@Test
	public final void testMovementDirectionBackwardAngle90() {
		turningRobot.setY(10);
		turningRobot.getRobotImage().setImageYPosition(100);
		turningRobot.setAngle(90);
		assertEquals(90, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
		assertEquals(0, turningRobot.getX());
		assertEquals(9, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test movement direction backward angle180.
	 */
	@Test
	public final void testMovementDirectionBackwardAngle180() {
		turningRobot.setAngle(180);
		assertEquals(180, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
		assertEquals(1, turningRobot.getX());
		assertEquals(0, turningRobot.getY());
		assertEquals(50, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(0, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());

	}

	/**
	 * Test movement direction backward angle270.
	 */
	@Test
	public final void testMovementDirectionBackwardAngle270() {
		turningRobot.setAngle(270);
		assertEquals(270, turningRobot.getAngle());
		turningRobot.movementDirection(turningRobot, Movement.BACKWARD);
		assertEquals(0, turningRobot.getX());
		assertEquals(1, turningRobot.getY());
		assertEquals(0, turningRobot.getRobotImage().getImageXPosition());
		assertEquals(50, turningRobot.getRobotImage().getImageYPosition());
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
	}

	/**
	 * Test turn orientation left angle zero.
	 */
	@Test
	public final void testTurnOrientationLeftAngleZero() {
		turningRobot.setAngle(0);
		assertEquals(0, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.LEFT);
		assertEquals(270, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation left angle360.
	 */
	@Test
	public final void testTurnOrientationLeftAngle360() {
		turningRobot.setAngle(360);
		assertEquals(360, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.LEFT);
		assertEquals(270, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation left angle90.
	 */
	@Test
	public final void testTurnOrientationLeftAngle90() {
		turningRobot.setAngle(90);
		assertEquals(90, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.LEFT);
		assertEquals(0, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation left angle180.
	 */
	@Test
	public final void testTurnOrientationLeftAngle180() {
		turningRobot.setAngle(180);
		assertEquals(180, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.LEFT);
		assertEquals(90, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation left angle270.
	 */
	@Test
	public final void testTurnOrientationLeftAngle270() {
		turningRobot.setAngle(270);
		assertEquals(270, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.LEFT);
		assertEquals(180, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation right angle zero.
	 */
	@Test
	public final void testTurnOrientationRightAngleZero() {
		turningRobot.setAngle(0);
		assertEquals(0, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.RIGHT);
		assertEquals(90, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation right angle360.
	 */
	@Test
	public final void testTurnOrientationRightAngle360() {
		turningRobot.setAngle(360);
		assertEquals(360, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.RIGHT);
		assertEquals(90, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation right angle90.
	 */
	@Test
	public final void testTurnOrientationRightAngle90() {
		turningRobot.setAngle(90);
		assertEquals(90, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.RIGHT);
		assertEquals(180, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation right angle180.
	 */
	@Test
	public final void testTurnOrientationRightAngle180() {
		turningRobot.setAngle(180);
		assertEquals(180, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.RIGHT);
		assertEquals(270, turningRobot.getAngle());
	}

	/**
	 * Test turn orientation right angle270.
	 */
	@Test
	public final void testTurnOrientationRightAngle270() {
		turningRobot.setAngle(270);
		assertEquals(270, turningRobot.getAngle());
		turningRobot.turnOrientation(Orientation.RIGHT);
		assertEquals(360, turningRobot.getAngle());
	}

	/**
	 * Test get movement errors.
	 */
	@Test
	public final void testGetMovementErrors() {
		assertEquals(0, turningRobot.getMovementErrors().getErrorList().size());
		turningRobot.setX(450);
		turningRobot.moveNorth();
		assertEquals(1, turningRobot.getMovementErrors().getErrorList().size());
	}

}
