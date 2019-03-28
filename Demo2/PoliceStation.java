package police;

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

public class PoliceStation {
	
	public static void PS(){

		Stage primaryStage = new Stage();
		primaryStage.setTitle("Police Station");
		
		VBox root = new VBox();
		Label storyLab = new Label("Your supervisor hands you a file containing information about a recent murder case. \n" +
								   "It reads: \n" +
								   "\n" +
								   "'On January 31, 1978 at 0210 hrs, the local disco club was evacuated after the club bouncer \n" + 
								   "discovered an unidentified body in the corner of the dance floor. Cause of death was \n" + 
								   "determined to be blunt force trauma to the head. The bouncer states the DJ that night called \n" +
								   "him to break up a fight between two people. However, after arriving to the dance floor, the \n" +
								   "bouncer found only an unidentified victim on the floor. \n" +
								   "\n" +
								   "The DJ that night states he witnessed a fight between two people on the dance floor, but has \n" +
								   "not yet given a final statement to the authorities. \n" +
								   "\n" + 
								   "Reports identified a list of possible suspects, but more evidence is required for prosecution.' \n" +
								   "\n" +
								   "It is your duty as a detective to determine WHO the murderer is and HOW they murdered the \n" +
								   "victim, and bring justice to us all or else the dance club will never re-open and disco will die.");
        storyLab.setFont(Font.font("Times New Roman", 24));  
        root.getChildren().add(storyLab);

		Button LocA = new Button("Location A");
		Button LocB = new Button("Location B");
		Button LocC = new Button("Location C");
		Button LocD = new Button("Location D");
		
		LocA.setOnAction(e -> {
			LocationAGUI.display();
		});
		
		LocB.setOnAction(e -> {
			LocationBGUI.display();
		});
			
		LocC.setOnAction(e -> {
			LocationCGUI.display();
		});
		
		LocD.setOnAction(e -> {
			LocationDGUI.display();
		});
		
		root.getChildren().add(LocA);
		root.getChildren().add(LocB);
		root.getChildren().add(LocC);
		root.getChildren().add(LocD);
	
		Scene application = new Scene(root, 847, 600);
		primaryStage.setScene(application);
		primaryStage.show();
	}
}
