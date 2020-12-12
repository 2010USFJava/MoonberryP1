package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class FormViewController {
	public static String view(HttpServletRequest req) {
		return "resources/html/newrequest.html";
	}
}
