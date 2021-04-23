/* 
 * File name: ScheduleLauncher.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import cst8284.asgmt3.employee.Dentist;


/**
 * The Class SchedulerLauncher.
 * <p> 
 * It has the main method and it is used to launch the application.
 * */
public class SchedulerLauncher {

	/**
	 * The main method.
	 *<p>
	 * This method executes application with the help of instantiation of scheduler class, 
	 * calling launch method. 
	 * @param args 			the arguments
	 */
	public static void main(String[] args) {
		(new Scheduler(new Dentist("Dr. Andrews"))).launch();
	}
}
