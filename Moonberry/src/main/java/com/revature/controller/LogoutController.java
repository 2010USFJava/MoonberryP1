package com.revature.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class LogoutController {
	
	public static String logout(HttpServletRequest req, HttpServletResponse res) {
				Cookie c = new Cookie("user","");
				Cookie ck = new Cookie("JSESSIONID","");
				Cookie c2 = new Cookie("utype","");
				c.setMaxAge(0);
				ck.setMaxAge(0);
				c2.setMaxAge(0);
				res.addCookie(c);
				res.addCookie(ck);
				res.addCookie(c2);
				req.getSession().invalidate();
				//return "resources/html/apphome.html";
				return "resources/html/logout.html";
				
			
	}
}
