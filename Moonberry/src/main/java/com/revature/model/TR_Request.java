package com.revature.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TR_Request {

	private RS requestStatus;
	private int requestId;
	private int employeeId;
	private LocalDateTime requestMadeDate;
	private String eventName;
	private String eventLocation;
	private String eventDescription;
	private LocalDateTime eventStartDate;
	private LocalDateTime eventEndDate;
	private double tuitionAmount;
	private double rmbsmentAmount;
	private Grade_Format gradeF;
	private String workJust;
	private boolean urgent;
	private LocalDateTime requestArrivalDate;
	
	public TR_Request() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TR_Request(RS requestStatus, int requestId, int employeeId, LocalDateTime requestMadeDate, 
			String eventName, String eventLocation, String eventDescription,
			LocalDateTime eventStartDate, LocalDateTime eventEndDate, double tuitionAmount, Grade_Format gradeF,
			String workJust, boolean urgent, LocalDateTime requestArrivalDate) {

		super();
		this.requestStatus = requestStatus;
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.requestMadeDate = requestMadeDate;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.tuitionAmount = tuitionAmount;
		this.rmbsmentAmount = 0.0;
		this.gradeF = gradeF;
		this.workJust = workJust;
		this.urgent = urgent;
		this.requestArrivalDate = requestArrivalDate;
	}

	public RS getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RS requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDateTime getRequestMadeDate() {
		return requestMadeDate;
	}

	public void setRequestDate(LocalDateTime requestMadeDate) {
		this.requestMadeDate = requestMadeDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public LocalDateTime getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(LocalDateTime eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public LocalDateTime getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(LocalDateTime eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public double getTuitionAmount() {
		return tuitionAmount;
	}

	public void setTuitionAmount(double tuitionAmount) {
		this.tuitionAmount = tuitionAmount;
	}

	public double getRmbsmentAmount() {
		return rmbsmentAmount;
	}

	public void setRmbsmentAmount(double rmbsmentAmount) {
		this.rmbsmentAmount = rmbsmentAmount;
	}


	public Grade_Format getGradeF() {
		return gradeF;
	}

	public void setGradeF(Grade_Format gradeF) {
		this.gradeF = gradeF;
	}

	public String getWorkJust() {
		return workJust;
	}

	public void setWorkJust(String workJust) {
		this.workJust = workJust;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}


	@Override
	public String toString() {
		return "TR_Request [requestStatus=" + requestStatus + ", requestId=" + requestId + ", employeeId=" + employeeId
				+ ", requestMadeDate=" + requestMadeDate + ", eventName=" + eventName + ", eventLocation="
				+ eventLocation + ", eventDescription=" + eventDescription + ", eventStartDate=" + eventStartDate
				+ ", eventEndDate=" + eventEndDate + ", tuitionAmount=" + tuitionAmount + ", rmbsmentAmount="
				+ rmbsmentAmount + ", gradeF=" + gradeF + ", workJust=" + workJust + ", urgent=" + urgent
				+ ", requestArrivalDate=" + requestArrivalDate + "]";
	}



	
	
	
}
