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
	private ResultSet rs;

	public SQLquery(Connection con) {//constructs every query 
		this.con = con;
		result = new ArrayList<Album>();//new objects per query 
		// TODO Auto-generated constructor stub
	}

	public ResultSet execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);

		
			
			result=new ArrayList<Album>();
			/*while (rs.next()) {
				result.add(new Album(rs.getString(1), rs.getString(2), rs.getString(3), artist));
				// create new album outside sqlquery !!!!!!!!!
				//result.add(new Album(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}*/
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		 return rs;
	}

}
