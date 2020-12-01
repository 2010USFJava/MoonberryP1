package com.revature.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee {
	private int employeeId;
	private String firstname;
	private String lastname;
	private int departmentId;
	private float tuitionAvail;
	private int directSuper;
	private String username;
	private String password;
	private ArrayList
	

	public Employee(int employeeId, String firstname, String lastname, int departmentId, int directSuper,
			String username, String password) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.departmentId = departmentId;
		this.directSuper = directSuper;
		this.username = username;
		this.password = password;
		this.tuitionAvail = 1000;
	}


	/**
	 * Makes a request.
	 * @param eventType
	 * @param requestDate
	 * @param requestAmount
	 * @param eventStartDate
	 * @param eventEndDate
	 * @param eventName
	 * @param eventLocation
	 * @param eventDescription
	 * @param gradeFormat
	 * @param workJust
	 * @return true if the request is valid.
	 */
	public boolean makeRequest(Event_Type eventType, LocalDate requestDate, float requestAmount, LocalDate eventStartDate, 
			LocalDate eventEndDate, String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust) {
		//TODO: Make a request object
		long untilEventStarts = requestDate.until(eventEndDate, ChronoUnit.DAYS);
		
		
		return false;
	}
	
	
	
	
}
