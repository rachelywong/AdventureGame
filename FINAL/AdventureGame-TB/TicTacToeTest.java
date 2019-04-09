/**
 * @author Team7
 * 
 * Junit test class for TicTacToeBoard.
 * <p>
 * Three tests to test the workings of the tic tac
 * toe game.
 */ 

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest extends TicTacToeBoard {

	@Test
	public void testBoardFull() {

		TicTacToeBoard t = new TicTacToeBoard();

		// Test case: board empty, no winner.
		assertEquals("Created invalid empty tictactoe board", false, t.boardFull()); 

	}

	@Test
	public void testPlaceTokenUnavaliable() {
	
		TicTacToeBoard t = new TicTacToeBoard();
	   	t.placeToken('o', 1, 1);
	   	t.placeToken('x', 1, 1);
	   	
		assertEquals("Created invalid token placement on board", false, t.boardFull()); 
	}
	
	@Test
	public void win() {
	
		TicTacToeBoard t = new TicTacToeBoard();
	   	t.placeToken('o', 0, 0);
	   	t.placeToken('o', 1, 1);
	   	t.placeToken('o', 2, 2);
	   	
		assertEquals("Created invalid win", true, t.hasWon('o')); 
	}

}