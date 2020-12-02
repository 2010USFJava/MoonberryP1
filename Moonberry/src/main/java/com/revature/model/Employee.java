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


	
	
	public String provideAddnInfo(String info) {
		return info;
	}
	
	public void rejectReimbursement(TR_Request r) {
		r.setRequestStatus(RS.REQUEST_REJECTED);
		requests.remove(r);
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public float getTuitionAvail() {
		return tuitionAvail;
	}


	public void setTuitionAvail(float tuitionAvail) {
		this.tuitionAvail = tuitionAvail;
	}


	public int getDirectSuper() {
		return directSuper;
	}


	public void setDirectSuper(int directSuper) {
		this.directSuper = directSuper;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public ArrayList<TR_Request> getRequests() {
		return requests;
	}


	public void setRequests(ArrayList<TR_Request> requests) {
		this.requests = requests;
	}


	public int getDepartmentId() {
		return departmentId;
	}
	
	
}