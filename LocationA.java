import java.util.Scanner; 
import java.util.Random; 

public class LocationA {
	
	
	/*In attack(), code for the Rock, Paper ,Scissors inspired by code by an anonymous user online. 
	Title: StackOverflow 
	Author: Anonymous User 
	Date: 02/20/19
	Availability: https://stackoverflow.com/questions/19204872/rock-paper-scissors-game-java
	*/ 
	
	public attack(){
	
	String personPlay; //User's play -- "R", "P", or "S" 
    String computerPlay = ""; //Computer's play -- "R", "P", or "S" 
    int computerInt; //Randomly generated number used to determine computer's play 
    String response; 


    Scanner scan = new Scanner(System.in); 
    Random generator = new Random(); 

    System.out.println("OH NO YOU'VE ENCOUNTERED A MONSTER! YOU'VE BEEN CHALLENGED TO A GAME OF Rock, Paper, Scissors!\n" + 
                       "Please enter a move.\n" + "Rock = R, Paper" + 
                       "= P, and Scissors = S.");

    System.out.println();

    //Generate computer's play (0,1,2) 
    computerInt = generator.nextInt(3)+1; 

    //Translate computer's randomly generated play to 
    //string using if //statements 

    if (computerInt == 1) {
       computerPlay = "R"; 
	}
    else if (computerInt == 2){ 
       computerPlay = "P"; 
	}
    else if (computerInt == 3){
       computerPlay = "S"; 
	}


    //Get player's play from input-- note that this is 
    // stored as a string 
    System.out.println("Enter your play: "); 
    personPlay = scan.next();

    //Make player's play uppercase for ease of comparison 
    personPlay = personPlay.toUpperCase(); 

    //Print computer's play 
    System.out.println("Computer play is: " + computerPlay); 
	boolean attack = true;
	if (personPlay.equals(computerPlay)){ 
       System.out.println("It's a tie!"); 
	}
    else if (personPlay.equals("R")){
       if (computerPlay.equals("S")){ 
          System.out.println("Rock crushes scissors. You win!!");
		  attack = false;
	   }
	  else if (computerPlay.equals("P")){ 
            System.out.println("Paper eats rock. You lose!!"); 
			}
	}
    else if (personPlay.equals("P")){
       if (computerPlay.equals("S")){
       System.out.println("Scissor cuts paper. You lose!!"); 
	   }
	   else if (computerPlay.equals("R")){
            System.out.println("Paper eats rock. You win!!");
			attack = false;
	   }
	}
    else if (personPlay.equals("S")){ 
		if (computerPlay.equals("P")){
         System.out.println("Scissor cuts paper. You win!!"); 
		 attack = false;
		 }
		else if (computerPlay.equals("R")){
            System.out.println("Rock breaks scissors. You lose!!"); 
		}
	}
    else{ 
         System.out.println("Invalid user input."); 
	}

	
	}
}
	public static String talk(){
		System.out.println("Witness: Hello officer. What can I help you with?");
		System.out.println("You: I need all the information you can provide me with about the night the murder took place");
		System.out.println("Witness: Clue #4");
	return "clue #4";
	}
	public static String look(){
		System.out.println("You find a slip of paper attached to the bottom of a shoe, it looks like a recipt from a gym memership!\n"+
							" This might fallen out of the suspect's pocket! The recipt is worn out but it looks like a locker between" +
							" 100 and 199.");
		return "100 - 199";
	}
	
	public static void main(String[] args){
		System.out.println("You have arrived at the witness's house, the door is open, but you must find the witness.");
		System.out.println("Navigate the house using the keyboard.");
		boolean door1 = false;
		boolean door2 = false;
		boolean door3 = false;
		boolean door4 = false;
		Scanner keyboard = new Scanner(System.in);
		
		
		while (door1 == false){
			System.out.println("Which way should you go? Type 'A' for left, type 'D' for right or type 'W' for forward.");
			String user_input = keyboard.next();
			if (user_input.equals("A")){
				System.out.println("You've hit a wall!");
				door1 = false;
			}
			else if (user_input.equals("D")){
				door1 = true;
			}
			else if (user_input.equals("W")){
				boolean attack = true;
				while (attack == true){
				Attack.attack();
				}
				System.out.println("You've escaped the monster! Do not go in through this door "+
									"unless you would like to face the monster again!");
		
			}
		
		}
		while (door2 == false){
			System.out.println("You've reached the 2nd door!"+
							"Which way should you go? Type 'A' for left, type 'D' for right or type 'W' for forward.");
			String user_input = keyboard.next();
			if (user_input.equals("A")){
				System.out.println("You've hit a wall!");
				door2 = false;
			}
			else if (user_input.equals("D")){
				boolean attack = true;
				while (attack == true){
				Attack.attack();
				}
				System.out.println("You've escaped the monster! Do not go in through this door "+
									"unless you would like to face the monster again!");
			}
			else if (user_input.equals("W")){
				door2 = true;
				
			}
		
		}
		while (door3 == false){
			System.out.println("You've reached the 3rd door!"+
							"Which way should you go? Type 'A' for left, type 'D' for right or type 'W' for forward.");
			String user_input = keyboard.next();
			if (user_input.equals("A")){
				System.out.println("You've hit a wall!");
				door3 = false;
			}
			else if (user_input.equals("D")){
				door3 = true;
			}
			else if (user_input.equals("W")){
				boolean attack = true;
				while (attack == true){
				LocationA.attack();
				}
				System.out.println("You've escaped the monster! Do not go in through this door "+
									"unless you would like to face the monster again!");
		
			}
		
		}
		while (door4 == false){
			System.out.println("You've reached the 4th door!"+
							"Which way should you go? Type 'A' for left, type 'D' for right or type 'W' for forward.");
			String user_input = keyboard.next();
			if (user_input.equals("A")){
				System.out.println("You've found the witness in their mansion!");
				door4 = true;
				
			}
			else if (user_input.equals("D")){
				boolean attack = true;
				while (attack == true){
				LocationA.attack();
				}
				System.out.println("You've escaped the monster! Do not go in through this door "+
									"unless you would like to face the monster again!");
			}
			else if (user_input.equals("W")){
				System.out.println("You've hit a wall!");
				door4 = false;	
		
			}
		
		}
		System.out.println("To talk to the witness, type: TALK\n"+
							"To look around the room, type: LOOK");
		String witness = keyboard.next();
		
		if (witness.equals("TALK")){
			String clue_4 = talk();
			// add to inventory 
			System.out.println("Would you still like to look around? If so, type LOOK" );
			witness = keyboard.next();
			if (witness.equals("LOOK")){
				String secret_clue = look();
				// add secret_clue to inventory?
			}
			
		}
		else if (witness.equals("LOOK")){
			String secret_clue = look();
			// add secret_clue to inventory?
			System.out.println("To talk to the witness, type: TALK");
			witness = keyboard.next();
			if (witness.equals("TALK")){
			String clue_4 = talk();
			// add to inventory 
			}
			
		}
	}
}