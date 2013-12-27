package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import model.Artist;

/**
 * SQLquery exectues a query and recives the result and puts it in an array as
 * objects
 * 
 * @author luben and steffe
 * 
 */
public class SQLqueryArtist {
	private Connection con;
	private ArrayList<String> AllArtist;
	private ArrayList<String> AllArtist2;
	private ResultSet result1;
	public SQLqueryArtist(Connection con) {//constructs every query 
		this.con = con;
		AllArtist = new ArrayList<String>();//new objects per query 
		// TODO Auto-generated constructor stub
	}

	public ResultSet execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			result1 = stmt.executeQuery(query);

			
			
			AllArtist=new ArrayList<String>();
			while (result1.next()) {
				
				AllArtist.add(result1.getString(1));
			
			}
			/*/
			rs.first();
			for(int i=1;rs.next();i++){
				AllArtist2.add((int) rs.getRowId(0), rs.getString(1));
			}
			//*/
			
			//result1= rs;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		 return result1;
	}
	/*
	public String getArtistAt(int index){
		return AllArtist.get(index);
	}
*/
	/**
	 * @return result, the result of the SQL query
	 */
	/*
	public ArrayList<String> getAllArtist() {
		return  AllArtist;
	}*/

}
