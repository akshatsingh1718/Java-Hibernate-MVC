package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDAOImpl;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
private static final long serialVersionUID = 1L;

public DeleteEmployee() {
	super();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
PrintWriter out = response.getWriter();
int empid = Integer.parseInt(request.getParameter("empid"));
EmployeeDAOImpl dao = new EmployeeDAOImpl();
boolean isDeleted = dao.delete(empid);
if(isDeleted){
	out.print("<h1><span class='badge badge-pill badge-success'>Employee Deleted Successfully!</span></h1>");
request.getRequestDispatcher("index.jsp").include(request, response);;
}else {
	out.print("<h1><span class='badge badge-pill badge-danger'>Employee Not Deleted!</span></h1>");
request.getRequestDispatcher("index.jsp").include(request, response);;
	}
}
}
