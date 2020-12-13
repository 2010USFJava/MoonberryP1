package com.revature.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonMainServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//when does this servlet get spun up? when a getsession.json  is returned from the browser.
	//this servlet calls the JSON helper servlet on thie req to serialize the JSON data
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws IOException, ServletException{
		System.out.println("in do get");
		JsonRequestHelper.process(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in JsonMain doPost");
		
//		Enumeration<String> names = req.getHeaderNames();
//        while(names.hasMoreElements()) {
//            String name = names.nextElement();
//          System.out.println(name + "=" + req.getHeader(name));
//        }
//		
//        HashMap<String, String[]> mapping = new HashMap<String, String[]>(req.getParameterMap());
//		for (String key : mapping.keySet()) {
//			System.out.println("key: " + key + ", value: " + Arrays.toString(mapping.get(key)));
//		}
		
		JsonRequestHelper.process(req,res);
		
	}


}
