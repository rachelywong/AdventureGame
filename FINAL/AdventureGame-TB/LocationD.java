import java.util.Scanner;
import java.util.Random;

/**
 * @author Team7
 * 
 * LocationD class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the methods for LocationD (guessing the suspect). This class takes in user-input and
 * checks to see if it is correct in guessing the murderer. 
 */ 

public class LocationD extends PoliceStation{

	/**
	 * 
	 * display method for LocationD.
	 * <p>
	 * This method prompts the user with information about the game. This method will check to see if the user
	 * input about who the murderer is is correct or not. If correct, the game will end and they win. If incorrect,
	 * the user will be prompted to guess again.
	 * @param void
	 */ 
	public static void display() {

		Scanner reader = new Scanner(System.in);  

		LocationD D = new LocationD();

		System.out.println(D.toString() + "Guess who did it!");

		String answer = "Abi";

		boolean flag = false;

		do {

			System.out.println ("Who is the murderer? Abi, Teresa, or Leeroy");
			String userInput = reader.nextLine();

			if (userInput.equals(answer)) {
				System.out.println ("Congrats! You win the game!");
				flag = true;
			}
			else {
				System.out.println ("You're wrong.");

				flag = false;			
			}
		}

		while (flag == false);

	}

	/**
	 * 
	 * toString  method for LocationD.
	 * <p>
	 * This method prompts the user a Welcome message when they arrive to the Police Station location.
	 * Subsequent child class locations will use this method (inheritance) to welcome the user to those
	 * specific locations.
	 */ 
	public String toString() {
		return (super.toString());
	}

}

