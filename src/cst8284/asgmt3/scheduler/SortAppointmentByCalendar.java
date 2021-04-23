/* 
 * File name: SortAppointmentByCalendar.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import java.util.Comparator;


/**
 * The Class SortAppointmentByCalendar.
 * <p>
 * This class is used to handle sorting Appointment according to calendar.
 */
public class SortAppointmentByCalendar implements Comparator<Appointment> {

	/**
	 * This is an overridden method of class Comparator which returns an integer
	 * value representing the difference between the Calendar’s of the two
	 * Appointment’s input as parameters to the compare() method.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	@Override
	public int compare(Appointment a, Appointment b) {
		
		return a.getCalendar().compareTo(b.getCalendar());
	}
}