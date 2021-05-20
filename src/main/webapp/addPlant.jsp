<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PLANTS</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Add Plant</h3>
		<form action="PlantAddServlet" method="post">
			<table>
				<caption>Add plants</caption>
				<tr>
					<th>Plant Name</th>
					<td><input type="text" name="plantname" id="plantname"
						required autofocus></td>
				</tr>
				<tr>
					<th>Price</th>
					<td><input type="text" name="price" id="price" required></td>
				</tr>
				<tr>
					<th>Plant Type</th>
					<td><select name="type" id="type">
							<option value="tree">Tree</option>
							<option value="plant">Plant</option>
							<option value="others">Others</option>
					</select></td>
				</tr>
				<tr>
					<th>Plant Category</th>
					<td><select name="category" id="category">
							<option value="fruit">Fruit</option>
							<option value="vegetable">Vegetable</option>
							<option value="flower">Flower</option>
							<option value="medicinal">Medicinal</option>
					</select></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
	</main>
</body>
</html>