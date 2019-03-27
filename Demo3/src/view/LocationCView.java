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

public class LocationCView {
	
	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("locC");

		Group root = new Group();
		Scene scene = new Scene(root, 847, 600);
		
		Label storyLab = new Label("You arrive at the local gym, thinking the suspect may work out here since \n" +
								   "they  must be pretty strong to cause blunt force trauma. The local workers \n" +
								   "at the gym give you a master locker key so you can open any locker you please! \n" +
								   "You walk into the locker room to find over a billion lockers. Which locker \n" +
								   "do you want to open?");
		storyLab.setFont(Font.font("Times New Roman", 21));
		root.getChildren().add(storyLab);

		Label promptLab = new Label("Guess:");
		promptLab.setLayoutX(200);
		promptLab.setLayoutY(140);

		Label resultLab = new Label("Result");
		resultLab.setLayoutX(225);
		resultLab.setLayoutY(175);

		TextField txtField = new TextField("(4 digits)");
		txtField.setLayoutX(250);
		txtField.setLayoutY(135);

		// create a button
	    Button PSButton = new Button("Go back to PS");
	    Button submitButton = new Button("Submit");
		Button LocAButton = new Button("Location A");
		Button hintButton = new Button("Hint");

        PSButton.setLayoutX(20);
        PSButton.setLayoutY(150);
        submitButton.setLayoutX(20);
        submitButton.setLayoutY(180);
		LocAButton.setLayoutX(20);
		LocAButton.setLayoutY(210);
		hintButton.setLayoutX(20);
		hintButton.setLayoutY(240);

	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e1) {						
				PSButton.setOnAction(e -> {
					//PoliceStation.PS();
				});
	        }
	    };
		
	    EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e2) {						
				if (txtField.getText().toUpperCase().equals("1978")) {
					resultLab.setText("You open a locker to find a diary with a bookmarked page \n" +
					"dated as January 31st. Reading the page it says: \n" +
					"'I just murdered someone.' \n" + 
					"You look through the rest of the locker to find a box of cereal, some \n" +
					"clean white socks, and a wrench.");
				} else {
					resultLab.setText("Empty locker. Please try again, or press the hint button \n" +
					"to solve a riddle for a little hint to help you.");
				}
			}
	    };	

		EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e3) {
				LocAButton.setOnAction(e -> {
					LocationAView.display();
				});
			}
		};
		
		EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e4) {
				hintButton.setOnAction(e -> {
					//Riddle2.display();
				});
			}
		};

	    // when button is pressed
	    PSButton.setOnAction(event);
	    submitButton.setOnAction(event2);
		LocAButton.setOnAction(event3);
		hintButton.setOnAction(event4);

		root.getChildren().addAll(promptLab, txtField, resultLab, PSButton, submitButton, LocAButton, hintButton);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
