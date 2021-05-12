<!DOCTYPE html>
<%@page import="in.karthika.service.UserManager"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
boolean isValid = UserManager.login(username, password);
if(isValid){
	response.sendRedirect("Plants.jsp");
}
else{
	out.println("Invalid Credentials");
	String message = "Invalid Credentials";
	response.sendRedirect("Login.jsp?errorMessage="+message);
}
%>
</body>
</html>