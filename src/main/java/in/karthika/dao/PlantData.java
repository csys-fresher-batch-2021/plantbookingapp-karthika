package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.karthika.exceptions.CannotAddException;
import in.karthika.exceptions.CannotDeleteDetails;
import in.karthika.exceptions.CannotGetCredentialException;
import in.karthika.model.Plant;
import in.karthika.util.Connectionutil;

public class PlantData {

	private PlantData() {
		/**
		 * constructor
		 */
	}

	/**
	 * This method is used to get the plant details from the database
	 * 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public static List<Plant> plantDetails() throws Exception {

		List<Plant> plantList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String url = "select * from plantList";
			con = Connectionutil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
		
			while (rs.next()) {
				String plantName = rs.getString("Plant_Name");
				String price = rs.getString("Cost");
				double cost = Double.parseDouble(price);
				String type = rs.getString("Type");
				String category = rs.getString("Category");
				plantList.add(new Plant(plantName, cost, type, category));
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Plant Details");
		} 
		
		finally {
			Connectionutil.close(pst, con);
		}
		return plantList;
	}

	/**
	 * This method is used to store the plant to the database
	 * @param plant
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @throws CannotAddException
	 */
	
	public static boolean save(Plant plant) throws Exception {
	
		boolean isAdd = false;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = Connectionutil.getConnection();
			String sql = "INSERT INTO plantList(Plant_Name,Cost,Type,Category) values (?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, plant.getPlantName());
			pst.setDouble(2, plant.getPrice());
			pst.setString(3, plant.getPlantType());
			pst.setString(4, plant.getCategory());
		
			int rows = pst.executeUpdate();
			
			if (rows == 1) {
				isAdd = true;
			}else {
				throw new CannotAddException("Cannot Add");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add Plant");
		} finally {
			Connectionutil.close(pst, con);
		}
		
		return isAdd;
	}

	public static boolean deletePlant(String plantName) throws Exception {

		boolean isDelete = false;
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = Connectionutil.getConnection();

			String sql = "DELETE FROM plantList WHERE Plant_Name=?;";
			pst = connection.prepareStatement(sql);
			pst.setString(1, plantName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new CannotDeleteDetails("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		} finally {
			Connectionutil.close(pst, connection);
		}

		return isDelete;

	}

	/*
	 * This array list is used to store the filtered plants
	 */
	private static List<Plant> filterPlants = new ArrayList<>();

	/**
	 * This method is used to return all filter plants
	 * 
	 * @return
	 */
	public static List<Plant> getFilterPlants() {
		return filterPlants;
	}

}
