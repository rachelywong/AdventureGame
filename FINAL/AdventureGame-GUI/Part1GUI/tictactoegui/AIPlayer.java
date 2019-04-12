/**
* @author Team 7
* This class creates the AIPlayer 
*code from Dr. Nathaly Verwaal (please see reference file)
*/
package tictactoegui;

public class AIPlayer {
    private char token = 'x';
     
    /**
	* Constructer for placing token 
	* @param char 
	 *@return void 
	*/
    public AIPlayer(char aToken) {
        setToken(aToken);
    }
    
    /**
	* Setter for token 
	* @param char
	 *@return void
	*/
    public void setToken(char aToken){
        if (aToken == 'x' || aToken == 'o') {
            token = aToken;
        }
    }
     
    public char getToken() {
        return token;
    }
    /**
	* Getter checks movement for placement 
	* @param board
	 *@return Move
	*/
    public Move getMove(TicTacToeBoard board){
        int row = 0;
        int column = 0;
        while (!board.isValidPlacement(row,column)) {
            row++;
            if (row >= 3) {
                row = 0;
                column++;
            }
        }
        return new Move(row,column);
    }
}
