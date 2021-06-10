<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Plant"%>
<%@page import="in.karthika.dao.PlantData"%>
<html lang="en">
<head>
<title>Plants</title>
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
<%session.removeAttribute("FILTER"); %>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Plant Stock</h3>
		<%
		String message = (String) session.getAttribute("Message");
		if (message != null) {
		%>
		<p class="text-danger"><%=message%></p>
		<%
		}
		%>
		<table class="table table-bordered">
			<caption>Our Stock</caption>
			<thead>
				<tr >
					<th scope="col">S.NO</th>
					<th scope="col">PLANT NAME</th>
					<th scope="col">PRICE (Rs)</th>
				</tr>
			</thead>
			<tbody>
				<%
				String role = (String) session.getAttribute("ROLE");
				List<Plant> plantList = PlantData.plantDetails();
				int i = 0;
				for (Plant plant : plantList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=plant.getPlantName()%></td>
					<td>Rs.<%=plant.getPrice()%></td>
					<%
					if (role != null) {
						if (role.equalsIgnoreCase("ADMIN")) {
					%>
					<td><a class="btn btn-danger"
						href="DeletePlantServlet?plantName=<%=plant.getPlantName()%>">DELETE</a></td>
					<%
					} else if (role.equalsIgnoreCase("USER")) {
					%>

					<td><a class="btn btn-success"
						href="AddCartServlet?plantName=<%=plant.getPlantName()%>">ADD
							TO CART</a></td>
					<%
					}
					}
					}
					%>
				
			</tbody>
		</table>
	</main>
</body>
</html>
