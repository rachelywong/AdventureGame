
import java.util.Scanner;

/**
 * @author Team7
 * 
 * Main class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the main method for the game, and initiates the beginning
 * of the entire game. The user is prompted to make choices using a while loop
 * and if/else if/else statements. The user will continue to progress throughout the game.
 */ 

public class Main {

	/**
	 * 
	 * Main method for the entire game.
	 * <p>
	 * This method prompts the user with information about the game and how to get started.
	 * The method asks users to make decisions in the games by submitting text responses as prompted
	 * and is read user reader and Scanner.
	 */ 
	public static void main (String[] args) {
		System.out.println("Someone has been murdered. Please choose a detective to solve the mystery.");

		Scanner reader = new Scanner(System.in);  
		System.out.println("Please type your choice and remember to choose wisely.");
		System.out.println("Detective A or Detective B?");
		String detective = reader.next();
		System.out.println("Congrats, you are detective " + detective);
		System.out.println("You have been assigned to this case. Make choices by typing the multiple choice letter in uppercase to try to solve the murder");
		System.out.println("Some choices require you to type the word in brackets ()");
		System.out.println("How will you get the case file?");
		System.out.println("A) Talk to your superintendent");
		System.out.println("B) Steal the file");

		/**
		 * casefile variable (String) is saved as user input to determine the program's next steps based on user action
		 */ 
		String casefile = reader.next();

		/**
		 * casefileChoice variable (boolean) is saved as user input to determine the program's next steps based on user 
		 * action. A Tic Tac Toe game (specific Tic Tac Toe class) will be launched depending on user input. 
		 */ 
		boolean casefileChoice = true;

		while (casefileChoice == true) {

			if (casefile.equals("A")) {
				System.out.println("Would you like to play Tic Tac Toe or start the case? (type PLAY or START)");
				String TTT = reader.next();
				casefileChoice = false;
				if (TTT.equals("PLAY")) {
					TicTacToeGame.main(args); //call TTT
				}
				else {
					System.out.println("Here is the case! "); //clue #1
				}

			}

			else if (casefile.equals("B")) {
				System.out.println("You've been fired. Make better choices.");
				System.out.println("How will you get the case file?");
				System.out.println("A) Talk to your superintendent");
				System.out.println("B) Steal the file");
				casefile = reader.next();
				casefileChoice = true;
			}


		}

		/**
		 * The next scene (Police Station class) is called after the user finishes through the introductory steps
		 * of the game.
		 */ 

		PoliceStation.display(); 

	}


}
