import java.util.Scanner;

/**
 * @author Team7
 * 
 * LocationB class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the methods for LocationB (crime scene). This class allows for a mini puzzle game implemented in GUI.
 * There is also a riddle implemented in this class.
 */ 
public class LocationB extends PoliceStation {

	/**
	 * 
	 * display method for LocationB.
	 * <p>
	 * This method prompts the user with information about the game. The method will call the puzzle class and police station
	 * class depending on user input.
	 * @param void
	 */ 
	public static void display() {

		LocationB B = new LocationB();

		System.out.println(B.toString() + "You've arrived at the crime scene... \n" + 
				"Do you want to examine the weapon (weapon) or talk to manager (manager)?");
		Scanner keyboard = new Scanner(System.in);
		String user_action = keyboard.nextLine();

		if (user_action.equals("weapon")) {
			System.out.println("You've found the weapon...\n" +
					"Do you want to take a picture (picture) or touch (touch) the weapon?");
			String user_action2 = keyboard.nextLine();

			if (user_action2.equals("touch")) {
				System.out.println("You've been FRAMED!... You go back to the police station. ");
				boolean investigation = false;
				PoliceStation.display(); //call the PoliceStation class
			}
			else if (user_action2.equals("picture")) {
				System.out.println("Your camera is broken. Play a puzzle game to fix it.");
				Puzzle.display(); //call the Puzzle class
			}
		}

		if (user_action.equals("manager")) {
			String riddle_answer = "10";
			boolean riddle = true;
			System.out.println("Your requests you to solve a riddle. \n" + //print story for riddle
					"Out of 100 ladies attending the dance, \n" + 
					"85 had a white hand bag; \n" +
					"75 had black shoes; \n" +
					"60 carried an umbrella; \n" +
					"90 wore a ring; \n" +
					"How many ladies must have had all four items?");


			String user_guess = keyboard.nextLine();

			while (riddle == true) {
				if (user_guess.equals(riddle_answer)) {

					riddle = false;

					System.out.println("You answered correctly! Print clue#3. ");	//ADD**
					//add clue to inventory
					//exit while
					//PS
				}
				else {
					System.out.println("You answered wrong! Enter another guess: ");
					user_guess = keyboard.nextLine();
					riddle = true;
				}
				riddle = false;
			}
			System.out.println("Return to PoliceStation. ");
			PoliceStation.display(); //Call the PoliceStation class
		}
	}

	/**
	 * 
	 * toString  method for LocationB.
	 * <p>
	 * This method prompts the user a Welcome message when they arrive to the Police Station location.
	 * Subsequent child class locations will use this method (inheritance) to welcome the user to those
	 * specific locations.
	 */ 
	public String toString() {
		return (super.toString());
	}
}
