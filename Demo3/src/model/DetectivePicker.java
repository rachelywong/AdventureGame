package model;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class DetectivePicker extends VBox {
	
	private ImageView circleImage;
	private ImageView detectiveImage;
	
	private String circleNotChoosen = "view/resources/detectivechooser/empty1.png";
	private String circleChoosen = "view/resources/detectivechooser/empty.png";
	
	private Detective detective;
	
	private boolean isCircleChoosen;
	
	//constructor
	public DetectivePicker (Detective detective) {
		circleImage = new ImageView(circleNotChoosen);
		detectiveImage = new ImageView(detective.getUrl());
		this.detective = detective;
		isCircleChoosen = false; // at the beginning the circle will not be chosen
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.getChildren().add(circleImage);
		this.getChildren().add(detectiveImage);
	}
	

	public Detective getDetective() {
		return detective;
	}

	public boolean getIsCircleChoosen() {
		return isCircleChoosen;
	}
	public void setIsCircleChoosen(boolean a) {
		String imageToSet;
		//System.out.println(isCirlceChoosen);
		//this.isCircleChoosen = isCircleChoosen;
		if (!a) { imageToSet ="view/resources/detectivechooser/empty1.png"	;}
		else { imageToSet ="view/resources/detectivechooser/empty.png";}
		
		//String imageToSet = this.isCircleChoosen ? "view/resources/detectivechooser/empty.png" : "view/resources/detectivechooser/empty1.png";
		System.out.println(imageToSet);
		circleImage.setImage(new Image(imageToSet));
	}
}
