/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 2, 2026 */

import java.util.Scanner;
import java.util.Deque;

public class PracticeProblem {

	public static void main(String args[]) {

		//Start menu
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to 'Book of the Doll'!");

		System.out.println("Please type Start to begin.");
		String nextChoice = "";

		do{
			nextChoice = input.nextLine();
		} while (!((nextChoice.equalsIgnoreCase("start"))));

		

	}

	public static String next (String nextChoice) {
		Scanner input = new Scanner(System.in);
		nextChoice.toLowerCase();

		do{
			nextChoice = input.nextLine().toLowerCase();
		} while (!((nextChoice.equalsIgnoreCase("next")) || (nextChoice.equalsIgnoreCase("return"))));
			
		return nextChoice;

	}

	public static String choiceChecker (int choiceNum) {
		// Scanner input = new Scanner(System.in);

		// do{
		// 	choiceNum = input.nextInt();
		// } while (!((choiceNum  || (choiceNum.equalsIgnoreCase("return"))));

		return "Hi";
	}

}
