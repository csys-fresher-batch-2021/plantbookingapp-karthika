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
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
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
			String username = request.getParameter("userName");
			String mobilenumber = request.getParameter("mobileNumber");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			boolean isValid  = UserService.insertUser(username, mobilenumber,password1, password2);
			if (isValid) {
				response.sendRedirect("Login.jsp?Registered Successful");
			} else {
				session.setAttribute("Message", "Invalid details");
				response.sendRedirect("Register.jsp?errorMessage=Invalid Login Credentials");
			}
		} catch (Exception e) {
			session.setAttribute("Message", "User already exists");
			response.sendRedirect("Register.jsp?errorMessage=Invalid Login Credentials");
		}

	}

}
