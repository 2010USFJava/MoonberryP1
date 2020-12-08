package com.revature.service;

import java.util.List;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.ApproverDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Approver;
import com.revature.model.Employee;

public class LoginService {
	
	//why do I exist? because I have to apparently
ApproverDao adao = new ApproverDaoImpl();
EmployeeDao edao = new EmployeeDaoImpl();
	
	public Approver loginGetEveryone(String username, String password) {
		if(loginVerify(username,password)) {
			return adao.getApproverByUsername(username);
		}//TODO call getEmployee
		return null;
	}


	private boolean loginVerify(String username, String password) {
		List<Approver> aList = adao.getAllApprovers();
		List<Employee> eList = edao.findAll();
		boolean verify = false;
		for(Approver a: aList) {
			if(a.getUsername().equals(username)&& a.getPassword().equals(password)) {
				verify = true;
			}
			
		}
		return verify;
	}


	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public void insertNewVillain(SuperVillain vill) {
//		svdao.insertVillain(vill);
//	}

}
