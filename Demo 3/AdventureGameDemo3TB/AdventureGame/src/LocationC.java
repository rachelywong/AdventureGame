import java.util.Scanner;

public class LocationC {
	
	public static boolean game(){
		int locker_num_to_guess = 1978;
		boolean guess = false;
		int guess2 = 1;
		
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
		
		PoliceStation.display(); //call PS
		
	}
}
