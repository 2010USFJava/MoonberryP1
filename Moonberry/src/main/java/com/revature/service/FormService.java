package com.revature.service;

import java.time.LocalDateTime;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.TR_Request;

public class FormService {
	EmployeeDao eDao = new EmployeeDaoImpl();
	
	public void makeTRMSRequest(Employee employee, LocalDateTime requestMadeDate, double tuitionAmount,
			LocalDateTime eventStartDate, LocalDateTime eventEndDate, String eventName, String eventLocation,
			String eventDescription, Grade_Format gradeFormat, Event_Type eventType, String workJust,
			boolean emailProvided) {
		System.out.println("make request called!");
		employee = eDao.findById(1); // TODO: REMOVE THIS!!!!!!!!!!!!!!
		TR_Request trR = new TR_Request();
	}
}
