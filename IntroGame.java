import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.animation.AnimationTimer;
 
public class IntroGame extends Application {
	
 	static Scene scene1, scene2, scene3, scene4, scene5;
	
    public void start(Stage primaryStage) {
		
	//scene1 - Start Menu
        VBox root1 = new VBox();
        Label label1 = new Label("Dead On The Dance Floor");
        label1.setFont(Font.font("Times New Roman", 24));
        root1.getChildren().add(label1);
		//PlayButton
        Button PlayButton = new Button("Play");
        PlayButton.setOnAction(new HandleButtonClick("Play", label1));
        root1.getChildren().add(PlayButton);
		//directs to scene2
		PlayButton.setOnAction(e -> primaryStage.setScene(scene2));
		
	//scene2 - Character Selection
		VBox root2 = new VBox();
        Label label2 = new Label("Pick a detective: ");
        label2.setFont(Font.font("Times New Roman", 24));
        root2.getChildren().add(label2);
		//aButton
        Button aButton = new Button("A");
        aButton.setOnAction(new HandleButtonClick("A", label2));
        root2.getChildren().add(aButton);
		//bButton
        Button bButton = new Button("B");
        bButton.setOnAction(new HandleButtonClick("B", label2));
        root2.getChildren().add(bButton);
		//directs to scene3
		aButton.setOnAction(e -> primaryStage.setScene(scene3));
		bButton.setOnAction(e -> primaryStage.setScene(scene3));

	//scene3 - Steal file or talk to supervisor
		VBox root3 = new VBox();
        Label label3 = new Label("Case file");
        label3.setFont(Font.font("Times New Roman", 24));
        root3.getChildren().add(label3);
		//StealButton
        Button StealButton = new Button("Steal file");
        StealButton.setOnAction(new HandleButtonClick("Steal", label3));
        root3.getChildren().add(StealButton);
		//TalkButton
        Button TalkButton = new Button("Talk to supervisor");
        TalkButton.setOnAction(new HandleButtonClick("Talk", label3));
        root3.getChildren().add(TalkButton);
		//directs to scene4 and scene5
		StealButton.setOnAction(e -> primaryStage.setScene(scene4));
		TalkButton.setOnAction(e -> primaryStage.setScene(scene5));
		
	//scene4 - FIRED for stealing file
		VBox root4 = new VBox();
        Label label4 = new Label("You've been fired!");
        label4.setFont(Font.font("Times New Roman", 24));
        root4.getChildren().add(label4);
		//ReturnButton
        Button ReturnButton = new Button("Return to case");
        ReturnButton.setOnAction(new HandleButtonClick("Return", label4));
        root4.getChildren().add(ReturnButton);
		//directs back to scene3
		ReturnButton.setOnAction(e -> primaryStage.setScene(scene3));
		
	//scene5 - Tic Tac Toe
		VBox root5 = new VBox();
        Label label5 = new Label("Play Tic Tac Toe or start case");
        label5.setFont(Font.font("Times New Roman", 24));
        root5.getChildren().add(label5);
		//TTTButton
		Button TTTButton = new Button("Play Tic Tac Toe");
        TTTButton.setOnAction(new HandleButtonClick("TTT", label4));
        root5.getChildren().add(TTTButton);
		//directs to TTT class
		//TTTButton.setOnAction(e -> {
			//TicTacToe.TTT();
		//});
		
		//CaseButton
		Button CaseButton = new Button("Start case");
        CaseButton.setOnAction(new HandleButtonClick("Case", label5));
        root5.getChildren().add(CaseButton);
		//directs to PoliceStation class
		CaseButton.setOnAction(e -> {
			PoliceStation.PS();
		});
		
		scene5 = new Scene(root5);
		scene4 = new Scene(root4);
		scene3 = new Scene(root3);
		scene2 = new Scene(root2);
  		scene1 = new Scene(root1);
		
        primaryStage.setTitle("Dead On The Dance Floor");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}