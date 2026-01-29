package quizcompetitionproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User 
{
	public static void startQuiz()
	{
		Scanner sc = new Scanner(System.in);
		int score = 0;
		
		try
		{
			Connection con = DataBaseConnection.getConnection();
			
			System.out.print("Enter Your Full Name : - ");
			String userName = sc.nextLine();
			
			String sql = "SELECT * FROM Questions ORDER BY RAND() LIMIT 5";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("\n"+rs.getString("Question"));
				System.out.println("1. "+rs.getString("Option1"));
				System.out.println("2. "+rs.getString("Option2"));
				System.out.println("3. "+rs.getString("Option3"));
				System.out.println("4. "+rs.getString("Option4"));
				
				System.out.print("Choose Your Answer From Option 1 to 4 : -  ");
				int option = sc.nextInt();
				
				if(option == rs.getInt("Correct_Option"))
				{
					score++;
				}
				
			}
			
			System.out.println("\nQuiz Finished");
			System.out.println("Your Score is : - "+score+"/5");
			
			String insertScore = "INSERT INTO Scores(userName, score) VALUES (?, ?)";
			
			PreparedStatement ps2 = con.prepareStatement(insertScore);
			
			ps2.setString(1, userName);
			ps2.setInt(2, score);
			
			ps2.executeUpdate();
			
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
