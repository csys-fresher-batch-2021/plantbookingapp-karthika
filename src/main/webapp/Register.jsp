<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Welcome</h2>
<h3><strong>REGISTER</strong></h3>
<form action="RegisterValidate.jsp" method="get">
<table><tr><td>Mobile Number</td>
<td><input type="text" name="username" id="username" placeholder="User ID" required autofocus></td></tr>
<tr><td>Password</td>
<td><input type ="password" name="password" id="password" placeholder="password" required ></td></tr>
<tr><td>Re-Enter Password</td>
<td><input type ="password" name="rePassword" id="rePassword" placeholder="password" required ></td></tr></table>
<%
String errorMessage = request.getParameter("errorMessage");
if(errorMessage!=null){
	out.println("<font color='red'>"+errorMessage+"</font>");
}
%>
<br/>
<button class="btn btn-primary">Login</button><br>
</form>
</main>
</body>
</html>
