    
/**
* @author Team 7
* This class represents location C, the locker room guessing game.
*/
package view;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import model.TalkStealButton;
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import model.Clabel;

import javafx.application.Application;
import javafx.animation.AnimationTimer;

public class LocationCView extends PoliceStation {
	/*
	* display()
	*
	* display method is called by Police Station.
	* New Stage is created called "Local Gym".
	* Guessing game minigame, where you must use hints previously gathered to make a guess. 
	*3 buttons to submit, for a hint or to back to the Polic Station.
	* 
	*/
	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Local Gym");

		
		
        Image backgroundC = new Image("view/resources/lockers.png");
		ImageView mvC = new ImageView(backgroundC);
		Group root = new Group();
		Label storyLab = new Label("You arrive at the local gym, thinking the suspect may work out here since they must \n" +
								   "be pretty strong to cause blunt force trauma. The local workers at the gym give you \n" +
								   "at the gym give you a master locker key so you can open any locker you please! You walk \n" +
								   "into the locker room to find over a billion lockers. Which locker do you want to open?");
		storyLab.setLayoutX(10);
		storyLab.setLayoutY(10);
		storyLab.setFont(Font.font("Times New Roman", 21));
		root.getChildren().add(mvC);
		root.getChildren().add(storyLab);

		Label promptLab = new Label("Guess:");
		promptLab.setLayoutX(10);
		promptLab.setLayoutY(115);

		Clabel resultLab = new Clabel("Result:");
		resultLab.setLayoutX(300);
		resultLab.setLayoutY(115);

		TextField txtField = new TextField("(4 digits)");
		txtField.setLayoutX(60);
		txtField.setLayoutY(110);

		// create a button
		TalkStealButton PSButton = new TalkStealButton("Back to Map");
		TalkStealButton submitButton = new TalkStealButton("Submit");
		TalkStealButton hintButton = new TalkStealButton("Hint");

        PSButton.setLayoutX(20);
        PSButton.setLayoutY(350);
        PSButton.setOnAction( e ->{
        	primaryStage.hide();
        	talkStage.show();
        	
        });
        submitButton.setLayoutX(20);
        submitButton.setLayoutY(230);
        
		//LocAButton.setLayoutX(20);
		//LocAButton.setLayoutY(350);
		hintButton.setLayoutX(20);
		hintButton.setLayoutY(290);
		hintButton.setOnAction( e ->{
			Riddle2.display();
		});
	


	
	 // Messages that are displayed depending on whether or not locker was guessed correctly by the player.
	    EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e2) {						
				if (txtField.getText().toUpperCase().equals("1978")) {
					resultLab.setText("      You open a locker to find a diary with a  \n" +
					"     bookmarked page dated as January 31st.   \n" +
					"     Reading the page it says: 'I just murdered   \n" + 
					"     someone.' You look through the rest of the  \n" +
					"     locker to find a box of cereal, someclean \n" +
					"     white socks, and a wrench.");
				} else {
					resultLab.setText("   Empty locker. Please try again, or press the   \n" +
					"   hint button to solve a riddle for a little \n" +
					"   hint to help you.");
				}
			}
	    };	
         
	

	    // when button is pressed
	    //PSButton.setOnAction(event);
	    submitButton.setOnAction(event2);
		//LocAButton.setOnAction(event3);
		//hintButton.setOnAction(event4);

	    Scene scene = new Scene(root, 847, 600);
		root.getChildren().addAll(promptLab, txtField, resultLab, PSButton, submitButton, hintButton);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
}
