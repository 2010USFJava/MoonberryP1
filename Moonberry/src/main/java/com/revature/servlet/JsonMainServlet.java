package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonMainServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//when does this servlet get spun up? when a .json returned from the browser.
	//this servlet calls the JSON helpert servlet on thie req to serialize the JSON data
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws IOException, ServletException{
		System.out.println("in do get");
		//JsonRequestHelper.process(req,res);
	}


}
