package com.revature.dao;

import java.sql.SQLException;
import java.time.LocalDate;

import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.TR_Request;

public interface EmployeeDao {
	//TODO save files to database
	//TODO submit details to databas
	//TODO  Michelle: add any method declarations besides the setters/getters/tostring 
	//to this file and then again the gull methods in the matching impl file
	public TR_Request makeRequest(Employee employee, Event_Type eventType, LocalDate requestDate, 
			double requestAmount, LocalDate eventStartDate, LocalDate eventEndDate, 
			String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust, boolean emailProvided) throws SQLException;
}
