package in.karthika.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.karthika.service.PlantService;

/**
 * Servlet implementation class PlantAddServlet
 */
@WebServlet("/PlantAddServlet")
public class PlantAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String plantname = request.getParameter("plantname");
			String price = request.getParameter("price");
			String type = request.getParameter("type");
			String category = request.getParameter("category");
			boolean isValid = false;

			isValid = PlantService.addPlant(plantname, price, type, category);
			if (isValid) {
				response.sendRedirect("plant.jsp?Plant SuccessFully Added");
			} else {
				response.sendRedirect("addPlant.jsp?errorMessage=Give Correct Details");
			}
		} catch (Exception e) {
			response.sendRedirect("addPlant.jsp?errorMessage=Plant already exist in stock");
		}
	}

}
