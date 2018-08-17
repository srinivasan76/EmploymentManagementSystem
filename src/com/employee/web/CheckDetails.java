package com.employee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDetails;

@WebServlet(urlPatterns = "/checking")
public class CheckDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid");
		String password = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		RequestDispatcher requestDispatcher;
		EmployeeDetails employeeDetails = new EmployeeDetails();
		if (employeeDetails.isValidUser(userId, password)) {
			out.println("<center><h1> Welcome <font color=red>" + userId + "</font>" + "</h1></center>");
			requestDispatcher = req.getRequestDispatcher("employeedetails.html");
			requestDispatcher.include(req, resp);
		} else {
			out.println("<p>userId or Password is " + "<font color = red >incorrect!</font>" + "</p>");

			requestDispatcher = req.getRequestDispatcher("login.html");
			requestDispatcher.include(req, resp);
		}

	}

}
