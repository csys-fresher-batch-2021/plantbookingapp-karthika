<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
</head>
<style>
form {
	border: 3px solid #f1f1f1;
	align: center;
}

img {
	border: 3px solid #f1f1f1;
	align: center;
}

input[type=number], input[type=text], input[type=password] {
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
						<strong>Register</strong>
					</h3>
					<form action="UserRegisterServlet" method="post">

						<div class="container">
							<label><strong>NAME</strong></label> <input type="text" name="userName"
								id="userName" onchange="nameValidate()"
								placeholder="Enter user name" required autofocus> <label><strong>PHONE
									NUMBER</strong></label> <input type="number" name="mobileNumber"
								id="mobileNumber" onchange="phonenumber()"
								placeholder="Enter your phone number" required> <label><strong>PASSWORD</strong></label>
							<input type="password" name="password1" id="password1"
								placeholder="Enter password" required> <label><strong>RE-
									ENTER PASSWORD</strong></label><input type="password" name="password2"
								id="password2" placeholder="Re-Enter password" required>

							<button type="submit" onclick="checkall()">SUBMIT</button>
							<br /> <a href="Login.jsp">Already Registered?</a>
						</div>
					</form>
				</div>
				<div class="col-sm">
					<div class="container">
						<img src="plant.jpg" alt="plant"  width="500" height="500">
					</div>
				</div>
			</div>
		</div>

		<%
		String message = (String) session.getAttribute("Message");
		if (message != null && message.equalsIgnoreCase("User already exists")) {
		%>
		<p class="text-danger"><%=message%>
		</p>
		<%
		}
		%>
		<script>
			function nameValidate() {
				let valid = false;
				let name = document.querySelector("#userName").value;
				if (name.charCodeAt(0) == 32 && name.length() > 4) {
					valid = true;
				} else {
					for (let i = 0; i < name.length; i++) {
						if (!(name.charCodeAt(i) >= 65
								&& name.charCodeAt(i) <= 90
								|| name.charCodeAt(i) >= 97
								&& name.charCodeAt(i) <= 122 || name
								.charCodeAt(i) == 32)) {
							valid = true;
						}
					}
				}
				if (valid) {
					alert("Invalid Name");
					event.preventDefault();
				}
			}

			function phonenumber() {
				let mobileNumber = document.querySelector("#mobileNumber").value;
				if (mobileNumber.trim().length == 10) {

				} else {
					alert("Incorrect Mobile Number");
					event.preventDefault();
				}
			}

			function checkall() {
				let password1 = document.querySelector('#password1').value;
				let password2 = document.querySelector('#password2').value;
				let name = document.querySelector('#userName').value;
				let phonenumber = document.querySelector('#mobileNumber').value;
				if (password1.length == 0 || password2.length == 0
						|| name.length == 0 || phonenumber.length == 0) {
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
	</main>
</body>
</html>
