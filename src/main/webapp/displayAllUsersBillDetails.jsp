<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Bill"%>
<%@page import="in.karthika.dao.BillData"%>
<html lang="en">
<head>
<title>BILL DETAILS</title>
</head>
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