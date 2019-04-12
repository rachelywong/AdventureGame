/**
 * @author Team7
 */

/**
 * Class represents the mini game of Hangman.
 * <p>
 */ 
package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundRepeat;
import model.IntroButton;
import model.IntroSubScene;
import javafx.scene.image.ImageView;
import model.Detective;
import model.DetectivePicker;
import model.InfoLabel;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.Clabel;
import javafx.scene.control.Label;



public class ViewManager {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTONS_START_X = 585;
	private final static int MENU_BUTTONS_START_Y = 130;
	
	
	private IntroSubScene creditsSubScene;
	private IntroSubScene helpSubScene;
	private IntroSubScene scoreSubScene;
	private IntroSubScene detectiveChooserScene;
	
	private IntroSubScene sceneToHide;
	List<IntroButton> menuButton;
	
	List<IntroButton> menuButtons;
	
	List<DetectivePicker> detectiveList;
	private  Detective choosenDetective; //private
	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		createSubScene();
		createButtons();
		createBackground();
		createLogo();
		
		

	}
	
	private void showSubScene(IntroSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	private void createSubScene() {
		
		
		
		
		helpSubScene = new IntroSubScene();
		mainPane.getChildren().add(helpSubScene);
		
		Label helpLabel = new Label(" To begin the game please press PLAY \n" + 
		                            " and then follow the instructions as \n" +  
		                            " prompted to play throughout the game.");
		
		helpLabel.setFont(new Font("Times New Roman", 23));
		helpLabel.setLayoutX(10);
		helpLabel.setLayoutY(30);
		
		creditsSubScene = new IntroSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		Label creditLabel = new Label("  Game created and developed by \n" +   
		                              "  Team 7 (Elvira, Rachel, Abi, \n" +  
		                              "  and Teresa) for CPSC 219 - Winter \n" + 
		                              "  2019. Game uses Java and Javafx.");
		creditLabel.setFont(new Font("Times New Roman", 23));
		creditLabel.setLayoutX(10);
		creditLabel.setLayoutY(30);
		
		creditsSubScene.getPane().getChildren().add(creditLabel);
		
		helpSubScene.getPane().getChildren().add(helpLabel);
		
		scoreSubScene = new IntroSubScene();
		mainPane.getChildren().add(scoreSubScene);
		
		Label scoreLabel = new Label("  This version of the game does not \n" + 
		                             "  utilize scoring methods. Please stay \n" + 
		                             "  tuned for if we ever work on this \n" + 
		                             "  game after CPSC 219.");
		scoreLabel.setFont(new Font("Times New Roman", 23));
		
		scoreLabel.setLayoutX(10);
		scoreLabel.setLayoutY(30);
		
		scoreSubScene.getPane().getChildren().add(scoreLabel);
		
		createDetectiveChooserSubScene();
	}
	
	private void createDetectiveChooserSubScene() {
		detectiveChooserScene = new IntroSubScene();
		mainPane.getChildren().add(detectiveChooserScene);
		
		InfoLabel chooseDetectiveLabel = new InfoLabel("CHOOSE YOUR DETECTIVE");
		chooseDetectiveLabel.setLayoutX(10);
		chooseDetectiveLabel.setLayoutY(15); 
		detectiveChooserScene.getPane().getChildren().add(chooseDetectiveLabel);
		detectiveChooserScene.getPane().getChildren().add(createDetectivesToChoose());
		detectiveChooserScene.getPane().getChildren().add(createButtonToStart());
		
		
	}
	
	private HBox createDetectivesToChoose() {
		HBox box = new HBox();
		box.setSpacing(20);
		detectiveList = new ArrayList<>();
		for(Detective detective : Detective.values()) {
			DetectivePicker detectiveToPick = new DetectivePicker(detective);
			detectiveList.add(detectiveToPick);
			box.getChildren().add(detectiveToPick);
			detectiveToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
					System.out.println(event.getX());
					for (DetectivePicker detective : detectiveList) {
						detective.setIsCircleChoosen(false);
						
						
					}
					detectiveToPick.setIsCircleChoosen(true);
					choosenDetective = detectiveToPick.getDetective();
					System.out.println(choosenDetective);
				}
			});
		}
		box.setLayoutX(300-(140*2));
		box.setLayoutY(80); 
		return box;
	}
	
	private IntroButton createButtonToStart() {
		IntroButton startButton = new IntroButton("START");
		startButton.setLayoutX(110);
		startButton.setLayoutY(260);
		
		//creates stealortalk window after START BUTTON is pressed
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (choosenDetective != null) {
					TalkorSteal gameManager = new TalkorSteal();
					gameManager.createNewGame(mainStage, choosenDetective); //chooseDetective
				}

			}
		});
		return startButton;
		
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public void addMenuButton(IntroButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size()* 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createButtons() {
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
		
	}
	
	private void createStartButton() {
		IntroButton startButton = new IntroButton ("PLAY");
		addMenuButton(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(detectiveChooserScene);
			}
		});
	}
	
	private void createScoresButton() {
		IntroButton scoresButton = new IntroButton("SCORES");
		addMenuButton(scoresButton);
		
		scoresButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubScene);
				
			}
		});
	}
	
	private void createHelpButton() {
		IntroButton helpButton = new IntroButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubScene);
			}
			
		});
	}
	
	private void createCreditsButton() {
		IntroButton creditsButton = new IntroButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showSubScene(creditsSubScene);
			}
		});
	}
	
	private void createExitButton() {
		IntroButton exitButton = new IntroButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}
		
		
	
	
	private void createBackground() {
		Image backgroundImage = new Image("view/resources/disco.png", 800, 600, false, true);
		BackgroundImage background = new BackgroundImage (backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
		
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("view/resources/logo.png");
		logo.setLayoutX(10);
		logo.setLayoutY(30);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
				
			}
		});
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}
		});
		
		mainPane.getChildren().add(logo);
	}

}
