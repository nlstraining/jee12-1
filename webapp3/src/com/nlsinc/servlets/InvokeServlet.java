package com.nlsinc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
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
		String user = (request.getParameter("user"));   //  for registration the user must be existing user
		String password = (request.getParameter("password"));
		
		// to verify with database we need to connect to db 
		// for this we need db connection properites declared in web.xml file 
		// the data in <init-params> will be available through a framework object ServletConfig
		
		ServletConfig config = getServletConfig();
		
		String url = config.getInitParameter("url");
		String dbUser = config.getInitParameter("username");
		String dbPwd = config.getInitParameter("password");
		PrintWriter out = response.getWriter();
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	         //out.println("connected to db..");
			
			Statement st = con.createStatement();
			String sql = "select * from registration where username='"+user+"' and password='"+ password+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
				out.println("welcome");
			else
				out.println("User not found");
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
