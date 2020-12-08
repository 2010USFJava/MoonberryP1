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
	
	public Object loginAnyone(String username, String password) {
		if(loginVerify(username,password).equals("approver")) {
			return adao.getApproverByUsername(username);
		}else if(loginVerify(username,password).equals("employee")) {
			return edao.findByUsername(username);
		}
		return null;
	}


	private String loginVerify(String username, String password) {
		List<Approver> aList = adao.getAllApprovers();
		List<Employee> eList = edao.findAll();
		String type = "no user found";
		for(Approver a: aList) {
			if(a.getUsername().equals(username)&& a.getPassword().equals(password)) {
				type = "approver";
			}else {
				for(Employee e: eList) {
					if(e.getUsername().equals(username)&& e.getPassword().equals(password)) {
						type = "employee";
					}
				}
			}
			
		}
		return type; 
		
	}


	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public void insertNewVillain(SuperVillain vill) {
//		svdao.insertVillain(vill);
//	}

}
