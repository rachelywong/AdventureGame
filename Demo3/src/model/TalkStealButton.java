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

public class TalkStealButton extends Button {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/blue_button00.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/blue_button02.png');";
	
	//creating a string that will be shown
	public TalkStealButton(String text) {
		setText(text);
		setSTButtonFont();
		setPrefWidth(190); //setting preferred width for button
		setPrefHeight(49); //setting preferred height for button
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
		
	}
	
	//method that will set the font
	private void setSTButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 12));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23)); //if application will not be able to set desired font, then it will set Verdana font
		}
	}
	
	//method for pressed and released style
	public void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() +4 ); //pressed button is 4 pixels smaller than released one
	}
	public void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() -4);
	}
	
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
