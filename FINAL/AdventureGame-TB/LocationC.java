import java.util.Scanner;

/**
 * @author Team7
 * 
 * LocationC class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the methods for LocationC (guessing game for local gym). This class implements a mini-game
 * to guess a number (guessing number game).
 */ 
public class LocationC extends PoliceStation {

	/**
	 * 
	 * game method for locationC
	 * <p>
	 * This method prompts the user with information about the game. The method will allow the user to
	 * input integer guesses to try to guess the locker number for a clue.
	 * @return guess
	 */ 
	public static boolean game(){
		int locker_num_to_guess = 1978;
		boolean guess = false;
		int guess2 = 1;

		LocationC C = new LocationC();

		System.out.println(C.toString());

		System.out.println("You've arrived at a room filled with lockers, in fact there are thousands of them!\n"+
				"Use the clues you have collected so far to open the correct locker of the suspect\n"+
				"You have a limited amount of time, so you can only make 5 guesses!"+
				"What is your guess?");
		Scanner keyboard = new Scanner(System.in);
		int user_guess = keyboard.nextInt();

		while (guess == false & guess2 < 5){ 
			guess2 += 1;
			if (user_guess < locker_num_to_guess){
				System.out.println("Your guess was too low! What is your guess?");
				user_guess = keyboard.nextInt();
				guess = false;
			}
			else if (user_guess > locker_num_to_guess){
				System.out.println("Your guess was too high! What is your guess?");
				user_guess = keyboard.nextInt();
				guess = false;
			}
			else if (user_guess == locker_num_to_guess){
				System.out.println("You got it! The locker opened!");
				guess = true;
			}
		}
		return guess;
	}

	/**
	 * 
	 * display method for LocationC.
	 * <p>
	 * This method prompts the user with information about the game. This method gives the user information about
	 * how to get a hint for the guessing game (solving a riddle).
	 * @param void
	 */ 
	public static void display(){

		Scanner keyboard = new Scanner(System.in);

		boolean guess = game();

		while (guess == false){
			System.out.println("You did not manage to guess the locker correctly. To try again type: TRY. To quit type: QUIT.");
			String losing_choice = keyboard.next();
			if (losing_choice.equals("TRY")){
				guess = game();
			}
			else if (losing_choice.equals("QUIT")){
				System.out.println("Are you sure? Type HINT to talk to your supervisor and get a hint. Or type QUIT to quit.");
				String hint_choice = keyboard.next();
				if (hint_choice.equals("HINT")){
					System.out.print("*ring ring*\n"+ "YOU: Hello supervisor, could I get a hint regarding the lockers?\n"+
							"SUPERVSOR: Make sure you've found all the needed information from location A!");

				}
				else if (hint_choice.equals("QUIT")){
					System.out.print ("You will be sent to the police station");
				}
			}
		}

		if (guess == true){
			System.out.print("Print clue#5           ");
		}

		/**
		 * The next scene (Police Station class) is called after the user finishes through the introductory steps
		 * of the game.
		 */ 
		PoliceStation.display(); //call PS

	}

	/**
	 * 
	 * toString  method for LocationC.
	 * <p>
	 * This method prompts the user a Welcome message when they arrive to the Police Station location.
	 * Subsequent child class locations will use this method (inheritance) to welcome the user to those
	 * specific locations.
	 */ 
	public String toString() {
		return (super.toString());
	}
}
