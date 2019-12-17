<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<h2 align="center">Home Page</h2>
	<h3 align="center">
		Welcome Dear:

		<%=request.getParameter("user")%>

	</h3>
	<h3 align="center">
		Now it is :
		<%=new java.util.Date()%>
		: in my location
	</h3>

	<b> <%
 	for (int i = 1; i <= 6; i++) {

 		out.println("i =" + i);
 	}
 %>

	</b>
	<br />

	<%
		for (int i = 1; i <= 6; i++) {
	%>
	       <h<%=i%> align='center'> Welcome to JSP WORLD </h<%=i%>>
	<%
		}
	%>
	<%
		for (int i = 6; i >= 1; i--) {
	%>
	       <h<%=i%> align='center'> Welcome to JSP WORLD </h<%=i%>>
	<%
		}
	%>
	
</body>
</html>