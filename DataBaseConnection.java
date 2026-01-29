package quizcompetitionproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	public static Connection getConnection()
	{
		
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_competition_database", "root", "root");
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	

}
