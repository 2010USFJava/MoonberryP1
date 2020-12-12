package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.FormController;
import com.revature.controller.FormViewController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.RequestViewController;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		
    System.out.println(req.getRequestURI());
    
		switch (req.getRequestURI()) {
		
		case "/MoonberryTRMS/login.trms":
			System.out.println("in login.trms helper");
			return LoginController.login(req);
		case "/MoonberryTRMS/apphome.trms":
			System.out.println("in home.change rhelper");
			return HomeController.home(req);
		case "/MoonberryTRMS/emphome.trms":
			System.out.println("in emp home helper");
			return HomeController.ohome(req);
		case "/MoonberryTRMS/request.view.trms":
			System.out.println("in request home helper");
			return RequestViewController.view(req);
		case "/MoonberryTRMS/newrequest.trms":
			return FormViewController.view(req);
		default:
			System.out.println("Your life? I'mma need that.");
			return "resources/html/unsuccessfullogin.html";
			}

	}

}
