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
import java.util.List;

@WebServlet("/DisplayAllServ")
public class DisplayAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayAllServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		List<Employee> emplist = dao.getAllEmployees();
		request.setAttribute("emplist", emplist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAll.jsp");
		rd.forward(request, response);
	}
}
