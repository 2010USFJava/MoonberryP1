package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.LogThis;

public class LogoutController {
	
	public static String logout(HttpServletRequest req, HttpServletResponse res) {
				Cookie c = new Cookie("user","");
				Cookie ck = new Cookie("JSESSIONID","");
				Cookie c2 = new Cookie("utype","");
				c.setMaxAge(0);
				ck.setMaxAge(0);
				c2.setMaxAge(0);
				res.addCookie(c);
				res.addCookie(ck);
				res.addCookie(c2);
				LogThis.LogIt("info", "User " + req.getSession().getAttribute("user") + " successfully logged out");
				req.getSession().invalidate();
				return "resources/html/logout.html";
				
			
	}
}
