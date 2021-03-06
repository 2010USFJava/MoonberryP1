package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("in Master doGet");
		req.getRequestDispatcher(RequestHelper.process(req,res)).forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("in Master doPost");
		req.getRequestDispatcher(RequestHelper.process(req,res)).forward(req, res);

	}
}
