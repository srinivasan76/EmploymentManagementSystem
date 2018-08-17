<%@ page language="java" import="com.employee.bean.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<table cellspacing="0" cellpadding="10" border="1" bordercolor="green">
<%		out.println("<center><h1>"+"Employee Details..."+"</h1><center>");
			out.println("<tr><th bgcolor=cyan>"+"EmpId"+"</th><th bgcolor=lightgreen>"+"Name"+"</th><th bgcolor=lightgreen>"+"Age"+"</th><th bgcolor=lightgreen>"+
					"E-mail"+"</th><th bgcolor=lightgreen>"+"PhoneNumber"+"</th></tr>");
			List<Employee> employeeList =(List<Employee>) request.getAttribute("empList");
			for(Employee empList : employeeList){
			out.println("<tr><td bgcolor=cyan>"+empList.getEmpId()+"</td><td>"+empList.getName()+"</td><td>"+
			empList.getAge()+"</td><td>"+empList.getEmail()+"</td><td>"+empList.getPhoneNumber()+"</td></tr>");
			}
	
	%>
	</table>
	</center>
</body>
</html>