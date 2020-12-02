package com.revature.model;

public class Approver {
	private int approverId;
	private Approver_Type atype;
	private String firstname;
	private String lastname;
	private String department;
	private String username;
	private String password;
	
	public Approver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Approver(int approverId, Approver_Type atype, String firstname, String lastname, String department,
			String username, String password) {
		super();
		this.approverId = approverId;
		this.atype = atype;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.username = username;
		this.password = password;
	}

	public int getApproverid() {
		return approverId;
	}

	public void setApproverid(int approverId) {
		this.approverId = approverId;
	}

	public Approver_Type getAtype() {
		return atype;
	}

	public void setAtype(Approver_Type atype) {
		this.atype = atype;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	@Override
	public String toString() {
		return "Approver [approverId=" + approverId + ", atype=" + atype + ", firstname=" + firstname + ", lastname="
				+ lastname + ", department=" + department + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
