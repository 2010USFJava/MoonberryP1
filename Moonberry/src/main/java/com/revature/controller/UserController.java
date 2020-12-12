package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Approver;
import com.revature.model.Employee;

/*this method gets the user off of the current user attribute written in login controller
 * checks if said user is an approver-. if so, casts user as an aapprover
 * if not casts user as an employee
 * writes object as as JSON to the request
 * equivalent to villian controller example
 * Gets called in the JSON Request  helper
*/
public class UserController {
	
	public static void getSessionUser(HttpServletRequest req, HttpServletResponse res) 
											throws JsonProcessingException, IOException{
		Approver a = new Approver();
		Object thisUser = req.getSession().getAttribute("currentuser");
		System.out.println("in user controller");
	
		if(thisUser.getClass().equals(a.getClass())) {
			Approver aUser = (Approver) thisUser;
			Cookie cookie = new Cookie("user",aUser.getUsername());
			cookie.setMaxAge( 60 * 60);	
			res.addCookie(cookie);
		}else {
			Employee eUser = (Employee) thisUser;
			Cookie cookie = new Cookie("user",eUser.getUsername());
			cookie.setMaxAge( 60 * 60);
			res.addCookie(cookie);
			
		}
		
	}
}