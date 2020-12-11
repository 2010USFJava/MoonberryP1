package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Approver;
import com.revature.model.Employee;
import com.revature.model.TR_Request;
import com.revature.service.LoginService;
import com.revature.service.RequestService;

/*this method gets the user off of the current user attribute written in login controller
 * checks if said user is an approver-. if so, casts user as an aapprover
 * if not casts user as an employee
 * calls request service to return list from dimpls
 * equivalent to login controller
 * will get called in some  helper servlet
*/

public class RequestController {
	
	static RequestService rServ = new  RequestService(); 

	public static void returnRequest(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		
		
		Approver a = new Approver();
		Object thisUser = req.getSession().getAttribute("currentuser");
		if (thisUser.getClass().equals(a.getClass())) {
			Approver aUser = (Approver) thisUser;
			List<TR_Request> userReqs = rServ.populate(aUser);
			res.getWriter().write(new ObjectMapper().writeValueAsString(userReqs));
		} else {
			Employee eUser = (Employee) thisUser;
			List<TR_Request> userReqs = rServ.populate(eUser);
			res.getWriter().write(new ObjectMapper().writeValueAsString(userReqs));
		}

	}



}
