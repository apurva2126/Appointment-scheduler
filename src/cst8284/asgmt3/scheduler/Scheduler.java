/* 
 * File name: Scheduler.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import java.util.Scanner;

import cst8284.asgmt3.employee.Employee;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * The Class Scheduler.
 * Handles all the input output of the application.
 */
public class Scheduler {

	/** The scan. */
	private static Scanner scan = new Scanner(System.in);

	/** The appointments. */
	private ArrayList<Appointment> appointments = new ArrayList<>();

	/** The employee. */
	private Employee employee;

	/** The Constant EXIT. */
	private static final int SAVE_APPOINTMENT = 1, DELETE_APPOINTMENT = 2, CHANGE_APPOINTMENT = 3,
			DISPLAY_APPOINTMENT = 4, DISPLAY_SCHEDULE = 5, SAVE_APPOINTMENTS_TO_FILE = 6,
			LOAD_APPOINTMENTS_FROM_FILE = 7, EXIT = 0;

	/**
	 * Instantiates a new scheduler.
	 * <p>
	 * New scheduler instantiated which leads to instance get stored of Employee.
	 * Appointment loaded from backup file.
	 * 
	 * @param emp the emp
	 */
	public Scheduler(Employee emp) {
		System.out.println("Scheduling appointments for " + emp);
		setEmployee(emp);
	}

	/**
	 * Sets the employee.
	 *
	 * @param emp new employee
	 */
	private void setEmployee(Employee emp) {
		this.employee = emp;
	}

	/**
	 * Gets the employee.
	 *
	 * @return employee
	 */
	private Employee getEmployee() {
		return employee;
	}

	/**
	 * Launch.
	 * <p>
	 * Stores value by displayMenu method, returned value is passed to
	 * executeMenuItem method
	 */
	public void launch() {
		int choice = 0;
		do {
			choice = displayMenu();
			executeMenuItem(choice);
		} while (choice != EXIT);
	}

	/**
	 * Display menu.
	 * <p>
	 * DisplayMenu method used to displaying menu, prompt user to select an option
	 * from menu.
	 * 
	 * @return the int
	 */
	private int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(SAVE_APPOINTMENT + ". Save appointment\n" + DELETE_APPOINTMENT + ". Remove appointment\n"
				+ CHANGE_APPOINTMENT + ". Change appointment\n" + DISPLAY_APPOINTMENT + ". Get appointment\n"
				+ DISPLAY_SCHEDULE + ". Display schedule\n" + SAVE_APPOINTMENTS_TO_FILE + ". Backup appointments\n"
				+ LOAD_APPOINTMENTS_FROM_FILE + ". Load appointments\n" + EXIT + ". Exit program");
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println();
		return ch;
	}

	/**
	 * Execute menu item.
	 * <p>
	 * Selection made from user is executed with the implementation of switch case.
	 * 
	 * @param choice the choice
	 */
	private void executeMenuItem(int choice) {
		switch (choice) {
		case SAVE_APPOINTMENT:
			saveAppointment(makeAppointmentFromUserInput());
			break;
		case DELETE_APPOINTMENT:
			deleteAppointment(makeCalendarFromUserInput(false));
			break;
		case CHANGE_APPOINTMENT:
			changeAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_APPOINTMENT:
			displayAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_SCHEDULE:
			displayDaySchedule(makeCalendarFromUserInput(true));
			break;
		case SAVE_APPOINTMENTS_TO_FILE:
			saveAppointmentsToFile(getAppointments(), "CurrentAppointments.apts");
			break;
		case LOAD_APPOINTMENTS_FROM_FILE:
			loadAppointmentsFromFile("CurrentAppointments.apts", getAppointments());
			break;
		case EXIT:
			System.out.println("Exiting Scheduler\n\n");
			break;
		default:
			System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println(); // add blank line after each output
	}

	/**
	 * Gets the response to.
	 * <p>
	 * getResponseTo method prints parameter passed. Also, scans and returns
	 * response of string.
	 *
	 * @param s the s
	 * @return response to another string
	 */
	private static String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());
	}

	/**
	 * Make appointment from user input.
	 * <p>
	 * This method takes input from the user about the appointment and uses if-else
	 * block to check each entry if it can be used or not. Hence, it will throw
	 * exception if something goes wrong. For example, a BadAppointmentDataException
	 * is thrown if no value for the client name is entered.
	 *
	 * @return the appointment
	 */
	private Appointment makeAppointmentFromUserInput() {

		String fullName = getResponseTo("Enter Client Name (as FirstName LastName): ");
		
		if (fullName.isEmpty()) {
			
			throw new BadAppointmentDataException("Must enter a value", "Empty or null value entered. ");
		
		} else if (!fullName.matches("[a-zA-Z-.']+\\s[a-zA-Z-.']+")) {
		
			throw new BadAppointmentDataException(
					"Name cannot include characters other than alphabetic\ncharacters, the dash (-), the period (.), and the apostrophe (‘).",
					"Illegal characters in name. ");
		
		} else if (fullName.length() > 30) {
			
			throw new BadAppointmentDataException("Name cannot exceed 30 characters.", "Name exceeds maximum length. ");
		
		}

		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");

		if (phoneNumber.isEmpty()) {
			
			throw new BadAppointmentDataException("Must enter a value", "Empty or null value entered");
		
		} else if (phoneNumber.length() > 12 || phoneNumber.length() < 12) {
			
			throw new BadAppointmentDataException(
					"Missing digit(s); correct format is AAA-PPP-NNNN, where AAA is the area code and PPP-NNNN is the local number",
					"Incorrect format");
		
		} else if (phoneNumber.startsWith("1") || phoneNumber.startsWith("0")) {
			
			throw new BadAppointmentDataException("Area code can’t start with a ‘0’ or a ‘1’", "Invalid number");
		
		} else if (!(phoneNumber.matches("[0-9\"-]*"))) {
			
			throw new BadAppointmentDataException("Telephone numbers can only contain numbers or the character ‘-’ ",
					"Bad character(s) in input string");
		}
		TelephoneNumber phone = new TelephoneNumber(phoneNumber);

		Calendar cal = makeCalendarFromUserInput(false);
		String activity = getResponseTo("Enter Activity: ");
		Activity act = new Activity(activity, getEmployee().getActivityType());
		return (new Appointment(cal, fullName, phone, act));
	}

	/**
	 * Make calendar from user input.
	 * <p>
	 * This method prompts user for the date. If the user input is valid and can be
	 * accepted it returns fully loaded calendar object. Otherwise exception gets
	 * thrown.
	 * 
	 * @param suppressHour the suppress hour
	 * @return the calendar
	 */
	private static Calendar makeCalendarFromUserInput(boolean suppressHour) {
		Calendar cal = Calendar.getInstance();
		int hour = 0;
		cal.clear();

		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date dateObj;
		dateFormat.setLenient(false);

		String date = getResponseTo("Appointment Date (entered as DDMMYYYY): ");

		try {
			dateObj = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new BadAppointmentDataException("Bad calendar date entered; format is DDMMYYYY",
					"Bad calendar format");
		}
		cal.setTime(dateObj);

		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4)) - 1; // offset by one to account for zero-based month in
																// Calendar
		int year = Integer.parseInt(date.substring(4, 8));

		if (!suppressHour) {
			String time = getResponseTo("Appointment Time: ");
			hour = processTimeString(time);
		}

		cal.set(year, month, day, hour, 0);
		return (cal);
	}

	/**
	 * Process time string.
	 * <p>
	 * This method makes sure any kind of format entered by user input would be
	 * converted into 24-hour format.
	 * 
	 * @param t the t
	 * @return int
	 */
	private static int processTimeString(String t) {
		int hour = 0;
		t = t.trim();
		if (t.contains(":"))
			hour = Integer.parseInt(t.split(":")[0]);
		else if (t.contains(" "))
			hour = Integer.parseInt(t.split(" ")[0]);
		else
			hour = Integer.parseInt(t);
		return ((hour < 8) ? hour + 12 : hour);
	}

	/**
	 * Find appointment. This method sorts ArrayList by Calendar date.
	 *
	 * @param cal calendar value used to search the date.
	 * @return appointment appointment returned same calendar value found or null
	 *         will be returned
	 */
	private Appointment findAppointment(Calendar cal) {
		
		Collections.sort(getAppointments(), new SortAppointmentByCalendar());
		
		int index = Collections.binarySearch(getAppointments(), new Appointment(cal, "", "", null, null),
		
				new SortAppointmentByCalendar());
		
		if (index >= 0) {
		
			return getAppointments().get(index);
		
		} else {
			
			return null;
		}
	}

	/**
	 * Save appointment.
	 * <p>
	 * This method checks appointment does not exist and saves it if time slot is
	 * available. Or if time slot taken then, prints a message to input other time.
	 * 
	 * @param apt apt
	 * @return true, if successful
	 */
	private boolean saveAppointment(Appointment apt) {
		Calendar cal = apt.getCalendar(); // Check that the appointment does not already exist
		if (findAppointment(cal) == null) { // Time slot available, okay to add appointment
			getAppointments().add(apt);
			System.out.println("Appointment saved.");
			return true;
		} // else time slot taken, need to make another choice
		System.out.println("Cannot save; an appointment at that time already exists");
		return false;
	}

	/**
	 * Delete appointment.
	 * <p>
	 * This method displays appointment by displayAppointment Method and prompts for
	 * deletion of appointment.
	 * 
	 * @param cal cal
	 * @return true, if successful
	 */
	private boolean deleteAppointment(Calendar cal) {
		if (displayAppointment(cal)) { // display existing appointment on this date/time
			String okToChange = getResponseTo("\nEnter 'Yes' to delete this appointment");
			if (okToChange.trim().equals("Yes")) { // okay to proceed with change/deletion?
				getAppointments().remove(findAppointment(cal));
				System.out.println("Appointment deleted");
				return true;
			} else
				System.out.println("Request cancelled");
		}
		return false; // Appointment didn't exist at the date/time specified
	}

	/**
	 * Change appointment.
	 * <p>
	 * This method displays appointment by displayAppointment Method and prompts for
	 * change in appointment. gets and sets the new appointment date and time if
	 * available.
	 * 
	 * @param cal the cal
	 * @return true, if successful
	 */
	private boolean changeAppointment(Calendar cal) {
		if (displayAppointment(cal)) { // display existing appointment on this date/time
			String okToChange = getResponseTo("\nEnter 'Yes' to change the date and time of this appointment ");
			if (okToChange.trim().equals("Yes")) {
				System.out.println("Enter new date and time");
				Calendar newCal = makeCalendarFromUserInput(false); // get new date/time
				if (findAppointment(newCal) == null) { // appointment time not already taken
					findAppointment(cal).setCalendar(newCal); // set new date/time in appointment
					System.out.println("Appointment re-booked\n");
					return true; // new appointment time set
				} else
					System.out.println("That time is already booked for an appointment\n");
			} else
				System.out.println("Request cancelled");
		}
		return false; // Appointment does not exist, was unavailable, or cancelled
	}

	/**
	 * Display appointment.
	 * <p>
	 * This method with the use of toString method of Appointment, outputs
	 * appointment information as a string to console. Else prints no appointment is
	 * scheduled at that time.
	 * 
	 * @param cal hour and date of appointment searched by user.
	 * @return true, if successful
	 */
	private boolean displayAppointment(Calendar cal) {
		Appointment apt = findAppointment(cal);
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		System.out.print((apt != null) ? "\n\n" + apt.toString() + "\n" : // Output the appointment as a string to the
																			// console, otherwise...
				"No appointment scheduled between " + hr + ":00 and " + (hr + 1) + ":00\n");
		return (apt != null);
	}

	/**
	 * Display day schedule which loops through displayAppointment method to
	 * display.
	 *
	 * @param cal
	 */
	private void displayDaySchedule(Calendar cal) {
		for (int hrCtr = 8; hrCtr < 17; hrCtr++) {
			cal.set(Calendar.HOUR_OF_DAY, hrCtr);
			displayAppointment(cal);
		}
	}

	/**
	 * Save appointments to file.
	 *
	 * @param apts     which accesses ArrayList
	 * @param saveFile name of the file used for backing up appointments
	 * @return true, if successful
	 */
	private static boolean saveAppointmentsToFile(ArrayList<Appointment> apts, String saveFile) {
		try (FileOutputStream fos = new FileOutputStream(saveFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (Appointment apt : apts)
				oos.writeObject(apt);
			System.out.println("Appointment data saved to " + saveFile);
			return true;
		} catch (IOException e) {
			System.out.println("Failed to load appointments from " + saveFile);
			return false;
		}
	}

	/**
	 * Load appointments from file.
	 *
	 * @param sourceFile source file from which appointments gets loaded into
	 *                   arrayList
	 * @param apts       which accesses ArrayList
	 * @return true, if successful
	 */
	private static boolean loadAppointmentsFromFile(String sourceFile, ArrayList<Appointment> apts) {
		apts.clear(); // remove all existing appointments from the ArrayList before loading from file
		try (FileInputStream fis = new FileInputStream(sourceFile);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			while (true)
				apts.add((Appointment) ois.readObject());
		} catch (EOFException ex) {
			System.out.println("Appointments successfully loaded from " + sourceFile);
			return true;
		} catch (IOException | ClassNotFoundException e) {
			return false;
		}
	}

	/**
	 * Gets the appointments.
	 *
	 * @return the appointments
	 */
	private ArrayList<Appointment> getAppointments() {
		return appointments;
	}

}
