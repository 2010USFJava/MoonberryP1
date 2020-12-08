package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		
    System.out.println(req.getRequestURI());
    
		switch (req.getRequestURI()) {
		
//		case "/MoonberryTRMS/login.trms":
//			System.out.println("in login.change helper");
//			return LoginController.login(req);

		case "/MoonberryTRMS/apphome.trms":
			System.out.println("in home.change rhelper");
			return HomeController.home(req);

		default:
			System.out.println("Your life? I'mma need that.");
			return "resources/html/unsuccessfullogin.html";
			}

	}

}
