package view;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.stage.*;
import model.TalkStealButton;
import tictactoegui.TicTacToeGUI;
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
public class LocationBView {

	static Scene crimeScene, weaponScene, framedScene;
	
	public static PoliceStation ps;

	public static void display() {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        
    
        
        /*
        Image background1 = new Image("view/resources/crimescene.png");
      	ImageView mv1 = new ImageView(background1);
      	mv1.setFitHeight(600);
      	mv1.setFitWidth(800);
      	*/
      	
      	
      	
      	
      	
      	
      	

        /*
        //crimeScene Background
      	Image background1 = new Image("/view/resources/crimescene.png");
      	ImageView mv1 = new ImageView(background1);
      	GridPane root = new GridPane();
      	root.setMaxSize(800, 600);
      	root.getChildren().add(mv1);
      	*/
      	
		
	//scene1 - crimeScene
        Group root1 = new Group();
        //root1.getChildren().add(mv1);
        Label storyLab = new Label("You arrive at the crime scene and begin to look around the club for any clues.\n" +
								   "The bouncer tells you that the DJ who was playing the night of the murder is \n" +
								   "here if you would like to speak to him." + 
								   "\n" +
								   "Would you like to speak to the DJ, or examin the weapon first?");
		//storyLab.setTextFill(Color.web("#FFFFFF"));				   
        storyLab.setFont(Font.font("Times New Roman", 24));
        root1.getChildren().add(storyLab);
        
        
        /*
        TalkStealButton backfromB = new TalkStealButton("Go Back");
        backfromB.setLayoutX(50);
        backfromB .setLayoutY(500);
		root1.getChildren().add(backfromB);
		
		
		
		
		backfromB .setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ps.display1();
			
			}
			});
			
			*/
        
        
        
        
		//DJButton
        TalkStealButton DJButton = new TalkStealButton("Talk to DJ");
        DJButton.setLayoutX(20);
        DJButton.setLayoutY(190);
        DJButton.setOnAction(new HandleButtonClick("DJ", storyLab));
        root1.getChildren().add(DJButton);
		//directs to Riddle1 class
		DJButton.setOnAction(e -> {
			primaryStage.hide();
			Riddle1.display();
		});
		//weaponButton
		TalkStealButton weaponButton = new TalkStealButton("Examine weapon");
		weaponButton.setLayoutX(20);
		weaponButton.setLayoutY(260);
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
        TalkStealButton pickUpButton = new TalkStealButton("Pick up weapon");
		pickUpButton.setOnAction(new HandleButtonClick("Pick up", choice3Label));
		root3.getChildren().add(pickUpButton);
		//directs to scene 4
		pickUpButton.setOnAction(e -> primaryStage.setScene(framedScene));
		//photoButton 
		TalkStealButton photoButton = new TalkStealButton("Take picture of weapon");
        photoButton.setOnAction(new HandleButtonClick("Puzzle", choice3Label));
        root3.getChildren().add(photoButton);
        photoButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					Puzzle puzzle = new Puzzle();
					
					puzzle.start(new Stage()); //chooseDetective
					//obj.thefunctioname(args);
					//Class2.main(args);
				

			}
		});
		
	
		
		
	    //scene4 - framedScene
		VBox root4 = new VBox();
        Label frameLabel = new Label("You've been framed! Your captain demands that you return to \n" +
									 "the station immediately for questioning. You may continue the \n" +
									 "case after.");
        frameLabel.setFont(Font.font("Times New Roman", 24));
        root4.getChildren().add(frameLabel);
		//PS2Button
        TalkStealButton PS2Button = new TalkStealButton("Back to Police Station");
        PS2Button.setOnAction(new HandleButtonClick("PS", frameLabel));
        root4.getChildren().add(PS2Button);
		//directs to PS
		PS2Button.setOnAction(e -> {
			primaryStage.hide();
			//PoliceStation.PS();
		});
		
		
		framedScene = new Scene(root4, 847, 600);
		weaponScene = new Scene(root3, 847, 600);
  		crimeScene = new Scene(root1, 847, 600);
  		
		primaryStage.setTitle("Location B");
        primaryStage.setScene(crimeScene);
        primaryStage.show();
	}
}

