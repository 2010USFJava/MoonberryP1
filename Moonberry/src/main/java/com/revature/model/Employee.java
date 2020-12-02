package com.revature.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Employee {
	private int employeeId;
	private String firstname;
	private String lastname;
	private int departmentId;
	private float tuitionAvail;
	private int directSuper;
	private String username;
	private String password;
	private ArrayList<TR_Request> requests;
	

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
		this.requests = new ArrayList<TR_Request>();
	}


	/**
	 * Makes a request.
	 * @param eventType: The type of event
	 * @param requestDate: The date the TR is being requested
	 * @param requestAmount: The cost of the event
	 * @param eventStartDate
	 * @param eventEndDate
	 * @param eventName
	 * @param eventLocation
	 * @param eventDescription
	 * @param gradeFormat
	 * @param workJust: Justification for reimbursement.
	 * @return true if the request is valid.
	 */
	public boolean makeRequest(Event_Type eventType, LocalDate requestDate, float requestAmount, LocalDate eventStartDate, 
			LocalDate eventEndDate, String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust) {
		//TODO: Make a request object
		long daysUntilStart = requestDate.until(eventEndDate, ChronoUnit.DAYS);
		if (daysUntilStart < 7) {
			return false;
		}
		boolean urgent = (daysUntilStart < 14);
		TR_Request r = new TR_Request(1, -1, employeeId, requestDate, eventName, eventLocation, eventDescription,
				eventStartDate, eventEndDate, requestAmount, gradeFormat, workJust, urgent);
		
		return true;
	}
	
	
	
	
}
