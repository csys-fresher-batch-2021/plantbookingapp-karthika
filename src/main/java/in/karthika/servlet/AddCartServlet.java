package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.karthika.service.CartService;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String plantName = request.getParameter("plantName");
			boolean isAddtoCart = CartService.addtoCart(plantName);
			if (isAddtoCart) {
				response.sendRedirect("displayCart.jsp");
			} else {

				String errorMessage = "Unable to add to cart";
				response.sendRedirect("plant.jsp?errorMessage=" + errorMessage);
			}
		} catch (Exception e) {
			response.sendRedirect("Register.jsp?errorMessage=Unexpected error ");
		}

	}

}
