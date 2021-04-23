/* 
 * File name: Employee.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.employee;

import java.util.Scanner;


/**
 * The Class Employee, is an abstract class to hold employee information.
 */
public abstract class Employee {
	
	
	private String fullName;
	
	/**
	 * Instantiates a new employee.
	 * <p>
	 * One constructor passes a one string arugument to another via chaining. 
	 */
	protected Employee() {this("unknown");}
	
	/**
	 * Instantiates a new employee.
	 * <p>
	 * Constructor used for storing the full name.
	 *
	 * @param fullName 			full name of the employee
	 */
	protected Employee(String fullName) {setName(fullName);}
	
	/** The scan, used for user input. */
	protected static Scanner scan = new Scanner(System.in);
	
	/**
	 * Sets the full name of employee. 
	 * 
	 *
	 * @param fullName 		 new name of employee
	 */
	public void setName(String fullName) {this.fullName = fullName;}
	
	/**
	 * Gets the full name of employee.
	 *
	 * @return fullName 		full name of employee
	 */
	public String getName() {return fullName;}
	
	/**
	 * Gets the activity type.
	 * <p>
	 * This method provides information about activity.
	 *
	 * @return the activity type
	 */
	public abstract String getActivityType();
	
	/**
	 * To string.
	 *
	 * @return string 			output of getName method is returned
	 */
	@Override
	public String toString() {return getName();}
}