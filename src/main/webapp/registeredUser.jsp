<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.User"%>
<%@page import="in.karthika.dao.UserData"%>
<html lang="en">
<head>
<title>Registered User</title>
</head>
<style>
tr, td {
  border-bottom: 1px solid #ddd;
  padding: 15px;
  text-align: center;  
}
tr:nth-child(even){background-color: #f2f2f2;}
tr:hover {background-color: #ddd;}
th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>All Registered User Details</h3>
		<form action="LoginUserServlet" method="post">
			<table class="table table-bordered">
				<caption>User</caption>
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
