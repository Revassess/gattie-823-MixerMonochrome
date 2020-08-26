package com.revature.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://databases.c2ga2loul9ng.us-east-2.rds.amazonaws.com:5432/postgres";
	// add your jdbc username
	public static final String USERNAME = "imhere";
	// add your jdbc password
	public static final String PASSWORD = "oneforall";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "byThree";

	// implement this method to connect to the db and return the connection object
	public Connection connect() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		try(Connection conn = connect()){
			String sql = "SELECT ABS(" + value + ");";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				return result.getLong(0);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1; //returns a negative to show absVal did not go through
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
