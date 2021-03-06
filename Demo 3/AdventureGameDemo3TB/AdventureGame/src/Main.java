import java.util.Scanner;

public class Main {

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

	String casefile = reader.next();
	
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
				System.out.println("Here is the case."); //clue #1
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
	
	PoliceStation.display(); //call PS
	
	}
	

}
