package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	
	
	//this just return the correct webpage
	public static String home(HttpServletRequest req) {
		return "resources/html/home.html";
	}


}