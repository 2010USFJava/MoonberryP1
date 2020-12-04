package com.revature.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.TR_Request;

public interface EmployeeDao {
	//TODO save files to database
	public TR_Request makeRequest(Employee employee, Event_Type eventType, LocalDateTime requestMadeDate, 
			double requestAmount, LocalDateTime eventStartDate, LocalDateTime eventEndDate, 
			String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust, boolean emailProvided);
	
	public Employee findById(int id);
	public Employee findByUsername(String username);
	public List<Employee> findAll();
	public Employee findByRequest(TR_Request r);
	public List<TR_Request> findEmployeeRequests(Employee e);
	
	public void insert(Employee e);
	
}
