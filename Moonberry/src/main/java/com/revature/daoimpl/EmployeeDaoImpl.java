package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.sql.Date;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
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
	public TR_Request makeRequest(Employee employee, Event_Type eventType, LocalDate requestDate, 
			double requestAmount, LocalDate eventStartDate, LocalDate eventEndDate, 
			String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, String workJust, boolean emailProvided) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "insert into tr_request values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		long daysUntilStart = requestDate.until(eventEndDate, ChronoUnit.DAYS);
		if (daysUntilStart < 7) {
			return null;
		}
		boolean urgent = (daysUntilStart < 14);
		if (emailProvided)
			ps.setInt(1, RS.AWAIT_BENCO_APPROVAL.getStatusCode());
		else
			ps.setInt(1, RS.AWAIT_SUPER_APPROVAL.getStatusCode());
		ps.setInt(2, employee.getEmployeeId());
		ps.setDate(3, Date.valueOf(requestDate));
		ps.setDate(4, Date.valueOf(eventStartDate));
		ps.setDate(5, Date.valueOf(eventEndDate));
		ps.setString(6, eventName);
		ps.setString(7, eventLocation);
		ps.setString(8, eventDescription);
		ps.setDouble(9, requestAmount);
		ps.setString(10, gradeFormat.toString().toLowerCase());
		ps.setString(11, eventType.toString().toLowerCase());
		ps.setBoolean(12, urgent);
		ps.executeUpdate();
		ResultSet keys = ps.getGeneratedKeys();
		int requestId = -1;
		if (keys.next())
			requestId = keys.getInt(1);
		TR_Request r = null;
		if (emailProvided)
			r = new TR_Request(RS.AWAIT_BENCO_APPROVAL, -1, employee.getEmployeeId(), requestDate, eventName, eventLocation, 
					eventDescription, eventStartDate, eventEndDate, requestAmount, gradeFormat, workJust, urgent);
		else
			r = new TR_Request(RS.AWAIT_SUPER_APPROVAL, -1, employee.getEmployeeId(), requestDate, eventName, eventLocation, 
					eventDescription, eventStartDate, eventEndDate, requestAmount, gradeFormat, workJust, urgent);
		return r;
		//TODO: Log creation of request
	}
}
