/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 4, 2026 */

import java.util.Scanner;
import java.util.Deque;

public class PracticeProblem {

	public static void main(String args[]) {

		//Start menu
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to 'Book of Doll'!");

		// System.out.println("What's your name?");
		// Global.name = input.nextLine();

		// System.out.println("Please type Start to begin.");
		// String nextChoice = "";

		// do{ //make sure they actually type start!!
		// 	nextChoice = input.nextLine();
		// } while (!((nextChoice.equalsIgnoreCase("start"))));

		System.out.println("Pro tip! Before we start, if there's a pause in the text, try typing next or pressing enter to proceed!");
		Global.next = next();

		firstScene();
	
	}

	public static String next () { //proceeds story
		Scanner input = new Scanner(System.in);
		String nextChoice;

		do{
			nextChoice = "";
			nextChoice = input.nextLine().toLowerCase();
		} while (!((nextChoice.equalsIgnoreCase("next"))) && !(nextChoice.equalsIgnoreCase("")));
			
		return nextChoice;
	}

	public static int choiceChecker () { //checks whether it's a valid choice number (for 1-2 answers) 
		Scanner input = new Scanner(System.in);
		int choice = 0; 

		while (!(input.hasNextInt())) { //make sure input is definitely an int
			input.nextLine(); //clear scanner and repeats until they put an int
		}
		do{ //loop until the input is one of the choices
			choice = 0;
			choice = input.nextInt();
		} while (!(choice == 1) && !(choice == 2));
		
		return choice;
	}

	public static void firstScene () { //the first waking scene 
		Scanner input = new Scanner(System.in);

		System.out.println("\nYou only see darkness. You could get up again, or you could stay asleep forever.");
		System.out.println("1. Wake up now" + "\n2. Don't wake up");
		Global.choice = choiceChecker();

		if (Global.choice == 2) { //don't wake
			System.out.println("Choosing apathy, you fall back into slumber. You hear a rustling, like something is moving closer.");
			System.out.println("1. Wake up" + "\n2. Stay asleep"); 
			
			Global.choice = choiceChecker(); //check again for choice
				if (Global.choice == 2) { //stay asleep
					System.out.println("\nYou brush off the noise. You don't notice as the library consumes you. You will never open your eyes again nor discover your purpose.");
					System.exit(0);
				}
				else { //wake up
					System.out.println("Yout eyes snap open. You sit up, looking around. There's nothing around you but still roots.");
					System.out.println("Strange.");
				}
		} //end of small sleepy time detour 

		System.out.println("You sigh. There's nothing to do on the floor anyways. You get on your feet, dusting yourself off.");
		System.out.println("\nYour wrist is slightly tingly.");
		System.out.println("1. Look at it" + "\n2. Don't look at it");
		Global.choice = choiceChecker();

		if (Global.choice == 1) {  //wrist check 
			System.out.println("You look down at your inner wrist. A number appears faintly, reading " + Global.turn + ".");

			switch (Global.turn) {
				case 0:
					System.out.println("\nThis is strange. You try to rub it off, but it doesn't fade. You don't remember how it got there, but you don't remember much in general.");
					break;
				case 1:
					System.out.println("You frown. Has the number changed?");
					break;
			}
			if (Global.turn >= 2) { //more than/= 2 turns
				System.out.println("The number is changing according to how many times you've run into an unfortunate roadblock.");
			}
		} else { //don't check the wrist
			System.out.println("You ignore it the sensation. The feeling fades in a few seconds.");
		}

		System.out.println("\nOh well. You get up and look around.");
		Global.next = next();

		library();
	} 

	public static void library () {
		System.out.println("========LIBRARY========");
		System.out.println("\nYou're in a huge open library. It looks the same as a regular library, but there are trees and greenery mixed in between the towering, seemingly endless shelves. Roots crawl against the wooden floorboards.");
		System.out.println("\nThe ceiling is also completely open, revealing a starry evening. A part of you wonders how that's possible.");
	
		switch (Global.turn) { //flavour text about counter books
			case 0: 
				System.out.println("\n There's a counter with one book on it.");
			break;

			case 1:
				System.out.println("\nThere's a counter with two books on it.");
			break;

			case 2:
				System.out.println("\nThere's a counter with three books on it. Soon enough, they'll have a proper stack.");
			break;

			case 3:
				System.out.println("\nTHere's a counter with a stack of books on it. You're going to stop counting...");
			break;
			default:
				System.out.println("\nThere's a counter with too many books for you to count on top.");
		}
		System.out.print(" There's nobody behind the counter.");
		
		Global.next = next();
	
		//meeting Mr. Yakubyougami
		System.out.println("Suddenly, a pretty blond man appears from the shelves with a pile of books in his arms. He's wearing a blue apron. He eyes you, as if not expecting you to have been standing there.");
		
		switch (Global.turn) {
			case 0:
				System.out.println("\nYou're sure that if this were a dating sim or something, he'd be a love interest. You shake your head, clearing your thoughts. You shouldn't assume because that makes a — nevermind.");
			break;
			//case 1:	
		}
	
	} 


}
