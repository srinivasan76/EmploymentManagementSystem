package com.employee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.employee.bean.Employee;
import com.employee.dao.EmployeeDetails;
import com.employee.util.DBUtil;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;



@WebServlet(urlPatterns = "/employeereport")
public class Report extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int inputAge = Integer.parseInt(req.getParameter("age"));
		//PrintWriter  out = resp.getWriter();
		EmployeeDetails employeeDetails = new EmployeeDetails();
		
		java.util.List<Employee> employeeList = employeeDetails.lessThanInputAgeEmployess(inputAge);		
		req.setAttribute("empList", employeeList);
		
		javax.servlet.RequestDispatcher requestDispatcher = req.getRequestDispatcher("/report.jsp");
		requestDispatcher.forward(req, resp);
		
		
		
	}
}
