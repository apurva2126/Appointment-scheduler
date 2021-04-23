/* 
 * File name: Dentist.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.employee;


/**
 * The Class Dentist.
 * <p>
 * Provides user the opportunity to book a doctor of their preference.
 */
public class Dentist extends Employee {
	
	
	private static String[] workDescription = {"Assessment", "Filling", "Crown", "Cosmetic Repair"};

	/**
	 * Instantiates a new dentist.
	 * <p>
	 * name of the dentist is passed to employee by chaining
	 *
	 * @param fullName			 full name for dentist
	 */
	public Dentist(String fullName) {
		super (fullName);
	}

	/**
	 * Gets the activity type.
	 *<p>
	 * method used to prompt user with activity option
	 *  
	 * @return the activity type 		string depending on selection by user
	 */
	public String getActivityType() {
		System.out.println("Enter a selection from the following menu:");
		int i = 1;
		for (String description: workDescription)
			System.out.println(i++ + "." + description);
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println();  // add a space
		return workDescription[ch-1];
	}
}
