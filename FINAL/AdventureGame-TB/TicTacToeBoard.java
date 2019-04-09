/*TicTacToe code/class that was provided by Dr. Verwaal was used
Title: TicTacToeBoard.java, TicTacToeGame.java and TicTacToeFameProcedural.java 
Author: Nathaly Verwaal 
Date: 02/20/19 
Availability: Nathaly Verwaal, University of Calgary 
 */

/**
 * 
 * Tic Tac Toe Board formation class. 
 * <p>
 * This class contains the methods to generate a Tic Tac Toe board to play Tic Tac Toe.
 */ 
public class TicTacToeBoard {
	char[][] grid = {{'.','.','.'},	{'.','.','.'}, {'.','.','.'}};

	/**
	 * 
	 * Place token method.
	 * <p>
	 * This method generates a token on a specific row and column on the grid.
	 */ 
	public void placeToken(char token, int row, int column){
		grid[row][column] = token;
	}

	/**
	 * 
	 * Empty filler method.
	 * <p>
	 * This method returns a '.' for an empty row and column spot.
	 */ 
	public boolean isEmpty(int row, int column){
		return grid[row][column] == '.';
	}

	/**
	 * 
	 * Won method.
	 * <p>
	 * This method checks if there is a winning player.
	 */ 
	public boolean hasWon(char token) {
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

	/**
	 * 
	 * Board full method.
	 * <p>
	 * This method checks if the board is full (a tie).
	 */ 
	public boolean boardFull() {
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

	/**
	 * 
	 * Game over method.
	 * <p>
	 * This method checks if there is a winner or if the board is full (a tie).
	 */ 
	public boolean gameOver(){
		return hasWon('x') || hasWon('o') || boardFull();
	}

	/**
	 * 
	 * Print method.
	 * <p>
	 * This method prints the grid.
	 */ 
	public void print(){
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}
}
