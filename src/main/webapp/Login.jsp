<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>User Login</h3>
		<form action="LoginUserServlet" method="post">
			<table>
				<caption>Login</caption>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="userId" id="userId"
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
		<h3>Admin Login</h3>
		<form action="LoginAdminServlet" method="post">
			<table>
				<caption>AdminLogin</caption>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="userId" id="userId"
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD</th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
	</main>
</body>
</html>
