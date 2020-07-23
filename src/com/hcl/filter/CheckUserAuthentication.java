package com.hcl.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CheckUserAuthentication
 */
@WebFilter("/CheckUserAuthentication")
public class CheckUserAuthentication implements Filter {
	public CheckUserAuthentication() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		PrintWriter out = response.getWriter();
		HttpSession session  = httpRequest.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println("USERNAME "+ username);
		if(!(httpRequest.getRequestURI().contains("/MVCHibernate/AuthenticateUser"))) {
		if (!(httpRequest.getRequestURI().contains("/MVCHibernate/login.html"))){
			if (username == null) {
				httpResponse.sendRedirect("login.html");
			}
		}}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
