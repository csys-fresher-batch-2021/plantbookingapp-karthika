<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Cart"%>
<%@page import="in.karthika.dao.CartData"%>
<html lang="en">
<head>
<title>Plants</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Your Cart</h3>
		<table class="table table-bordered">
			<caption>Cart</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">PLANT NAME</th>
					<th scope="col">PRICE (Rs)</th>
					<th scope="col">QUANTITY</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Cart> cartList = CartData.getCart();
				int i = 0;
				for (Cart cart : cartList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=cart.getPlantName()%></td>
					<td>Rs.<%=cart.getPrice()%></td>
					<td><input type="number" id="quantity" name="quantity" required autofocus></td>
					<%
					}
					%>
			</tbody>
		</table>
		<a class="btn btn-primary" href="AddQuantity"  >Place Order</a>
		<a class="btn btn-primary" href="plant.jsp">Want to buy more plants</a>
	</main>
</body>
</html>
