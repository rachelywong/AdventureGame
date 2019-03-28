import java.util.Scanner;
/*TicTacToe code/class that was provided by Dr. Verwaal was used
Title: TicTacToeBoard.java, TicTacToeGame.java and TicTacToeFameProcedural.java 
Author: Nathaly Verwaal 
Date: 02/20/19 
Availability: Nathaly Verwaal, University of Calgary 
*/
public class TicTacToeProcedural {
	static char[][] grid = {{'.','.','.'},	{'.','.','.'}, {'.','.','.'}};

	public static void placeToken(char token, int row, int column){
		grid[row][column] = token;
		
	}
	
	public static boolean isEmpty(int row, int column){
		return grid[row][column] == '.';
	}
	
	public static boolean hasWon(char token) {
		boolean threeInARow = false;
		// check rows and columns
		for (int index = 0; index < 3 && !threeInARow; index++) {
			threeInARow = (grid[index][0] == token && 
							grid[index][1] == token && 
							grid[index][2] == token) ||
							
							(grid[0][index] == token &&
							grid[1][index] == token &&
							grid[2][index] == token);
		}
		// is there a diagonal of token
		
		threeInARow = threeInARow || 
			(grid[0][0] == token && grid[1][1] == token && grid[2][2] == token);
		
		threeInARow = threeInARow ||
			(grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
			
		return threeInARow;
	}
	
	public static boolean boardFull() {
		boolean full = true;
		for (int row = 0; row < 3 && full; row++){
			for (int column = 0; column < 3 && full; column++){
				if (grid[row][column] == '.') {
					full = false;
				}
			}
		}
		return full;
	}
	
	public static boolean gameOver(){
		return hasWon('x') || hasWon('o') || boardFull();
	}
	
	public static void print(){
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char turn = 'x';
		Scanner keyboard = new Scanner(System.in);
		
		while (!gameOver()){
			print();
			System.out.print(turn + "'s turn, which row? ");
			int row = keyboard.nextInt();
			System.out.print("which column? ");
			int column = keyboard.nextInt();
			
			if (isEmpty(row,column)){
				placeToken(turn,row,column);
				if (turn == 'x'){
					turn = 'o';
				} else {
					turn = 'x';
				}
			} else {
				System.out.println("Can't place a token there.");
			}
		}
		
		if (hasWon('x')){
			System.out.println("X is the winner!");
		} else if (hasWon('o')){
			System.out.println("O is the winner!");
		} else {
			System.out.println("Tie game.");
		}
	}
}
