package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.ApproverDao;
import com.revature.model.Approver;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class ApproverDaoImpl implements ApproverDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void setApprovalStatus(TR_Request tr) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInfo() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEmployeeByUsername(String username) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "select * from approver where approver_id = ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeQuery();
			
			// TODO optional, log this recording who accessed this data
			
		
	}
	
	/*takes in approver id and retrieves 
	 * entry from approver table| returns java object*/
	@Override
	public void getEmployeeById(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from approver where approver_id = ?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeQuery();
		
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

	
}
