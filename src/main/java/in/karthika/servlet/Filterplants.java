package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.karthika.service.PlantService;

/**
 * Servlet implementation class Filterplants
 */
@WebServlet("/Filterplants")
public class Filterplants extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String filter = request.getParameter("filter");
			boolean isFilter = PlantService.filterPlants(filter);
			if (isFilter) {
				response.sendRedirect("filterPlants.jsp?Success");
			} else {
				response.sendRedirect("plant.jsp?errorMessage=Can't filter");
			}
		} catch (Exception e) {
			response.sendRedirect("plant.jsp?errorMessage=Can't filter the plants");
		}
	}
}
