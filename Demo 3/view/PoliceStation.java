package view;

import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.event.Event;
import model.TalkStealButton;
import javafx.scene.Scene;
import java.util.List;
import model.TalkorStealSubScene;
import tictactoegui.TicTacToeGUI;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.InfoLabel;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundPosition;
import model.StealLabel;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.input.MouseButton;
import javafx.scene.image.ImageView;
import model.Detective;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.animation.AnimationTimer;


public class PoliceStation {
	
	
	

	
	private AnchorPane talkPane;
	private Scene talkScene;
	protected static Stage talkStage;
	
	
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	
	
	private Stage menuStage;
	
	
	
	public PoliceStation() {
	initializeStage();
	}

	private void initializeStage() {
	talkPane = new AnchorPane();
	talkScene = new Scene(talkPane, GAME_WIDTH, GAME_HEIGHT);
	talkStage = new Stage();
	talkStage.setScene(talkScene);
	createAButton();
	createBButton();
	createBackground();
	createCButton();
	createDButton();
	}

	public void createNewGameS(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		talkStage.show();
		

	}
	
	public void display1() {
		talkStage.show();
		
	}
	
	
	

	
	//method to create buttons
	private TalkStealButton createAButton() {
		
		TalkStealButton abutton = new TalkStealButton("Witness House");
		talkPane.getChildren().add(abutton);
		
		abutton.setLayoutX(250);
		abutton.setLayoutY(210);
		
		LocationAView.ps = this;
		LocationBView.ps = this;
		
		abutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//LocationAView locationa = new LocationAView();
				talkStage.hide();
				LocationAView.display();
				
			}
		});
		
		return abutton;
		
	}
	
	
	
	
	
	
    private TalkStealButton createBButton() {
		
		TalkStealButton bbutton = new TalkStealButton("Crime Scene");
		talkPane.getChildren().add(bbutton);
		
		bbutton.setLayoutX(600);
		bbutton.setLayoutY(80);
		
		bbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//LocationBView locationb = new LocationBView();
				LocationBView.display();
			}
		});
		
		return bbutton;
		
	}
    
private TalkStealButton createCButton() {
		
		TalkStealButton cbutton = new TalkStealButton("Local Gym");
		talkPane.getChildren().add(cbutton);
		
		cbutton.setLayoutX(580);
		cbutton.setLayoutY(430);
		
		cbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//LocationCView locationc = new LocationCView();
				LocationCView.display();
			}
		});
		return cbutton;
		
	}

    
    private TalkStealButton createDButton() {
	
	TalkStealButton dbutton = new TalkStealButton("Guess the murderer");
	talkPane.getChildren().add(dbutton);
	
	dbutton.setLayoutX(100);
	dbutton.setLayoutY(540);
	
	dbutton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			//LocationDView locationd = new LocationDView();
			LocationDView.display();
		}
	});
	return dbutton;
	
}
	
	private void createBackground() {
		Image backgroundImage = new Image("view/resources/map.jpg",820, 650, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		talkPane.setBackground(new Background(background));
		
		
		
	}	
}