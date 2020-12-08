package com.revature.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.revature.model.Approver;
import com.revature.model.RS;
import com.revature.model.TR_Request;

public interface ApproverDao {

	public void setApprovalStatus(RS rs, TR_Request tr, LocalDateTime date);
	
	public RS getApprovalStatus(TR_Request tr);
	
	public Approver getApproverByUsername(String username);

	public Approver getApproverById(int id);

	public void newApprover(Approver a);

	public void updateRMBMAmount(TR_Request tr, double amount);

	public TR_Request getRequestById(int id);

	public List<TR_Request> getRequestByEmployeeId(int id);

	public List<TR_Request> getAllRequests();
	
	public void autoApproveRequests(LocalDateTime date);
	
	public List<Approver> getAllApprovers();
}
