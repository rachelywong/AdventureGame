/**
 * @author Team7
 */

/**
 * Class represents test class for tictactoegui. 
 */ 
 
import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest extends TicTacToeGame {
  	@Test
	public void testAddRating_upperbound() {	
		TicTacToe t = new TicTacToe();
		assertEquals("Created credit history with invalid rating (greater than 5)", 0, ch.getRatings().size());
	}
}
