package com.hcl.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hcl.dao.EmployeeDAOImpl;
import com.hcl.model.Employee;


@WebServlet("/DisplayAnEmployeeServ")
public class DisplayAnEmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DisplayAnEmployeeServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Employee e = dao.getEmployeeById(empid);
		request.setAttribute("employee", e);
		RequestDispatcher rd = request.getRequestDispatcher("displayEmp.jsp");
		rd.forward(request, response);
	}

}
