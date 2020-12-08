package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Approver;
import com.revature.model.Employee;
import com.revature.service.LoginService;

public class LoginController {

	// This method get the the credentials from the the html elements and calls the
	// service layer for login verification. this controller also redirects the user
	// to a different page if their credentials fail

	static LoginService lServ = new  LoginService();

	public static String login(HttpServletRequest req) {
		Approver a = new Approver();
		if (!req.getMethod().equals("POST")) {
			return "resources/html/index.html";
		}
		
		String sessionId = req.getSession().getId();
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		Object user = lServ.loginAnyone(username, password);
		if (user == null) {
			return "unsuccessfullogin.trms";
		}else if(user.getClass().isInstance(a)) {
			req.getSession().setAttribute("currentuser", user);
			req.getSession().setAttribute("sessionid", sessionId);
			return "apphome.trms";
		}else{
			req.getSession().setAttribute("currentuser", user);
			req.getSession().setAttribute("sessionid", sessionId);
			return "emphome.trms"; //TODO this doesn't exist yet, make it so
		}

	}
}
