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
 
public class IntroGame extends Application {
	
 	static Scene startScene, characterSelection, getInfoScene, FIREDscene, supervisorScene;
	
    public void start(Stage primaryStage) {
		
	//scene1 - startScene
        VBox root1 = new VBox();
		//titleLabel
        Label titleLabel = new Label("Dead On The Dance Floor");
        titleLabel.setFont(Font.font("Times New Roman", 24)); 
        root1.getChildren().add(titleLabel);
		//playButton
        Button playButton = new Button("Play");
        playButton.setOnAction(new HandleButtonClick("Play", titleLabel));
        root1.getChildren().add(playButton);
		//directs to scene2
		playButton.setOnAction(e -> primaryStage.setScene(characterSelection));
		
	//scene2 - characterSelection
		VBox root2 = new VBox();
		//pickCharLabel
        Label pickCharLabel = new Label("Pick a detective: ");
        pickCharLabel.setFont(Font.font("Times New Roman", 24));
        root2.getChildren().add(pickCharLabel);
		//aButton
        Button aButton = new Button("A");
        aButton.setOnAction(new HandleButtonClick("A", pickCharLabel));
        root2.getChildren().add(aButton);
		//bButton
        Button bButton = new Button("B");
        bButton.setOnAction(new HandleButtonClick("B", pickCharLabel));
        root2.getChildren().add(bButton);
		//directs to scene3
		aButton.setOnAction(e -> primaryStage.setScene(getInfoScene));
		bButton.setOnAction(e -> primaryStage.setScene(getInfoScene));

	//scene3 - getInfoScene
		VBox root3 = new VBox();
		//choice1Label
        Label choice1Label = new Label("How would you like to go about getting information regarding the case: \n" +
									   "Talk to your supervisor first, or steal the case folder from the filing cabinet?");
        choice1Label.setFont(Font.font("Times New Roman", 24));
        root3.getChildren().add(choice1Label);
		//stealButton
        Button stealButton = new Button("Steal file");
        stealButton.setOnAction(new HandleButtonClick("Steal", choice1Label));
        root3.getChildren().add(stealButton);
		//talkButton
        Button talkButton = new Button("Talk to supervisor");
        talkButton.setOnAction(new HandleButtonClick("Talk", choice1Label));
        root3.getChildren().add(talkButton);
		//directs to scene4 and scene5
		stealButton.setOnAction(e -> primaryStage.setScene(FIREDscene));
		talkButton.setOnAction(e -> primaryStage.setScene(supervisorScene));
		
	//scene4 - FIREDscene
		VBox root4 = new VBox();
		//FIREDlabel
        Label FIREDlabel = new Label("You're FIRED! This has been a test, and you failed. \n" +
									 "Make better choices in the game!");
        FIREDlabel.setFont(Font.font("Times New Roman", 24));
        root4.getChildren().add(FIREDlabel);
		//returnButton
        Button returnButton = new Button("Return to case");
        returnButton.setOnAction(new HandleButtonClick("Return", FIREDlabel));
        root4.getChildren().add(returnButton);
		//directs back to scene3
		returnButton.setOnAction(e -> primaryStage.setScene(getInfoScene));
		
	//scene5 - supervisorScene
		VBox root5 = new VBox();
		//choice2Label
        Label choice2Label = new Label("Supervisor: 'I'm so glad to see that you are so eager. Would you care to play a \n" +
									   "round of Tic Tac Toe with me before you start the case? If you win, I'll give \n" +
									   "a hint...'");
        choice2Label.setFont(Font.font("Times New Roman", 24));
        root5.getChildren().add(choice2Label);
		//TTTButton
		Button TTTButton = new Button("Play Tic Tac Toe");
        TTTButton.setOnAction(new HandleButtonClick("TTT", FIREDlabel));
        root5.getChildren().add(TTTButton);
		//directs to TTT class
		//TTTButton.setOnAction(e -> {
			//TicTacToeGUI.display();
		//});
		
		//caseButton
		Button caseButton = new Button("Start case");
        caseButton.setOnAction(new HandleButtonClick("Case", choice2Label));
        root5.getChildren().add(caseButton);
		//directs to PoliceStation class
		caseButton.setOnAction(e -> {
			primaryStage.hide();
			PoliceStation.PS();
		});
		
		
		supervisorScene = new Scene(root5, 847, 600);
		FIREDscene = new Scene(root4, 847, 600);
		getInfoScene = new Scene(root3, 847, 600);
		characterSelection = new Scene(root2, 847, 600);
  		startScene = new Scene(root1, 847, 600);
		
        primaryStage.setTitle("Dead On The Dance Floor");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }
}
