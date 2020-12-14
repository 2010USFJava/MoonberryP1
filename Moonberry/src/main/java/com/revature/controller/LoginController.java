package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Approver;
import com.revature.model.Employee;
import com.revature.service.LoginService;
import com.revature.util.LogThis;

public class LoginController {

	// This method get the the credentials from the the html elements and calls the
	// service layer for login verification. this controller also redirects the user
	// to a different page if their credentials fail

	static LoginService lServ = new  LoginService();

	public static String login(HttpServletRequest req, HttpServletResponse res) {
		Approver a = new Approver();
		if (!req.getMethod().equals("POST")) {
			return "resources/html/index.html";
		}
		
		String sessionId = req.getSession().getId();
		//from the login boxes
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		//returns the user as java object created from database entry
		Object user = lServ.loginAnyone(username, password);
		if (user == null) {
			return "unsuccessfullogin.trms";
		}else if(user.getClass().isInstance(a)) {
			Approver aUser = (Approver) user;
			req.getSession().setAttribute("currentuser", aUser);
			req.getSession().setAttribute("sessionid", sessionId);
			Cookie cookie = new Cookie("user",aUser.getUsername());
			Cookie cookie2 = new Cookie("utype",aUser.getAtype().toString());
			System.out.println(cookie2);
			cookie.setMaxAge( 60 * 60);	
			res.addCookie(cookie);
			res.addCookie(cookie2);
			LogThis.LogIt("info", "Approver with id "+ aUser.getApproverid() + " logged in");
			return "apphome.trms";
		}else{
			Employee eUser = (Employee) user;
			req.getSession().setAttribute("currentuser", eUser);
			req.getSession().setAttribute("sessionid", sessionId);
			Cookie cookie = new Cookie("user",eUser.getUsername());
			Cookie cookie2 = new Cookie("utype","employee");
			cookie.setMaxAge( 60 * 60);	
			res.addCookie(cookie);
			res.addCookie(cookie2);
			LogThis.LogIt("info", "Employee with id "+ eUser.getEmployeeId() + " logged in");
			return "emphome.trms"; 
		}

	}
}
