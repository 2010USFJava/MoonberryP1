package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.model.Approver;
import com.revature.model.Approver_Type;
import com.revature.model.Employee;
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class ApproverDaoImpl implements ApproverDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	/*
	 * takes in request object and response code enum and updates the response code
	 * for that row in the db table
	 */
	@Override
	public void setApprovalStatus(RS rs, TR_Request tr, LocalDateTime actionDate) {
		try {
			tr.setRequestStatus(rs);
			Connection conn = cf.getConnection();
			String sql = "update tr_request set request_status= ?, request_arrival_date = ?  where request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rs.getStatusCode());
			ps.setInt(3, tr.getRequestId());
			ps.setTimestamp(2, Timestamp.valueOf(actionDate));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO what will happen in the case of this error for the program? resubmit?
		}
		// TODO: log this

	}

	@Override
	public RS getApprovalStatus(TR_Request tr) {
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request where request_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tr.getRequestId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return RS.valueOfStatusCode(rs.getInt("request_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public Approver getApproverByUsername(String username) {
		Approver myApprover = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from approver where username  = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myApprover = new Approver(rs.getInt(1), Approver_Type.valueOf(rs.getString(2).toUpperCase()),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return myApprover;

		// TODO optional, log this recording who accessed this data

	}

	// takes in approver id and retrieves
	// entry from approver table| returns java object

	@Override
	public Approver getApproverById(int id) {
		Approver myApprover = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from approver where approver_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myApprover = new Approver(rs.getInt(1), Approver_Type.valueOf(rs.getString(2).toUpperCase()),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return myApprover;

		// TODO optional, log this recording who accessed this data

	}

//creates new entry in approver table from matching java object fields 

	@Override
	public void newApprover(Approver a) {
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into approver values(default,CAST(? AS approver_type),?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAtype().toString().toLowerCase());
			ps.setString(2, a.getFirstname());
			ps.setString(3, a.getLastname());
			ps.setString(4, a.getDepartment());
			ps.setString(5, a.getUsername());
			ps.setString(6, a.getPassword());
			ps.executeUpdate();
			// TODO Log this!
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRMBMAmount(TR_Request tr, double amount) {
		try {
			tr.setTuitionAmount(amount);
			Connection conn = cf.getConnection();
			String sql = "update tr_request set rmbsment_amount = ? where request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, tr.getRequestId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO log this, optional: include the id of the employeee and approver
	}

	@Override
	public TR_Request getRequestById(int id) {
		TR_Request tr = null;
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request where request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TR_Request(rs.getInt(1), RS.valueOfStatusCode(rs.getInt(2)), rs.getInt(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(),
						rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), Grade_Format.valueOf(rs.getString(12).toUpperCase()),
						Event_Type.valueOf(rs.getString(13).toUpperCase()), rs.getString(14), rs.getBoolean(15),
						rs.getTimestamp(16).toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tr;
	}

	public List<TR_Request> getRequestBySuper(int super_id) {
		TR_Request tr = null;
		List<TR_Request> trList = new ArrayList<TR_Request>();
		try {
			Connection conn = cf.getConnection();	
			String sql = "select * from tr_request left join employee on tr_request.employee_id = employee.employee_id where employee.direct_super =?";		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, super_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				tr = new TR_Request(rs.getInt(1),RS.valueOfStatusCode(rs.getInt(2)),rs.getInt(3), 
							rs.getTimestamp(4).toLocalDateTime(),
							rs.getTimestamp(5).toLocalDateTime(),
							rs.getTimestamp(6).toLocalDateTime(), rs.getString(7),rs.getString(8),
							rs.getString(9),rs.getDouble(10),rs.getDouble(11),
							Grade_Format.valueOf(rs.getString(12).toUpperCase()), Event_Type.valueOf(rs.getString(13).toUpperCase()),
							rs.getString(14),rs.getBoolean(15),rs.getTimestamp(16).toLocalDateTime());
				
				trList.add(tr);
			}			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return trList;
	}

	
	@Override
	public List<TR_Request> getRequestByDpt(int department_id) {	
		TR_Request tr = null;
		List<TR_Request> trList = new ArrayList<TR_Request>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request left join employee on tr_request.employee_id = employee.employee_id where employee.department_id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, department_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TR_Request(rs.getInt(1), RS.valueOfStatusCode(rs.getInt(2)), rs.getInt(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(),
						rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), Grade_Format.valueOf(rs.getString(12).toUpperCase()),
						Event_Type.valueOf(rs.getString(13).toUpperCase()), rs.getString(14), rs.getBoolean(15),
						rs.getTimestamp(16).toLocalDateTime());

				trList.add(tr);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return trList;
	}

	@Override
	public List<TR_Request> getRequestByStatus(RS status) {
		TR_Request tr = null;
		List<TR_Request> trList = new ArrayList<TR_Request>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request where request_status =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status.getStatusCode());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TR_Request(rs.getInt(1), RS.valueOfStatusCode(rs.getInt(2)), rs.getInt(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(),
						rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), Grade_Format.valueOf(rs.getString(12).toUpperCase()),
						Event_Type.valueOf(rs.getString(13).toUpperCase()), rs.getString(14), rs.getBoolean(15),
						rs.getTimestamp(16).toLocalDateTime());
				trList.add(tr);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return trList;
	}

	@Override
	public List<TR_Request> getRequestByEmployeeId(int id) {
		TR_Request tr = null;
		List<TR_Request> trList = new ArrayList<TR_Request>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request where employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TR_Request(rs.getInt(1), RS.valueOfStatusCode(rs.getInt(2)), rs.getInt(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(),
						rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), Grade_Format.valueOf(rs.getString(12).toUpperCase()),
						Event_Type.valueOf(rs.getString(13).toUpperCase()), rs.getString(14), rs.getBoolean(15),
						rs.getTimestamp(16).toLocalDateTime());
				trList.add(tr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trList;
	}

	@Override
	public List<TR_Request> getAllRequests() {
		TR_Request tr = null;
		List<TR_Request> trList = new ArrayList<TR_Request>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				tr = new TR_Request(rs.getInt(1), RS.valueOfStatusCode(rs.getInt(2)), rs.getInt(3),
						rs.getTimestamp(4).toLocalDateTime(), rs.getTimestamp(5).toLocalDateTime(),
						rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getDouble(10), rs.getDouble(11), Grade_Format.valueOf(rs.getString(12).toUpperCase()),
						Event_Type.valueOf(rs.getString(13).toUpperCase()), rs.getString(14), rs.getBoolean(15),
						rs.getTimestamp(16).toLocalDateTime());
				trList.add(tr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trList;
	}

	/**
	 * Checks all the requests and auto-approves requests awaiting super OR dpt head
	 * approval if they have not been approved within one week. Updates the request
	 * status and arrival date.
	 */
	@Override
	public void autoApproveRequests(LocalDateTime date) {

		try {
			Connection conn = cf.getConnection();
			String sql = "select * from tr_request";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				int request_id = rs.getInt("request_id");
				LocalDateTime arrivalDate = rs.getTimestamp("request_arrival_date").toLocalDateTime();
				long daysSinceArrival = arrivalDate.until(date, ChronoUnit.DAYS);
				if (daysSinceArrival > 7) {
					if (rs.getInt("request_status") == RS.AWAIT_SUPER_APPROVAL.getStatusCode())
						this.setApprovalStatus(RS.AWAIT_DPT_HEAD_APPROVAL, this.getRequestById(request_id), date);
					if (rs.getInt("request_status") == RS.AWAIT_DPT_HEAD_APPROVAL.getStatusCode())
						this.setApprovalStatus(RS.AWAIT_BENCO_APPROVAL, this.getRequestById(request_id), date);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Approver> getAllApprovers() {
		Approver app = null;
		List<Approver> aList = new ArrayList<Approver>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from approver";
			// Statement ps = conn.createStatement();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				app = new Approver(rs.getInt(1), Approver_Type.valueOf(rs.getString(2).toUpperCase()), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				aList.add(app);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aList;

	}

	@Override
	public int getDepartmentIdByName(String depName) {
		try {
			Connection conn = cf.getConnection();
			String sql = "select department_id from department where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, depName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("department_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
}

}
