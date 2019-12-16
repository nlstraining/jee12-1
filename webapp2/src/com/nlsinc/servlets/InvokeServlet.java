package com.nlsinc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InvokeServlet
 */
public class InvokeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvokeServlet() {
		super();

	}

	// Browser sends a request --> Server --> Delegates to Container --> Invokes
	// appr Servlet-- > sends response
	// HTTP GET is mapped to doGet method only
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h2 style='text-align:center' > This is from  doGet() of servlet..... </h2>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		char op = request.getParameter("op").charAt(0);
		int result = 0;
		switch (op) {

		case '+':
			result = n1 + n2;
			break;

		case '*':
			result = n1 * n2;
			break;
		}
		PrintWriter out = response.getWriter();
		out.println(n1 + "," + op + "," + n2 + " = " + result);
	}

}
