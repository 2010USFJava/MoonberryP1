package com.revature.model;

import java.time.LocalDate;

public class TR_Request {

	private int request_Status;
	private int request_Id;
	private int employee_Id;
	private LocalDate request_Date;
	private LocalDate event_Date;
	private String event_Length;
	private String event_Name;
	private String event_Location;
	private String event_Description;
	private LocalDate event_Start_Date;
	private LocalDate event_End_Date;
	private double tuition_Amount;
	private Grade_Format grade_F;
	private String work_Just;
	private boolean urgent;
	
	public TR_Request() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TR_Request(int request_Status, int request_Id, int employee_Id, LocalDate request_Date, LocalDate event_Date,
			String event_Length, String event_Name, String event_Location, String event_Description,
			LocalDate event_Start_Date, LocalDate event_End_Date, double tuition_Amount, Grade_Format grade_F,
			String work_Just, boolean urgent) {
		super();
		this.request_Status = request_Status;
		this.request_Id = request_Id;
		this.employee_Id = employee_Id;
		this.request_Date = request_Date;
		this.event_Date = event_Date;
		this.event_Length = event_Length;
		this.event_Name = event_Name;
		this.event_Location = event_Location;
		this.event_Description = event_Description;
		this.event_Start_Date = event_Start_Date;
		this.event_End_Date = event_End_Date;
		this.tuition_Amount = tuition_Amount;
		this.grade_F = grade_F;
		this.work_Just = work_Just;
		this.urgent = urgent;
	}



	public int getRequest_Status() {
		return request_Status;
	}

	public void setRequest_Status(int request_Status) {
		this.request_Status = request_Status;
	}

	public int getRequest_Id() {
		return request_Id;
	}

	public void setRequest_Id(int request_Id) {
		this.request_Id = request_Id;
	}

	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public LocalDate getRequest_Date() {
		return request_Date;
	}

	public void setRequest_Date(LocalDate request_Date) {
		this.request_Date = request_Date;
	}

	public LocalDate getEvent_Date() {
		return event_Date;
	}

	public void setEvent_Date(LocalDate event_Date) {
		this.event_Date = event_Date;
	}

	public String getEvent_Length() {
		return event_Length;
	}

	public void setEvent_Length(String event_Length) {
		this.event_Length = event_Length;
	}

	public String getEvent_Name() {
		return event_Name;
	}

	public void setEvent_Name(String event_Name) {
		this.event_Name = event_Name;
	}

	public String getEvent_Location() {
		return event_Location;
	}

	public void setEvent_Location(String event_Location) {
		this.event_Location = event_Location;
	}

	public String getEvent_Description() {
		return event_Description;
	}

	public void setEvent_Description(String event_Description) {
		this.event_Description = event_Description;
	}

	public LocalDate getEvent_Start_Date() {
		return event_Start_Date;
	}

	public void setEvent_Start_Date(LocalDate event_Start_Date) {
		this.event_Start_Date = event_Start_Date;
	}

	public LocalDate getEvent_End_Date() {
		return event_End_Date;
	}

	public void setEvent_End_Date(LocalDate event_End_Date) {
		this.event_End_Date = event_End_Date;
	}

	public Grade_Format getGrade_F() {
		return grade_F;
	}

	public void setGrade_F(Grade_Format grade_F) {
		this.grade_F = grade_F;
	}

	public String getWork_Just() {
		return work_Just;
	}

	public void setWork_Just(String work_Just) {
		this.work_Just = work_Just;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	@Override
	public String toString() {
		return "TR_Request [request_Status=" + request_Status + ", request_Id=" + request_Id + ", employee_Id="
				+ employee_Id + ", request_Date=" + request_Date + ", event_Date=" + event_Date + ", event_Length="
				+ event_Length + ", event_Name=" + event_Name + ", event_Location=" + event_Location
				+ ", event_Description=" + event_Description + ", event_Start_Date=" + event_Start_Date
				+ ", event_End_Date=" + event_End_Date + ", grade_F=" + grade_F + ", work_Just=" + work_Just
				+ ", urgent=" + urgent + "]";
	}
	
	
}
