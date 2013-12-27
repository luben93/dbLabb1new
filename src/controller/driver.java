package controller;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Album;
import model.Artist;
import view.View;

/**
 * the actual controller, handle all communication between the view and the
 * model
 * 
 * @author luben and steffe
 * 
 */
public class driver implements DatabaseConnection {
	// private ArrayList<String> test;
	private View frame;
	private ArrayList<Album> results;

	private Connection con = null;
	// private ArrayList<String> colname;
	private String ip = "83.250.249.187", user = "steffe",
			pwd = "stefanborivalla", database = "labb1a";

	/**
	 * start is the equivalent of the constructor
	 */
	public void start() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new View(driver.this);
					frame.setVisible(true);
				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Could not start program, " + e.toString());
					// e.printStackTrace();// test only
				}
			}
		});
		String server = "jdbc:mysql://" + ip + ":3306/" + database
				+ "?UseClientEnc=UTF8";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(server, user, pwd);
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
		}
	}

	public void terminateCon() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
		}

	}

	/**
	 * update contains a insert SQL statment
	 * 
	 * @param artist
	 * @param album
	 * @param genre
	 * @throws SQLException
	 */
	public void AddTransaction(String artist, String album, String genre)
			throws DatabaseErrorExecption,NullValueExecption {
		try {

			if (!artist.equals("") && !album.equals("")) {

				// TODO TRANSAKTION. KLAR
				// connect("insert into artist (idartist) values ('" + artist +
				// "')",
				// "insert into album (albumid, genre) values ('" + album +
				// "','" + genre + "')",
				// "insert into album_artist (album, artist) values ('" + album
				// + "','" + artist + "')",
				// "AddTransaction");
				AddTransaction AddTran = new AddTransaction(con);

				AddTran.execute("insert into artist (idartist) values ('"
						+ artist + "')",
						"insert into album (albumid, genre) values ('" + album
								+ "','" + genre + "')",
						"insert into album_artist (album, artist) values ('"
								+ album + "','" + artist + "')");

			} else {
				throw new NullValueExecption(
						"Null is not an acceptable value here)");
			}
		} catch (SQLException e) {
			throw new DatabaseErrorExecption(e);
		}
	}

	public void AddAnotherArtistToAlbum(String artist, String album)
			throws DatabaseErrorExecption,NullValueExecption  {
		try {

			if (!artist.equals("")) {

				// TODO LAGRAD PRECEDUR. KLAR
				CallableStatement cStmt = con
						.prepareCall("{call checkArtist(?)}");
				cStmt.setString(1, artist);
				int hadResults = cStmt.executeUpdate();

				System.out.println("HEJ !");
				// connect("insert into album_artist (album, artist) values ('"
				// +
				// album + "','" + artist + "')",
				// null,
				// null,
				// "update");
				SQLupdate update = new SQLupdate(con);
				update.execute("insert into album_artist (album, artist) values ('"
						+ album + "','" + artist + "')");

			} else {
				throw new NullValueExecption(
						"Null is not an acceptable value here");
			}
		} catch (SQLException e) {
			throw new DatabaseErrorExecption(e);
		}
	}

	/**
	 * Search contains a select SQL statment
	 * 
	 * @param SearchOn
	 * 
	 * @param SearchedText
	 * 
	 * @param Table
	 * @throws SQLException
	 */

	// TODO SEARCH
	public void Search(String SearchColumn, String SearchedText, String Table)
			throws DatabaseErrorExecption {
		try {

			// connect("Select * FROM " + Table + " where " + SearchColumn +
			// " like '" + SearchedText
			// + "%'", null,null,"query");
			ResultSet rsAl, rsAr;
			SQLquery query = new SQLquery(con);
			SQLqueryArtist aquery =new SQLqueryArtist(con);
	
			rsAl = query.execute("Select albumid, genre, rating, artist FROM album,  "
					+ "where "
					+ SearchColumn
					+ " like '"
					+ SearchedText+"'");//fel fel fel, ta enbart album
			
			
			rsAr = aquery.execute("Select albumid, artist FROM , album_artist "
					+ "where "
					+ SearchColumn
					+ " like '"
					+ SearchedText
					+ "%' AND album.albumid = album_artist.album");//fel fel fel, ta enbart artister
			
			Artist artist=new Artist();
			while (rsAr.next()) {
				artist.addArtist(rsAr.getString(1));
			}
			
			while (rsAl.next()) {
				Artist tempartist=new Artist();
				//fill temp artist with the correct album Artists
				results.add(new Album(rsAl.getString(1), rsAl.getString(2), rsAl.getString(3), tempartist));
			}
			
			
			
			
			
			
		
			// rs = query.getResults();
			// results=new ArrayList<Album>();
			// while (rs.next()) {
			// results.add(new Album(rs.getString(1), rs.getString(2),
			// rs.getString(3), rs.getString(4)));
			// }
		} catch (SQLException e) {
			throw new DatabaseErrorExecption(e);
		}
	}

	// TODO
	/**
	 * selects all
	 * 
	 * @throws SQLException
	 */
	public void selectAll() throws DatabaseErrorExecption {
		try {

			SQLquery query = new SQLquery(con);
			query.execute("Select albumid, genre, rating, artist FROM album, album_artist where album.albumid = album_artist.album ");
			results = query.getResults();
			// ResultSet rs;
			// results=new ArrayList<Album>();
			// rs = query.getResults();
			// while (rs.next()) {
			// results.add(new Album(rs.getString(1), rs.getString(2),
			// rs.getString(3), rs.getString(4)));
			// }
		} catch (SQLException e) {
			throw new DatabaseErrorExecption(e);
		}
	}

	/**
	 * updates rating
	 * 
	 * @param rating
	 * @param album
	 * @throws SQLException
	 */

	// TODO SEARCH F���RST. TYP KLAR MEN SEARCH ?
	public void updateRating(String rating, String SelectedRow)
			throws DatabaseErrorExecption {
		try {

			SQLupdate update = new SQLupdate(con);
			System.out.println(SelectedRow);
			update.execute("update album set rating = '" + rating
					+ "' where albumid ='" + SelectedRow + "'");
			// connect("update album set rating = '" + rating +
			// "' where albumid ='"
			// + SelectedRow + "'", null, null, "update");
		} catch (SQLException e) {
			throw new DatabaseErrorExecption(e);
		}
	}

	// @SuppressWarnings("unchecked")
	public ArrayList<Album> getLatestQueryResults() {
		return (ArrayList<Album>) results.clone();
	}

}
