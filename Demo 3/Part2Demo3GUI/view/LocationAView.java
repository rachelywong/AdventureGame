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
	*Will create a new Stage and display scene 1 (doors) on the stage. Background is a 
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
	    
	    
	    
	    
		
		/*
		 *Block scene
		 *
		 *Creating scene for the blocked pathway using ImageView() method. 
		 *TalkStealButtons are used display formatted Play buttons. 
		 */
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
		
		
		

		/*
		 *Background
		 *
		 *Initial backdrop of beginning of Location A. 
		 *Using metho Imageview()
		 */
		
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
		
		

		/*
		 *Intro Label 
		 *
		 *Creates HBox introloc which displays the initial instructions
		 *Creates a label to introduce the initial challenge of finding the correct door that has the witness.
		 *Formats label and adds to HBox introloc
		 */
		
		HBox introloc = new HBox();
		introloc.setAlignment(Pos.BOTTOM_CENTER);
		Label intro = new Label("You have arrived at the witness's house, the front door is open, but you must navigate through the "+
								"house to find the witness. Keep your eyes peeled, you never know what dangers may lurk!" );
		System.out.println("You have arrived at the witness's house, the front door is open, but you must navigate through the "+
								"house to find the witness. Keep your eyes peeled, you never know what dangers may lurk!");
		intro.setTextFill(Color.web("#FFFFFF"));
		intro.setFont(new Font("Times New Roman", 18));
		intro.setTextAlignment(TextAlignment.CENTER);
		intro.setWrapText(true);			
		root.getChildren().add(introloc);
		introloc.getChildren().add(intro);
		
		
		/*
		 *Go Back button 
		 *
		 *Creates HBox gback which allows user to return to the police station.
		 *Creates new TalkStealButton that displays "Go Back". 
		 *Button is added to Hbox gback which is added to the root
		 */
		HBox gback = new HBox();
		gback.setAlignment(Pos.TOP_LEFT);
		TalkStealButton gbutton = new TalkStealButton("Go Back");
		root.getChildren().add(gback);
		gback.getChildren().add(gbutton);
		
		
		/*
		 *Arrows
		 *
		 *Creates HBox arrows1 at size 250. HBox arrows1 is added to the root. 
		 *3 new buttons are created, formatted using the method setPolygon(). 
		 *Arrow buttons either lead to a blocked wall, a Rock Paper Scissors mini game or 
		 *to the witness. 
		 *Buttons are added to HBox arrows1. 
		 */
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
				
			}
		});
		
		
		arrows1.getChildren().add(arrowA1);
		arrows1.getChildren().add(arrowB1);
		arrows1.getChildren().add(arrowC1);
		
		
	
		/*
		 *Background4
		 *
		 *Creating scene for the witness that calls the Hangman mini-game. 
		 *TalkStealButtons are used display formatted Play buttons. 
		 */
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

