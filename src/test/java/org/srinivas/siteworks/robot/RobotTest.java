package org.srinivas.siteworks.robot;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.Robot;

import junit.framework.TestCase;

/**
 * The Class RobotTest.
 */
public class RobotTest extends TestCase {

	private Robot robot;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		robot = new Robot();
	}

	/**
	 * Test Robot Constructor
	 */
	@Test
	public final void testRobot() {
		assertFalse(robot == null);
	}

	/**
	 * Test Robot two arguments Constructor .
	 */
	@Test
	public final void testRobotIntInt() {
		robot = new Robot(10, 20);
		assertEquals(10, robot.getX());
		assertEquals(20, robot.getY());
	}

	/**
	 * Test move north.
	 */
	@Test
	public final void testMoveNorth() {
		assertEquals(1, robot.getX());
		assertEquals(1, robot.getY());
		robot.moveNorth();
		assertEquals(1, robot.getX());
		assertEquals(2, robot.getY());
		robot = new Robot(10, 20);
		robot.moveNorth();
		assertEquals(10, robot.getX());
		assertEquals(21, robot.getY());
	}

	/**
	 * Test move south.
	 */
	@Test
	public final void testMoveSouth() {
		assertEquals(1, robot.getX());
		assertEquals(1, robot.getY());
		robot.moveSouth();
		assertEquals(1, robot.getX());
		assertEquals(0, robot.getY());
		robot = new Robot(10, 20);
		robot.moveSouth();
		assertEquals(10, robot.getX());
		assertEquals(19, robot.getY());
	}

	/**
	 * Test move east.
	 */
	@Test
	public final void testMoveEast() {
		assertEquals(1, robot.getX());
		assertEquals(1, robot.getY());
		robot.moveEast();
		assertEquals(2, robot.getX());
		assertEquals(1, robot.getY());
		robot = new Robot(10, 20);
		robot.moveEast();
		assertEquals(11, robot.getX());
		assertEquals(20, robot.getY());
	}

	/**
	 * Test move west.
	 */
	@Test
	public final void testMoveWest() {
		assertEquals(1, robot.getX());
		assertEquals(1, robot.getY());
		robot.moveWest();
		assertEquals(0, robot.getX());
		assertEquals(1, robot.getY());
		robot = new Robot(10, 20);
		robot.moveWest();
		assertEquals(9, robot.getX());
		assertEquals(20, robot.getY());
	}

	/**
	 * Test set x.
	 */
	@Test
	public final void testSetX() {
		robot.setX(150);
		assertEquals(150, robot.getX());

	}

	/**
	 * Test set y.
	 */
	@Test
	public final void testSetY() {
		robot.setY(150);
		assertEquals(150, robot.getY());
	}

	/**
	 * Test get x.
	 */
	@Test
	public final void testGetX() {
		assertEquals(1, robot.getX());
		robot.setX(150);
		assertEquals(150, robot.getX());
	}

	/**
	 * Test get y.
	 */
	@Test
	public final void testGetY() {
		assertEquals(1, robot.getY());
		robot.setY(150);
		assertEquals(150, robot.getY());
	}

	/**
	 * Test move to.
	 */
	@Test
	public final void testMoveTo() {
		assertEquals(1, robot.getX());
		assertEquals(1, robot.getY());
		robot.moveTo(100, 200);
		assertEquals(100, robot.getX());
		assertEquals(200, robot.getY());

	}

}
