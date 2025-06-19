package databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class databaseutility {
	
    Connection con;

	public void getDBConnection() throws SQLException {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

		} catch (SQLException e) {
		}

	}

	public void closeDBConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public ResultSet executeselectquery(String query) {
		ResultSet result = null;
		Statement stat = null;
		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			result = stat.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;

	}

	public int executenonselectquery2(String query) {
		int result = 0;
		Statement stat = null;
		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
