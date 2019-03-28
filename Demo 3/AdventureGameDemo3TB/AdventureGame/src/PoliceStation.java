import java.util.Scanner;

public class PoliceStation {
	
	public static void display() {
				
		System.out.println("Where do you want to go? Witness house (A), Crime scene (B), Local gym (C), or Guess suspect (D)");
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
	
	public void CL(String currentLocation)
	{
		currentLocation = "Police Station";

	}

	*/


}
