package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class IntroSubScene extends SubScene {

	private final static String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private final static String BACKGROUND_IMAGE = "model/resources/blue_panel.png";
	
	private boolean isHidden;
	
	public IntroSubScene() {
		super(new AnchorPane(), 700, 800);
		prefWidth(500);
		prefHeight(100);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 300, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		isHidden = true;
		
		setLayoutX(1000); 
		setLayoutY(180);
		
	}
	
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		if(isHidden) {
		transition.setToX(-950);
		isHidden = false;
		}else {
			transition.setToX(0);
			isHidden = true;
		}
		
		transition.play();
	}
	//this method returns pane of subscene
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
}