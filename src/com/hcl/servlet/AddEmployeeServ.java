package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import com.hcl.dao.EmployeeDAOImpl;
import com.hcl.model.Employee;


@WebServlet("/AddEmployeeServ")
public class AddEmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddEmployeeServ() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		long salary = Integer.parseInt(request.getParameter("salary"));
		int date = Integer.parseInt(request.getParameter("date"));
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));

		Date dob = new Date(date, month, year);
		Date joined = new Date();
		// Creating Employee Object
		Employee e = new Employee(dob, joined, name , city, salary);
		// Saving Employee Object in DB
		System.out.println("SAVING DATA------------");
		boolean  isSaved= dao.save(e);
		if(isSaved){
			System.out.println("ISSAVED TRUE------------");
			out.print("<h1><span class='badge badge-pill badge-success'>Employee Saved Successfully!</span></h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);;
		}else {
			System.out.println("ISSAVED False------------");
			out.print("<h1><span class='badge badge-pill badge-danger'>Employee Not Saved!</span></h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);;
		}
	}

}
