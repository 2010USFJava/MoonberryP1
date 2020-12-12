package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	
	
	//this just return the correct webpage
	public static String home(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				return "resources/html/apphome.html";
				
			}
		}
		return "resources/html/index.html";
		
	}
	
	public static String ohome(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				return "resources/html/emphome.html";
				
			}
		}
		return "resources/html/index.html";
		
		
	}


}
