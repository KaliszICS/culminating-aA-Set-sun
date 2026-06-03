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

		System.out.println("What's your name?");
		Global.name = input.nextLine();

		System.out.println("Please type Start to begin.");
		String nextChoice = "";

		do{ //make sure they actually type start!!
			nextChoice = input.nextLine();
		} while (!((nextChoice.equalsIgnoreCase("start"))));

		//setting up 600 booleans
		int choice = 0;


		firstScene();
	
	}

	public static String next (String nextChoice) {
		Scanner input = new Scanner(System.in);
		nextChoice.toLowerCase();

		do{
			nextChoice = input.nextLine().toLowerCase();
		} while (!((nextChoice.equalsIgnoreCase("next")) || (nextChoice.equalsIgnoreCase("return"))));
			
		return nextChoice;

	}

	public static int choiceChecker () {
		Scanner input = new Scanner(System.in);
		int choice; 

		do{
			choice = 0;
			choice = input.nextInt();
		} while (!(choice == 1) && !(choice == 2));

		return choice;
	}

	public static void firstScene () {
		Scanner input = new Scanner(System.in);

		System.out.println("\n" + "You only see darkness. You can open your eyes, or you could stay asleep forever.");
		System.out.println("1. Wake up" + "\n2. Don't wake up");
		int choice = choiceChecker();

		if (choice == 2) { //actual game end.
			System.out.println("Choosing apathy, you fall back into slumber.");
			System.out.println("You don't notice as the library consumes you. You will never open your eyes again.");
			System.exit(0);
		}

		System.out.println("\nYour wrist is slightly tingly. Do you check it?");
		System.out.println("1. Check it" + "\n2. Don't check it");
		choiceChecker();

		if (choice == 1) { 
			System.out.println("You look down at your inner wrist. A number appears faintly, reading " + Global.turn + ".");

			switch (Global.turn) { //fix later
				case 0:
					System.out.println("\nThis is strange. You try to rub  it off, but it doesn't fade. You don't remember how it got there, but you realize you don't remember much in general.");
					break;
				case 1:
					System.out.println("You frown. Has the number changed?");
					break;
				case 3:
					System.out.println("The number is changing according to how many times you've run into an unfortunate roadblock.");

			}
			// if (Global.turn == 0) {
			// 	System.out.println("\nThis is strange. You try to rub  it off, but it doesn't fade. You don't remember how it got there, but you realize you don't remember much in general.");
			// }

			// if (Global.turn == 1) {
			// 	System.out.println("You frown. Has the number changed?");
			// }

			// if (Global.turn)
		}

		System.out.println(Global.name + " got out!");
	



	} 

}
