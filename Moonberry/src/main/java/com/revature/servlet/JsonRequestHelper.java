package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.LoginController;
import com.revature.controller.UserController;

public class JsonRequestHelper {
	
	//this method gets the JSON data from the .json request and uses the JAXON object mapper
	// to serilaize to Java object
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		switch(req.getRequestURI()) {
		case "/MoonberryTRMS/getsession.json":
			UserController.getSessionUser(req, res);;
			//return something here???
			break;
		default:
			System.out.println("This the default you messed up.");
			//SuperVillain vill = new SuperVillain("?","?",0);
			//res.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		}
	}

}
