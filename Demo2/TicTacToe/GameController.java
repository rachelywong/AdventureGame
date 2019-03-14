import java.util.Random;
 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
 
public class GameController {
    public class HandleCellClick implements EventHandler<ActionEvent> {
        private int row;
        private int column;
        public HandleCellClick(int aRow, int aColumn) {
            row = aRow;
            column = aColumn;
        }
        public void handle(ActionEvent event){
            // place token
            placeToken(playerToken, row, column);
            // check if the game is over
            if (board.hasWon(playerToken)) {
                gui.setMessage("You won!");
                gui.disable();
            } else {
                // let ai take a turn
                aiTurn();
            }
        }
    }
     
    private TicTacToeGUI gui;
    private TicTacToeBoard board = new TicTacToeBoard();
    private AIPlayer ai = new AIPlayer('o');
    private char playerToken = 'x';
     
    private void placeToken(char token, int row, int column) {
        gui.placeToken(token, row, column);
        board.placeToken(token, row, column);       
    }
 
    private void aiTurn() {
        Move m = ai.getMove(board);
        placeToken(ai.getToken(), m.row, m.column);
        if (board.hasWon(ai.getToken())) {
            gui.setMessage("You lost!");
            gui.disable();
        }       
    }
     
    public GameController(TicTacToeGUI gui){
        this.gui = gui;
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++) {
                gui.setButtonHandler(new HandleCellClick(row,col),row,col);
            }
        }
         
        int randomChoice = new Random().nextInt(2);
        if (randomChoice == 0){
            playerToken = 'o';
            ai.setToken('x');
            aiTurn();
            gui.setMessage("Your turn, you're token is 'o'");
        } else {
            playerToken = 'x';
            ai.setToken('o');
            gui.setMessage("Your turn, you're token is 'x'");
        }
    }
     
}
