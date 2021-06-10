<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Password Change</title>
</head>
<style>
form {
	border: 3px solid #f1f1f1;
	align: center;
	height: 400px;
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

p {
	font-color: green
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
			<b>WELCOME TO GREENKART</b>
		</h2>
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<h3>
						<b>User Login</b>
					</h3>
					<form action="PasswordChangeServlet">
						<div class="container">
							<label><b>MOBILE NUMBER</b></label> <input type="number"
								id="phoneNumber" name="phoneNumber" onchange="phonenumber()"
								placeholder="Enter Mobile Number" required autofocus> <label><b>NEW
									PASSWORD</b></label> <input type="password" id="password1" name="password1"
								placeholder="Enter Password" required> <label><b>RE-ENTER
									NEW PASSWORD</b></label> <input type="password" id="password2"
								name="password2" placeholder="Re-Enter Password" required>

							<button type="submit"
								onclick="checkall()">SUBMIT</button>
							<br /> <a href="login.jsp">Back</a>
						</div>
					</form>
				</div>
				<div class="col-sm"><div class="container">
				<img src="tree.jpg" width="450" height="450">
				</div></div>
			</div>
		</div>
		<script>
			function phonenumber() {
				let mobileNumber = document.querySelector("#phoneNumber").value;
				if (mobileNumber.trim().length == 10) {

				} else {
					alert("Incorrect Mobile Number");
					event.preventDefault();
				}
			}

			function checkall() {
				let password1 = document.querySelector('#password1').value;
				let password2 = document.querySelector('#password2').value;
				let phonenumber = document.querySelector('#phoneNumber').value;
				if (password1.length == 0 || password2.length == 0
						|| phonenumber.length == 0) {
					alert("Enter All Details");
				} else {
					if (password1.length == 8 && password2.length == 8
							&& password1 == password2) {

					} else {
						alert("Invalid Password");
						event.preventDefault();
					}
				}

			}
		</script>
		<%
		String message = (String) session.getAttribute("Message");
		if (message != null && message.equalsIgnoreCase("User is not registered")) {
		%>
		<p class="text-danger"><%=message%></p>
		<%
		}
		%>
	</main>
</body>
</html>