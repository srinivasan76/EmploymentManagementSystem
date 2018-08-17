package com.employee.web;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDetails;

@WebServlet(urlPatterns = "/details")
public class EmployeeDetailsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new LinkedList<>();
		list.add(req.getParameter("name"));
		list.add(req.getParameter("age"));
		list.add(req.getParameter("dob"));
		String address = req.getParameter("address");
		System.out.println(address.replaceAll("\n",""));
		list.add(address);
		list.add(req.getParameter("salary"));
		list.add(req.getParameter("description"));
		list.add(req.getParameter("email"));
		list.add(req.getParameter("phonenumber"));
		System.out.println(list.size());
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.insertEmployeeDetails(list);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("report.html");
		requestDispatcher.forward(req, resp);

	}
}
