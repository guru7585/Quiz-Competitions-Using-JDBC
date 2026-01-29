package quizcompetitionproject;

import java.util.Scanner;

public class QuizCompetition {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Quiz Competition");
		System.out.println("Admin Role ");
		System.out.println("User Role");
		
		System.out.print("Enter Your Role (Admin / User) : - ");
		String role = sc.nextLine();
		
		
		if(role.equalsIgnoreCase("Admin"))
		{
			Admin.addQuestion();
		}
		
		else if(role.equalsIgnoreCase("User"))
		{
			User.startQuiz();
		}
		
		else
		{
			System.out.println("Invalid Choice");
		}
		
		
		
		
	}

}
