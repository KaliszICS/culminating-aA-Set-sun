/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 7, 2026 */

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;

public class PracticeProblem {

	public static int turn = 0; 
    public static String name;
    public static int choice;
    public static String next;

	//Event checkers -> have you done this event yet?
	public static boolean metSano = false;
	public static boolean firstTimeBookshelf = true; //first time looking at bookshelf, triggers demonstration
	public static boolean chasedBySeimei = false;
	public static boolean openDoor = false;

    public static Stack<String> deaths = new Stack<>(); //keep track of most recent death 
        /* Fell = died to falling out of the library
            Lost = died in endless library
            Wall = crashed into wall from Seimei's chase
            Aka = died in bathroom */
	//check what books you've unlocked + how you died
    public static boolean fellOut = false;
	public static boolean gotLost = false;
	public static boolean crashed = false;
	public static boolean dieAka = false; //this is technically an event

	public static Stack<String> scenes = new Stack<>(); //keep track of what scene we want to go to next etc.
	public static ArrayList<Integer> books = new ArrayList<Integer>(); //keep track of how many books you've unlocked basically -> use to expand the number of options for the bookshelf choice

	//inventory/items
	public static boolean toiletpaper = false;
		public static boolean bluepaper = false;
		public static boolean redpaper = false;
	public static boolean redCloak = false;
	public static boolean sailorUni = false;

	public static boolean chalk = false;
	public static boolean cake = false;
	public static boolean scissors = false;
	public static boolean candlesAndLighter = false;   

	public static int cruelty = 0; 

	public static void sceneChooser() { //the scene chooser 
		String scene = scenes.peek().toLowerCase();

		while (!(scene.isEmpty())) {
			switch (scene) {
				case ("scene1"): firstScene(); break;
				case ("library"): library(); break;
				case ("bookshelf"): bookshelf(); break;
				case ("hallway"): hallway(); break;
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
		
		// System.out.println("Welcome to 'Book of Doll'!");

		// System.out.println("What's your name?");
		// name = input.nextLine();

		// System.out.println("Please type Start to begin.");
		// String nextChoice = "";

		// do{ //make sure they actually type start!!
		// 	nextChoice = input.nextLine();
		// } while (!((nextChoice.equalsIgnoreCase("start"))));

		System.out.println("Pro tip! Before we start, if there's a pause in the text, try typing next or pressing enter to proceed!");
		next = next();

		scenes.push("library");
		sceneChooser();
			
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

	public static int bookshelfChecker () { //checks and expands for more than 2 answers as bookshelf expands 
		Scanner input = new Scanner(System.in);
		int choice = 0; 
		System.out.println(books);
		System.out.println(books.size());

		while (!(input.hasNextInt())) { //make sure input is definitely an int
			input.nextLine(); //clear scanner
		}
		do{
			choice = 0;
			choice = input.nextInt();
		} while (!(choice >= books.get(0)) || !(choice <= books.size()));
	
		return choice;
	}

	public static void firstScene () { //the first waking scene 
		Scanner input = new Scanner(System.in);

		System.out.println("\nYou only see darkness. You could get up again, or you could stay asleep forever.");
		System.out.println("1. Wake up now\n2. Don't wake up");
		choice = choiceChecker();

		if (choice == 2) { //don't wake
			System.out.println("Choosing apathy, you fall back into slumber. You hear a rustling, like something is moving closer.");
			System.out.println("1. Wake up\n2. Stay asleep"); 
			
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
			if (turn >= 2) { //more than/= 3 turns
				System.out.println("You've deduced that the number is changing according to how many times you've run into an unfortunate roadblock.");
			}
		} else { //don't check wrist
			System.out.println("You ignore it. The feeling fades in a few seconds.");
		}

		System.out.println("\nOh well. You look around.");
		next = next();

		metSano = false; //because you've restarted the loop, you have to meet Sano again from the beginning
		scenes.push("library");
		sceneChooser();
	} 

	public static void library () {
		System.out.println("========LIBRARY========");
		System.out.println("\nYou're in a huge open library. It looks the same as a regular library, but there are trees and greenery mixed in between the towering, seemingly endless shelves. Roots crawl against the wooden floorboards.");
		System.out.println("\nThe ceiling is also completely open, revealing a starry evening. A part of you wonders how that's possible.");
	
		switch (turn) { //flavour text about counter books
			case 0: System.out.print("\nThere's a counter with one book on it."); break;
			case 1: System.out.print("\nThere's a counter with two books on it."); break;
			case 2:	System.out.print("\nThere's a counter with three books on it. Soon enough, they'll have a proper stack."); break;
			case 3: System.out.print("\nTHere's a counter with a stack of books on it. You're going to stop counting..."); break;
			default: System.out.print("\nThere's a counter with too many books for you to count on top.");
		}
		System.out.print(" There's nobody behind the counter.");
		next = next();
		
		while (metSano == false) { 
		//meeting Sano-------------------------------------------
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

			System.out.println("\nYou stare at him blankly. He watches you back with a neutral expression.");
			next = next();

			System.out.println("After a bit, he clears his throat and he walks past you to set the books down. He turns back around to face you.");
			System.out.println("\n\"I'm...\" He introduces himself.");
			next = next();

			switch (turn) { //flavour text regarding his name
				case 0:
					System.out.println("You frown. You didn't hear it at all, however it was too awkward to ask him to repeat. You stare at him again in silence, squinting as if that would magically give you his name.");
					next = next();
					System.out.println("\n'Yakubyougami' Your brain helpfully supplies. Thank you, brain.\n\nYou had no clue what a 'Yakubyougami' was nor did you know why you knew that word, but regardless, you decided his name must've been Mr. Yakubyougami.");
				break;

				case 1: System.out.println("\nYou tried your best to listen attentively this time, but you still had no clue what his name was. He was still Mr. Yakugyougami then."); break;
				default: System.out.println("\nOkay, this silence had to be intentional. Sorry, Mr. Yakubyougami then.");
			}
			next = next();

			//FIRST POSSIBLE TURN DEATH------------------------------------------------------ 
			System.out.println("\n\"Um, you're the new employee, right? I'm your co-worker,\" Mr. Yakubyougami says.");
			System.out.println("1. Silently nod along\n2. Tell him you're not an employee");
			choice = choiceChecker();

			if (choice == 2) { //GAME RESTARTS
				System.out.println("\"What? You know you're not supposed to be here then before opening.\" Mr. Yakubyougami raises a brow. He looks suspicious. \"You should leave then,\" he says.");
				next = next();

				if (fellOut == true) { //has fallen at least once
					System.out.println("\n\"I-I can't leave! I'll die! You don't understand, there's nothing out there!\" You begin to frantically tell him. \n\nMr. Yakubyougami's eyes narrow at your erratic behaviour." + 
					" \n\n\"Maybe you get some fresh air. I'm afraid you have to leave.\" He firmly pushes you out. You resist, but he's stronger than you. He opens the door and you fall into the darkness again.");
				} 
				else { //haven't died from falling before
					System.out.println("\nYou frown as he speaks, but you get distracted. \n\nThere's a door you hadn't noticed behind Mr. Yakubyougami. \n\n\"Nevermind. I think that's my exit.\" You hurry towards the exit with a smile. You open the door and step outside. Except there's no outside. You fall into the darkness.");
					fellOut = true; //died once to falling 
				}
				turn++;
				deaths.push("Fell"); //died to falling, most recent
				scenes.push("scene1"); //go back to scene 1
				sceneChooser();
			}
	
			System.out.println("\"Since you're here, could you fetch me the book sign-out records? They should be in the office.\" Sano gestures to a hallway beside the counter.");

			if (turn == 1) { //extra dialogue option for the first death
				System.out.println("\nYou still feel unsettled. Maybe you should ask him to confirm.");
				System.out.println("1. Ask him if you just died\n2. Stay silent");
				choice = choiceChecker();
				
				if (choice == 1) { //ask him
					System.out.println("\n\"Did I just die?\" you blurt out. " + 
					"\n\nMr. Yakubyougami gives you a strange look that suggests he thinks you've lost your mind. Maybe you have. " +
					"\n\n\"What...? Do you need a break...? If not, just get to work.\" He walks away and you lose him almost instantly among the shelves. Ugh...");
				}
			}
			metSano = true;
		} //end of Sano's first scene

		System.out.println("1. Look at bookshelf\n2. Continue to the hallway");
		choice = choiceChecker();

		switch (choice) {
			case 1: //look at shelf
				System.out.println("You look at the bookshelf.");
				scenes.push("bookshelf");
				sceneChooser();
			break;

			case 2:	//continue to hall
				System.out.println("With nothing else to do, you decide to head over to the hallway.");
				scenes.push("hallway");
				sceneChooser();
			break;
		}
	}

	public static void bookshelf() { //work on bookshelf
		System.out.println("========BOOKSHELF========");

		if (firstTimeBookshelf == true) { //a one-time check for if MC knows how the books work
			System.out.println("You reach for a book. As soon as you open it, the surface of the book ripples. A fat white radish is buried in the dirt, looking adorable in its drawn style.");
			next = next();
			System.out.println("Hesitantly, you touch the rippling surface. Your finger sinks into the surface and you pluck the vegetable out of the dirt by the leaves. It screams insults at you and bites your finger.");
			next = next();
			System.out.println("\n\"Yeowch!\" you yelp, dropping the book and falling on your butt. Leaves scatter around you as the book closes. You rub your finger. Thankfully, it didn't draw blood."); 
			System.out.println("\nYou get up. Okay...maybe you could do something like that with other books too...\n");
			firstTimeBookshelf = false;
		}

		//------CHOOSING BOOKS-----------------------------------------------------
		books.clear(); //clear books
		System.out.println("1.[Origami with Unusual Materials]\n2.[Laidback Guide to the Wacky and Wysterious]\n3.[Ritual Book]");
		books.add(1); 
		books.add(2);
		books.add(3);

		chasedBySeimei = true;
		if (chasedBySeimei == true) {
			System.out.println("4.[Catalog of Sailor Uniforms Over the Ages]");
			books.add(4);
		}
	
		if (dieAka == true) {
			System.out.println("5.[That Time I Was a Whale, and I Ate a Guy's Leg]\n6.[Bloody Baking]");
			books.add(5);
			books.add(6);

		}//reading bloody baking or birthday after reading chalk prince will allow you to get cake

		if (openDoor == true) {
			System.out.println("7.[Lit Birthday Etiquette]\n8.[The Chalk Prince]\n9.[Scissor Serial]");
			books.add(7);
			books.add(8);
			books.add(9);
		}

		System.out.println("1. Read a book\n2.Return to the library");
		choice = choiceChecker();
		
		if (choice == 1) {
			System.out.print("Enter the book number: ");
			choice = bookshelfChecker();
			switch (choice) {
				case 1: //origami book 
					System.out.println("It's a guide about folding origami using strange materials, such as toilet paper.");
					if (dieAka == true) {
						System.out.println("You reach your hand in and grab a roll of toilet paper.");
						toiletpaper = true; 
					}
				break;

				case 2: //wacky guide
					System.out.println("It's a book about various types of creatures.");
			} 
		}

		if (choice == 2) {
		scenes.push("library");
		sceneChooser();
		}
	}


	public static void hallway() {
		System.out.println("========HALLWAY========");


		scenes.push("library");
		sceneChooser();
	}

	public static void office() {
		System.out.println("========OFFICE========");

		scenes.push("hallway");
		sceneChooser();
	}

	public static void bathroom() {
		System.out.println("========BATHROOM========");

		scenes.push("hallway");
		sceneChooser();
	}
} //this is end of code btw, Angie, so you don't screw up the brackets
