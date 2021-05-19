<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Register</h3>
		<form action="RegisterServlet" method="post">
			<table>
				<caption>Register</caption>
				<tr>
					<th scope="col">NAME</th>
					<td><input type="text" name="userName" id="userName"
						placeholder="Enter user name" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="mobileNumber" id="mobileNumber"
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="password1" id="password1"
						placeholder="Enter password" required></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER PASSWORD</th>
					<td><input type="password" name="password2" id="password2"
						placeholder="Re-Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
	</main>
</body>
</html>
