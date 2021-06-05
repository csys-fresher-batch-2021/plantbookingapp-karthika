<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Password Change</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="PasswordChangeServlet">
			<table>
				<caption>Password Change</caption>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" id="phoneNumber" name="phoneNumber" onchange="phonenumber()"
						placeholder="Enter Mobile Number" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">NEW PASSWORD</th>
					<td><input type="password" id="password1" name="password1"
						placeholder="Enter Password" required></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER NEW PASSWORD</th>
					<td><input type="password" id="password2" name="password2"
						placeholder="Re-Enter Password" required></td>
				</tr>
			</table>
			<button type="submit" onclick="passcheck()">SUBMIT</button>
		</form>
		<script>
			function phonenumber() {
				let mobileNumber = document.querySelector("#phoneNumber").value;
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