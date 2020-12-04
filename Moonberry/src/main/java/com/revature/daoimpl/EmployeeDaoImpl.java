package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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
	 * @param tuitionAmount: The cost of the event
	 * @param eventStartDate
	 * @param eventEndDate
	 * @param eventName
	 * @param eventLocation
	 * @param eventDescription
	 * @param gradeFormat
	 * @param workJust: Justification for reimbursement.
	 * @return null if the request is invalid.
	 */
	public TR_Request makeRequest(Employee employee, LocalDateTime requestMadeDate, 
			double tuitionAmount, LocalDateTime eventStartDate, LocalDateTime eventEndDate, 
			String eventName, String eventLocation, String eventDescription, 
			Grade_Format gradeFormat, Event_Type eventType, String workJust, boolean emailProvided) {
		
		TR_Request r = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into tr_request values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			double projectedRmbsment = Math.min(tuitionAmount * eventType.getRmbsmentCoverage(),
												employee.getAvailRmbsment());
			employee.setAvailRmbsment(employee.getAvailRmbsment() - projectedRmbsment);

			long daysUntilStart = requestMadeDate.until(eventEndDate, ChronoUnit.DAYS);
			if (daysUntilStart < 7) {
				return null;
			}
			boolean urgent = (daysUntilStart < 14);

			if (emailProvided)
				ps.setInt(1, RS.AWAIT_BENCO_APPROVAL.getStatusCode());
			else
				ps.setInt(1, RS.AWAIT_SUPER_APPROVAL.getStatusCode());
			ps.setInt(2, employee.getEmployeeId());
		
			ps.setObject(3, requestMadeDate);
			ps.setObject(4, eventStartDate);
			ps.setObject(5, eventEndDate);
			ps.setString(6, eventName);
			ps.setString(7, eventLocation);
			ps.setString(8, eventDescription);
			ps.setDouble(9, tuitionAmount);
			ps.setDouble(10, projectedRmbsment);
			ps.setString(11, gradeFormat.toString().toLowerCase());
			ps.setString(12, eventType.toString().toLowerCase());
			ps.setString(13, workJust);
			ps.setBoolean(13, urgent);
			ps.setObject(13, requestMadeDate);
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			int requestId = -1;
			if (keys.next())
				requestId = keys.getInt(1);
			if (emailProvided)
				r = new TR_Request(RS.AWAIT_BENCO_APPROVAL, requestId, employee.getEmployeeId(), requestMadeDate, eventName,
						eventLocation, eventDescription, eventStartDate, eventEndDate, tuitionAmount, gradeFormat,
						eventType, workJust, urgent, requestMadeDate);
			else
				r = new TR_Request(RS.AWAIT_SUPER_APPROVAL, requestId, employee.getEmployeeId(), requestMadeDate, eventName,
						eventLocation, eventDescription, eventStartDate, eventEndDate, tuitionAmount, gradeFormat,
						workJust, urgent, requestMadeDate);
			r.setRmbsmentAmount(projectedRmbsment);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return r;
		//TODO: Log creation of request
	}
	
	@Override
	public Employee findById(int id) {
		Employee e = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from employee where employee_id=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e = new Employee(id, rs.getString("firstname"), rs.getString("lastname"), 
						rs.getInt("department_id"), rs.getInt("direct_super"), 
						rs.getString("username"), rs.getString("password"));
				e.setAvailRmbsment(rs.getDouble("avail_rmbsment"));
			}
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return e;
	}
	
	@Override
	public Employee findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> employees = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from employee";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			employees = new ArrayList<>();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt("employee_id"), rs.getString("firstname"), rs.getString("lastname"), 
						rs.getInt("department_id"), rs.getInt("direct_super"),  
						rs.getString("username"), rs.getString("password"));
				
			}
		return null;
	}
	
	@Override
	public Employee findByRequest(TR_Request r) {
		
		return null;
	}
	@Override
	public List<TR_Request> findEmployeeRequests(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(Employee e) {
		// TODO Auto-generated method stub
		
	}


}
