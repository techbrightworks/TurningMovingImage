package org.srinivas.siteworks.visual;

import java.awt.Image;
import org.junit.Test;
import org.srinivas.siteworks.visual.RobotImageUtility;

import junit.framework.TestCase;
import static org.srinivas.siteworks.robot.utility.RobotUtilityConstants.*;

/**
 * The Class RobotImageUtilityTest.
 */
public class RobotImageUtilityTest extends TestCase {

	/**
	 * Test create Image.
	 */
	@Test
	public final void testCreate() {
		Image image = RobotImageUtility.create(null);
		assertTrue(image == null);
		image = RobotImageUtility.create("/Unknown/Location");
		assertTrue(image == null);
		image = RobotImageUtility.create(EMPTY);
		assertTrue(image == null);
		assertFalse(RobotImageUtility.create(RESOURCE_PATH_SOMEIMAGE_JPG) == null);
		assertTrue(RobotImageUtility.create(RESOURCE_PATH_SOMEIMAGE_JPG) instanceof Image);
	}

}
