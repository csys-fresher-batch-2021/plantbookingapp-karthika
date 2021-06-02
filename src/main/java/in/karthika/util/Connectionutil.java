package in.karthika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connectionutil{
	
	private Connectionutil() {
		/*
		 * Constructor
		 */
	}
	
	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DATABASE_NAME = "plantbookingapp";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "RKrk@1727";
	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME; // jdbc:postgres://localhost:5432/plantbookingapp

	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the database connection");
		}
		return connection;
	}
	public static void close(PreparedStatement pst, Connection con) throws Exception {
	
		if (pst != null) {
			pst.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
