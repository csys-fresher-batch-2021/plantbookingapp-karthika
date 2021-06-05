<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<h3>User Login</h3>
					<form action="LoginUserServlet" method="post">
						<table>
							<caption>Login</caption>
							<tr>
								<th scope="col">MOBILE NUMBER</th>
								<td><input type="number" name="userId" id="userId"
									onchange="phonenumber1()" placeholder="Enter your phone number"
									required autofocus></td>
							</tr>
							<tr>
								<th scope="col">PASSWORD</th>
								<td><input type="password" name="password" id="password"
									placeholder="Enter password" required></td>
							</tr>
						</table>
						<a href="passwordChange.jsp">Forget Password?</a>
						<button type="submit" onclick="passcheck1()">SUBMIT</button>
					</form>
				</div>
				<script>
					function phonenumber1() {
						let mobileNumber = document.querySelector("#userId").value;
						if (mobileNumber.trim().length == 10) {

						} else {
							alert("Incorrect Mobile Number");
							event.preventDefault();
						}
					}

					function passcheck1() {
						let password = document.querySelector("#password").value;
						if (password.length == 8) {

						} else {
							alert("Invalid Password");
							event.preventDefault();
						}
					}
				</script>
				<div class="col-sm-4">
					<h3>Admin Login</h3>
					<form action="LoginAdminServlet" method="post">
						<table>
							<caption>AdminLogin</caption>
							<tr>
								<th scope="col">MOBILE NUMBER</th>
								<td><input type="number" name="adminId" id="adminId"
									onchange="phonenumber2()" placeholder="Enter your phone number"
									required></td>
							</tr>
							<tr>
								<th scope="col">PASSWORD</th>
								<td><input type="password" name="passcode" id="passcode"
									placeholder="Enter password" required></td>
							</tr>
						</table>
						<button type="submit" onclick="passcheck2()">SUBMIT</button>
					</form>
					<script>
						function phonenumber2() {
							let mobileNumber = document
									.querySelector("#adminId").value;
							if (mobileNumber.trim().length == 10) {

							} else {
								alert("Incorrect Mobile Number");
								event.preventDefault();
							}
						}

						function passcheck2() {
							let password = document.querySelector("#passcode").value;
							if (password.trim().length == 8) {

							} else {
								alert("Invalid Password");
								event.preventDefault();
							}
						}
					</script>
				</div>
			</div>
		</div>
		<%
		String message = (String) session.getAttribute("Message");
		if (message != null && message.equalsIgnoreCase("Invalid Login Credentials")) {
		%>
		<p class="text-danger"><%=message%></p>
		<%
		}
		%>
	</main>
</body>
</html>
