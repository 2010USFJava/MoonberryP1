package com.revature.controller;

public class LoginController {

	//This method get the the credentials from the the html elements and calls the
	//service layer for login berification.  this controller also redirects the user 
	//to a  different page if their credentials fail
	
//static VillainService vServ = new VillainService();
//	
//	public static String login(HttpServletRequest req) {
//		if(!req.getMethod().equals("POST")) {
//			return "resources/html/index.html";
//		}
//		
//		String name = req.getParameter("villainname");
//		String superpower = req.getParameter("superpower");
//		SuperVillain vill = vServ.loginGetVillain(name, superpower);
//		if(vill==null) {
//			return "wrongcreds.change";
//		}else {
//			req.getSession().setAttribute("currentvill", vill);
//			return "home.change";
//		}
//		
//	}
}
