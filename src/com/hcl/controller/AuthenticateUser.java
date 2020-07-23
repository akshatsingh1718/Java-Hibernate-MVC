package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AuthenticateUser")
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AuthenticateUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// username and password from LoginForm
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// username and Password to be checked with
		final String validatedUsername = "akshat";
		final String validatedPassword = "root";
		
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		// if user is authenticated
		if(username.equals(validatedUsername) && password.equals(validatedPassword)) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("index.jsp");
		}
		// if user is not authenticated
		else {
			out.print("<h2>You are not authorized</h2>");
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}
