/**
 * @author Team7
 * 
 * Puzzle class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the methods for the sliding puzzle game called upon in LocationB (crime scene) when the 
 * weapon is examined. Currently, the text-based version does not run a full sliding puzzle game, however, will
 * print the information about the game for a similar effect. To see the real version of the puzzle game, please
 * play the GGUi version of the adventure game.
 */ 
public class Puzzle {

	/**
	 * 
	 * display method for Puzzle.
	 * <p>
	 * This method prompts the user with information about the game. This method will print out
	 * information about the sliding puzzle game.
	 * @param void
	 */ 
	public static void display() {

		System.out.println("Playing sliding puzzle game");


		/**
		 * The next scene (Police Station class) is called after the user finishes through the introductory steps
		 * of the game.
		 */ 
		PoliceStation.display();
	}

}
