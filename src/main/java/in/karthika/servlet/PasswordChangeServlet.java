package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.UserService;

/**
 * Servlet implementation class PasswordChangeServlet
 */
@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("Message");
			String phoneNumber = request.getParameter("phoneNumber");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			boolean isChange = UserService.changepassword(phoneNumber, password1, password2);
			if (isChange) {
				response.sendRedirect("Login.jsp?Successfully Changed");
			} else {
				session.setAttribute("Message", "User is not registered");
				response.sendRedirect("passwordChange.jsp?errorMessage=Can't Change your password");
			}
		}

		catch (Exception e) {
			session.setAttribute("Message", "User is not registered");
			response.sendRedirect("passwordChange.jsp?errorMessage=The user is not exist");
		}
	}

}
