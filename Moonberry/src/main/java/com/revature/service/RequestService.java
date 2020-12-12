package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.ApproverDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Approver;
import com.revature.model.Approver_Type;
import com.revature.model.Employee;
import com.revature.model.TR_Request;

public class RequestService {
	
	//This method checks the credentials against a java object created from the database entries
	//this gets called in the controller layer
	ApproverDao adao = new ApproverDaoImpl();
	EmployeeDao edao = new EmployeeDaoImpl();
	Approver a = new Approver();
	
	public List<TR_Request> populate(Object user){
		List<TR_Request> myRequests = new ArrayList<TR_Request>();
		if(user.getClass().equals(a.getClass())) {
			Approver thisUser =(Approver) user;
			if(thisUser.getAtype().equals(Approver_Type.SUPERVISOR)) {
				for(TR_Request t : adao.getRequestBySuper(thisUser.getApproverid())) { 
					myRequests.add(t);
				}
			}else if(thisUser.getAtype().equals(Approver_Type.BEN_CO)) {
				for(TR_Request t : adao.getAllRequests()) { 
					myRequests.add(t);
				}
			}else {
				int dId = adao.getDepartmentIdByName(thisUser.getDepartment());
				for(TR_Request t : adao.getRequestByDpt(dId)) { 
					myRequests.add(t);
				}
//					
			}
		}else {
			for(TR_Request t :edao.findEmployeeRequests((Employee) user)) {
				myRequests.add(t);
			}
		}
		
		return myRequests;
	}

	public RequestService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
