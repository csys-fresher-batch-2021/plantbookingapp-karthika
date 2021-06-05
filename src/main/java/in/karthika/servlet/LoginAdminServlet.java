package in.karthika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.AdminService;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("Message");
			String userId = request.getParameter("adminId");
			String password = request.getParameter("passcode");
			boolean isValid = false;

			isValid = AdminService.checkAdmin(userId, password);
			if (isValid) {
				String username = AdminService.getAdminName(userId);
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("ROLE", "ADMIN");
				response.sendRedirect("Adminpage.jsp?Login Successful");
			} else {
				session.setAttribute("Message", "Invalid Login Credentials");
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login Credentials");
			}

		}

		catch (Exception e) {
			session.setAttribute("Message", "Invalid Login Credentials");
			response.sendRedirect("Login.jsp?errorMessage=Invalid admin details");
		}

	}

}
