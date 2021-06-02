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
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>TOTAL BILL</h3>
		<table class="table table-bordered">
			<caption>BILL</caption>
			<tbody>
				<%
				String phoneNumber = (String) session.getAttribute("PHONE_NUMBER");
				List<Bill> bill=BillData.getBill();
				Bill total=new Bill();
				int i = 0;
				for(Bill totalBill:bill){
					String mobileNumber=String.valueOf(totalBill.getMobileNumber());
					if(phoneNumber.equalsIgnoreCase(mobileNumber)){%>
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
					<td><%=totalBill.getTotalBill()%></td>
				</tr>
				<%}} %>
			</tbody>
		</table>
	</main>
</body>
</html>
