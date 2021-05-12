<!DOCTYPE html>
<%@page import="in.karthika.service.UserManager"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String repassword = request.getParameter("rePassword");
boolean insert=false;
if(password.equals(repassword)){
	insert = UserManager.addUser(username, password);
}
if(insert){
	response.sendRedirect("Login.jsp");
}
else{
	out.println("Invalid Credentials");
	String message = "Invalid Credentials";
	response.sendRedirect("Register.jsp?errorMessage="+message);
}
%>
<br><a href="adminLogin.jsp">click to retry again</a>
</body>
</html>