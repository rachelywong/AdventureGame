import java.util.Scanner;

/**
 * @author Team7
 * 
 * PoliceStation class for text-based version of Dead on The Dance Floor (adventure game).
 * <p>
 * This class contains the methods for the PoliceStation class which is the parent class for the various
 * location classes.
 */ 
public class PoliceStation {
	
	/**
	 * 
	 * Display method for PoliceStation.
	 * <p>
	 * This method prompts the user with information about the PoliceStation and allows the user to input
	 * which location they would like to go to. Based on user input, the game will direct the user to various location
	 * classes. 
	 */ 
	public static void display() {

		PoliceStation p1 = new PoliceStation();
		
		System.out.println(p1.toString() + "Where do you want to go? Witness house (A), Crime scene (B), Local gym (C), or Guess suspect (D)");
		Scanner reader = new Scanner(System.in);  
		String location = reader.next();

		boolean location1 = true;

		while (location1 == true) {

			if (location.equals("A")) {
				LocationA.display();
				location1 = false;
			}

			else if (location.equals("B")) {
				LocationB.display();
				location1 = false;
			}

			else if (location.equals("C")) {
				LocationC.display();
				location1 = false;
			}

			else if (location.equals("D")) {
				LocationD.display();
				location1 = false;
			}
		}
	}
	
	/**
	 * 
	 * toString  method for PoliceStation.
	 * <p>
	 * This method prompts the user a Welcome message when they arrive to the Police Station location.
	 * Subsequent child class locations will use this method (inheritance) to welcome the user to those
	 * specific locations.
	 */ 
	public String toString() {
	    return ("Welcome: ");
	}

}
