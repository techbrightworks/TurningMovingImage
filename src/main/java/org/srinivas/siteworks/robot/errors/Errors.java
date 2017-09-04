package org.srinivas.siteworks.robot.errors;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Errors.
 */
public class Errors {
	private List<String> errorList;
	
	/**
	 * Instantiates a new errors.
	 */
	public Errors() {
		errorList = new ArrayList<String>();		
	}

	/**
	 * Gets the error list.
	 *
	 * @return the error list
	 */
	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * Sets the error list.
	 *
	 * @param errorList the new error list
	 */
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
	/**
	 * Adds to the errors.
	 *
	 * @param error the error
	 */
	public void addToErrors(String error) {
		getErrorList().add(error);
		
	}

}
