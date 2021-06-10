<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ADD PLANTS</title>
</head>
<style>
form {
	border: 3px solid #f1f1f1;
	align: center;
}

input[type=number], input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

h2 {
	font-color: green;
	font-size: 24px;
	line-height: 40px;
	text-align: center;
	font-size: 24px;
}

h3 {
	font-size: 24px;
	line-height: 40px;
	text-align: center;
}

select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.container {
	float: center;
	padding: 16px;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<h3>
						<b>Add Plant</b>
					</h3>
					<form action="PlantAddServlet" method="post">
						<div class="container">
							<label><b>Plant Name</b></label><input type="text"
								name="plantname" id="plantname" onchange="plantNameValidate()"
								required autofocus> <label><b>Price</b></label><input
								type="text" name="price" id="price" onchange="priceCheck()"
								required> <label><b>Plant Type</b></label> <select
								name="type" id="type" class="selection">
								<option value="tree">Tree</option>
								<option value="plant">Plant</option>
							</select> <label><b>Plant Category</b></label> <select name="category"
								id="category" class="selection">
								<option value="fruit">Fruit</option>
								<option value="vegetable">Vegetable</option>
								<option value="flower">Flower</option>
								<option value="medicinal">Medicinal</option>
							</select>
							
							<button type="submit">SUBMIT</button>
							<br/>
								<a  href="Adminpage.jsp">BACK</a>
						</div>
					</form>
						</div>
					<div class="col-sm">
						<div class="container">
						<img src="leaf.jpg" width="500" height="500">
						</div>
				

				</div>
			</div>
		</div>
		<br />
		<%
		String message = (String) session.getAttribute("Message");
		if (message != null) {
		%>
		<p class="text-danger"><%=message%></p>
		<%
		}
		%>
		<script>
			function plantNameValidate() {
				let valid = false;
				let name = document.querySelector("#plantname").value;
				if (name.charCodeAt(0) == 32) {
					valid = true;
				} else {
					for (let i = 0; i < name.length; i++) {
						if (!(name.charCodeAt(i) >= 65
								&& name.charCodeAt(i) <= 90
								|| name.charCodeAt(i) >= 97
								&& name.charCodeAt(i) <= 122 || name
								.charCodeAt(i) == 32)) {
							valid = true;
						}
					}
				}
				if (valid) {
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