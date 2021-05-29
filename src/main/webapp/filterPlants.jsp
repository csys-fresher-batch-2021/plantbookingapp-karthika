<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Plant"%>
<%@page import="in.karthika.dao.PlantData"%>
<html lang="en">
<head>
<title>Plants</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Plant Stock</h3>
		<table class="table table-bordered">
			<caption>Our Stock</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">PLANT NAME</th>
					<th scope="col">PRICE (Rs)</th>
				</tr>
			</thead>
			<tbody>
				<%
				String role = (String) session.getAttribute("ROLE");
				List<Plant> plantList = PlantData.getFilterPlants();
				int i = 0;
				for (Plant plant : plantList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=plant.getPlantName()%></td>
					<td>Rs.<%=plant.getPrice()%></td>
					<%
					if (role.equalsIgnoreCase("ADMIN")) {
					%>
					<td><a class="btn btn-primary"
						href="DeletePlantServlet?plantName=<%=plant.getPlantName()%>">DELETE</a></td>
					<%
					} else if (role.equalsIgnoreCase("USER")) {
					%>

					<td><a class="btn btn-primary"
						href="AddCartServlet?plantName=<%=plant.getPlantName()%>">ADD
							TO CART</a></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>
	</main>
</body>
</html>