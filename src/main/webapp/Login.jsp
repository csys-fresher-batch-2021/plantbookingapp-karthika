<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
</head>
<style>
form {
	border: 3px solid #f1f1f1;
	align:center;
	height:300px;
}

input[type=number], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}


h2 {
	font-color: green;
	font-size: 24px;
	line-height: 40px;
	text-align: center;
	font-size: 24px;
}

h3 {
	font-size: 24px;
	line-height: 40px;
	text-align: center;
}

p{
   font-color:green
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.container {
	float: center;
	padding: 16px;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>
			<strong>WELCOME TO GREENKART</strong>
		</h2>
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<h3>
						<strong>User Login</strong>
					</h3>
					<form action="LoginUserServlet" method="post">
						<div class="container">
							<label><strong>MOBILE NUMBER</strong></label> <input type="number"
								name="userId" id="userId" onchange="phonenumber1()"
								placeholder="Enter your phone number" required autofocus>

							<label><strong>PASSWORD</strong></label> <input type="password"
								name="password" id="password" placeholder="Enter password"
								required>

							<button type="submit" onclick="passcheck1()">Login</button>
							<br /> <a href="passwordChange.jsp">Forget Password?</a>
					
						</div>
					</form>
					<script>
						function phonenumber1() {
							let mobileNumber = document
									.querySelector("#userId").value;
							if (mobileNumber.trim().length == 10) {

							} else {
								alert("Incorrect Mobile Number");
								event.preventDefault();
							}
						}

						function passcheck1() {
							let password = document.querySelector("#password").value;
							let mobileNumber = document
									.querySelector("#userId").value;
							if (password.length == 0
									|| mobileNumber.length == 0) {
								alert("Enter all details");
							} else {
								if (password.length == 8) {

								} else {
									alert("Invalid Password");
									event.preventDefault();
								}
							}
						}
					</script>
				</div>

				<div class="col-sm">
					<h3><strong>Admin Login</strong></h3>
					<form action="LoginAdminServlet" method="post">
						<div class="container">
							<label><strong>MOBILE NUMBER</strong></label> <input type="number"
								name="adminId" id="adminId" onchange="phonenumber2()"
								placeholder="Enter your phone number" required autofocus>

							<label><strong>PASSWORD</strong></label> <input type="password"
								name="passcode" id="passcode" placeholder="Enter password"
								required>

							<button type="submit" onclick="passcheck2()">Login</button>
							<br />

						</div>

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
							let mobileNumber = document
									.querySelector("#adminId").value;
							if (password.length == 0
									|| mobileNumber.length == 0) {
								alert("Enter all details");

							} else {
								if (password.length == 8) {

								} else {
									alert("Invalid Password");
									event.preventDefault();
								}
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
