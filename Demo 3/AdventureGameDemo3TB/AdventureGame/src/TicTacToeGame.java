import java.util.Scanner;
/*TicTacToe code/class that was provided by Dr. Verwaal was used
Title: TicTacToeBoard.java, TicTacToeGame.java and TicTacToeFameProcedural.java 
Author: Nathaly Verwaal 
Date: 02/20/19 
Availability: Nathaly Verwaal, University of Calgary 
*/

public class TicTacToeGame {
	public static void main(String[] args) {
		char turn = 'x';
		Scanner keyboard = new Scanner(System.in);
		TicTacToeBoard board = new TicTacToeBoard();
		
		while (!board.gameOver()){
			board.print();
			System.out.print(turn + "'s turn, which row? ");
			int row = keyboard.nextInt();
			System.out.print("which column? ");
			int column = keyboard.nextInt();
			
			if (board.isEmpty(row,column)){
				board.placeToken(turn,row,column);
				if (turn == 'x'){
					turn = 'o';
				} else {
					turn = 'x';
				}
			} else {
				System.out.println("Can't place a token there.");
			}
		}
		
		if (board.hasWon('x')){
			System.out.println("X is the winner!");
		} else if (board.hasWon('o')){
			System.out.println("O is the winner!");
		} else {
			System.out.println("Tie game.");
		}
	}
}
