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
 
public class LocationBView {

	static Scene crimeScene, weaponScene, framedScene;

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("locB");
        
      //Background
      	Image background1 = new Image("view/resources/crimescene.jpg");
      	ImageView mv1 = new ImageView(background1);
      	GridPane root = new GridPane();
      	root.setMaxSize(600, 600);
      	root.getChildren().add(mv1);
      	
      //DJ scene
      Image blockImage = new Image("view/resources/bouncer.png");
      ImageView blockView = new ImageView(blockImage);
      GridPane blockPane = new GridPane();
      blockPane.setMaxSize(847, 600);
      blockPane.getChildren().add(blockView);
      Scene block = new Scene(blockPane);
        
   
		
	//scene1 - crimeScene
        VBox root1 = new VBox();
        root1.setAlignment(Pos.BOTTOM_CENTER);
        Label storyLab = new Label("You arrive at the crime scene and begin to look around the club for any clues.\n" +
								   "The bouncer tells you that the DJ who was playing the night of the murder is \n" +
								   "here if you would like to speak to him." + 
								   "\n" +
								   "Would you like to speak to the DJ, or examin the weapon first?");
        storyLab.setTextFill(Color.web("#FFFFFF"));
        storyLab.setFont(Font.font("Times New Roman", 18));
        root.getChildren().add(root1);
        root1.getChildren().add(storyLab);
     
        
		//DJButton
        Button DJButton = new Button("Talk to DJ");
        DJButton.setOnAction(new HandleButtonClick("Bouncer", storyLab));
        root1.getChildren().add(DJButton);
		//directs to Riddle1 class
		DJButton.setOnAction(e -> { 
			//Riddle1.display();
		});
		//weaponButton
		Button weaponButton = new Button("Examine weapon");
        weaponButton.setOnAction(new HandleButtonClick("Weapon", storyLab));
        root1.getChildren().add(weaponButton);
		//directs to scene3
		weaponButton.setOnAction(e -> primaryStage.setScene(weaponScene));
		
	//scene3 - weaponScene
		VBox root3 = new VBox();
        Label choice3Label = new Label("Pick up weapon or take pic.");
        choice3Label.setFont(Font.font("Times New Roman", 24));
        root3.getChildren().add(choice3Label);
		//pickUpButton 
        Button pickUpButton = new Button("Pick up weapon");
		pickUpButton.setOnAction(new HandleButtonClick("Pick up", choice3Label));
		root3.getChildren().add(pickUpButton);
		//directs to scene 4
		pickUpButton.setOnAction(e -> primaryStage.setScene(framedScene));
		//photoButton 
        Button photoButton = new Button("Take picture of weapon");
        photoButton.setOnAction(new HandleButtonClick("Puzzle", choice3Label));
        root3.getChildren().add(photoButton);
		//directs to Puzzle class
		photoButton.setOnAction(e -> {
			//Puzzle.display();
		});
		
	//scene4 - framedScene
		VBox root4 = new VBox();
        Label frameLabel = new Label("You've been framed!");
        frameLabel.setFont(Font.font("Times New Roman", 24));
        root4.getChildren().add(frameLabel);
		//PS2Button
        Button PS2Button = new Button("Back to Police Station");
        PS2Button.setOnAction(new HandleButtonClick("PS", frameLabel));
        root4.getChildren().add(PS2Button);
		//directs to PS
		PS2Button.setOnAction(e -> {
			//PoliceStation.PS();
		});
		
		framedScene = new Scene(root4);
		weaponScene = new Scene(root3);
  		crimeScene = new Scene(root);
		
		primaryStage.setTitle("Location B");
        primaryStage.setScene(crimeScene);
        primaryStage.show();
		
	}
}
	
	
