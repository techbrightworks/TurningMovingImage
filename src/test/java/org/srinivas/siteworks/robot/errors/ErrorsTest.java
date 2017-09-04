package org.srinivas.siteworks.robot.errors;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.srinivas.siteworks.robot.errors.Errors;

import junit.framework.TestCase;

/**
 * The Class ErrorsTest.
 */
public class ErrorsTest extends TestCase {

	private Errors errors;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		errors = new Errors();
	}

	/**
	 * Test Errors constructor.
	 */
	@Test
	public final void testErrors() {
		assertFalse(errors == null);
		assertEquals(0, errors.getErrorList().size());
	}

	/**
	 * Test get Error list.
	 */
	@Test
	public final void testGetErrorList() {
		assertEquals(0, errors.getErrorList().size());
		errors.addToErrors("ErrorOne");
		assertEquals(1, errors.getErrorList().size());

	}

	/**
	 * Test set Error list.
	 */
	@Test
	public final void testSetErrorList() {
		assertEquals(0, errors.getErrorList().size());
		List<String> errorList = new ArrayList<String>();
		errorList.add("ErrorOne");
		errorList.add("ErrorTwo");
		errors.setErrorList(errorList);
		assertEquals(2, errors.getErrorList().size());

	}

	/**
	 * Test add to Errors.
	 */
	@Test
	public final void testAddToErrors() {
		assertEquals(0, errors.getErrorList().size());
		List<String> errorList = new ArrayList<String>();
		errorList.add("ErrorOne");
		errorList.add("ErrorTwo");
		errors.setErrorList(errorList);
		errors.addToErrors("ErrorThree");
		assertEquals(3, errors.getErrorList().size());
	}

}
