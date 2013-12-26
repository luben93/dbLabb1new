package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Album;
import model.Artist;

/**
 * SQLquery exectues a query and recives the result and puts it in an array as
 * objects
 * 
 * @author luben and steffe
 * 
 */
public class SQLquery {
	private Connection con;
	private ArrayList<Album> result;
	private ResultSet result1;

	public SQLquery(Connection con) {//constructs every query 
		this.con = con;
		result = new ArrayList<Album>();//new objects per query 
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Album> execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

		
			
			result=new ArrayList<Album>();
			while (rs.next()) {
				result.add(new Album(rs.getString(1), rs.getString(2), rs.getString(3), artist));
				// create new album outside sqlquery !!!!!!!!!
				//result.add(new Album(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			result1= rs;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		 return result;
	}

	/**
	 * @return result, the result of the SQL query
	 */
	public ArrayList<Album> getResults() {
		return  result;
	}

}
