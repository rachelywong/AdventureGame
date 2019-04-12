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
import model.TalkStealButton;
 
public class Riddle2 extends PoliceStation{

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Riddle2");
	
        
        Image background1 = new Image("view/resources/bigmac.jpg");
		ImageView mv1 = new ImageView(background1);
		Group root = new Group();
		

	//Labels 
		Label riddle2 = new Label("Solve riddle to get a hint. \n" +
	     "What do you get when you cross a hamburger with a computer?");
		riddle2.setTextFill(Color.web("#FFFFFF"));
		riddle2.setFont(Font.font("Times New Roman", 24));
		root.getChildren().add(mv1);
		root.getChildren().add(riddle2);

	//Labels
		//promptLab
		Label promptLab = new Label("Guess: (Press the submit button to enter guess)");
		promptLab.setTextFill(Color.web("#FFFFFF"));
		promptLab.setLayoutX(1);
		promptLab.setLayoutY(110);
		promptLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(promptLab);
		//resultLab
		Label resultLab = new Label(" ");
		resultLab.setLayoutX(400);
		resultLab.setLayoutY(80);
		resultLab.setTextFill(Color.web("#FFFFFF"));
		resultLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(resultLab);	
		//txtField
		TextField txtField = new TextField("(3 words, first word is A)");
		txtField.setLayoutX(1);
		txtField.setLayoutY(80);
		root.getChildren().add(txtField);

	//Buttons
		//PSButton
	    TalkStealButton PSButton = new TalkStealButton("Back to Local Gym");
	    PSButton.setLayoutX(1);
		PSButton.setLayoutY(140);
		root.getChildren().add(PSButton);
		PSButton.setOnAction(new HandleButtonClick("PS", promptLab));
		PSButton.setOnAction(e -> {
			primaryStage.hide();
			talkStage.show();
			//PoliceStation.PS();
		});
		//submitButton
		TalkStealButton submitButton = new TalkStealButton("Submit");
	    submitButton.setLayoutX(1);
		submitButton.setLayoutY(190);
		root.getChildren().add(submitButton);

	//Actions
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent eve2) {	
				if (txtField.getText().toUpperCase().equals("A BIG MAC")) {
					resultLab.setText("You solved the riddle. Make sure you have been \n" +
									  "to Witness House.");						
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
