import java.util.Scanner;

public class Riddle {
	
	public static void main(String[] args) {
		
		String riddle_answer = ""; //input riddle answer**
		boolean riddle = true;
		System.out.println(""); //print story for riddle
		
		//Riddle#1
		//"No legs have I to dance. \n" +
		//"No lungs have I to breathe. \n" +
		//"No life have I to live or die \n" +
		//"And yet I do all three. What am I?" +
		//ANS: Fire
		
		//OR
		
		//Riddle#2
		//"Out of 100 ladies attending the dance, \n" + 
		//"85 had a white hand bag; \n" +
		//"75 had black shoes; \n" +
		//"60 carried an umbrella; \n" +
		//"90 wore a ring; \n" +
		//"How many ladies must have had all four items? \n" +
		//ANS:10
		
		Scanner keyboard = new Scanner(System.in);
		String user_guess = keyboard.nextLine();

		while (riddle = true) {
			if (user_guess == riddle_answer) {
				System.out.println("You answered correctly! Print clue#3. ");	//ADD**
				riddle = false;
				//add clue to inventory
				//exit while
				//PS
			}
			else {
				System.out.println("You answered wrong! Enter another guess: ");
				user_guess = keyboard.next();
				riddle = true;
			}
		}
	}
}
