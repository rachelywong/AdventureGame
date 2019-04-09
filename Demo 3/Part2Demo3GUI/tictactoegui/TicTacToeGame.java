/**
 * @author Team7
 */

/**
 * Class represents the TicTacToeGame. 
 * <p>
 * Players will play as characters 'x' or 'o'
 * and play tic tac toe. Their moves will be placed
 * alone a copy of a tic tac toe board, and updated
 * as the game continues.
 * <p>
 * The class allows the user to play one round of
 * tic tac toe.
 */ 

package tictactoegui;

public class TicTacToeGame{
    private int numberOfRounds = 1;
    private TicTacToeBoard board = new TicTacToeBoard();
    private Player player1 = new Player('x');
    private Player player2 = new Player('o');
     
    public TicTacToeGame(){}
    
    public TicTacToeGame(int aNumberOfRounds) {
        numberOfRounds = aNumberOfRounds;
    }
     
    public void play(){
        while (!board.gameOver()){
            // Don't trust the player so don't give the player the 
            // original board, instead give a copy by using the copy
            // constructor
            Move move = player1.getMove(new TicTacToeBoard(board));
            board.placeToken(player1.getToken(),move.row,move.column);
             
            move = player2.getMove(board);
            board.placeToken(player2.getToken(),move.row,move.column);
        }
    }
     
    public static void main(String[] args){
        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }
}
