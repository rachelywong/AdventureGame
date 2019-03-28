import java.util.Scanner;
import java.util.Random;

public class LocationD {

	public static void display() {

		Scanner reader = new Scanner(System.in);  

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

}

