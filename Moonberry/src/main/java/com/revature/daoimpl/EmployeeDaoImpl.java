package com.revature.daoimpl;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.revature.dao.EmployeeDao;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	/**
	 * Makes a request and stores in the database.
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
	 * @return null if the request is invalid.
	 */
	public TR_Request makeRequest(Event_Type eventType, LocalDate requestDate, double requestAmount, LocalDate eventStartDate, 
			LocalDate eventEndDate, String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust, boolean emailProvided) {
		
		Connection conn = cf.getConnection();
		String sql = "insert into tr_request values(?,"
		//TODO: Make a request object
		long daysUntilStart = requestDate.until(eventEndDate, ChronoUnit.DAYS);
		if (daysUntilStart < 7) {
			return false;
		}
		boolean urgent = (daysUntilStart < 14);
		TR_Request r = null;
		if (emailProvided)
			r = new TR_Request(RS.AWAIT_BENCO_APPROVAL, -1, this.employeeId, requestDate, eventName, eventLocation, 
					eventDescription, eventStartDate, eventEndDate, requestAmount, gradeFormat, workJust, urgent);
		else
			r = new TR_Request(RS.AWAIT_SUPER_APPROVAL, -1, this.employeeId, requestDate, eventName, eventLocation, 
					eventDescription, eventStartDate, eventEndDate, requestAmount, gradeFormat, workJust, urgent);
		requests.add(r);
		return true;
	}
}
