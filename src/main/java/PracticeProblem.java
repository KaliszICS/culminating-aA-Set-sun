/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 4, 2026 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;

public class PracticeProblem {

	public static int turn = 0; 
    public static String name;
    public static int choice;
    public static String next;

	public static boolean metSano = false;

    public static Stack<String> deaths = new Stack<>(); //keep track of most recent death 
        /* Fell = died to falling out of the library
            Lost = died in endless library
            Wall = crashed into wall from Seimei's chase
            Aka = died in bathroom */
	public static String recentDeath = deaths.peek().toLowerCase();
	public static boolean fellOut = false;

	public static Stack<String> scenes = new Stack<>(); //keep track of what scene we want to go to next etc.

	public static void sceneChooser() {
		String scene = scenes.peek().toLowerCase();

		while (!(scene.isEmpty())) {
			switch (scene) {
				case ("scene1"): firstScene(); break;
				case ("library"): library(); break;
				//case (""): break;
			}
		}
	}

	/* 1. Make stack 
	2. Start with scene chooser and push scene1 onto stack
	3. Peek stack for what's on top using switch cases, and then run method there 
	4. Before method ends, push the next room into stack and return to sceneChooser
	5. Loop it WHILE it's not empty */
	
	public static void main(String args[]) {

		//Start menu
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to 'Book of Doll'!");

		// System.out.println("What's your name?");
		// name = input.nextLine();

		// System.out.println("Please type Start to begin.");
		// String nextChoice = "";

		// do{ //make sure they actually type start!!
		// 	nextChoice = input.nextLine();
		// } while (!((nextChoice.equalsIgnoreCase("start"))));

		System.out.println("Pro tip! Before we start, if there's a pause in the text, try typing next or pressing enter to proceed!");
		next = next();

		choiceChecker();
	
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
			input.nextLine(); //clear scanner
		}
		do{
			choice = 0;
			choice = input.nextInt();
		} while (!(choice == 1) && !(choice == 2));
		
		return choice;
	}

	public static void firstScene () { //the first waking scene 
		Scanner input = new Scanner(System.in);

		switch (recentDeath) {
			case ("fell"): System.out.println("====FELL====\n\nYou remember falling out of the door. It was endlessly cold. Maybe you should lie to Mr. Yakubyougami for now..."); break;
			case ("lost"): System.out.println("====LOST====\n\nYou remember losing yourself. Alone and afraid. Maybe you shouldn't enter the library..."); break;
			case ("wall"): System.out.println("====CRASH====\n\nYou remember crashing into a wall. Embarassing. Maybe you should cover up your clothes, or find a change of clothes..."); break;
			case ("aka"): System.out.println("====TOILET====\n\nYou don't want to remember that one. Maybe you should give him a taste of his own medicine..."); break;
		}
		System.out.println("\nYou only see darkness. You could get up again, or you could stay asleep forever.");
		System.out.println("1. Wake up now" + "\n2. Don't wake up");
		choice = choiceChecker();

		if (choice == 2) { //don't wake
			System.out.println("Choosing apathy, you fall back into slumber. You hear a rustling, like something is moving closer.");
			System.out.println("1. Wake up" + "\n2. Stay asleep"); 
			
			choice = choiceChecker(); //check again for choice
				if (choice == 2) { //stay asleep
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
		choice = choiceChecker();

		if (choice == 1) {  //wrist check 
			System.out.println("You look down at your inner wrist. A number appears faintly, reading " + turn + ".");

			switch (turn) {
				case 0:	System.out.println("\nThis is strange. You try to rub it off, but it doesn't fade. You don't remember how it got there, but you don't remember much in general."); break;
				case 1: System.out.println("\nYou frown. Has the number changed?"); break;
			}
			if (turn >= 3) { //more than/= 3 turns
				System.out.println("You've deduced that the number is changing according to how many times you've run into an unfortunate roadblock.");
			}
		} else { //don't check wrist
			System.out.println("You ignore it. The feeling fades in a few seconds.");
		}

		System.out.println("\nOh well. You look around.");
		next = next();

		library();
	} 

	public static void library () {
		System.out.println("========LIBRARY========");
		System.out.println("\nYou're in a huge open library. It looks the same as a regular library, but there are trees and greenery mixed in between the towering, seemingly endless shelves. Roots crawl against the wooden floorboards.");
		System.out.println("\nThe ceiling is also completely open, revealing a starry evening. A part of you wonders how that's possible.");
	
		switch (turn) { //flavour text about counter books
			case 0: System.out.print("\n There's a counter with one book on it."); break;
			case 1: System.out.print("\nThere's a counter with two books on it."); break;
			case 2:	System.out.print("\nThere's a counter with three books on it. Soon enough, they'll have a proper stack."); break;
			case 3: System.out.print("\nTHere's a counter with a stack of books on it. You're going to stop counting..."); break;
			default: System.out.print("\nThere's a counter with too many books for you to count on top.");
		}
		System.out.print(" There's nobody behind the counter.");
		next = next();
		
		while (metSano == false) { 
		//meeting Mr. Yakubyougami-------------------------------------------
			switch (turn) {
				case 0:	
					System.out.println("\nSuddenly, a pretty blond man appears from the shelves with a pile of books in his arms.");
				break;
				default: 
					System.out.println("\nMr. Yakubyougami appears from the shelves with a pile of books in his arms.");
			}
			System.out.println("\nHe's wearing a blue apron, suggesting he worked here. He looks your age, although you don't know how old you are. " + 
			"He eyes you coolly, as if not expecting you to have been standing there.");
			next = next();

			switch (turn) { //flavour text depending on how many times you've met him
				case 0:
					System.out.println("You're sure that if this were a dating sim or something, he'd be an aloof love interest. You shake your head, clearing your thoughts. You shouldn't assume because that makes a...nevermind.");
				break;
			}
			System.out.println("\nYou stare at him blankly. He watches you back with a neutral expression.");
			next = next();

			System.out.println("After a bit, he clears his throat and he walks past you to set the books down. He turns back around to face you.");
			System.out.println("\n\"I'm...\" He introduces himself.");
			next = next();

			switch (turn) { //flavour text regarding his name
				case 0:
					System.out.println("You frown. You didn't hear it at all, however it was too awkward to ask him to repeat. You stare at him again in silence, squinting as if that would magically give you his name.");
					next = next();
					System.out.println("\n'Yakubyougami' You brain helpfully supplies. Thank you, brain.\n\nYou had no clue what a 'Yakubyougami' was nor did you know why you knew that word, but regardless, you decided his name must've been Mr. Yakubyougami.");
				break;

				case 1: System.out.println("\nYou tried your best to listen attentively this time, but you still had no clue what his name was. He was still Mr. Yakugyougami then."); break;
				default: System.out.println("\nOkay, this had to be intentional. Sorry, Mr. Yakubyougami then.");
			}
			next = next();

			//FIRST POSSIBLE TURN DEATH------------------------------------------------------ 
			System.out.println("\n\"Um, you're the new employee, right? I'm your co-worker,\" Mr. Yakubyougami says.");
			System.out.println("1. Silently nod along\n2. Tell him you're not an employee");
			choice = choiceChecker();

			if (choice == 2) { //game END
				System.out.println("\"What? You know you're not supposed to be here then before opening.\" Mr. Yakubyougami raises a brow. He looks suspicious. \"You should leave then,\" he says.");
				next = next();

				if (fellOut == true) { //has fallen at least once
					System.out.println("\n\"I-I can't leave! I'll die! You don't understand, there's nothing out there!\" You begin to frantically tell him. \n\nMr. Yakubyougami's eyes narrow at your erratic behaviour." + 
					" \n\n\"Maybe you get some fresh air. I'm afraid you have to leave.\" He firmly pushes you out. You resist, but he's stronger than you. He opens the door and you fall into the darkness again.");
				} 
				else { //haven't died from falling before
					System.out.println("\nYou frown as he speaks.\n\nThere's a door you hadn't noticed behind Mr. Yakubyougami. \n\n\"Nevermind. I think that's my exit.\" You hurry towards the exit with a smile. You open the door and step outside. Except there's no outside. You fall into the darkness.");
					fellOut = true; //died once to falling 
				}
				turn++;
				deaths.push("Fell"); //died to falling, most recent
				scenes.push("scene1"); //go back to scene 1
				sceneChooser();
			}

			if (turn == 1) { //extra dialogue option for the first death
				System.out.println("1. Ask him if you just died\n2. Stay silent");
				choice = choiceChecker();
				if (choice == 1) {
				System.out.println("\n\"Did I just die?\" you blurt out. " + 
				"\n\nMr. Yakubyougami gives you a strange look that suggests he thinks you've lost your mind. Maybe you have. " +
				"\n\n\"What...? Do you need a break...? If not, just get to work.\" He walks away and you lose him almost instantly among the shelves. Ugh...");
				}
			}
	} //end of Sano's first scene

		System.out.println("\nAHHHHHHHHH ANGIE HELP HELP IT'S REPEATING HERE LOOK HERE");





	

	}
}
