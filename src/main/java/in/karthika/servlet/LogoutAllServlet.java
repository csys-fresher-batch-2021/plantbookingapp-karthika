package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.CartService;

/**
 * Servlet implementation class LogoutAllServlet
 */
@WebServlet("/LogoutAllServlet")
public class LogoutAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("LOGGED_IN_USER");
		session.removeAttribute("ROLE");
		session.removeAttribute("PHONE_NUMBER");
		session.removeAttribute("FILTER"); 
		CartService.ClearCart();
		response.sendRedirect("Login.jsp");
	}

}
