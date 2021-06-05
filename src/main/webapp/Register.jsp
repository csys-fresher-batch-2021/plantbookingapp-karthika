<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Register</h3>
		<form action="UserRegisterServlet" method="post">
			<table>
				<caption>Register</caption>
				<tr>
					<th scope="col">NAME</th>
					<td><input type="text" name="userName" id="userName"
						onchange="nameValidate()" placeholder="Enter user name" required
						autofocus></td>
				</tr>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" name="mobileNumber" id="mobileNumber"
						onchange="phonenumber()" placeholder="Enter your phone number"
						required></td>
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
			<button type="submit" onclick="passcheck()">SUBMIT</button>
		</form>
		<%
			String message = (String)session.getAttribute("Message");
			if (message != null && message.equalsIgnoreCase("User is already exist")) {%>
				<p  class="text-danger"><%=message %> </p>
			<%}
			%>
		<script>
			function nameValidate() {
				let valid = false;
				let name = document.querySelector("#userName").value;
				if (name.charCodeAt(0) == 32) {
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

			function passcheck() {
				let password1 = document.querySelector("#password1").value;
				let password2 = document.querySelector("#password2").value;
				if (password1.length == 8 && password2.length == 8) {

				} else {
					alert("Invalid Password");
					event.preventDefault();
				}
				if (password1 == password2) {

				} else {
					alert("Password and confirm password should be same");
					event.preventDefault();
				}
			}
		</script>
	</main>
</body>
</html>
