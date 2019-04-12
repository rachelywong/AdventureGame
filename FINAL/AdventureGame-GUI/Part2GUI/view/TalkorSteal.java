package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.util.List;
import model.TalkorStealSubScene;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import tictactoegui.TicTacToeGUI;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundPosition;
import model.StealLabel;
import model.TalkStealButton;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.image.ImageView;
import model.Detective;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.animation.AnimationTimer;


public class TalkorSteal {
	
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	
	
	private Stage menuStage;
	private ImageView detective;
	
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private int angle;
	private AnimationTimer gameTimer;
	
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	private Stage mainStage;
	
	
	//setting positions to buttons
	private final static int MENU_BUTTONS_START_X = 100; 
	private final static int MENU_BUTTONS_START_Y = 90;
	
	//stealcase subscene
	private TalkorStealSubScene stealSubScene;
	private TalkorStealSubScene talkSubScene;
	
	private TalkorStealSubScene sceneToHide;
	
	
	
	//defining a list where buttons will be stored
	List<TalkStealButton> menuButtons;
		
	public TalkorSteal() {
		menuButtons = new ArrayList<>();
		initializeStage();
		//createKeyListeners();
		createSTButton();
		createBackground();
		createSubScenes();
		
		
	}
	//method to implement hiding , showing logic
	private void showSubScene(TalkorStealSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}	
	subScene.moveSubScene();
	sceneToHide = subScene;	
	}
	
	//method that initializes subscenes
	private void createSubScenes() {
		createTalkSubScene();
		createStealSubScene();
	}
	
	private void createTalkSubScene() {
		talkSubScene = new TalkorStealSubScene();
		gamePane.getChildren().add(talkSubScene);
		
		StealLabel talkLabel = new StealLabel("Play TTT or start a case");
		talkLabel.setLayoutX(3);
		talkLabel.setLayoutY(25);
		talkSubScene.getPane().getChildren().add(talkLabel);
		talkSubScene.getPane().getChildren().add(createtalkButtonToStart()); 
		talkSubScene.getPane().getChildren().add(createtttButtonToStart()); 
	}
        
    private TalkStealButton createtttButtonToStart() {
        TalkStealButton TTTButton = new TalkStealButton("Play TTT");
        TTTButton.setLayoutX(50);
        TTTButton.setLayoutY(80);
        TTTButton.setOnAction(new EventHandler<ActionEvent>() {
			
		@Override
		public void handle(ActionEvent event) {
			TicTacToeGUI tttgui = new TicTacToeGUI();	
			tttgui.start(new Stage()); //chooseDetective
			}
		});
		return TTTButton;	
	}
	
	private TalkStealButton createtalkButtonToStart() {
		TalkStealButton talkButton = new TalkStealButton("Start a Case");
		talkButton.setLayoutX(50);
		talkButton.setLayoutY(130);

		//creates stealortalk window after START BUTTON is pressed
		talkButton.setOnAction(new EventHandler<ActionEvent>() {
			
		@Override
		public void handle(ActionEvent event) {
			PoliceStation talkManager = new PoliceStation();
					talkManager.createNewGameS(gameStage); //chooseDetective
				

			}
		});
		
		return talkButton;
		
	}
	
	
	
	private void createStealSubScene() {
		stealSubScene = new TalkorStealSubScene();
		gamePane.getChildren().add(stealSubScene);
		
		StealLabel stealLabel = new StealLabel("You are FIRED! Go and talk to supervisor.");
		//stealLabel.setFont(new Font("Times New Roman", 18));
		stealLabel.setLayoutX(5);
		stealLabel.setLayoutY(25);
		stealSubScene.getPane().getChildren().add(stealLabel);
		//stealSubScene.getPane().getChildren().add(createtalkButtonToStart());
		
		}
	
	
	
	
	
	//method that helps to add menu buttons
	private void addMenuButton(TalkStealButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		gamePane.getChildren().add(button);
	}
	

	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene (gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setResizable(false);
		
	}
	public void createNewGame(Stage menuStage, Detective choosenDetective) {
		this.menuStage = menuStage;;
		this.menuStage.hide();
		//createGameLoop();
		gameStage.show();
		
	}
	
	//private TalkStealButton createButtonToStart() {
		//TalkStealButton talkButton = new TalkStealButton("NEXT");
		//talkButton.setLayoutX(350);
		//talkButton.setLayoutY(350);
		//return talkButton;
		
		
	//}
	
	
	//public Stage getMainStage() {
		//return mainStage;
	

	

	

	
	//separate method for each button and calling each button in createSTButton method
	private void createSTButton() {
		createStealButton();
		createTalkButton();
		createBackButton();
		
	}
	

	
	
	private void createTalkButton() {
		TalkStealButton talkButton = new TalkStealButton("Talk to the supervisor");
		addMenuButton(talkButton);
		
		talkButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(talkSubScene);
				
			}
		});
		
	} 
	private void createStealButton() {
		TalkStealButton stealButton = new TalkStealButton("Steal the case");
		addMenuButton(stealButton);
		
		stealButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(stealSubScene);
				
				
			}
			
		});
	}
	

	
	
	private void createBackButton() {
		TalkStealButton backButton = new TalkStealButton("Go back");
		addMenuButton(backButton);
        
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				gameStage.close();
				menuStage.show();
	}
		});
	}
	
	
	
	
	private void createBackground() {
		Image backgroundImage = new Image("view/resources/topsecret.jpg", 800, 890, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage , BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		gamePane.setBackground(new Background(background));
	}
	
		
		
		
		
		
				
		}
		
	
	
	/*
	private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				moveShip();
				
			}
		};
		
		gameTimer.start();
	}
	//method responsible for moving and rotating a ship
	private void moveShip() {
		if  (isLeftKeyPressed && !isRightKeyPressed) {
			if (angle > -5) { //-30
				angle= angle -5; // -5
			}
			detective.setRotate(angle);
			if(detective.getLayoutX() > -20) { // -20
				detective.setLayoutX(detective.getLayoutX()-3); //-3
			}
		}
		if  (isRightKeyPressed && !isLeftKeyPressed) {
			if (angle > 30) { //30
				angle = angle + 5;
			}
			detective.setRotate(angle);
			if (detective.getLayoutX()< 522) { //522
				detective.setLayoutX(detective.getLayoutX()+3);
			}
		}
		if  (!isLeftKeyPressed && !isRightKeyPressed) {
			if (angle < 0) {
				angle = angle + 5;
			}else  if (angle > 0){
				angle = angle -5;
			}
			detective.setRotate(angle);
		}
		if  (isLeftKeyPressed && isRightKeyPressed) {
			if (angle < 0) {
				angle = angle + 5;
			}else if (angle > 0) {
				angle = angle - 5;
			}
			detective.setRotate(angle);
		}
		}
		*/


/*
 * 
 */



