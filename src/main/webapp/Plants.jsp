<%@page import="java.util.List"%>
<%@page import="in.karthika.service.PlantContainer"%>
<%@page import="in.karthika.service.Plants"%>
<html>
<head>
<title>Plants</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Plant Stock</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
				<th>S.NO</th>
				<th>PLANT NAME </th> 
				<th>PRICE (Rs) </th>
				</tr>
			</thead>
			<tbody>
				<%
				List<PlantContainer> plantList =Plants.getPlants() ;
				int i=0;
				for (PlantContainer plant : plantList) {
					i++;
				%>
				<tr>
					<td><%=i %>
		            <td><%=plant.plantName %> </td> 
		            <td>Rs.<%=plant.price %> </td>
		        </tr>
				<%} %>
			</tbody>
		</table>
	</main>
</body>
</html>
