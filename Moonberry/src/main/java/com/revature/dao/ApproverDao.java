package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.Approver;
import com.revature.model.TR_Request;

public interface ApproverDao {

  public void setApprovalStatus(TR_Request tr) throws SQLException;
  	/* This method will take in a tr request java object and edit the status code of the request to an approval code
  	 * */
  public void requestInfo() throws SQLException;
  
  public void getEmployeeByUsername(String username) throws SQLException;
  
  public void getEmployeeById(int id) throws SQLException;
  
  public void newApprover(Approver a)throws SQLException;
}
