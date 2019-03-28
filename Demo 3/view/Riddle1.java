
package view;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.stage.*;
import model.TalkStealButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
 
/////CONNECT POLICE STATION
public class Riddle1 {

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Riddle1");

		Group root = new Group();
		
	//Story Line
        Label storyLab = new Label("You find the DJ at the club and ask him to tell you what he saw that night." +
								   "\n" +
								   "DJ: 'If you want my witness account, you'll have to prove to me you're \n" +
								   "a good detective. Solve the following riddle.' \n" +
								   "\n" +
								   "I can be cracked, I can be made. I can be told, I can be played.");
        storyLab.setFont(Font.font("Times New Roman", 24));
        root.getChildren().add(storyLab);

	//Labels
		//promptLab
		Label promptLab = new Label("What am I? (Press the submit button to enter guess)");
		promptLab.setLayoutX(25);
		promptLab.setLayoutY(150);
		promptLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(promptLab);
		//resultLab
		Label resultLab = new Label(" ");
		resultLab.setLayoutX(225);
		resultLab.setLayoutY(120);
		resultLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(resultLab);
		//txtField
		TextField txtField = new TextField("(2 words, first word is A)");
		txtField.setLayoutX(25);
		txtField.setLayoutY(180);
		root.getChildren().add(txtField);

	//Buttons
		//PSButton
		TalkStealButton PSButton = new TalkStealButton("Go back to PS");
        PSButton.setLayoutX(20);
        PSButton.setLayoutY(300);
		root.getChildren().add(PSButton);
		PSButton.setOnAction(new HandleButtonClick("PS", promptLab));
		PSButton.setOnAction(e -> {
			primaryStage.hide();
			//PoliceStation.show();
		});
		//submitButton
		TalkStealButton submitButton = new TalkStealButton("Submit");
        submitButton.setLayoutX(20);
        submitButton.setLayoutY(230);
		root.getChildren().add(submitButton);
		
	//Actions
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e1) {						
				if (txtField.getText().toUpperCase().equals("A JOKE")) {
					resultLab.setText("DJ: 'Nice job pal you got it correct! You can call me Disco Joe then! Let me tell you, \n" +
								      "I was there that night everything went down. To be honest, I don't remember much. I \n" +
								      "didnt notice the one dude hitting the other dude because they were going at it to the \n" + 
								      "beat of the jam that was playing. I thought it was some sort of new dance move! I do remember \n" +
								      "the kid who was doing most of the whacking had brown hair though.'\n" +
									  "\n" +
									  "Return to the police station to report and continue.");
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