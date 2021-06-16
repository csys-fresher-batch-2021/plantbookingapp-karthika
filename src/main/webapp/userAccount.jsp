<!DOCTYPE html>
<html lang="en">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<head>
<title>Plant</title>
</head>
<style>
.divborder{
    border-style: outset;
	padding: 15px;
	text-align: center;
}
tr, td {
	border-bottom: 1px solid #ddd;
	padding: 15px;
	text-align: center;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}


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
		<%
		String phoneNumber = (String) session.getAttribute("PHONE_NUMBER");
		String customerName = (String) session.getAttribute("LOGGED_IN_USER");
		%>
		<br />
		<br />
		<div class="container">
			<div class="row">
				<div class="col divborder"><label><strong>NAME : <%=customerName %></strong></label></div>
				<div class="col divborder"><label><strong>PHONE NUMBER : <%=phoneNumber %></strong></label></div>
			</div>
		</div><br/>

		<table id="orderTable" class="table table-bordered"></table>

		<a href="#" class="btn btn-info" onclick="getdetails()"
			class="form-control form-control-sm">MY ORDERS</a> 
			
			<a href="plant.jsp" class="btn btn-secondary" 
			class="form-control form-control-sm">BACK</a> 
			
			<label id="mesage" > </label>
			
			<input
			type="hidden" id="mobileNumber" name="mobileNumber"
			value=<%=phoneNumber%>></input>


		<script type="text/javascript">

		
			function getdetails() {
				event.preventDefault();
				console.log("geting details");
				let number= document.getElementById("mobileNumber").value;
				let params = 'phoneNumber='+number;
				let url = "GetUserAccountDetails?"+params;
				fetch(url).then(res=> res.json()).then(res=>{
					let data = res;
					console.log(res);
					displayAccountDetails(data);
				});
			

			}
			
			function displayAccountDetails(data){
				if(data.length==0){
					let msg="YOU ARE NOT PLACED ANY ORDERS";
					document.getElementById("mesage").innerHTML= msg;
				}
				else{
				var tableData = '<thead><tr><th>SNO</th><th>PLANT NAME</th><th>ORDER DATE</th><th>PRICE</th><th>QUANTITY</th><th>TOTAL PRICE</th></tr></thead>'
					tableData+= '<tbody>'
				    for(i = 0;i < data.length; i++){
				    	tableData+= '<tr>';
				    	tableData+= '<td>' + (parseInt(i)+1) + '</td>';	
				    	tableData+= '<td>' +  data[i].plantName + '</td>';
				    	tableData+= '<td>' +  moment(data[i].orderDate).format('DD-MM-YYYY'); + '</td>';
				    	tableData+= '<td>' +  data[i].price     + '</td>';
				    	tableData+= '<td>' +  data[i].quantity  + '</td>';
				    	tableData+= '<td>' +  data[i].amountForAplant + '</td>';
				    	tableData+= '</tr>';   
				    }
					tableData+='</tbody>';
				    document.getElementById("orderTable").innerHTML = tableData;			
				
			}
			}
			
		</script>
	</main>
</body>

</html>