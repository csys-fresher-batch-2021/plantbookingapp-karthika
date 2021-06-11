package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.BillService;
import in.karthika.service.CartService;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String phoneNumber = (String) session.getAttribute("PHONE_NUMBER");
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			CartService.storeAllOrderPlants(phoneNumber);
			boolean isAdd = BillService.storeBillDetails(phoneNumber, userName);
			if (isAdd) {
				response.sendRedirect("bill.jsp?Ordered Successful");
			} else {
				response.sendRedirect("displayCart.jsp?errorMessage=Can't Generated Bill");
			}
		} catch (Exception e) {
			response.sendRedirect("displayCart.jsp?errorMessage=Can't Generated Bill");
		}
	}

}
