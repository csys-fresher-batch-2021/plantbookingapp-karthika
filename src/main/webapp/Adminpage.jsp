<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin page</title>
</head>
<style>
form {
	border: 3px solid #f1f1f1;
	align: center;
	height: 400px;
	width: 400px;
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

.buttonstyle {
	color: white;
	padding: 40px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	height: 75px;
}

a:hover {
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
		<br />
		<br />
		<h3>
			<b>WELCOME TO GREENKART</b>
		</h3>
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<form>
						<div class="container">
							<a class="btn btn-primary buttonstyle" href="addPlant.jsp"><b>ADD
								PLANT</b></a>
								
							 <a class="btn btn-secondary buttonstyle"
								href="registeredUser.jsp"><b>DISPLAY ALL USERS</b></a>
								
							 <a
								class="btn btn-danger buttonstyle" href="plant.jsp"><b>DELETE
								PLANTS</b></a>
								
							 <a class="btn btn-success buttonstyle"
								href="displayAllUsersBillDetails.jsp"><b>VIEW ORDER DETAILS</b></a>
						</div>
					</form>
				</div>
				<div class="col-sm">
					<div class="container">
						<img src="tree2.jpg" width="400" height="400">
					</div>
				</div>
			</div>
		</div>
		

	</main>
</body>
</html>
