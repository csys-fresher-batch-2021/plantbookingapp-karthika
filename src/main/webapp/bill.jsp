<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Bill"%>
<%@page import="in.karthika.model.Cart"%>
<%@page import="in.karthika.dao.CartData"%>
<%@page import="in.karthika.dao.BillData"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<html lang="en">
<head>
<title>BILL</title>
</head>
<style>
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
	<%
	String phoneNumber = (String) session.getAttribute("PHONE_NUMBER");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<table class="table table-bordered">
			<caption>Cart</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">PLANT NAME</th>
					<th scope="col">PRICE (Rs)</th>
					<th scope="col">QUANTITY</th>
					<th scope="col">PRICE FOR A PLANT</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Cart> cartList = CartData.getCart();
				int i = 0;
				int j = 0;
				for (Cart cart : cartList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=cart.getPlantName()%></td>
					<td>Rs.<%=cart.getPrice()%></td>
					<td><%=cart.getQuantity()%></td>
					<td><%=cart.getAmountForAplant()%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>

		<h3>BILL DETAILS</h3>
		<table class="table table-bordered">
			<caption>BILL</caption>
			<tbody>
				<%
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				for (Bill totalBill : BillData.billDetails()) {
					if (phoneNumber != null) {
						long number = Long.parseLong(phoneNumber);
						if (number == totalBill.getMobileNumber() && LocalDate.now().equals(totalBill.getOrderData())) {
				%>
				<tr>
					<th scope="col">ORDER ID</th>
					<td><%=totalBill.getOrderId()%></td>
				</tr>
				<tr>
					<th scope="col">CUSTOMER NAME</th>
					<td><%=totalBill.getCustomerName()%></td>
				</tr>
				<tr>
					<th scope="col">PHONE NUMBER</th>
					<td><%=totalBill.getMobileNumber()%></td>
				</tr>
				<tr>
					<th scope="col">ORDERED DATE</th>
					<td><%=formatter.format(totalBill.getOrderData())%></td>
				</tr>
				<tr>
					<th scope="col">DELIVERY DATE</th>
					<td><%=formatter.format(totalBill.getDeliveryDate())%></td>
				</tr>
				<tr>
					<th scope="col">TOTAL BILL</th>
					<td>RS.<%=totalBill.getTotalBill()%></td>
				</tr>
				<tr>
					<th scope="col">GST</th>
					<td><%=totalBill.getGst()%>%</td>
				</tr>
				<tr>
					<th scope="col">FINAL BILL</th>
					<td>RS.<%=totalBill.getFinalBill()%></td>
				</tr>
				<%
				break;
				}
				}
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>
