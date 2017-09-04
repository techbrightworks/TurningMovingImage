package org.srinivas.siteworks.robot.robotimage;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.robotimage.RobotImage;

import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;
import junit.framework.TestCase;

/**
 * The Class RobotImageTest.
 */
public class RobotImageTest extends TestCase {
	private RobotImage robotImage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		robotImage = new RobotImage();
	}

	/**
	 * Test RobotImage constructor.
	 */
	@Test
	public final void testRobotImage() {
		assertFalse(robotImage == null);
		assertEquals(1, robotImage.getImageRelativeGapXPosition());
		assertEquals(1, robotImage.getImageRelativeGapYPosition());
	}

	/**
	 * Test RobotImage two arguments Constructor.
	 */
	@Test
	public final void testRobotImageIntInt() {
		assertFalse(robotImage == null);
		robotImage = new RobotImage(10, 15);
		assertEquals(10, robotImage.getImageRelativeGapXPosition());
		assertEquals(15, robotImage.getImageRelativeGapYPosition());
	}

	/**
	 * Test get image location.
	 */
	@Test
	public final void testGetImageLocation() {
		assertTrue(robotImage.getImageLocation() == null);
		robotImage.setImageLocation("/imageLocation");
		assertEquals("/imageLocation", robotImage.getImageLocation());
	}

	/**
	 * Test set image location.
	 */
	@Test
	public final void testSetImageLocation() {
		robotImage.setImageLocation(RESOURCE_PATH_SOMEIMAGE_JPG);
		assertEquals(RESOURCE_PATH_SOMEIMAGE_JPG, robotImage.getImageLocation());
	}

	/**
	 * Test get image x position.
	 */
	@Test
	public final void testGetImageXPosition() {
		assertEquals(0, robotImage.getImageXPosition());
		robotImage.setImageXPosition(150);
		assertEquals(150, robotImage.getImageXPosition());
	}

	/**
	 * Test set image x position.
	 */
	@Test
	public final void testSetImageXPosition() {
		robotImage.setImageXPosition(350);
		assertEquals(350, robotImage.getImageXPosition());
	}

	/**
	 * Test get image y position.
	 */
	@Test
	public final void testGetImageYPosition() {
		assertEquals(0, robotImage.getImageYPosition());
		robotImage.setImageYPosition(150);
		assertEquals(150, robotImage.getImageYPosition());
	}

	/**
	 * Test set image y position.
	 */
	@Test
	public final void testSetImageYPosition() {
		robotImage.setImageYPosition(350);
		assertEquals(350, robotImage.getImageYPosition());
	}

	/**
	 * Test get image relative gap x position.
	 */
	@Test
	public final void testGetImageRelativeGapXPosition() {
		assertEquals(1, robotImage.getImageRelativeGapXPosition());
		robotImage.setImageRelativeGapXPosition(150);
		assertEquals(150, robotImage.getImageRelativeGapXPosition());

	}

	/**
	 * Test set image relative gap x position.
	 */
	@Test
	public final void testSetImageRelativeGapXPosition() {
		robotImage.setImageRelativeGapXPosition(250);
		assertEquals(250, robotImage.getImageRelativeGapXPosition());
	}

	/**
	 * Test get image relative gap y position.
	 */
	@Test
	public final void testGetImageRelativeGapYPosition() {
		assertEquals(1, robotImage.getImageRelativeGapYPosition());
		robotImage.setImageRelativeGapYPosition(150);
		assertEquals(150, robotImage.getImageRelativeGapYPosition());
	}

	/**
	 * Test set image relative gap y position.
	 */
	@Test
	public final void testSetImageRelativeGapYPosition() {
		robotImage.setImageRelativeGapYPosition(10);
		assertEquals(10, robotImage.getImageRelativeGapYPosition());
	}

}
