<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="in.karthika.model.Cart"%>
<%@page import="in.karthika.dao.CartData"%>
<html lang="en">
<head>
<title>CART</title>
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
				int j = 0;
				for (Cart cart : cartList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=cart.getPlantName()%></td>
					<td>Rs.<%=cart.getPrice()%></td>
					<%
					if (cart.getQuantity() > 0) {
						j++;
					%>
					<td><%=cart.getQuantity()%></td>
					<%
					} else {
					%><td>
						<form action="AddQuantity">
							<input type="text" id="quantity" name="quantity"
								placeholder="Quantity" required autofocus>
							<button class="btn btn-primary" type="submit">CONFIRM</button>
					</td>
					<td><a class="btn btn-primary"
						href="DeleteCartPlantServlet?plantName=<%=cart.getPlantName()%>">DELETE</a></td>
					<%
					session.setAttribute("plantName", cart.getPlantName());
					%>
					</form>
					<%
					}

					}
					%>


				</tr>
			</tbody>
		</table>
		<%
		if (cartList.size() == j) {
		%>
		<a class="btn btn-primary" href="plant.jsp">Want To Buy More
			Plants</a> <a class="btn btn-primary" href="PlaceOrderServlet">Place
			Order</a>
		<%
		} else {
		%>
		<h3>Please Enter Quantity</h3>

		<%
		}
		%>
	</main>
</body>
</html>
