/**
 * @author Team7
 */

/**
 * Class represents the mini game of Hangman.
 * <p>
 * This game is adapted from the code from desrtfx.
 */ 

package hangman;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class Hangman extends Application {
	/**
	* Code is generated to create a GUI interface where user input is taken in 
	* and checked to see if it is in the word "DISCO" to play a hangman game.
	* The code takes information from the Dictionary class to determine what
	* the word to guess is
	*/
	private TextField tfGuess = new TextField();
	private TextField tfLettersGuessed = new TextField();
	Dictionary word = new Dictionary();
	// JavaFX Text elements to display the letters
	// Stored in an array to make them easily visible
	private Text[] text;
	private Label guessesRemaining;
	private Label resultLab;
	private int left;

	// This arrayList holds the individual parts of the body.
	private ArrayList<Shape> body;
	private ObservableList<Node> children;
	private StringBuilder guessedLetters;
	private String theWord;
	private void initGallows() {
		Line gallow1 = new Line(25, 25, 200, 25);
		gallow1.setStroke(Color.BROWN);
		gallow1.setStrokeWidth(3);
		children.add(gallow1);
		Line gallow2 = new Line(25, 25, 25, 300);
		gallow2.setStroke(Color.BROWN);
		gallow2.setStrokeWidth(3);
		children.add(gallow2);
		Line gallow3 = new Line(300, 300, 25, 300);
		gallow3.setStroke(Color.BROWN);
		gallow3.setStrokeWidth(3);
		children.add(gallow3);
		Line rope = new Line(200, 25, 200, 75);
		rope.setStroke(Color.BROWN);
		rope.setStrokeWidth(3);
		children.add(rope);
	}

	/**
	 * Initializes and draws the body All elements are hidden by default
	 * @param void
	 */
	private void initBody() {
		body = new ArrayList<Shape>();
		Ellipse head = new Ellipse(200, 112, 35, 35);
		head.setStroke(Color.BLACK);
		head.setFill(Color.WHITE);
		head.setStrokeWidth(5);
		head.setVisible(false);
		children.add(head);
		body.add(head);
		
		Line tor = new Line(200, 200, 200, 150);
		tor.setStroke(Color.GOLD);
		tor.setStrokeWidth(5);
		tor.setVisible(false);
		children.add(tor);
		body.add(tor);
		
		Line lftArm = new Line(150, 225, 200, 175);
		lftArm.setStroke(Color.BLACK);
		lftArm.setStrokeWidth(5);
		lftArm.setVisible(false);
		children.add(lftArm);
		body.add(lftArm);
		Line rtArm = new Line(250, 225, 200, 175);
		rtArm.setStroke(Color.BLACK);
		rtArm.setStrokeWidth(5);
		rtArm.setVisible(false);
		children.add(rtArm);
		body.add(rtArm);

		Line lftLeg = new Line(200, 200, 175, 275);
		lftLeg.setStroke(Color.BLACK);
		lftLeg.setStrokeWidth(5);
		lftLeg.setVisible(false);
		children.add(lftLeg);
		body.add(lftLeg);

		Line rtLeg = new Line(200, 200, 225, 275);
		rtLeg.setStroke(Color.BLACK);
		rtLeg.setStrokeWidth(5);
		rtLeg.setVisible(false);
		children.add(rtLeg);
		body.add(rtLeg);
	}
	
	/**
	 * Initializes the blanks
	 * @param void
	 */
	private void initBlanks(String word) {
		Line[] blanks = new Line[word.length()];
		int xStart = 375;
		int lineLength = 25;
		int lineSpacing = 35;
		for (int i = 0; i < blanks.length; i++) {
			// Calculate the starting point of the line segment
			int xcoord = xStart + (lineSpacing * i);
			// create the line
			blanks[i] = new Line(xcoord, 225, xcoord - lineLength, 225);
			blanks[i].setStroke(Color.BLACK);
			blanks[i].setStrokeWidth(3);
			children.add(blanks[i]);
		}
	}
	
	/**
	 * Initializes the text
	 * @return text
	 */
	private Text[] initText(String word) {
		Text[] text = new Text[word.length()];
		int xStartw = 355;
		int lineSpacingw = 35;
		for (int i = 0; i < text.length; i++) {
			// Calculate the starting point of the line segment
			int xcoordw = xStartw + (lineSpacingw * i);
			text[i] = new Text(word.substring(i, i + 1));
			text[i].setFont(new Font(30));
			text[i].setX(xcoordw);
			text[i].setY(220);
			text[i].setVisible(false);
			children.add(text[i]);
		}
		return text;
	}
	/**
	 * Initializes and start
	 * @param void
	 */
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		// Store the children variable for easier access
		children = pane.getChildren();
		// initialize and draw the gallows
		initGallows();
		// initialize the body
		initBody();
		theWord = word.getHiddenWord().toUpperCase();
		// Initialize the guessed Letters StringBuilder
		guessedLetters = new StringBuilder();
		// initialize the Blanks (lines)
		initBlanks(theWord);
		System.out.println(theWord);
		// initialize the word drawing
		text = initText(theWord);
		// initialize the remaining guesses
		left = 6;
		GridPane gridPane = new GridPane(); // Create UI
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Enter a letter:"), 0, 0);
		gridPane.add(tfGuess, 1, 0);
		gridPane.add(new Label("Letters Guessed:"), 0, 1);
		gridPane.add(tfLettersGuessed, 1, 1);
		gridPane.add(new Label("Guesses Remaining: "), 0, 2);
		guessesRemaining = new Label(String.valueOf(left));
		gridPane.add(guessesRemaining, 0, 3);
		
		//resultLab
		gridPane.add(new Label(" "), 0, 40);
		resultLab = new Label();
		gridPane.add(resultLab, 0, 40);
		///////////
		
		BorderPane thing = new BorderPane();
		thing.setRight(gridPane);
		thing.setCenter(pane);

		tfGuess.setOnAction(e -> playGame());
		
		Scene scene = new Scene(thing, 700, 400);
		primaryStage.setTitle("Show Hangman");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main method
	 */
	public static void main(String[] args) { // main method to launch application
		Application.launch(args);
	}
	/**
	 * Initializes the play game
	 * @param void
	 */
	private void playGame() {
		// Part 1: Get the guessed letter
		String guess = tfGuess.getText(); // first letter of user entered value
		if (guess.length() == 0) {
			//doesn't do anything with empty textbox
			return;
		}
		if (guess.length() > 1) { // if more than one letter, take only the
									// first
			guess = guess.substring(0, 1);
		}
		guess = guess.toUpperCase();
		// reset the textbox for guessing the letter
		tfGuess.setText("");
		
		// Part 2: Check if the letter has already been guessed
		// Check if this is not the first guess
		if (guessedLetters.length() > 0) {
			// Check if letter has already been guessed
			if (guessedLetters.indexOf(guess) > -1) {
				// Give User an error message
				// TODO: write the error message
				// Leave the method, nothing to do here
				return;
			} else {
				guessedLetters.append(guess);
			}
		} else { // is first guess
			guessedLetters.append(guess);
		}
		tfLettersGuessed.setText(guessedLetters.toString());

		// Part 3: Check if the letter is in the word
		boolean good = false;
		for (int i = 0; i < theWord.length(); i++) {
			// Check if guessed letter is at position(i) in the word to guess
			if (guess.equalsIgnoreCase(theWord.substring(i, i + 1))) {
				// Letter found, make the respective text visible
				text[i].setVisible(true);
				// guess was good, the letter was in the word
				good = true;
				// Don't break the loop here because the letter might
				// occur more than once
			}
		}
		
		// Part 4: Check if letter was not in word
		// good == false means that the letter was not in the word
		if (!good) {
			// Draw the part of the torso
			// Actually, only the respective part is made visible
			body.get(6 - left).setVisible(true);
			// Decrease number of guesses
			left--;
			// Update the Remaining Guesses Text
			guessesRemaining.setText(String.valueOf(left));
		}
		// No more guesses - GAME OVER
		if (left == 0) {
			// GAME OVER
			// TODO: Losing message
			resultLab.setText("Game over.");
		}
	
		// Part 5: Check if word is solved
		// This is very simple:
		// If all text[] items are visible, the word is solved
		boolean solved = true;
		for (int i = 0; i < text.length; i++) {
			if (!text[i].isVisible()) {
				solved = false;
				// no need to check further
				break;
			}
		}
		
		// Part 6: handle winning
		if (solved) {
			resultLab.setText("You win! \n" + "Clue: the locker \n" + "number is between \n" + "1500 - 2000");
		}
	}

}	
