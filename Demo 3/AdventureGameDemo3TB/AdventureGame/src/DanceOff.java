import java.util.Scanner;
import java.util.Random;

public class DanceOff {

	public static void display() {

		Scanner reader = new Scanner(System.in);  

		String answer = "Abi";

		System.out.println ("Who is the murderer? Abi, Teresa, or Leeroy");
		String userAnswer = reader.next();

		boolean flag = false;

		while (flag = false) {

			
			System.out.println ("Who is the murderer? Abi, Teresa, or Leeroy");
			userAnswer = reader.next();
			
			if (userAnswer.equals(answer)) {
				System.out.println ("Congrats! You win the game!");
				flag = true;
			}
			else {
				flag = false;
				System.out.println ("You're wrong.");
				System.out.println ("Who is the murderer? Abi, Teresa, or Leeroy");
				userAnswer = reader.next();
			}

		}
	}
}

