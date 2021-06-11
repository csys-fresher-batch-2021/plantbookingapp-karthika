<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Bill"%>
<%@page import="in.karthika.dao.BillData"%>
<html lang="en">
<head>
<title>BILL DETAILS</title>
</head>
<style>
th, td {
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
		<table class="table table-bordered">
			<caption>Bill Details</caption>
			<thead>
				<tr>
					<th scope="col">USER ID</th>
					<th scope="col">NAME</th>
					<th scope="col">CONTACT NUMBER</th>
					<th scope="col">ORDER DATE</th>
					<th scope="col">DELIVERY DATE</th>
					<th scope="col">BILL</th>
					<th scope="col">GST</th>
					<th scope="col">FINAL BILL</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Bill totalBill : BillData.billDetails()) {
				%>
				<tr>
					<td><%=totalBill.getOrderId()%></td>
					<td><%=totalBill.getCustomerName()%></td>
					<td><%=totalBill.getMobileNumber()%></td>
					<td><%=totalBill.getOrderData()%></td>
					<td><%=totalBill.getDeliveryDate()%></td>
					<td><%=totalBill.getTotalBill()%></td>
					<td><%=totalBill.getGst()%></td>
					<td><%=totalBill.getFinalBill()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a class="btn btn-success" href="Adminpage.jsp">BACK</a>
	</main>
</body>
</html>