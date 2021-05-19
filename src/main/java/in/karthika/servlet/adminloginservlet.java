package in.karthika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.karthika.service.AdminService;
import in.karthika.validate.AdminValidate;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean isValid = false;
		try {
			isValid = AdminValidate.validatetAdmin(userId, password);
			if (isValid) {
				String username = AdminService.getAdminName(userId);
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("ROLE", "ADMIN");
				response.sendRedirect("Adminpage.jsp");
			} else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login Credentials");
			}

		}

		catch (Exception e) {
			response.sendRedirect("Login.jsp?errorMessage=Please Enter All Details");
		}
	}

}
