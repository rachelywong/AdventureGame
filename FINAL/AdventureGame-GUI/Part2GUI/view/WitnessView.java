/**
 * @author Team7
 */

/**
 * Class represents the witness 
 * <p>
 *
 */ 
package view;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class WitnessView {
	
	//instance variable
	private AnchorPane witnessPane;
	private Scene witnessScene;
	private Stage witnessStage;
	private static final int GAME_WIDTH = 800;
	private static final int GAME_HEIGHT = 600;
	private Stage locaStage;
	
	public WitnessView() {
		initializeStage();
		createBackground();
	}
	
	private void initializeStage() {
		witnessPane = new AnchorPane();
		witnessScene = new Scene(witnessPane, GAME_WIDTH, GAME_HEIGHT);
		witnessStage = new Stage();
		witnessStage.setScene(witnessScene);
	}
	
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
*/
