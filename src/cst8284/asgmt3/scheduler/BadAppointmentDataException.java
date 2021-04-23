/* 
 * File name: BadAppointmentDataException.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

/**
 * The Class BadAppointmentDataException.
 * <p>
 * All the exceptions are handled. prints message if invalid data is entered.
 */
public class BadAppointmentDataException extends java.lang.RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID =  1L;
	
	/** The description. */
	private String description = "";
	
	/**
	 * no-arg constructor BadAppointmentDataException
	 * Instantiates a new bad appointment data exception.
	 * chained to the parameterized constructor and pass the values.
	 */
	public BadAppointmentDataException() {
		this("Please try again", "Bad data entered");
	}
	
	/**
	 * Parameterized constructor
	 * Instantiates a new bad appointment data exception.
	 *
	 * @param s output message string
	 * @param s2 takes description string
	 */
	public BadAppointmentDataException(String s, String s2) {
		super(s);
		setDescription(s2);
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
}