package quizcompetitionproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Admin {

	public static void addQuestion()
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			try
			{
				Connection con = DataBaseConnection.getConnection();
				String sql = "INSERT INTO Questions(Question, Option1, Option2, Option3, Option4, Correct_Option) VALUES (?, ?, ?, ?, ?, ?)";
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				System.out.print("Enter a Question : - ");
				ps.setString(1, sc.nextLine());
				
				System.out.print("Enter Option 1 : - ");
				ps.setString(2, sc.nextLine());
				
				
				System.out.print("Enter Option 2  : - ");
				ps.setString(3, sc.nextLine());
				
				
				System.out.print("Enter Option 3  : - ");
				ps.setString(4, sc.nextLine());
				
				
				System.out.print("Enter Option 4  : - ");
				ps.setString(5, sc.nextLine());
				
				
				System.out.print("Enter Correct OptionFrom 1 to 4 is  : - ");
				ps.setInt(6, sc.nextInt());
			
				
				int i = ps.executeUpdate();
				
				if(i > 0)
				{
					System.out.println("Question Added Successfully!");
				}
				
				
				System.out.print("Do You Want to Add One More Question and its Options along with its Corrected Option? Give Answer in (Yes or No) Formate Only : - ");
				String input = sc.next();
				
				
				if(input.equalsIgnoreCase("No"))
				{
					System.out.println("Exiting Admin Panel .....");
					break;
				}
				
				con.close();
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
	}

}
