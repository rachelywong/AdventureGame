package view;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
 
public class Riddle2 extends PoliceStation{

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Riddle2");
	
		VBox root = new VBox();

	//Labels 
		Label riddle2 = new Label("Solve riddle to get a hint. \n" +
	     "What do you get when you cross a hamburger with a computer?");
		riddle2.setFont(Font.font("Times New Roman", 24));
		root.getChildren().add(riddle2);

	//Labels
		//promptLab
		Label promptLab = new Label("Guess: (Press the Submit button to enter guess)");
		promptLab.setLayoutX(200);
		promptLab.setLayoutY(200);
		promptLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(promptLab);
		//resultLab
		Label resultLab = new Label(" ");
		resultLab.setLayoutX(225);
		resultLab.setLayoutY(120);
		resultLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(resultLab);	
		//txtField
		TextField txtField = new TextField("(3 words, first word is A)");
		txtField.setLayoutX(300);
		txtField.setLayoutY(200);
		root.getChildren().add(txtField);

	//Buttons
		//PSButton
	    Button PSButton = new Button("Back");
	    PSButton.setLayoutX(20);
		PSButton.setLayoutY(20);
		root.getChildren().add(PSButton);
		PSButton.setOnAction(new HandleButtonClick("PS", promptLab));
		PSButton.setOnAction(e -> {
			primaryStage.hide();
			talkStage.show();
			//PoliceStation.PS();
		});
		//submitButton
	    Button submitButton = new Button("Submit");
	    submitButton.setLayoutX(20);
		submitButton.setLayoutY(50);
		root.getChildren().add(submitButton);

	//Actions
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent eve2) {	
				if (txtField.getText().toUpperCase().equals("A BIG MAC")) {
					resultLab.setText("You solved the riddle. \n" +
									  "Make sure you have been to Witness House.");						
				} else {
					resultLab.setText("Incorrect. Please try again.");
				}
	        }
	    };

	//When button is pressed
	    submitButton.setOnAction(event);

		Scene scene = new Scene(root, 847, 600);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
}