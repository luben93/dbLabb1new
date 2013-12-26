package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLupdate exectues the update statment
 * 
 * @author luben and steffe
 * 
 */
public class SQLupdate {

	private Connection con;

	public SQLupdate(Connection con) {
		this.con = con;
		// TODO Auto-generated constructor stub
	}

	public void execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			stmt.executeUpdate(query);

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
