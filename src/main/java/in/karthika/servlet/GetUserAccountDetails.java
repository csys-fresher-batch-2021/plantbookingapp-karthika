package in.karthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.karthika.model.Cart;
import in.karthika.service.CartService;
import in.karthika.util.DateTimeAdapter;

/**
 * Servlet implementation class GetUserAccountDetails
 */
@WebServlet("/GetUserAccountDetails")
public class GetUserAccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUserAccountDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobileNumber = request.getParameter("phoneNumber");
		try {
			List<Cart> orderItems = CartService.getOrderItems(mobileNumber);

			Gson gson = new GsonBuilder().setPrettyPrinting()
					.registerTypeAdapter(LocalDate.class, new DateTimeAdapter())
					.registerTypeAdapter(LocalDate.class, new DateTimeAdapter()).create();

			String object = gson.toJson(orderItems);
			PrintWriter out = response.getWriter();
			System.out.println(object);
			out.println(object);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
