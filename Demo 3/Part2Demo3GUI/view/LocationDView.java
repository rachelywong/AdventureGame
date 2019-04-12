package view;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import model.TalkStealButton;
import tictactoegui.TicTacToeGUI;
import javafx.stage.*;
import dance.JavaFX_12;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;

//RETURN TO POLICE STATION
public class LocationDView {
	
	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Guess the Murderer");

        
        Image backgroundD = new Image("view/resources/prison.jpg");
		ImageView mvD = new ImageView(backgroundD);
		Group root = new Group();
		
	//Story Line
		Label storyLab = new Label("You are ready to make your final decision and arrest the murderer. \n" +
								   "You have been given a list of suspects, and must choose who the \n" +
								   "murderer is. The list identifies key characteristics of the suspects \n" +
								   "that may help in your decision.");
		storyLab.setTextFill(Color.web("#FFFFFF"));
		storyLab.setFont(Font.font("Times New Roman", 24));
		root.getChildren().add(mvD);
		root.getChildren().add(storyLab);
		
	//Labels
		//promptLab
		Label promptLab = new Label("Murderer: (Press the Submit button to enter guess) ");
		promptLab.setTextFill(Color.web("#FFFFFF"));
		promptLab.setLayoutX(240);
		promptLab.setLayoutY(300);
		promptLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(promptLab);
		//resultLab
		Label resultLab = new Label(" ");
		resultLab.setTextFill(Color.web("#FFFFFF"));
		resultLab.setLayoutX(240);
		resultLab.setLayoutY(400);
		resultLab.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(resultLab);
		//txtField
		TextField txtField = new TextField("(Name)");
		txtField.setLayoutX(240);
		txtField.setLayoutY(330);
		root.getChildren().add(txtField);
	
	//suspectList
		Label suspect1 = new Label("Abi \n" +
								   "Gender: Female \n" +
								   "Hair Color: Brown \n" +
								   "Occupation: Mechanic");
		
		suspect1.setTextFill(Color.web("#FFFFFF"));
		suspect1.setLayoutX(240);
		suspect1.setLayoutY(150);
		suspect1.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(suspect1);
		
		Label suspect2 = new Label("Teresa \n" +
								   "Gender: Female \n" +
								   "Hair Color: Red \n" +
								   "Occupation: Electrician");
		suspect2.setTextFill(Color.web("#FFFFFF"));
		suspect2.setLayoutX(440);
		suspect2.setLayoutY(150);
		suspect2.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(suspect2);
		
		Label suspect3 = new Label("Leeroy \n" +
								   "Gender: Male \n" +
								   "Hair Color: Brown \n" +
								   "Occupation: Artist");
		suspect3.setTextFill(Color.web("#FFFFFF"));
		suspect3.setLayoutX(640);
		suspect3.setLayoutY(150);
		suspect3.setFont(Font.font("Times New Roman", 20));
		root.getChildren().add(suspect3);

	//Buttons
		//PSButton
		TalkStealButton PSButton = new TalkStealButton("Back to Map");
        PSButton.setLayoutX(20);
        PSButton.setLayoutY(500);
		root.getChildren().add(PSButton);
		PSButton.setOnAction(new HandleButtonClick("PS", promptLab));
		PSButton.setOnAction(e -> {
			primaryStage.hide();
			//PoliceStation.PS();
		});
		//arrestButton
		TalkStealButton arrestButton = new TalkStealButton("Arrest");
        arrestButton.setLayoutX(20);
        arrestButton.setLayoutY(430);
		root.getChildren().add(arrestButton);

	//Actions
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e2) {						
				if (txtField.getText().toUpperCase().equals("ABI")) {
					JavaFX_12 java = new JavaFX_12();
					java.start(new Stage());
					resultLab.setText("Congrats! You've finally caught the murderer and win the game!");
					
				} else {
					resultLab.setText("You arrested the wrong suspect! Please try again.");
					
				}
			}
	    };	

	//When button is pressed
	    arrestButton.setOnAction(event);

		Scene scene = new Scene(root, 847, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
