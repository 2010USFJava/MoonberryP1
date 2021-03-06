package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void makeRequest(TR_Request tr) {
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into tr_request values(default,?,?,?,?,?,?,?,?,?,?,CAST(? AS grade_format),CAST(? AS event_type),?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tr.getRequestStatus().getStatusCode());
			ps.setInt(2, tr.getEmployeeId());
			ps.setTimestamp(3, Timestamp.valueOf(tr.getRequestMadeDate()));
			ps.setTimestamp(4, Timestamp.valueOf(tr.getEventStartDate()));
			ps.setTimestamp(5, Timestamp.valueOf(tr.getEventEndDate()));
			ps.setString(6, tr.getEventName());
			ps.setString(7, tr.getEventLocation());
			ps.setString(8, tr.getEventDescription());
			ps.setDouble(9, tr.getTuitionAmount());
			ps.setDouble(10, tr.getRmbsmentAmount());
			ps.setString(11, tr.getGradeF().toString().toLowerCase());
			ps.setString(12, tr.getEventT().toString().toLowerCase());
			ps.setString(13, tr.getWorkJust());
			ps.setBoolean(14, tr.isUrgent());
			ps.setTimestamp(15, Timestamp.valueOf(tr.getRequestMadeDate()));
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			int requestId = -1;
			if (keys.next())
				requestId = keys.getInt(1);
			tr.setRequestId(requestId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override 
	public boolean isSuperAlsoDptHead(Employee e) {
		try {
			Connection conn = cf.getConnection();
			String sql = "select department_head from department where department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getDepartmentId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("department_head") == e.getDirectSuper();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee findById(int id) {
		Employee e = null;
		ApproverDao a = new ApproverDaoImpl();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from employee where employee_id=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e = new Employee(id, rs.getString("firstname"), rs.getString("lastname"), rs.getInt("department_id"),
						rs.getInt("direct_super"), rs.getString("username"), rs.getString("password"));
				e.setAvailRmbsment(rs.getDouble("avail_rmbsment"));
				e.setRequests((ArrayList<TR_Request>) a.getRequestByEmployeeId(id));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return e;
	}

	@Override
	public Employee findByUsername(String username) {
		Employee e = null;
		ApproverDao a = new ApproverDaoImpl();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from employee where username=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e = new Employee(rs.getInt("employee_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("department_id"),
						rs.getInt("direct_super"), rs.getString("username"), rs.getString("password"));
				e.setAvailRmbsment(rs.getDouble("avail_rmbsment"));
				e.setRequests((ArrayList<TR_Request>) a.getRequestByEmployeeId(rs.getInt("employee_id")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return e;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = null;
		ApproverDao a = new ApproverDaoImpl();
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
				e.setAvailRmbsment(rs.getDouble("avail_rmbsment"));
				e.setRequests((ArrayList<TR_Request>)a.getRequestByEmployeeId(rs.getInt("employee_id")));
				employees.add(e);
			} 
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee findByRequest(TR_Request r) {
		try {
			Connection conn = cf.getConnection();
			String sql = "select employee_id from tr_request where request_id=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getRequestId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return findById(rs.getInt("employee_id"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TR_Request> findEmployeeRequests(Employee e) {
		ApproverDao a = new ApproverDaoImpl();
		return a.getRequestByEmployeeId(e.getEmployeeId());
	}

	@Override
	public void insert(Employee e) {
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into employee values (default,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getFirstname());
			ps.setString(2, e.getLastname());
			ps.setInt(3, e.getDepartmentId());
			ps.setDouble(4, e.getAvailRmbsment());
			ps.setInt(5, e.getDirectSuper());
			ps.setString(6, e.getUsername());
			ps.setString(7, e.getPassword());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(Employee e, double newAvailRmbsment) {
		try {
			Connection conn = cf.getConnection();
			String sql = "update employee set avail_rmbsment=? where employee_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, e.getAvailRmbsment());
			ps.setInt(2, e.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
