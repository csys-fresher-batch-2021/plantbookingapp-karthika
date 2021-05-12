<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<h2>Welcome</h2>
<h3><strong>LOGIN</strong></h3>
<form action="LoginValidate.jsp" method="get">
<table>
<caption>login</caption>
<tr><th scope="col">Mobile Number</th>
<td><input type="text" name="username" id="username" placeholder="User ID" required autofocus></td></tr>
<tr><th scope="col">Password</th>
<td><input type ="password" name="password" id="password" placeholder="password" required ></td></tr></table>
<br/>
<button class="btn btn-primary">Login</button><br>
</form>
</main>
</body>
</html>
