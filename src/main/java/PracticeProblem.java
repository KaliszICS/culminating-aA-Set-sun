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

		if (choice == 2) {
			System.out.println("You fall back into slumber with your eyes closed. You don't notice as the library consumes you." + "\nYour world returns to darkness");
			Global.turn++;
			firstScene();
		}

		System.out.println("\nYour forearm is slightly tingly. Do you check it?");
		System.out.println("1. Check it" + "\n2. Don't check it");
		choiceChecker();

		if (choice == 1) { //if you pick to sleep and then pick to check, it loops again?? wth??
			System.out.println("You look down at your forearm, tilting it until you could see your inner forearm." + "\nA number appears on your forearm, reading " + Global.turn + ".");
		}

		System.out.println(Global.name + " got out!");
	



	} 

}
