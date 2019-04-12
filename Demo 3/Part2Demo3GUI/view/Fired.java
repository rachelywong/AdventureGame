/**
 * @author Team7
 */

/**
 * Class represents the fired 
 * <p>
 * 
 */


package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Fired {
	
	//instance variables
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	
	
	public Fired() {
		initializeStage();
	}
	//Initializes stage with a new anchorpane and gameScene
	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
	}

	//method that hides the previous window and shows the fired window
	public void createFiredWindow(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		gameStage.show();
		
	
		
	}
	
	

}
