package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestViewController {
	
	//this just return the correct webpage
		public static String view(HttpServletRequest req) {
			return "resources/html/request.view.html";
			
		}

}
