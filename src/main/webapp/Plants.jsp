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
				<th scope ="col">S.NO</th>
				<th scope="col">PLANT NAME </th> 
				<th scope="col">PRICE (Rs) </th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Plant> plantList =PlantData.getPlants() ;
												int i=0;
												for (Plant plant : plantList) {
													i++;
				%>
				<tr>
					<td><%=i %>
		            <td><%=plant.getPlantName()%> </td> 
		            <td>Rs.<%=plant.getPrice() %> </td>
		        </tr>
				<%} %>
			</tbody>
		</table>
	</main>
</body>
</html>
