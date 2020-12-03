package com.revature.dao;

import java.sql.SQLException;

import com.revature.model.Approver;
import com.revature.model.RS;
import com.revature.model.TR_Request;

public interface ApproverDao {

  public void setApprovalStatus(RS rs,TR_Request tr) throws SQLException;
  	/* This method will take in a tr request java object and edit the status code of the request to an approval code
  	 * */
  public void requestInfo(TR_Request tr) throws SQLException;
  
  public Approver getApproverByUsername(String username) throws SQLException;
  
  public Approver getApproverById(int id) throws SQLException;
  
  public void newApprover(Approver a)throws SQLException;
 
  public void updateAmount(TR_Request tr, double amount) throws SQLException;
  
  //public void 
  
  
}
