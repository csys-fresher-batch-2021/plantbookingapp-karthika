package in.karthika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.UserService;
import in.karthika.validate.UserValidate;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			boolean isValid = false;

			isValid = UserValidate.validatetUser(userId, password);
			if (isValid) {
				String username = UserService.getUserName(userId);
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username); 
				session.setAttribute("PHONE_NUMBER", userId); 
				session.setAttribute("ROLE", "USER");
				response.sendRedirect("plant.jsp");
			} else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login Credentials");
			}

		}

		catch (Exception e) {
			response.sendRedirect("Login.jsp?errorMessage=Unexpected Error");
		}
	}

}
