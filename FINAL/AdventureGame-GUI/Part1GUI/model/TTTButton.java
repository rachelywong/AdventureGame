/**
 * @author Team 7
 * This class formats the buttons for the TicTacToe mini game
 */

package model;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.text.Font;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class TTTButton extends Button {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/yellow.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/green.png');";
	
	/**
	 * Creates a String that will be shown and changes different aspects of the button for correct positioning
	 * @param String that is being formatted
	 * @return void
	 */
	public TTTButton(String text) {
		setText(text);
		setSTButtonFont();
		setPrefWidth(100); //setting preferred width for button
		setPrefHeight(49); //setting preferred height for button
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
		
	}
	
	/**
	 * set Font for desired text
	 * @param void
	 * @return void
	 */
	private void setSTButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 12));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23)); //if application will not be able to set desired font, then it will set Verdana font
		}
	}
	
	/**
	 * Creates style for when buttons are pressed
	 * @ param void
	 * @ return void
	 */
	public void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() +4 ); //pressed button is 4 pixels smaller than released one
	}
	/**
	 * Creates style for when buttons are released
	 * @ param void
	 * @ return void
	 */
	public void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() -4);
	}
	/**
	 * Creates ButtonListeners and EventHandlers for when buttons are pressed and released
	 * @ param void
	 * @ return void
	 */
	private void initializeButtonListeners() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
				
			}
		});
		
	
		setOnMouseExited(new EventHandler<MouseEvent>() {
			
				@Override
				public void handle(MouseEvent event) {
					setEffect(null);
					
				}
			});
	}
	
}
