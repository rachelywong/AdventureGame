package tictactoegui;

import java.util.Scanner;

/**
 * @author Team7
 */

/**
 * Class represents a player class for the tic tac toe game.
 * <p>
 * The class allows the user to act as a player and choose
 * moves as tokens for the tic tac toe game against an AI computer
 * player. The game will tell the user when to move and whose turn it is.
 */ 

public class Player {
    private String id;
    private char token = 'x';
     
    public Player(char aToken) {
        setToken(aToken);
        System.out.print("What is your name: ");
        Scanner keyboard = new Scanner(System.in);
        id = keyboard.nextLine();
    }
     
    public void setToken(char aToken){
        if (aToken == 'x' || aToken == 'o') {
            token = aToken;
        }
    }
     
    public char getToken() {
        return token;
    }
     
    
 * Plays the move on the tic tac toe board.
 * <p>
 * @return move
 */
    public Move getMove(TicTacToeBoard board){
        board.print();
        System.out.println(id + " it's your turn.  You're token is " + token);
        Scanner keyboard = new Scanner(System.in);
        int row = 0;
        int column = 0;
         
        do {
            System.out.print("Enter row: ");
            row = keyboard.nextInt();
            System.out.print("Enter column: ");
            column = keyboard.nextInt();
        } while (!board.isValidPlacement(row,column));
         
        Move move = new Move(row, column);
        return move;    
         
    }
 
}
