package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Approver;
import com.revature.model.Employee;

/*this method gets the user off of the current user attribute written in login controller
 * checks if said use is an approver-. if so, casts user as anaapprover
 * if not casts user as an employee
 * writes user as as JSON
 * equivalent to villian controller
 * 
*/
public class UserController extends HttpServlet {
	public static void getSessionUser(HttpServletRequest req, HttpServletResponse res) 
											throws JsonProcessingException, IOException{
		Approver a = new Approver();	
		Object thisUser = req.getSession().getAttribute("currentuser");
		if(thisUser.getClass().isInstance(a.getClass())) {
			Approver aUser = (Approver) thisUser;
			res.getWriter().write(new ObjectMapper().writeValueAsString(aUser));
		}else {
			Employee eUser = (Employee) thisUser;
			res.getWriter().write(new ObjectMapper().writeValueAsString(eUser));
		}
		
	}
}