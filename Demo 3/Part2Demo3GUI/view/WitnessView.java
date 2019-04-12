
/**
 * @author Team7
 */

/**
 * Class represents the witness 
 * <p>
 *
 */ 

package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.TalkStealButton;
import tictactoegui.TicTacToeGUI;

public class WitnessView {
	
	private AnchorPane witnessPane;
	private Scene witnessScene;
	private Stage witnessStage;
	
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	
	private Stage locaStage;
	
	
	public WitnessView() {
		initializeStage();
		createBackground();
		//createdoor1Button();
	}
	
	private void initializeStage() {
		witnessPane = new AnchorPane();
		witnessScene = new Scene(witnessPane, GAME_WIDTH, GAME_HEIGHT);
		witnessStage = new Stage();
		witnessStage.setScene(witnessScene);
	}
	
	/*
	private TalkStealButton createdoor1Button() {
	       
	       TalkStealButton door1Button = new TalkStealButton("DOOR1");
	        door1Button.setLayoutX(50);
	        door1Button.setLayoutY(80); }
	      
	        /*
	        door1Button.setOnAction(new EventHandler<ActionEvent>() {
				
	        	@Override
				public void handle(ActionEvent event) {
						T talkManager = new TalkViewManager();
						talkManager.createNewGameS(gameStage); //chooseDetective
					

				}
			});
			
			return talkButton;
			
		}
		*/
	
	public void createLocAWindow(Stage locaStage) {
		this.locaStage = locaStage;
		this.locaStage.hide();
		witnessStage.show();
		
		
	}
	private void createBackground() {
		Image backgroundImage = new Image("hilda.jpg", 800, 890, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage , BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		witnessPane.setBackground(new Background(background));
	}
	
}
