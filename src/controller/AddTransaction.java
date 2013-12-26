package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTransaction {

	private Connection con;

	public AddTransaction(Connection con) {

		this.con = con;
	}

	public void execute(String query1, String query2, String query3)
			throws SQLException {

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);

			con.commit();
		} catch (SQLException e) {
			if (con != null)
				con.rollback();
			throw e;
		}

		finally {
			if (stmt != null)
				stmt.close();
			con.setAutoCommit(true);
		}
	}
}