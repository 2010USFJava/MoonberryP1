package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.FormController;
import com.revature.controller.LoginController;
import com.revature.controller.RequestController;
import com.revature.controller.UserController;

public class JsonRequestHelper {
	
	//this method calls a controller which will write an object to the response object
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		switch(req.getRequestURI()) {
		case "/MoonberryTRMS/getsession.json":
			UserController.getSessionUser(req, res);
			break;
		case "/MoonberryTRMS/getrsession.json": //this might break tbh. fix in request.js if it do
			RequestController.returnRequest(req, res);
		
			break;
		case("/MoonberryTRMS/postform.json"):
			System.out.println("in json request helper for post form");
			FormController.submit(req, res);
			break;
		default:
			System.out.println("This the default, you messed up.");
			//SuperVillain vill = new SuperVillain("?","?",0);
			//res.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		}
	}

}
