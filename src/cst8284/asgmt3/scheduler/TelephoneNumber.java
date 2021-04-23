/* 
 * File name: TelephoneNumber.java
 * Author: Apurva Patel
 * Course: CST8284 - Object oriented Programming
 * Assignment: 3
 * Date: 26-11-2019
 */
package cst8284.asgmt3.scheduler;

import java.io.Serializable;


/**
 * The Class TelephoneNumber.
 * <p>
 * It is used to construct number.
 */
public class TelephoneNumber implements Serializable {
	
	
	private int areaCode, lineNumber, prefix;
	
	/**
	 * Instantiates a new telephone number.
	 *<p>
	 * The constructor takes a string in a defined form and splits into individual fields, namely 
	 * areaCode, prefix and lineNumber. Setters used for storage.
	 *  
	 * @param phoneNumber the phone number
	 */
	public TelephoneNumber(String phoneNumber) {
		int areaCode = Integer.parseInt(phoneNumber.split("-")[0].trim());
		int prefix = Integer.parseInt(phoneNumber.split("-")[1].trim());
		int lineNumber = Integer.parseInt(phoneNumber.split("-")[2].trim());
		setAreaCode(areaCode); setPrefix(prefix); setLineNumber(lineNumber);
	}	
	
	/**
	 * Gets the area code.
	 *
	 * @return 		the area code of the phone number
	 */
	public int getAreaCode() {return areaCode;}
	
	/**
	 * Sets the area code.
	 *
	 * @param areaCode 		area code of the phone number
	 */
	public void setAreaCode(int areaCode) {this.areaCode = areaCode;}
	
	/**
	 * Gets the prefix for the phone number.
	 *
	 * @return prefix		returns prefix of the phone number
	 */
	public int getPrefix() { return prefix;}
	
	/**
	 * Sets the prefix.
	 *
	 * @param prefix 		prefix of phone number
	 */
	public void setPrefix(int prefix) {this.prefix = prefix;}
	
	/**
	 * Gets the line number.
	 *
	 * @return lineNumber		line number of the phone number
	 */
	public int getLineNumber() {return lineNumber;}
	
	/**
	 * Sets the line number.
	 *
	 * @param lineNumber 		the line number of the phone number 
	 */
	public void setLineNumber(int lineNumber) {this.lineNumber = lineNumber;}
	
	/**
	 * To string.
	 *<p>
	 * This toString() method returns phone number in the desired form.
	 * 
	 * @return string
	 */
	public String toString() {return "(" + getAreaCode() +") "+ getPrefix() + "-" + getLineNumber();}
}
