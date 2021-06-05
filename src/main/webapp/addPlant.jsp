<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
					<th scope="col">Plant Name</th>
					<td><input type="text" name="plantname" id="plantname"
						onchange="plantNameValidate()" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">Price</th>
					<td><input type="text" name="price" id="price"
						onchange="priceCheck()" required></td>
				</tr>
				<tr>
					<th scope="col">Plant Type</th>
					<td><select name="type" id="type">
							<option value="tree">Tree</option>
							<option value="plant">Plant</option>
					</select></td>
				</tr>
				<tr>
					<th scope="col">Plant Category</th>
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
		<a class="btn btn-secondary" href="Adminpage.jsp">BACK</a>
		<script>
			function plantNameValidate() {
				let valid=false;
				let name = document.querySelector("#plantname").value;
		        if(name.charCodeAt(0) == 32){
		            valid = true;
		        }else{
		        for(let i = 0; i < name.length; i++){
		            if(!(name.charCodeAt(i) >= 65 && name.charCodeAt(i) <= 90       
		             || name.charCodeAt(i) >= 97 && name.charCodeAt(i) <= 122
		             || name.charCodeAt(i) == 32)){
		                valid = true;
		             }
		        }
		        }
		        if(valid){
		        	alert("Invalid plant Name");
		        }
			}

			function priceCheck() {
				let cost = document.querySelector("#price").value;
				if (cost > 0) {

				} else {
					alert("Invalid Cost");
					event.preventDefault();
				}
			}
		</script>
	</main>
</body>
</html>