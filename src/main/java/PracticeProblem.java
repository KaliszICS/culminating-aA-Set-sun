/*
Title: Culminating
Name: Angie Seto
Date Created: June 1, 2026
Date Updated: June 7, 2026 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class PracticeProblem {

	public static int turn = 0; 
    public static String name;
    public static int choice;
    public static String next;

	//Event checkers -> have you done this event yet?
	public static boolean metSano = false;
	
	public static boolean firstTimeBookshelf = true; //first time looking at bookshelf, triggers demonstration
	public static boolean readRitualBook = false;
	
	public static boolean triedDoor = false;
	public static boolean triedDoorScene = false; //seperate boolean so it doesn't get in the way of the other one from trigger dialogue
	public static boolean metSeimei = false;
	public static boolean finishChase = false;

	public static boolean waitingForAka = false;
	public static boolean openDoor = false; //opens final 3 books

	public static boolean readNotes = false; //unlocks code
	public static boolean readSignOutRecords = false; 
	
	public static boolean readChalkPrince = false; //now unlocks as soon as you read the ritual book
	public static boolean ending = false;

	public static boolean returnRecords = false; //this is for the returning the record scene
	public static boolean endingScene = false; //this is for the scissor scene in the library
	
	public static boolean goodEnd = false;
	public static boolean badEnd = false;


    public static Stack<String> deaths = new Stack<>(); //keep track of most recent death 
        /* Fell = died to falling out of the library
            Lost = died in endless library
            Wall = crashed into wall from Seimei's chase
            Aka = died in bathroom */
	//check what books you've unlocked or how you died
	public static boolean chasedBySeimei = false;
    public static boolean fellOut = false;
	public static boolean dieAka = false; //this is technically an event

	public static Stack<String> scenes = new Stack<>(); //keep track of what scene we want to go to next etc.
	public static ArrayList<Integer> books = new ArrayList<Integer>(); //keep track of how many books you've unlocked basically -> use to expand the number of options for the bookshelf choice

	//inventory/items
	public static boolean toiletPaper = false;
		public static boolean bluePaper = false;
		public static boolean redPaper = false;
	public static boolean redCloak = false;
	public static boolean sailorUni = false;

	//ritual items
	public static boolean ichijama = false; //need to read dodomeki notes to unlock code
	public static boolean chalk = false;
	public static boolean cake = false;
	public static boolean scissors = false;
	public static boolean candlesAndLighter = false;   
	public static boolean seimeiHair = false;

	public static int cruelty = 0; 

	public static void sceneChooser() { //the scene chooser 
		String scene = scenes.peek().toLowerCase();

		while (!(scene.isEmpty())) {
			switch (scene) {
				case ("scene1"): firstScene(); break;
				case ("library"): library(); break;
				case ("bookshelf"): bookshelf(); break;
				case ("hallway"): hallway(); break;
				case ("bathroom"): bathroom(); break;
				case ("office"): office(); break;
				case ("chase"): chase(); break;
			}
		}
	}
	
	public static void main(String args[]) {

		//Start menu
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to 'Book of Doll'!");

		System.out.println("What's your name?");
		name = input.nextLine(); //yes, it is intentional that you can input whatever you want, it's goofy

		System.out.println("Please type Start to begin.");
		String nextChoice = "";

		do{ //make sure they actually type start!!
			nextChoice = input.nextLine();
		} while (!((nextChoice.equalsIgnoreCase("start"))));

		System.out.println("Pro tip! Before we start, if there's a pause in the text, try typing next or pressing enter to proceed!");
		next = next();

		scenes.push("scene1");
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
			try {
				choice = 0;
				choice = input.nextInt();
			} catch (InputMismatchException e) { //IF THEY PUT IN ANOTHER STRING I'M JUMPING THEM
				input.nextLine(); //clear
			}
		} while (!(choice == 1) && !(choice == 2));
		return choice;
	}

	public static int bookshelfChecker () { //checks and expands for more than 2 answers as bookshelf expands 
		Scanner input = new Scanner(System.in);
		int choice = 0; 
		System.out.println(books);

		while (!(input.hasNextInt())) { //make sure input is definitely an int
			input.nextLine(); //clear scanner
		}
		do{
			try {
				choice = 0;
				choice = input.nextInt();
			} catch (InputMismatchException e) { //IF THEY PUT IN ANOTHER STRING I'M JUMPING THEM
				input.nextLine(); //clear
			}
		} while (!(choice >= books.get(0)) || !(choice <= books.size()));
	
		return choice;
	}

	public static void firstScene () { //the first waking scene 
		Scanner input = new Scanner(System.in);

		if (turn > 0) {
			switch (deaths.peek()) {
				case ("Fell"): System.out.println("\n====FELL OFF====");
					System.out.println("You remember falling into an endless void, but you're back. Maybe you should try lying to him for now..."); 
				break;

				case ("Lost"): System.out.println("\n====LOST FOREVER====");
					System.out.println("You remember getting lost in that endless library, but you're back. Maybe you should try not running into the endless libary...");
				break;

				case ("Wall"): System.out.println("\n====CRASHED OUT====");
					System.out.println("You remember crashing into that wall while running from the Uniform Fiend, but you're back. Maybe you should keep your eyes on the road...");
				break;

				case ("Aka"): System.out.println("\n====TOILET...BOUND?====");
					System.out.println("You don't want to remember that. You need to cover up your uniform if you want Mr. Sunshine to help. Maybe his red cloak will do, if you could just get his guard down...");
				break;
			}

			System.out.println("\nIf you're ever stuck, you could try checking the bookshelf!");
		}

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
					System.out.println("Your eyes snap open. You sit up, looking around. There's nothing around you but still roots.");
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
		System.out.println("You're in a huge open library. It looks the same as a regular library, but there are trees and greenery mixed in between the towering, seemingly endless shelves. Roots crawl against the wooden floorboards.");
		System.out.println("\nThe ceiling is also completely open, revealing a starry evening. A part of you wonders how that's possible.");
	
		switch (turn) { //flavour text about counter books
			case 0: System.out.print("\nThere's a counter with one book on it."); break;
			case 1: System.out.print("\nThere's a counter with two books on it."); break;
			case 2:	System.out.print("\nThere's a counter with three books on it. Soon enough, they'll have a proper stack."); break;
			case 3: System.out.print("\nTHere's a counter with a stack of books on it. You're going to stop counting..."); break;
			default: System.out.print("\nThere's a counter with too many books for you to count on top.");
		}
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

			System.out.println("You stare at him blankly. He watches you back with a neutral expression.");
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
					System.out.println("\nYou frown as he speaks, but you get distracted. There's a door you hadn't noticed behind Mr. Yakubyougami.\n\n\"Nevermind. I think that's my exit.\" You hurry towards the exit with a smile. You open the door and step outside. Except there's no outside. You fall into the darkness.");
					fellOut = true; //died once to falling 
				}
				next = next();
				turn++;
				deaths.push("Fell"); //died to falling, most recent
				scenes.push("scene1"); //go back to scene 1
				sceneChooser();
			}
	
			System.out.println("\"Since you're here, could you fetch me the book sign-out records? They should be in the office.\" Mr. Yakubyougami gestures to a hallway beside the counter.");

			if (turn == 1) { //extra dialogue option for the first death
				System.out.println("\nYou still feel unsettled. Maybe you should ask him to confirm.");
				System.out.println("1. Ask him if you just died\n2. Stay silent");
				choice = choiceChecker();
				
				if (choice == 1) { //ask him
					System.out.println("\n\"Did I just die?\" you blurt out. " + 
					"\n\nMr. Yakubyougami gives you a strange look that suggests he thinks you've lost your mind. Maybe you have. " +
					"\n\n\"What...? Do you need a break...? If not, just get to work.\" He walks away and you lose him almost instantly among the shelves. Ugh...");
				} else {
					System.out.println("Mr. Yakubyougami walks away without a word.");
				}
			}
			metSano = true;
		} //end of Sano's first scene

		while (triedDoorScene == true) { //SCENE AFTER YOU RETURN FROM THE OFFICE
			triedDoorScene = false;

			System.out.println("\nYou return and explain the door situation to Mr. Yakubyougami.");
			System.out.println("\n\"I wasn't expecting that. Hmm...\" Mr. Yakubyougami mutters. He thinks for a bit before looking over to the shelves. \"That idiot who just arrived should be able to help you. Hey, Abe...!\" Mr. Yakubyougami calls someone over. Again, you couldn't hear what his name was.");
			next = next();
			if (metSeimei == false) { //first time meeting
				System.out.println("\nA tall man with black hair and large ahoge (or cowlick) pops his head out from the shelves with a bright close-eyed smile. He's wearing a white shirt and striped tie, suggesting he's a professional of some sort.");
				next = next();
				System.out.println("\nYou cover your eyes at his blinding smile. Since you missed his name...somehow...you decide to call him Mr. Sunshine. The joy radiating off of him was too much!");
				metSeimei = true;
			} else {
				System.out.println("\nMr. Sunshine pops his head out from the shelves with a bright close-eyed smile. He's wearing a white shirt and striped tie, suggesting he was a teacher.");
			}
		
			System.out.println("\nHe greets Mr. Yakubyougami cheerfully with a name you can't hear. Mr. Yakubyougami looks begrudgingly bashful at Mr. Sunshine's overwhelming joy.");
			next = next();
			if (sailorUni == false && redCloak == false) { //start Seimei chase
				System.out.println("\nHe stops suddenly as he finally looks at you.");
				System.out.println("\n\"I-Is that...IT'S A BLAZER UNIFORM???? GYAHHHHHHH!!\" His energy changes in an instant. You look down at what you're wearing and back at him. He charges at you.");
				System.out.println("\nIn response to that, you turn on your heels and RUN!");
				next = next();
				chasedBySeimei = true;

				scenes.push("chase");
				sceneChooser();

			} else if (sailorUni == true) { //has sailor uniform
				System.out.println("\nHe stops suddenly as he finally looks at you.");
				System.out.println("\n\"I-Is that...IT'S A SAILOR UNIFORM!! EEEEEEEEEEP! Oh, it's so beautiful!\" Mr. Sunshine's eyes light up. He squeals and circles you rapidly, looking over the uniform.");
				System.out.print("\nYou stand awkwardly and stare at Mr. Yakubyougami, who looks as embarassed as you feel.");
				next = next();
				cruelty--;
			
				System.out.println("\n\"Um, so Mr. Sunshine, can you help me open the office door?\" You clear your throat.\n\n\"Of course!\" Mr. Sunshine happily skips towards the hallway. You follow after him.");
				next = next();

			} else if (redCloak == true) { //has red cloak
				System.out.println("\n\"Oh, it's nice to meet you! I'm...\" Mr. Sunshine introduces himself. You stare at him, nodding slowly. At least he doesn't seem to have any adverse reaction to your outfit this time. \"You look around my students' age, um, although some of them don't look their age.\" Mr. Sunshine laughs, glancing at Mr. Yakubyougami who deadpans at him.");
				System.out.println("\n\"Can you go with them to open the office door?\" Mr. Yakubyougami clears his throat, tapping his foot impatiently.\n\n\"Oh, sure!\" Mr. Sunshine walks towards the hallway. You follow after him.");
				next = next();
			}
			System.out.println("\nMr. Sunshine walks up to the office door. You expected him to pull out a key, but all he does is try the knob. The paper ward flutters off. Mr. Sunshine easily pushes open the door.");
			System.out.println("\n\"Oh, the handle was a bit heavy. It's no problem though! I'll see you around!\" Mr. Sunshine grins. He leaves.");
		
			openDoor = true;
			scenes.push("office");
			sceneChooser();
		} //end of Seimei scene

		while (returnRecords == true) { //
			System.out.println("\nYou return to the library and hand the records off to Mr. Yakubyougami. He's in the middle of scolding Mr. Sunshine, who looks sheepish.");
			System.out.println("\nMr. Yakubyougami notices you and takes the records.\n\n\"Thanks...I'll put you in charge of the counter for now while I go return the books on this list,\" he sighs.");
			System.out.println("\nYou nod in understanding.");
			next = next();
			System.out.println("Mr. Yakubyougami grabs a stack of books and heads off, list in hand. Mr. Sunshine trails after him like an overeager puppy.");
			returnRecords = false;
		}

		if (goodEnd == true) {
			System.out.println("\nYou position yourself at the counter. A few patrons do come in, and you help them out the best you can. It's fun.");
			System.out.println("Your eyelids begin growing heavy as the day goes on. You're close to dozing off when...");
			next = next();
			System.out.println("\"Yoohoo! You weren't planning on sleeping on the job were you?\"");
			System.out.println("\nYou look up.");
			next = next();
			System.out.println("A man with parted black hair and a long white coat is leaning over the counter with a fond smile.");
			next = next();
			System.out.println("\n\"You're Dr. Dodomeki...?\" you yawn, rubbing your eyes as you sit up.");
			System.out.println("He nods. \"Yes, and I'm here to take you home with me, if that's what you'd like.\" He offers you a hand.");
			next = next();
			System.out.println("\"I'm sleepy...\" You continue yawning as you take his hand in yours. He laughs and leads you out of the store, but not before you both give your goodbyes to Mr. Sunshine and Mr. Yakubyougami.");
			System.out.println("====GOOD END!====");

			next = next();
			System.exit(0);
		}

		while (endingScene == true) {
			System.out.println("You hear Mr. Sunshine chatting Mr. Yakubyougami's ear off in the distance. Mr. Yakubyougami occasionally responds dryly or with insults towards Mr. Sunshine.");
			System.out.println("1. Go towards them\n2. Leave them be");
			choice = choiceChecker();
			if (choice == 1) {
				System.out.println("\nYou walk over and peek at what they're doing. Mr. Yakubyougami and Mr. Sunshine are stopped in front of a shelf and Mr. Sunshine appears to be discussing his class. Books keep falling on Mr. Sunshine's head...it must be Mr. Yakubyougami's influence.");
				if (scissors == true) {
					System.out.println("\nYou sneak up closer, and when the moment is right, you snip off Mr. Sunshine's cowlick! Weirdly enough, a new one pops back into place so nobody notices a thing.");
					seimeiHair = true;
					endingScene = false;

				}
				System.out.println("There's nothing else for you to do here, so you walk back.");
				next = next();

				scenes.push("library");
				sceneChooser();
			}
		}

		if (badEnd == true) {
			if (chalk == true && candlesAndLighter == true && seimeiHair == true && ichijama == true) { //have all ritual pieces
				System.out.println("\nYou step out and begin drawing a large pentagram using the chalk.");
				next = next();
				System.out.println("Next, you place a candle at every point of the star and light it up.");
				next = next();
				System.out.println("Using Mr. Sunshine's hair, you place it in the center next to your ichijama butokii. You stand in the center as well.");
				next = next();
				System.out.println("For the prayer...you think for a bit before deciding a name to pray to.");
				System.out.println("\n\"" + name + ", please cleanse this living curse from this world.\" You close your eyes and begin praying to " + name + ".");
				next = next();
				System.out.println("Light floods your vision and your body feels a lot lighter.");
				System.out.println("'Ah...I'm free' You think, and then it all disappears.");
				System.out.println("====END====");

				next = next();
				System.exit(0);
			}
		}

		System.out.println("1. Look at bookshelf\n2. Continue to the hallway");
		choice = choiceChecker();

		switch (choice) {
			case 1: //look at shelf
				System.out.println("You look at the bookshelf.");

				next = next();
				scenes.push("bookshelf");
				sceneChooser();
			break;

			case 2:	//continue to hall
				if (firstTimeBookshelf == true) { //haven't looked at shelf yet
					System.out.println("There's still something you're curious about. Maybe you should go check out the bookshelf before you move on.");
					next = next();
					scenes.push("library");
					sceneChooser();
				}

				System.out.println("With nothing else to do, you decide to head over to the hallway.");
				next = next();
				scenes.push("hallway");
				sceneChooser();
			break;
		}
	}

	public static void bookshelf() { 
		System.out.println("========BOOKSHELF========");

		if (firstTimeBookshelf == true) { //a one-time check for if MC knows how the books work
			System.out.println("You reach for a book. As soon as you open it, the surface of the book ripples. A fat white radish is buried in the dirt, looking adorable in its drawn style.");
			next = next();
			System.out.println("Hesitantly, you touch the rippling surface. Your finger sinks into the surface and you pluck the vegetable out of the dirt by the leaves. It screams insults at you and bites your finger.");
			next = next();
			System.out.println("\n\"Yeowch!\" you yelp, dropping the book and falling on your butt. Leaves scatter around you as the book closes. You rub your finger. Thankfully, it didn't draw blood."); 
			System.out.println("\nYou get up. Okay...maybe you could do something like that with other books too...\n");
			firstTimeBookshelf = false;
			next = next();
		}

		System.out.println("You walk up to the nearest bookshelf. The Ritual Book draws your attention...");

		//------CHOOSING BOOKS-----------------------------------------------------
		books.clear(); //clear books
		System.out.println("1.[Origami with Unusual Materials]\n2.[Laidback Guide to the Wacky and Wysterious]\n3.[Ritual Book]");
		books.add(1); 
		books.add(2);
		books.add(3);

		if (readRitualBook == true) {
			System.out.println("4.[The Chalk Prince]");
			books.add(4);
		}

		if (chasedBySeimei == true) {
			System.out.println("5.[Catalog of Sailor Uniforms Over the Ages]");
			books.add(5);
		}

		if (dieAka == true) {
			System.out.println("6.[That Time I Was a Whale, and I Ate a Guy's Leg]\n7.[Bloody Baking]");
			books.add(6);
			books.add(7);

		}//reading bloody baking or birthday after reading chalk prince will allow you to get cake

		if (openDoor == true) {
			System.out.println("8.[Lit Birthday Etiquette]\n9.[Scissor Serial]");
			books.add(8);
			books.add(9);
		}

		System.out.println("\n1. Read a book\n2. Return to the library");
		choice = choiceChecker();
		
		
		if (choice == 2) {
			while (readRitualBook == false) { //haven't read ritual book yet
				System.out.println("You move to leave...but you feel like you're missing something. The Ritual Book is calling your name...not that you knew what your name was.");
				next = next();
				scenes.push("bookshelf");
				sceneChooser();

			}
			scenes.push("library"); //return to libary
			sceneChooser();
		}

		if (choice == 1) {
			System.out.print("Enter the book number: ");
			choice = bookshelfChecker();
			switch (choice) {
				case 1: //origami book 
					System.out.println("It's a guide about folding origami using strange materials, such as toilet paper.");
					while (toiletPaper == false && sailorUni == false) {
						if (dieAka == true) {
							System.out.println("You reach your hand in and grab a roll of toilet paper.");
							toiletPaper = true; 
						}
					break;
					}
				break;

				case 2: //wacky guide
					System.out.println("It's a book about various types of creatures. You flip to a random page.");
					Random random = new Random(); //random pages
					int page = random.nextInt(7);

					switch (page) {
						case 1: //Sano's page
							System.out.println("====PAGE 7====");
							System.out.println("\"Yakubyougami are malevolent spirits who spread disease and misfortune to others around them. They are also known as 'Gods of Plague'.\"");
						break;
						case 2: //Seimei's page
							System.out.println("====PAGE 21====");
							System.out.println("\"Onmyojis are historically powerful diviners who occasionally perform tasks like cleansing to get rid of bad youkai! The Abe family is one of the most well-known.\""); 
						break;
						case 3: //Aka Manto's page
							System.out.println("====PAGE 4====");
							System.out.println("\"Aka Manto is a ghost who haunts bathrooms without toilet paper. A figure with a ghastly red cloak will arrive and offer red or blue toilet paper" + 
							" before delivering a harsh punishment. How unhelpful!\"");
						break;
						case 4: //Dodomeki's page
							System.out.println("===PAGE 10====");
							System.out.println("\"A dodomeki is a type of oni with many eyes and long arms! They can will eyes to appear all over their body or within a 500ft radius, as a historical punishment for coin theives.\""); break;
						
						case 5: //Ichijama page
							System.out.println("====PAGE 14===="); 
							System.out.println("\"An icihijama is a curse, but the term also refers to the family line that posesses the knowledge on how to create and manifest a ichijama butokii." +
							" A spirit resembling the caster will visit the target and deliver a gift. After recieving the gift, the target develops an unidentifiable disease.\""); break;
						
						case 6: //Mandragora page
							System.out.println("====PAGE 300===");
							System.out.println("\"Mandragoras, otherwise known as mandrakes, are poisonous plant creatures who resemble radishes, but they hate being mistaken as anything but mandragoras." + 
							" They shriek when pulled out of the ground.\""); break;

						default: //Library page
							System.out.println("====PAGE 41====");
							System.out.println("\"There exists a library that contains every book in the world, including every living creature's story."+ 
							" Nobody knows where it is, but it's possible this library is disguised as a regular bookstore?\""); break;
					}
				break;

				case 3: //ritual book
					readRitualBook = true;
					System.out.println("It's a book on exorcisms. There are instructions.");
					System.out.println("\"1. Draw a pentagram with chalk\"");
					System.out.println("\"2. Place and light five candles on each point of the star\"");
					System.out.println("\"3. Place a piece of an exorcist in the center along with the cursed item or person\"");
					System.out.println("\"4. Chant and start praying to whoever you believe in\"");
					
					System.out.println("\nHuh. Interesting. You take note of the book. It wouldn't be bad to prepare for it anyways, regardless of if you're performing it or not.");
				break;
				
				case 4: //chalk book
					System.out.println("It's an adventure picture book about a little chalk prince wielding a chalk sword. He's on a quest to retrieve the cake for his daisy.");
				
					if (readChalkPrince == false) { //first time reading
						System.out.println("\nYou reach in and try to pluck the chalk sword out of the prince's hands. He nimbly jumps away!");
						System.out.println("\n\"Excuse me! You can't just steal my sword! I need it for my quest!\" The Chalk Prince speaks.");
						System.out.println("\nYour brows furrow as you think hard about how to proceed.");
							
						readChalkPrince = true;
					}
					while (chalk == false) {
						System.out.println("\n\"Well?\" The Chalk Prince stares at you expectantly from the page.");
						boolean cakeQuest = false; //have you finished the quest yet

						next = next();
						while (cakeQuest == false) {
							System.out.println("1. Rob him\n2. Trade him a cake");
							choice = choiceChecker();

							if (choice == 1) {
								System.out.println("\n\"Sorry.\" You pick the Chalk Prince up and pull him away from his sword. He struggles fruitlessly against you, but you easily yank the sword away from him.");
								System.out.println("You close the book as the Chalk Prince begins crying.");
								cruelty++;
								chalk = true;
							}

							if (choice == 2) { //cake quest
								if (cake == false) { //doesn't have cake yet
									System.out.println("\n\"I'll get you a cake.\" You nod.");
								}
								else { //have a cake
									System.out.println("\n\"Here you go!\" You offer the cake into the book. It's bigger than the Chalk Prince but he celebrates.\n\n\"Thank you, kind lad! Please, have my sword!\" He holds up his sword for you. You smile and take the sword from him.");									
									chalk = true;
									cruelty--;
								}
							cakeQuest = true; //finished
							} //end of cake quest
						break;	
						}
					break; //should only run if you DON'T have the chalk
					}
				break;

				case 5: //sailor catalog
					System.out.println("It's as the title says. It's a book about different types of sailor uniforms through different eras.");
					
					while (sailorUni == false) {
						if ((chasedBySeimei == true) && (toiletPaper == false)) { //chased by Seimei, haven't gotten toilet paper
							System.out.println("\nMr. Sunshine would probably like this. You reach your hand into a random page and pull out a whole sailor uniform. You hastily wear it over your blazer uniform.");
							sailorUni = true;
						}
					break;
					}
				break;

				case 6: //whale book
					System.out.println("It's a comical retelling of a famous book about a whale.");

					while (bluePaper == false) {
						if ((toiletPaper == true) && (redPaper == false) && (sailorUni == false)) { //has toilet paper, hasn't dyed it yet, doesn't have sailor uniform
							System.out.println("You take the toilet paper and place it into the rippling surface of the book. You dip it in the blue waters, and your toilet paper comes out blue. Huh.");
							bluePaper = true;
						}
					break;

					}
				break;

				case 7: //baking book
					System.out.println("It's a cookbook for red cakes themed after horror movies.");
				
					while (redPaper == false) {
						if ((toiletPaper == true) && (bluePaper == false) && (sailorUni == false)) { //has toilet paper, hasn't dyed it yet, doesn't have sailor uniform
							System.out.println("You take the toilet paper and place it into the rippling surface of the book. You dip it in the red icing, and your toilet paper comes out red. Huh.");
							redPaper = true;
						}
					break;	
					}

					while (cake == false) {
					  if ((readChalkPrince == true) && (chalk == false)) { //don't have cake, has read the Chalk book, don't have chalk
							System.out.println("\nYou reach in and pull out a slice of cake. Yum.");
							cake = true;
						}
					}
				break;

				case 8: //birthday book
					System.out.println("It's a book about how to pull off the best birthday parties, specifically with fire.");
					
					while (cake == false) {
						if ((readChalkPrince == true) && (chalk == false)) { //don't have cake, has read the Chalk book, don't have chalk
							System.out.println("\nYou reach in and pull out a slice of cake. Yum.");
							cake = true;
						}
					break;	
					}

					while (candlesAndLighter == false) {
						if (openDoor == true && candlesAndLighter == false) {
							System.out.println("You reach in and pluck 5 candles off the cake and the lighter next to it.");
							candlesAndLighter = true;
						}
					break;	
					}

				break;

				case 9: //Scissor book
					System.out.println("It's a horror story about a classic slasher who uses scissors.");

					while (scissors == false) {
						System.out.println("You reach in and pull out a pair of scissors.");
						scissors = true;
						break;
					}
				break;
			} 
		next = next();
		scenes.push("bookshelf"); //return to bookshelf selection
		sceneChooser();
		}
	}
		
	public static void hallway() {
		System.out.println("========HALLWAY========");
		System.out.println("You're in a regular hallway. The ceiling is closed here with fluorescent lights dimly lighting the hallway.");
		System.out.println("\nThere are two doors down the hall.");

		System.out.println("1. Enter the office\n2. Enter the bathroom\n3. Return to the library");
		choice = choiceChecker3();

		switch (choice) {
			case 1: //enter office
				if (openDoor == false) { //haven't opened door yet
					if (triedDoor == false){
						triedDoor = true; //you have tried to open the door
						triedDoorScene = true; //trigger the scene in the library later
						System.out.println("You try the handle, but you instantly fall backwards on your butt because you're dumb. Maybe you tripped over your own feet while standing still.");
						System.out.println("\nYou look up to see there's a paper with characters on it hanging on the door. It reads that it's intended for protection." + 
						" You're not sure how you understood that. You rub your butt, getting onto your feet.");
						next = next();
						System.out.println("\"Huh, I guess the owner is superstitious,\" you grumble. Oh well. That means you should return to Mr. Yakubyougami for now.");
						next = next();
					} 
					else {
						System.out.println("Okay, well, the door is still closed, as you expected. You return to the library.");
						triedDoor = true; //you have tried to open the door
						triedDoorScene = true;
						next = next();
					}
					scenes.push("library");
					sceneChooser(); //return to library
				}
				scenes.push("office");
				sceneChooser();
			break;

			case 2: //enter bathroom
				if (chasedBySeimei == false) {
					System.out.println("You don't really have to pee or poo right now...and what if a scary ghost drags you down? No way. You leave.");
					next = next();

					scenes.push("hallway");
					sceneChooser();
				} //hasn't been chased yet
				scenes.push("bathroom");
				sceneChooser();
			break;

			case 3: //go back to library
				if (triedDoor == false) {
					System.out.println("You haven't even done what you were set out to do yet.");
					next = next();
				} else {
					scenes.push("library");
					sceneChooser();
				}
			break;
		}
		
	}

	public static void chase() {
		System.out.println("You immediately start booking it away from Mr. Sunshine...or should you call him the Uniform Fiend?! All you hear from behind you are his scary words about how sailor uniforms were superior to blazer uniforms.");
		System.out.println("1. Run into the libary\n2. Run into the hallway");
		choice = choiceChecker();

		switch (choice) { 
			case 1: //death to getting lost
				System.out.println("\nYou run into the aisles of shelves. It doesn't take long for you to lose him.");
				System.out.println("\nYou turn around. You can't see anything familair. You begin trying to retrace your steps.");
				
				for (int i = 0; i < 3; i++) {
					next = next();
					System.out.println(".");
				}

				System.out.println("You don't know how long you've been here or how long it's been.");
				System.out.println("\n\"Mr. Yakubyougami? Mr. Sunshine...?\" you call out.");
				next = next();
				System.out.println("The vastness does not respond.");

				for (int i = 0; i < 3; i++) {
					next = next();
					System.out.println(".");
				}

				System.out.println("You're tired.");
				next = next();
				System.out.println("You lay down. You close your eyes.");
				turn++;

				deaths.push("Lost");
				scenes.push("scene1");
				sceneChooser();
			break;
			case 2: //actual chase
				System.out.println("\nThe hallway seems to stretch on forever to spite you. Was it really this long before?");
				System.out.println("1. Run\n2. Look back");
				int speed = 0;
				choice = choiceChecker();
					switch (choice) {
						case 1://run 
							System.out.println("\nYou refuse to look back as you keep running. You feel like he's getting closer.");
							speed++;
						break;
					
						case 2: //look back
							System.out.println("\nHe's a moderate distance away, but he's getting closer.");
							speed--;
						break;
					}
				next = next();

				System.out.println("\n\"Blazer uniforms are just a blight on society!\" the Uniform Fiend screeches. It's not fair that his legs are longer than yours.");
				System.out.println("1. Run\n2. Look back");
				choice = choiceChecker();
					switch (choice) {
						case 1:
							System.err.println("\nYou have got to keep running. You push yourself, finding you're unexpectedly fast.");
							speed++;
						break;
						
						case 2: 
							System.out.println("\nYou turn your head. He's almost right behind you!");
							speed--;
						break;
					}
				next = next();

				System.out.println("\"Come back!\" the Uniform Fiend shouts. His footsteps are getting closer.");
				System.out.println("1. Run\n2. Look back");
				choice = choiceChecker();
					switch (choice) {
						case 1:
							System.out.println("\nYou dash, breathing heavily now. How long was this hallway...?");
							speed++;
						break;
						
						case 2:
							System.out.println("\nYikes! His face was right there behind you; blacked out except for a fierce look in his eyes! He looked like a straight monster!");
							speed--;
						break;

					}
				next = next();

				System.out.println("\"Wait! Slow down!\" he yelps, reaching out his hand.");
				System.out.println("1. Run\n2. Look back");
				choice = choiceChecker();
					switch (choice) {
						case 1:
							System.out.println("\n\"T-That's what kidnappers say! I'm not stupid!\" you retort, still running. You're out of breath at this point.");
							speed++;
						break;

						case 2:
							System.out.println("\n\"GAAAAAAH, GET AWAY FROM ME, FREAK!\" you scream. His hand is about to reach your face!");
							speed--;
						break;
					}
								
				next = next();
				
				if (speed < 2) { //you looked back too many times, GAME RESTART
					System.out.println("\nPanicked, you don't see where you're going.");
					System.out.print("\nMr. Sunshine reaches his hand out...past your head? You look up for a brief moment and he looks just as panicked as you.");
					next = next();
					System.out.println("You run straight into the wall, hitting your head. Your vision blurs and there's a heavy pounding in your head.");
					for (int i = 0; i < 3; i++) {
						next = next();
						System.out.println(".");
					}
					System.out.println("\nOh, he was trying to cushion my head against the wall. You realize that belatedly.");
					next = next();
					System.out.println("\nYour consciousness is fading. Mr. Sunshine hovers over you, worried and frantically calling someone's name.");
					next = next();
					System.out.println("A blond blur arrives after a few seconds. You hear bits of their conversation.\n\n\"...are they dead?!\" Mr. Sunshine looked like he was about to burst into tears from the worry.\n\n\"...be fine,\" he replies, staring at you.");
					next = next();
					System.out.println("You black out.");
					next = next();
					
					deaths.push("Wall");
					turn++;
					scenes.push("scene1");
					sceneChooser();
				} else {
					finishChase = true;
					System.out.println("Making a split-second choice, you spin around on your heel and run backwards. Behind you, you hear the Uniform Fiend crash into the wall.");
					System.out.println("\nYou quickly enter the first door you see, pushing it open.");
					next = next();

					scenes.push("bathroom");
					sceneChooser();
					
				}
			break;
		}
	}
	public static void bathroom() {
		System.out.println("========BATHROOM========");
		System.out.print("You're in a clean looking bathroom. There are four stalls and a weird corner behind the stalls where the light is dimmer. None of the stalls appear to have any toilet paper and some of the locks are loose. It's awful.");

		while (finishChase == true) {
			System.out.println("\n\nYou run into the fourth stall, closing the door behind you. You wait, listening as Mr. Sunshine walks away, wondering aloud where you went.");
			System.out.println("\nYou sigh in relief, knowing he's left you alone for now. Since you were here, you might as well relieve yourself before you head back out.");
			next = next();
			
			System.out.println("Just as you finish, you hear a knock on the stall's door.");
			System.out.println("\n\"...? There's someone in here.\" You speak up. There were three other stalls.");
			next = next();
			
			System.out.println("They knock again.\n\n\"Just hold on. I'll be out in a minute,\" you grumble. Yeesh.");
			System.out.println("\nYou turn to your right to grab the toilet paper...but there is none. Your heart sinks.");
			next = next();
			
			System.out.println("\"Do you need toilet paper?\" the voice outside asks. You peer down at the shoes outside. All you see is a red fabric that reaches the bathroom floor...kind of gross. Before you can reply, he holds out two rolls of toilet paper. One's red and one's blue.");
			System.out.println("\n\"Would you like the red or blue paper?\""); 
			next = next();

			System.out.println("\"Do you have...normal paper?\" You try to ask. He doesn't reply.");
			System.out.println("\nYou sigh. Desperate times called for desperate measures.");
			
			System.out.println("1. Red toilet paper\n2. Blue toilet paper");
			choice = choiceChecker();

			switch (choice) { //toilet paper endings
				case 1: //red paper
					System.out.println("You try to reach for the red, but he pulls it away. You watch as he reaches his hand underneath the stall, impossibly long.");
					System.out.println("\nClick.");
					next = next();

					System.out.println("You look up. The bathroom door is open.");
					System.out.println("\n\"Hehehe, here's your toilet paper.\" It's a person in a long red cloak.");
					next = next();

					System.out.println("\n'Aka Manto' Your brain helpfully pipes up again. Red Cloak. Thanks, brain.");
					System.out.println("\nYour face turns red, from embarrassment and anger equally. Your nose begins bleeding.");
					
					System.out.println("\n\"Ugh! Pass me the paper!\" You grab the toilet roll from his hands and fumble to plug up your nose. However, there's just too much.");
					next = next();
				break;

				case 2: //blue paper
					System.out.println("You try to reach for the blue, but he pulls it away. You watch as he reaches his hand underneath the stall, impossibly long.");
					System.out.println("\nClick.");
					next = next();

					System.out.println("You look up. The bathroom door is open.");
					System.out.println("\n\"Hehehe, here's your toilet paper.\" It's a person in a long red cloak.");
					next = next();

					System.out.println("\n'Aka Manto' Your brain helpfully pipes up again. Red Cloak. Thanks, brain.");
					System.out.println("\n\"You...!\" You begin coughing. You choked on your own spit in your anger and embarassment.");
						
					System.out.println("\nYou panic and clutch at your throat, turning blue. However, it's just too much.");
					next = next();
				break;
			}
			System.out.println("\"Um, are you okay?\" Aka Manto has the audacity to ask.");
			System.out.println("\nYou pass out in response, thinking 'ughhh, that was so embarassing...'");
			finishChase = false; 

			deaths.push("Aka"); //died to Aka...is it more embarassing to run into a wall or this guy?
			dieAka = true;
			turn++;

			scenes.push("scene1");
			sceneChooser();
		} //end of chase context Aka

		System.out.println("\n1. Stay in the bathroom\n2. Return to the hallway");
		choice = choiceChecker();

		switch (choice) {
			case 1: //stay in bathroom
			
			while (waitingForAka == false) {
				if (dieAka == true) {
					System.out.println("\nLast time you were here, you ran into an embarassing situation.");			
						
					System.out.println("\nThis time...you have a plan. You decide to wait out in a different stall.");
						
					for (int i = 0; i < 3; i++) {
					next = next();
					System.out.println(".");
					}

					System.out.println("You hear footsteps and see the shuffling red cloak. Aka Manto stands in front of the fourth stall.");
					System.out.println("\n\"...\" You hold your breath.");
					
					for (int i = 0; i < 3; i++) {
					next = next();
					System.out.println(".");
					}

					System.out.println("After a moment, you hear a click as Aka Manto enters the stall.\n\n\"I guess there's nobody in here...\" Aka Manto sighs aloud in his stall.");
					System.out.println("\nYou feel awkward, listening in on him as he uses the bathroom. He flushes, and then there's silence.");
					next = next();
						
					System.out.println("\"Is anybody there?! There's no toilet paper!\" You hear him call out after a minute.");
				}		
				waitingForAka = true;			
			}
			if (dieAka == true) {
				System.out.println("\nHe's still stuck in the stall. You could get revenge and steal his red cloak to cover up your uniform.");
			}

			while (redCloak == false) { //don't have red cloak
				if (bluePaper == true || redPaper == true) {
					System.out.println("\nYou approach the stall, toilet paper in hand.\n\n\"Do you need toilet paper?\" you ask innocently.");
					System.out.println("\n\"...\"");
					for (int i = 0; i < 3; i++) {
						next = next();
						System.out.println(".");
					}
					System.out.println("\n\"Is there normal paper...?\" Aka Manto meekly asks. You do not respond.");
					next = next();
				
					System.out.println("He reluctantly reaches for your toilet paper, but you pull it away before he can grab it.");
					System.out.println("\nAll you do need to do for the lock to come loose is push against the door at an angle. That opens the stall door right up.");
					next = next();

					if (redPaper == true) {
						System.out.println("You lean against the door frame. Then, you do something so terrible that you wouldn't have done outside of this circumstance.");
						next = next();

						System.out.println("\"Hey, peeing by yourself, beautiful?\" You hold out the toilet paper roll charmingly."); //pls don't say anything, this was absolutely essential to the characterization of the main character, I swear
						next = next();
						
						System.out.println("Aka Manto's face turns as red as his cloak. Steam comes from the top of his head. He passes out.");
					}

					if (bluePaper == true) {
						System.out.println("Your hand twitches as you stand over him, but a voice in your head tells you that you can't give him a swirlie. Instead, you point at him.");
						next = next();
						
						System.out.println("\n\"You're ugly,\" you speak bluntly.");
						next = next();

						System.out.println("Aka Manto's lips quiver as a sign that he's growing blue He begins crying uncontrollably and loudly.");
					}

					System.out.println("\nWhile he's incapacitated, you pull the cloak off of him. He's really just another guy your age. You fasten it around yourself and leave him quickly.");

					redCloak = true;
					cruelty++;

					next = next();
					scenes.push("hallway");
					sceneChooser();

				}
				next = next();
				scenes.push("hallway");
				sceneChooser();
			}
			next = next();
			
			scenes.push("hallway");
			sceneChooser();
			break;

			case 2:
			System.out.println("You turn around and exit the bathroom.");
			next = next();
			
			scenes.push("hallway");
			sceneChooser();
			break;
		}

	}
	public static void office() {
		Scanner input = new Scanner (System.in);
		System.out.println("========OFFICE========");
		System.out.println("It's a cozy office. There's a desk in the center and a picture of the previous owner hung on the wall. The desk has a bunch of papers over it; some might be important to you.");
		System.out.println("\nThere's a vault in the corner.");
		
		System.out.println("1. Stay in the office\n2. Return to the library");
		choice = choiceChecker3();
		boolean still;
			switch (choice) {
				case 2: //return library
				
				while (ending == false) { //haven't picked ending yet
					if (readNotes == true && readSignOutRecords == true && ichijama == true) { //have everything
						System.out.println("\nWith nothing else left to do here, you're set to return to the library with the sign-out records in hand.");
						next = next();

						//ENDING------------------------------------------------
						System.out.println("Before you return, there's decision you have to make now. You take out the look-alike doll from your pocket.");
						System.out.println("\nNow that you know that you're just a living curse, do you still want to continue your purposeless existence?");
						System.out.println("Dr. Dodomeki could come back for you, or you could exorcise yourself.");
						for (int i = 0; i < 3; i++) {
							next = next();
							System.out.println(".");
						}
						System.out.println("====" + cruelty + " CRUELTY POINTS====");

						if (cruelty > 0) { //BAD END
							badEnd = true;
							System.out.println("'No. I'm a curse who has failed my purpose.' You shake your head. There's nothing left for you to do anyways.\n\nYou can use that ritual book to exorcise yourself.");
							next = next();
							System.out.println("\nYou set back to the library, intent on performing that ritual.");
						} else { //GOOD END
							goodEnd = true;
							System.out.println("'No! Dr. Dodomeki said he was coming back. I can find out more about myself then, I'm not just some living curse!' you huff to yourself.");
							next = next();
							System.out.println("You return to the library, ready to find a new purpose.");
						}
						next = next();
						
						ending = true;
						returnRecords = true;
						endingScene = true;
						scenes.push("library");
						sceneChooser();
					}
					else { //missing things
						System.out.println("\nYou feel like there's something you're still missing here.");
						next = next();
								
						scenes.push("office");
						sceneChooser();
					}
				}
				break;
			}
		
		System.out.println("There's some things that catch your attention.");
		System.out.println("1. Read the notes\n2. Look at the vault\n3. Read the book sign-out records");
		choice = choiceChecker3();

		switch (choice) {
			case 1: //dr. dodomeki notes
			readNotes = true;
			System.out.println("\nYou look over the notes on the table. There's a lot. It looks like a doctor's handwriting too, but you're skilled at reading that for some reason. The name signed on the notes is 'Dr. Dodomeki'.");
			next = next();
			
			System.out.println("====NOTES====");
			System.out.println("\"I suspect a student tried to curse me recently. They attempted to gift me something amidst the crowd on Feburary 14th.\"");
			next = next();
			
			System.out.println("\"I got a mild rash on my arm afterwards. Thankfully, those are easy to remedy nowadays. I suspected nothing of it, until I found something curious outside my clnic.\"");
			System.out.println("\n\"There was a fabric doll with a nail in the arm which I recognize as an ichijama butokii! Isn't that just THRILLING?!^O^\"");
			next = next();
			
			System.out.println("\"I've never met a proper member of the Ichijama family...my, besides that one time I met a woman who ALSO attempted to curse me.\"");
			System.out.println("\"She had such beautifully sharp eyes...and I wish I could've studied her more, but she ran away...\"");
			System.out.println("\n\"Even so, I've never seen the ichijama butokii itself up-close before.\"");
			next = next();

			System.out.println("\"Thanks to this exciting opportunity, I managed to study the ichijama butokii and summon back the living curse by boiling it correctly. However...it seems to have lost its purpose.\"");
			next = next();

			System.out.println("\"The ichijama appears to have trouble with long-term memory and can hardly remember the names of those the caster knew. I suspect this is because it failed to fufill its purpose in cursing me, hence why the caster tossed it aside.\"");
			System.out.println("\n\"This is a much greater gift to me than they could've ever imagined.\"");
			next = next();

			System.out.println("\"I've decided to leave the ichijama at my dear old friend's bookstore. Just until they've found their purpose. In the meantime, I'll work with .... to investigate the student's family.\"");
			System.out.println("====END NOTES====");
			next = next();

			System.out.println("You frown. You can't read the name mentioned in the notes, but your brain fills in that Dr. Dodomeki is probably talking about Mr. Doppelganger. You don't know who that is, but you've learned not to question what your brain tells you.");
			System.out.println("\nThat was a lot to take in. You have a suspicion towards your own identity now. You flip over the note to find there's still a bit more.");
			next = next();

			System.out.println("====EXTRA NOTE====");
			System.out.println("\"My, I also discovered that [Mr. Sunshine] visits the bookstore often because his student, [Mr. Yakubyougami], works there.\"");
			System.out.println("\n\"I'm excited to inspect him closer one day...considering his identity.\"");
			next = next();
			
			System.out.println("\"[Mr. Sunshine] is the descendant of the legendary diviner and exorcist of the Abe family after all. I wonder if I could bribe him with sailor uniforms into allowing me to pick him apart?\"");
			System.out.println("====END NOTES====");
			next = next();
			
			System.out.println("Okay, you didn't know how to feel about that one. Mr. Sunshine, or the Uniform Fiend, had such a powerful lineage? It was hard to believe because he did appear underwhelmingly normal at first. You shrug, placing the notes back.");
			next = next();
			break; //END OF NOTES

			case 2: //vault
			System.out.println("\nYou crouch down. It's a regular vault with a number pad.");

			while (ichijama == false) {
				System.out.println("\nYou wonder if you can try cracking it open. Something inside is calling you.");
				if (readNotes == true) { //read the notes
					System.out.println("\nMaybe you could try 0214 or 214...? That was the date mentioned in Dr. Dodomeki's notes.");
				}
				System.out.print("Input a code: ");
				boolean code = vaultCode();

				if (code == true) {
					System.out.println("\nThe vault swings open! You peer into the vault and grab the object sitting inside of it.");
					System.out.println("\nIt's...not what you were expecting.");
					next = next();
					
					System.out.println("It's a doll made with fabric and stuffed with straw. It has holes for an eye and mouth. There's also a sewn patch over the doll's arm, indicating there likely was a hole there previously.");
					next = next();
					
					System.out.println("'An ichijama butokii.' You instantly recognize it as well.");
					next = next();

					System.out.println("\nWorst of all, it...looks like you.");
					System.out.println("\n\"That's not...creepy at all.\" You sniff. This might be the object that was calling to you.");
					next = next();

					System.out.println("You pocket the ichijama doll. It IS yours after all.");
					ichijama = true;
					next = next();
				} 
				if (code == false) {
					System.out.println("The vault doesn't open. Hm, maybe you should look around some more.");
					next = next();
					break;
				} 	
			}			
			break;

			case 3:
			while (readSignOutRecords == false) {	
				System.out.println("\nYou read over the book sign-out records for the library. You read it over and you don't recognize any of these names, nor do you find particularly interesting.");
					System.out.println("\nSomeone named Ten-something took out at least 20 manga in one day, but that's neither here nor there.");
					next = next();
					System.out.println("You pick up the record to return to Mr. Yakubyougami.");
					readSignOutRecords = true;
					next = next();
					
					scenes.push("office");
					sceneChooser();
			} 
			System.out.println("You picked it up already.");
			next = next();
			break;
		}
		
	}

	public static int choiceChecker3 () { //checks whether it's a valid choice number (for 3 answers) 
		Scanner input = new Scanner(System.in);
		int choice = 0; 

		while (!(input.hasNextInt())) { //make sure input is definitely an int
				input.nextLine(); //clear scanner
		}
		do{
			try {
				choice = 0;
				choice = input.nextInt();
			} catch (InputMismatchException e) { //IF THEY PUT IN ANOTHER STRING I'M JUMPING THEM
				input.nextLine(); //clear
			}
		} while (!(choice == 1) && !(choice == 2) && !(choice == 3));
		return choice;
	}
	public static boolean vaultCode() {
		Scanner input = new Scanner(System.in);
		int choice;

		while (!(input.hasNextInt())) {
			input.nextLine(); //clear scanner
			System.out.println("You can't put anything but integers into a keypad, c'mon...you know this.");

			System.out.print("Input a code: ");
		}
		choice = input.nextInt();
		
		if (choice == 214) {
			System.out.println(choice);

			return true;
		} else {
			System.out.println(choice);
			return false;
		}
	}
	
} //this is end of code btw, Angie, so you don't screw up the brackets
