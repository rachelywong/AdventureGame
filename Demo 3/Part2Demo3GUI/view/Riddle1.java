
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
import model.Clabel;
 
/////CONNECT POLICE STATION
public class Riddle1 extends PoliceStation{
	
	/*
	* display()
	*
	* display method is called by Location B
	* New Stage is created called "Riddle1".
	* DJ gives player a riddle, that they must solve to aquire a hint 
	*3 buttons to submit, for a hint or to back to the Police Station.
	* 
	*/

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Riddle1");

        
        
        Image backgroundR = new Image("view/resources/bouncer1.jpg");
		ImageView mvR = new ImageView(backgroundR);
		Group root = new Group();
		
	//Label for riddle presented by the DJ.
        Label storyLab = new Label("You find the DJ at the club and ask him to tell you what he saw that night." +
								   "\n" +
								   "DJ: 'If you want my witness account, you'll have to prove to me you're \n" +
								   "a good detective. Solve the following riddle.' \n" +
								   "\n" +
								   "I can be cracked, I can be made. I can be told, I can be played.");
        storyLab.setLayoutX(240);
        storyLab.setLayoutY(50);
        storyLab.setFont(Font.font("Times New Roman", 15));
        root.getChildren().add(mvR);
        root.getChildren().add(storyLab);
        

	//Labels
		//Prompt field to submit answer. 
		Label promptLab = new Label("What am I? (Press the submit button to enter guess)");
		promptLab.setLayoutX(240);
		promptLab.setLayoutY(150);
		promptLab.setFont(Font.font("Times New Roman", 15));
		root.getChildren().add(promptLab);
		//resultLab
		Clabel resultLab = new Clabel(" ");
		resultLab.setLayoutX(410);
		resultLab.setLayoutY(250);
		//resultLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(resultLab);
		//txtField
		TextField txtField = new TextField("(2 words, first word is A)");
		txtField.setLayoutX(25);
		txtField.setLayoutY(180);
		root.getChildren().add(txtField);

	//Buttons
		//New TalkStealButton that direct to the Police Station. 
		TalkStealButton PSButton = new TalkStealButton("Back to Map");
        PSButton.setLayoutX(20);
        PSButton.setLayoutY(300);
		root.getChildren().add(PSButton);
		PSButton.setOnAction(new HandleButtonClick("PS", promptLab));
		PSButton.setOnAction(e -> {
			primaryStage.hide();
			talkStage.show();
			
			
			//PoliceStation.show();
		});
		//submitButton
		TalkStealButton submitButton = new TalkStealButton("Submit");
        submitButton.setLayoutX(20);
        submitButton.setLayoutY(230);
		root.getChildren().add(submitButton);
		
	//Appropriate messages that are displayed if riddle is guessed correctly. 
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e1) {						
				if (txtField.getText().toUpperCase().equals("A JOKE")) {
					resultLab.setText("DJ: 'Nice job pal you got it correct! You can call \n" +
							          "me Disco Joe then! Let me tell you, I was there    \n" +
								      "that night everything went down. To be honest, I   \n" +
							          "don't remember much. I didn't notice the one dude  \n" +
								      "hitting the other dude because they were going at  \n" +
								      "it to the beat of the jam that was playing. I      \n" + 
								      "thought it was some sort of new dance move! I do   \n" +
								      "remember the kid who was doing most of the         \n" +
								      "whacking had brown hair though.'\n" +
									  "\n" +
									  "Return to the police station to report \n" +
									  "and continue.");
				} else {
					resultLab.setText("Incorrect. Please try again.");
					
				}
			}
	    };		
	
	//When submit button is pressed the message is prompted. 
	    submitButton.setOnAction(event);
		
		Scene scene = new Scene(root, 847, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
