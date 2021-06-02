package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.exceptions.InvalidNumberException;
import in.karthika.exceptions.NumberCannotBeNegativeException;
import in.karthika.service.CartService;

/**
 * Servlet implementation class AddQuantity
 */
@WebServlet("/AddQuantity")
public class AddQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String quantity = request.getParameter("quantity");
			HttpSession session = request.getSession();
			String plantName = (String) session.getAttribute("plantName");
			boolean isAdd = false;

			isAdd = CartService.addQauantity(quantity, plantName);
			if (isAdd) {
				response.sendRedirect("displayCart.jsp?Quantity added successfully added");
			} else {

				String errorMessage = "Unable to add to cart";
				response.sendRedirect("displayCart.jsp?errorMessage=" + errorMessage);
			}
		} catch (NumberCannotBeNegativeException | InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
