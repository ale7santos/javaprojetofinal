package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:mysql://localhost/lojapadrao?useTimeZone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "036078Ab*";

	public static Connection getConnection() {
		try {

		 return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Erro na conexão: ", ex);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {

		closeConnection(con);

		try {

			if (stmt != null) {
				stmt.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

		closeConnection(con, stmt);

		try {

			if (rs != null) {
				rs.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}

