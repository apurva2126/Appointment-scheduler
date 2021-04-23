/* 
 * File name: Activity.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import java.io.Serializable;


/**
 * The Class Activity.
 * <p>
 * it stores the description of what activity is about.
 */
public class Activity implements Serializable {
	
	
	/** The description of work. */
	private String descriptionOfWork;
	
	
	/** The category. */
	private String category;
	
	/**
	 * Instantiates a new activity.
	 * 
	 * 
	 *
	 * @param description   	the description about the appointment.
	 * @param category      	the category under which the appointment falls.
	 */
	public Activity(String description, String category) {
		setDescription(description);
		setCategory(category);
	}
	
	/**
	 * Gets the description.
	 *
	 * @return descriptionOfWork 		the description about appointment
	 */
	public String getDescription() {return descriptionOfWork;}
	
	/**
	 * Sets the description.
	 *
	 * @param description 				the description about appointment
	 */
	public void setDescription(String description) {this.descriptionOfWork = description;}
	
	/**
	 * Gets the category for activity.
	 *
	 * @return category
	 */
	public String getCategory() {return category;}
	
	/**
	 * Sets the category.
	 *
	 * @param category		the category of the appointment. 
	 */
	public void setCategory(String category) {this.category = category;}
	
	/**
	 * To string.
	 *
	 * @return string
	 */
	public String toString() {return getCategory() + "\n" + getDescription();}
}
