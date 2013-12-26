package controller;

	import java.sql.SQLException;
import java.util.ArrayList;

	import model.Album;
import view.View;
	
	/**
	 * the actual controller, handle all communication between the view and the
	 * model
	 * 
	 * @author luben and steffe
	 * 
	 */
public interface DatabaseConnection {
		
		 String ip = "83.250.249.187", user = "steffe", pwd = "stefanborivalla", database = "labb1a";

		/**
		 * start is the equivalent of the constructor
		 */
		public void start() ;
		
		/**
		 * terminates the connection
		 */
		public void terminateCon();

		/**
		 * update contains a insert SQL statment
		 * 
		 * @param artist
		 * @param album
		 * @param genre
		// * @throws SQLException 
		 */
		public void AddTransaction(String artist, String album, String genre)throws DatabaseErrorExecption ,NullValueExecption;
		
		
		public void AddAnotherArtistToAlbum(String artist, String album)throws DatabaseErrorExecption,NullValueExecption ;

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
		
		//TODO SEARCH
		public void Search(String SearchColumn, String SearchedText, String Table)throws DatabaseErrorExecption ;
		
		//TODO 
		/**
		 * selects all
		 * @throws SQLException 
		 */
		public void selectAll()throws DatabaseErrorExecption ;

		/**
		 * updates rating
		 * 
		 * @param rating
		 * @param album
		 * @throws SQLException 
		 */
		
		//TODO SEARCH F���RST. TYP KLAR MEN SEARCH ?
		public void updateRating(String rating, String SelectedRow)throws DatabaseErrorExecption;

		//@SuppressWarnings("unchecked")
		public ArrayList<Album> getLatestQueryResults() ;


		
}
