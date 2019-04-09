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
import tictactoegui.TicTacToeGUI;
public class LocationAView {

    /*
     *Create static variables for all scenes. Scene 1 displays the door choice scene and scene
     *4 displays the witness that allows you to recieve the next clue after playing a game of hangman.
     *Initializes variable wondow as the stage and initializes an instance of PoliceStation 
     */
    
	public static Scene scene1, scene4;
	private static Stage window;
	public static PoliceStation ps;

	/**
	 * Will get the window and return it
	 * 
	 * @param the current Stage specified 
	 * @return the Stage called window
	 */ 
	public Stage getStage() {
        return window;
    }
	/*
	*Will take the specific button specified and change it's shape into an arrow
	* 
	* @param the button for arrows pointing to the doors and sets their shapes as arrows
	* @return no return
	*/
	public static void setPolygon(Button arrow){
		Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            0.0, 0.0,
            100.0, 0.0,
            75.0, 20.0,
			125.0,65.0,
			75.0,125.0,
			25.0, 80.0,
			0.0,100.0
			});
		arrow.setShape(polygon);
		
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
	    window.setTitle("Location A");
		
	    
	    /*
	     * TalkStealButton riddleButton = new TalkStealButton("Play");
		riddleButton.setLayoutX(100);
		riddleButton.setLayoutY(200);
		root4.getChildren().add(riddleButton);
	     */
	    
	    
	    
	    
		//block scene
		Image blockImage = new Image("view/resources/brickwall.png");
		ImageView blockView = new ImageView(blockImage);
		Group blockPane = new Group();
		//blockPane.setMaxSize(800, 600);
		blockPane.getChildren().add(blockView);
		Scene block = new Scene(blockPane);
		
		/*
		TalkStealButton backButton = new TalkStealButton("Go Back");
		backButton.setLayoutX(50);
		backButton.setLayoutY(420);
		blockPane.getChildren().add(backButton);
		
		
		backButton.setOnAction( e -> window.setScene(scene1));
       */
		
		
		
		
		
        //Background
		Image background1 = new Image("view/resources/doors2.jpg");
		ImageView mv1 = new ImageView(background1);
		Group root = new Group();
		root.prefHeight(600);
		root.prefWidth(800);
		root.getChildren().add(mv1);
		
		/*
		TalkStealButton backA = new TalkStealButton("Go Back");
		backA.setLayoutX(50);
		backA.setLayoutY(500);
		root.getChildren().add(backA);
		
		
		
		
		backA.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ps.display1();
			
			}
			});
			
		*/	
		
		

		
		//Intro Label 
		HBox introloc = new HBox();
		Label intro = new Label("You have arrived at the witness's house, the front door is open, but you must navigate through the "+
								"house to find the witness. Keep your eyes peeled, you never know what dangers may lurk!" );
		intro.setLayoutX(100);
		intro.setLayoutY(300);
		intro.setTextFill(Color.web("#FFFFFF"));
		intro.setFont(new Font("Times New Roman", 18));
		intro.setWrapText(true);			
		root.getChildren().add(introloc);
		introloc.getChildren().add(intro);
		
		//Go Back button 
		HBox gback = new HBox();
		gback.setAlignment(Pos.TOP_LEFT);
		TalkStealButton gbutton = new TalkStealButton("Go Back");
		root.getChildren().add(gback);
		gback.getChildren().add(gbutton);
		
		//Arrows
		HBox arrows1  = new HBox(250);
		arrows1.setAlignment(Pos.CENTER);
		root.getChildren().add(arrows1);
	
		Button arrowA1= new Button("A");
		arrowA1.setOnAction(e -> window.setScene(scene4));
		setPolygon(arrowA1);
		
		Button arrowB1 = new Button("B");
		arrowB1.setOnAction(e -> window.setScene(block));
		setPolygon(arrowB1);
		
		Button arrowC1 = new Button("C");
		setPolygon(arrowC1);
		arrowC1.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent attack) {
				Scene attackerScene = RPS.getAttackScene();
				window.setScene(attackerScene);
				//attackTerm.doattackTerm();
			}
		});
		
		
		arrows1.getChildren().add(arrowA1);
		arrows1.getChildren().add(arrowB1);
		arrows1.getChildren().add(arrowC1);
		
		
		
		
		//Background4
		Image background4 = new Image("view/resources/witness.jpg");
		ImageView mv4 = new ImageView(background4);
		Group root4 = new Group();
		Label lab = new Label("Help a witness to guess a word and get a new clue.");
		lab.setTextFill(Color.web("#FFFFFF"));
		lab.setFont(Font.font("Times New Roman", 24));
		
		root4.getChildren().add(mv4);
		root4.getChildren().add(lab);
		
		TalkStealButton riddleButton = new TalkStealButton("Play");
		riddleButton.setLayoutX(100);
		riddleButton.setLayoutY(200);
		root4.getChildren().add(riddleButton);

		
		
		
		riddleButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Hangman hangman = new Hangman();
				hangman.start(new Stage());
			}
		});
		
		TalkStealButton backfromA = new TalkStealButton("Go Back");
		backfromA.setLayoutX(100);
		backfromA.setLayoutY(250);
		root4.getChildren().add(backfromA);
		
		backfromA.setOnAction( e -> window.setScene(scene1));
		
		
		
		
		
		
		/*
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				riddleButton.setOnAction(e -> {
					Hangman hangman = new Hangman();
					hangman.start(new Stage());
				
			});
			
			}
		};
		*/
		
		/*
		riddleButton.setOnAction(e -> {
			Riddle2.display();
		});
		*/
		
		
		
		scene4 = new Scene(root4);
		
		
		
		
		scene1 = new Scene(root, 800, 600);
		window.setScene(scene1);
		window.showAndWait();

    }

}

