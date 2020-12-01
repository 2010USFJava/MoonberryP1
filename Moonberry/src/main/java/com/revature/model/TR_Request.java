package com.revature.model;

import java.time.LocalDate;

public class TR_Request {

	private int requestStatus;
	private int requestId;
	private int employee_Id;
	private LocalDate requestDate;
	private LocalDate eventDate;
	private String eventLength;
	private String eventName;
	private String eventLocation;
	private String eventDescription;
	private LocalDate eventStartDate;
	private LocalDate eventEndDate;
	private double tuitionAmount;
	private Grade_Format gradeF;
	private String workJust;
	private boolean urgent;
	
	public TR_Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TR_Request(int requestStatus, int requestId, int employee_Id, LocalDate requestDate, LocalDate eventDate,
			String eventLength, String eventName, String eventLocation, String eventDescription,
			LocalDate eventStartDate, LocalDate eventEndDate, double tuitionAmount, Grade_Format gradeF,
			String workJust, boolean urgent) {
		super();
		this.requestStatus = requestStatus;
		this.requestId = requestId;
		this.employee_Id = employee_Id;
		this.requestDate = requestDate;
		this.eventDate = eventDate;
		this.eventLength = eventLength;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.tuitionAmount = tuitionAmount;
		this.gradeF = gradeF;
		this.workJust = workJust;
		this.urgent = urgent;
	}

	public int getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLength() {
		return eventLength;
	}

	public void setEventLength(String eventLength) {
		this.eventLength = eventLength;
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

	public LocalDate getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(LocalDate eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public LocalDate getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(LocalDate eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public double getTuitionAmount() {
		return tuitionAmount;
	}

	public void setTuitionAmount(double tuitionAmount) {
		this.tuitionAmount = tuitionAmount;
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
		return "TR_Request [requestStatus=" + requestStatus + ", requestId=" + requestId + ", employee_Id="
				+ employee_Id + ", requestDate=" + requestDate + ", eventDate=" + eventDate + ", eventLength="
				+ eventLength + ", eventName=" + eventName + ", eventLocation=" + eventLocation + ", eventDescription="
				+ eventDescription + ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate
				+ ", tuitionAmount=" + tuitionAmount + ", gradeF=" + gradeF + ", workJust=" + workJust + ", urgent="
				+ urgent + "]";
	}
	
	
}
