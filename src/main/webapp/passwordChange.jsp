<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="PasswordChangeServlet">
			<table>
				<tr>
					<th scope="col">MOBILE NUMBER</th>
					<td><input type="number" id="phoneNumber" name="phoneNumber"
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
			<button type="submit">SUBMIT</button>
		</form>
	</main>

</body>
</html>