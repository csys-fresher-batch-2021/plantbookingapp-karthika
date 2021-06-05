<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Bill"%>
<%@page import="in.karthika.model.Cart"%>
<%@page import="in.karthika.dao.CartData"%>
<%@page import="in.karthika.dao.BillData"%>
<html lang="en">
<head>
<title>BILL</title>
</head>
<body>
<%String phoneNumber = (String) session.getAttribute("PHONE_NUMBER"); %>
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
					</tr></tbody><%} %></table>
	
		<h3>BILL DETAILS</h3>
		<table class="table table-bordered">
			<caption>BILL</caption>
			<tbody>
				<%
				for(Bill totalBill:BillData.billDetails()){
					String mobileNumber=String.valueOf(totalBill.getMobileNumber());
					if(phoneNumber.equalsIgnoreCase(mobileNumber) && phoneNumber!=null){%>
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
					<td><%=totalBill.getOrderData()%></td>
				</tr>
				<tr>
					<th scope="col">DELIVERY DATE</th>
					<td><%=totalBill.getDeliveryDate()%></td>
				</tr>
				<tr>
					<th scope="col">TOTAL BILL</th>
					<td>RS.<%=totalBill.getTotalBill()%></td>
				</tr>
				<tr>
					<th scope="col">GST</th>
					<td><%=totalBill.getGst() %>%</td>
				</tr>
				<tr>
					<th scope="col">FINAL BILL</th>
					<td>RS.<%=totalBill.getFinalBill() %></td>
				</tr>
				<% break;}} %>
			</tbody>
		</table>
	</main>
</body>
</html>
