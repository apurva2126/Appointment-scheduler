/* 
 * File name: Appointmnet.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import java.io.Serializable;
import java.util.Calendar;


/**
 * The Class Appointment.
 * <p>
 * it represents an appointment when user provides the information.
 */
public class Appointment implements Serializable {
	
	
	/** The appointment date. */
	private Calendar aptDate;
	
	
	/** The first name. */
	private String firstName, lastName;
	
	
	/** The phone. */
	private TelephoneNumber phone;
	
	
	/** The activity. */
	private Activity activity;
	//public static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new appointment.
	 * <p>
	 * 
	 *
	 * @param cal 			 utilised for appointment date
	 * @param fullName 		 full name of the client
	 * @param phone 		 phone number of the client
	 * @param act 			 activity description of the appointment
	 */
	public Appointment(Calendar cal, String fullName, TelephoneNumber phone, Activity act) {
		this(cal, fullName.trim().split(" ")[0], fullName.trim().split(" ")[1], phone, act);
	}
	
	/**
	 * Instantiates a new appointment.
	 *<p>
	 *Instantiation leads to appointment storing into the setters.
	 *
	 * @param cal the cal 
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param phone the phone
	 * @param act the act
	 */
	public Appointment(Calendar cal, String firstName, String lastName, TelephoneNumber phone, Activity act) {
		setFirstName(firstName.trim()); 
		setLastName(lastName.trim());
		setCalendar(cal); 
		setPhone(phone);
		setActivity(act);
	}
	
	/**
	 * Gets the calendar.
	 *
	 * @return aptDate		gets the appointment date of client
	 */
	public Calendar getCalendar() {return aptDate;}
	
	/**
	 * Sets the calendar.
	 *
	 * @param aptDate 		sets the appointment date
	 */
	public void setCalendar(Calendar aptDate) {this.aptDate = aptDate;}
	
	/**
	 * Gets the first name.
	 *
	 * @return firstName		client's first name
	 */
	public String getFirstName() {return firstName; }
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName 		first name of the client
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	/**
	 * Gets the last name.
	 *
	 * @return lastName 		last name of the client
	 */
	public String getLastName() {return lastName;}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName 			last name of the client
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	/**
	 * Gets the phone number of the client.
	 *
	 * @return phone 		 	phone number of the client
	 */
	public TelephoneNumber getPhone() {return phone;}
	
	/**
	 * Sets the phone number of client.
	 *
	 * @param phone 			phone number of the client
	 */
	public void setPhone(TelephoneNumber phone) {this.phone = phone;}
	
	/**
	 * Gets the activity.
	 *
	 * @return activity 		activity booked for the appointment
	 */
	public Activity getActivity() {return activity;}
	
	/**
	 * Sets the activity.
	 *
	 * @param activity			activity booked for the appointment
	 */
	public void setActivity(Activity activity) {this.activity = activity;}
	
	/**
	 * To string.
	 *<p>
	 * toString() method of Appointment class calls the toString() methods of Calendar class.
	 * All the getters used for constructing string for outputting information to the console about appointment.
	 * @return string
	 */
	public String toString() {
		return getCalendar().getTime().toString() + "\n" +
			   getFirstName() + " " + getLastName() + "\n" + 
			   getPhone().toString() + "\n" +
			   getActivity().toString();
	}

}
