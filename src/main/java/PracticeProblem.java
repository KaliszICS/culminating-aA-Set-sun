/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 1, 2026 */

import java.util.Scanner;

public class PracticeProblem {

	public static void main(String args[]) {

		//Start menu
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to 'Book of the Doll'!");

		System.out.println("Please type next to begin.");
		String nextChoice = next(input.nextLine());

		int num; 

	// 	do { 
	// 		System.out.print("Input a positive integer: ");
	// 		num = input.nextInt();
	// 	} while (num < 0);

	// 	System.out.println(num * 2);
	}

	public static String next (String nextChoice) {
		Scanner input = new Scanner(System.in);
		nextChoice.toLowerCase();

		do{
			System.out.println("Please type a valid answer.");
			nextChoice = input.nextLine().toLowerCase();
		} while (!((nextChoice.equalsIgnoreCase("next")) || (nextChoice.equalsIgnoreCase("return"))));
			
		System.out.println("Hey, it's good");
		return nextChoice;

	}

	public static String choiceChecker (int choiceNum) {
		return "Hi";
	}

}
