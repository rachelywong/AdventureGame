
package view;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import hangman.Hangman;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import model.StealLabel;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import model.TalkStealButton;
public class LocationB {

    
	public static Scene crimeScene, weaponScene, framedScene;
	private static Stage window;
	public static PoliceStation ps;

	 
	public Stage getStage() {
        return window;
    }
	

	/*
	*Will take the specific button specified and change it's shape into an arrow
	* 
	* @param the button for arrows pointing to the doors and sets their shapes as arrows
	* @return no return
	*/		
	
	
	public static void display() {
		
		Stage window = new Stage();
	    window.initModality(Modality.APPLICATION_MODAL);
	    window.setTitle("Location B");
		
	
        //Background
	    
		Image background1 = new Image("view/resources/crime.jpg");
		ImageView mv1 = new ImageView(background1);
		GridPane root = new GridPane();
		root.setMaxSize(800, 600);
		root.prefHeight(600);
		root.prefWidth(800);
		root.getChildren().add(mv1);

		
		//Intro Label 
		HBox introloc = new HBox();
		Label intro = new Label("You have arrived at the Crime scene" );
		introloc.setAlignment(Pos.TOP_CENTER);
		//intro.setLayoutX(100);
		//intro.setLayoutY(300);
		intro.setTextFill(Color.web("#FFFFFF"));
		intro.setFont(new Font("Times New Roman", 18));
		intro.setWrapText(true);			
		root.getChildren().add(introloc);
		introloc.getChildren().add(intro);
		
		
		//Buttons
		HBox butt = new HBox(250);
		butt.setAlignment(Pos.CENTER);
		root.getChildren().add(butt);
		//DJButton
		TalkStealButton DJButton = new TalkStealButton("Talk to DJ");
		//weaponButton
	    DJButton.setLayoutX(20);
        DJButton.setLayoutY(190);
        //DJButton.setOnAction(new HandleButtonClick("DJ", storyLab));
        root.getChildren().add(DJButton);
		//directs to Riddle1 class
		DJButton.setOnAction(e -> {
			window.hide();
			Riddle1.display();
		});
		
		TalkStealButton weaponButton = new TalkStealButton("Examine weapon");
		weaponButton.setLayoutX(20);
		weaponButton.setLayoutY(260);
		//weaponButton.setOnAction(new HandleButtonClick("Weapon", storyLab));
		root.getChildren().add(weaponButton);
        //directs to scene3
		
	    weaponButton.setOnAction(e -> window.setScene(weaponScene));
	    //weaponButton.setOnAction(e -> window.setScene(block));
		
		
	    butt.getChildren().add(DJButton);
	    butt.getChildren().add(weaponButton);
	    

	  //scene3 - weaponScene
	    Image background3 = new Image("view/resources/crime.jpg");
	    ImageView mv3 = new ImageView(background3);
	    Group root3 = new Group();
	    Label lab = new Label("Pick up weapon or take a photo.");
	    lab.setLayoutX(300);
	    lab.setLayoutY(1);
	    lab.setTextFill(Color.web("#FFFFFF"));
		lab.setFont(Font.font("Times New Roman", 24));
		
		root3.getChildren().add(mv3);
		root3.getChildren().add(lab);
		
		TalkStealButton pickUpButton = new TalkStealButton("Pick up weapon");
		pickUpButton.setLayoutX(100);
		pickUpButton.setLayoutY(200);
  		pickUpButton.setOnAction(new HandleButtonClick("Pick up", lab));
  		root3.getChildren().add(pickUpButton);
  		
  		pickUpButton.setOnAction(e -> window.setScene(framedScene));
  		
  		
  		TalkStealButton photoButton = new TalkStealButton("Take picture of weapon");
  		pickUpButton.setLayoutX(100);
		pickUpButton.setLayoutY(250);
        photoButton.setOnAction(new HandleButtonClick("Puzzle", lab));
        root3.getChildren().add(photoButton);
        photoButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					Puzzle puzzle = new Puzzle();
					
					puzzle.start(new Stage()); 
					
				

			}
		});
	    
            

	        //scene4 - framedScene
            Image background4 = new Image("view/resources/crime.jpg");
            ImageView mv4 = new ImageView(background4);
	  		Group root4 = new Group();
	          Label frameLabel = new Label("You've been framed! Your captain demands that you return to \n" +
	  									 "the station immediately for questioning. You may continue the \n" +
	  									 "case after.");
	          frameLabel.setFont(Font.font("Times New Roman", 24));
	          frameLabel.setTextFill(Color.web("#FFFFFF"));
	          root4.getChildren().add(mv4);
	          root4.getChildren().add(frameLabel);
	  		//PS2Button
	          TalkStealButton PS2Button = new TalkStealButton("Back to Police Station");
	          PS2Button.setLayoutX(1);
	          PS2Button.setLayoutY(150);
	          PS2Button.setOnAction(new HandleButtonClick("PS", frameLabel));
	          root4.getChildren().add(PS2Button);
	  		//directs to PS
	  		PS2Button.setOnAction(e -> {
	  			window.hide();
	  			//PoliceStation.PS();
	  		});
	   
		
	  	framedScene = new Scene(root4, 847, 600);
		weaponScene = new Scene(root3, 847, 600);

		crimeScene = new Scene(root, 800, 600);
		window.setScene(crimeScene);
		window.showAndWait();

    }

}

