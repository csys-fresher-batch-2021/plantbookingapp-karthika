package in.karthika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.karthika.service.CartService;

/**
 * Servlet implementation class DeleteCartPlantServlet
 */
@WebServlet("/DeleteCartPlantServlet")
public class DeleteCartPlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String plantName = request.getParameter("plantName");
			boolean isDeleted = CartService.deletePlant(plantName);
			if (isDeleted) {
				response.sendRedirect("displayCart.jsp");
			} else {

				String errorMessage = "Unable to delete Plant";
				response.sendRedirect("displayCart.jsp?errorMessage=" + errorMessage);
			}
		} catch (Exception e) {
			response.sendRedirect("displayCart.jsp?errorMessage=Unexpected error");
		}
	}

}
