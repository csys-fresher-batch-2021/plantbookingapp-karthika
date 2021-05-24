package in.karthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.karthika.service.PlantService;

/**
 * Servlet implementation class DeletePlantServlet
 */
@WebServlet("/DeletePlantServlet")
public class DeletePlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plantName = request.getParameter("plantName");
		boolean isDeleted = PlantService.deletePlant(plantName);
		if(isDeleted) {
			response.sendRedirect("plant.jsp");
		}
		else {
			
			String errorMessage = "Unable to delete Plant";
			response.sendRedirect("plant.jsp?errorMessage=" + errorMessage);
		}
	}

}
