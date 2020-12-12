package com.revature.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Employee;
import com.revature.service.FormService;

public class FormController {
	
	static FormService fServ = new FormService();
			
	public static void submit(HttpServletRequest req, HttpServletResponse res)  {

		System.out.println("in form controller");
		if (!req.getMethod().equals("POST")) {
			System.out.println("this is weird, form should be a post!");
		}
		Object thisUser = req.getSession().getAttribute("currentuser");
		if (thisUser == null) {
			//TODO: login first 
			thisUser = new Employee();
		}
		if (thisUser.getClass().equals(Employee.class)) {
			System.out.println("form controller got the user employee");
		} else {
			System.out.println("uh oh, form controller should have got the user");
		}
		
		HashMap<String, String[]> mapping = new HashMap<String, String[]>(req.getParameterMap());
		for (String key : mapping.keySet()) {
			System.out.println("key: " + key + ", value: " + Arrays.toString(mapping.get(key)));
		}
		//System.out.println("request :" + mapping.toString());

		LocalDateTime currentTime = LocalDateTime.of(
				LocalDate.parse(req.getParameter("current_date")), LocalTime.now());
		LocalDateTime eventStartTime = LocalDateTime.parse(req.getParameter("event_start_date"));
		LocalDateTime eventEndTime = LocalDateTime.parse(req.getParameter("event_end_date"));
		String eventLocation = req.getParameter("event_address") + ", " + req.getParameter("event_city") + ", "
				+ req.getParameter("event_state") + ", " + req.getParameter("event_zip");
		System.out.println("location is " + eventLocation);
		//fServ.makeTRMSRequest((Employee) thisUser);
		
	}
	

}
