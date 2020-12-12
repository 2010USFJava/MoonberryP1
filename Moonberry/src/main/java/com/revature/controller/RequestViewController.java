package com.revature.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class RequestViewController {
	
	//this just return the correct webpage
		public static String view(HttpServletRequest req) {
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					return "resources/html/request.view.html";
					}
				
			}
			 return "resources/html/index.html";
		}

}
