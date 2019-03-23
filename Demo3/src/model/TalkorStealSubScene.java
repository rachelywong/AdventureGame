package model;

import javafx.scene.SubScene;
import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class TalkorStealSubScene extends SubScene {
	
	//constants for font and background image
	private final static String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private final static String BACKGROUND_IMAGE = "model/resources/blue_panel.png";
	
	private boolean isHidden;
	
	public TalkorStealSubScene() {
		super(new AnchorPane(), 600, 200); // y = 400
		prefWidth(300);
		prefHeight(200);
		
		//setting background
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 300, 200, false, true), //y  = 200
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		isHidden = true;
		
		setLayoutX(1024);
		setLayoutY(130);
		
	}
	
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this); //which element should be moved
		
		if (isHidden) { //is subscene is hidden show it up
		transition.setToX(-676); //how a particular element will change in x axis
		isHidden = false;
		} else { // if subscene is shown, then hide it
			transition.setToX(0);
			isHidden = true;
		}
		
		transition.play();
	}
	//this method returns the pane of subscene
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
		
	}

}
