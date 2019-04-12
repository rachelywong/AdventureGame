/**
* @author Team 7
* This class formats the button for a better viewing experience in the intro.
*/
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


public class IntroButton extends Button {

	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/blue_button00.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/blue_button02.png');";
	
	/**
	* Formats text to set a desired position.
	* @param String 
	 *@return IntroButton
	*/
	public IntroButton(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190); //image width
		setPrefHeight(33); //image height
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
		
	}
	/**
	* set Font for desired text
	* @param void
	 *@return void
	*/
	private void setButtonFont() {
		
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		}catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));
			}
	}
	/**
	* set Font for desired text when button pressed
	* @param void
	 *@return void
	*/
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}
	/**
	* set Font for desired text when button released 
	* @param void
	 *@return void
	*/
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY()-4);
	}
	/**
	* set buttons to desired effects 
	* @param void
	 *@return void
	*/
	private void initializeButtonListeners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}
		});
		
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
