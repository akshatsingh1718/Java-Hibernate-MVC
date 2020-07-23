package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hcl.dao.EmployeeDAOImpl;
import com.hcl.model.Employee;

@WebServlet("/UpdateEmployeeServ")
public class UpdateEmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateEmployeeServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee e = dao.getEmployeeById(empid);
		request.setAttribute("employee", e);
		RequestDispatcher rd = request.getRequestDispatcher("updateEmployee.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int empid = Integer.parseInt(request.getParameter("empid"));
		String empName = request.getParameter("empName");
		String empCity = request.getParameter("empCity");
		long empSal = Long.parseLong(request.getParameter("empSal"));
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		boolean isUpdated = dao.update(empid, empName, empCity, empSal);
		if(isUpdated) {
				System.out.println("ISUpdated TRUE------------");
				out.print("<h1><span class='badge badge-pill badge-success'>Employee Updated Successfully!</span></h1>");
				request.getRequestDispatcher("index.jsp").include(request, response);;
			}else {
				System.out.println("ISUpdated False------------");
				out.print("<h1><span class='badge badge-pill badge-danger'>Employee Not Updated!</span></h1>");
				request.getRequestDispatcher("index.jsp").include(request, response);;
			}
	}
}
