<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.User"%>
<%@page import="in.karthika.dao.UserData"%>
<html lang="en">
<head>
<title>Registered User</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>All Registered User Details</h3>
		<form action="LoginUserServlet" method="post">
			<table class="table table-bordered">
				<caption>Our Stock</caption>
				<thead>
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">USER ID</th>
						<th scope="col">USER NAME</th>
						<th scope="col">MOBILE NUMBER</th>
						<th scope="col">PASSWORD</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<User> userList = UserData.userDetails();
					int i = 0;
					for (User user : userList) {
						i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><%=user.getUserId()%></td>
						<td><%=user.getName()%></td>
						<td><%=user.getPhoneNumber()%></td>
						<td><%=user.getPassWord()%></td>
						<%
						}
						%>
					
				</tbody>
			</table>
           <a class="btn btn-secondary" href="Adminpage.jsp">BACK</a>
		</form>
	</main>
</body>
</html>
