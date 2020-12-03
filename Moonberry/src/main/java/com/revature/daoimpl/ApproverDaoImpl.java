package com.revature.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.ApproverDao;
import com.revature.model.Approver;
import com.revature.model.Approver_Type;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class ApproverDaoImpl implements ApproverDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	/*takes in request object and response code enum
	 * and updates the response code for that row in the db table*/
	@Override
	public void setApprovalStatus(RS rs, TR_Request tr) throws SQLException {
		tr.setRequestStatus(rs);
		Connection conn = cf.getConnection();
		String sql = "update tr_request set request_status=? where request_id = ?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1,rs.getStatusCode());
		ps.setInt(2,tr.getRequestId());
		ps.executeUpdate();
		//TODO: log this
		
	}

	@Override
	public void requestInfo(TR_Request tr) throws SQLException {
	    setApprovalStatus(RS.ADD_INFO_REQUESTED,tr);
	    //TODO:Send message to employee that additional info is requested
	    //TODO: log this
		
	}
	//add note request
	@Override
	public Approver getApproverByUsername(String username) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "select * from approver where approver_id = ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			Approver myApprover = null;
			if(rs!=null) {
				while(rs.next()) {
					myApprover = new Approver(rs.getInt(1),Approver_Type.valueOf(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					
				}
				return myApprover;
			}else {
				return null;
			}
			// TODO optional, log this recording who accessed this data
			
		
	}
	
	//takes in approver id and retrieves 
	//entry from approver table| returns java object
	
	@Override
	public Approver getApproverById(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from approver where approver_id = ?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		Approver myApprover = null;
		if(rs!=null) {
			while(rs.next()) {
				myApprover = new Approver(rs.getInt(1),Approver_Type.valueOf(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				
			}
			return myApprover;
		}else {
			return null;
		}
		// TODO optional, log this recording who accessed this data
		
	}
	
//creates new entry in approver table from matching java object fields 
	
	@Override
	public void newApprover(Approver a) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into approver values(default,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, a.getAtype().toString().toLowerCase());
		ps.setString(2, a.getFirstname());
		ps.setString(3, a.getLastname());
		ps.setString(4, a.getDepartment());
		ps.setString(5, a.getUsername());
		ps.setString(6, a.getPassword());
		ps.executeUpdate();
		//TODO Log this!
		
	}

	@Override
	public void updateAmount(TR_Request tr, double amount) throws SQLException {
		tr.setTuitionAmount(amount);
		Connection conn = cf.getConnection();
		String sql = "update tr_request tuition_amount= ? where request_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, amount);
		ps.setInt(2, tr.getRequestId());
		ps.executeUpdate();
		//TODO log this, optional: include the id of the employeee and approver
	}

	
}
