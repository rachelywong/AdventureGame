/**
* @author Team 7
* This class formats the detective choosing expereince 
*/
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
	
	/**
	* Constructor that develops the Detective chooser scene 
	* @param Detective 
	 *@return DetectivePicker
	*/
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
	
	
	/**
	* Getter for detective 
	* @param Detective 
	 *@return DetectivePicker
	*/
	public Detective getDetective() {
		return detective;
	}
	
	/**
	* Getter that for checking of circle is chosen 
	* @param void 
	 *@return boolean 
	*/
	public boolean getIsCircleChoosen() {
		return isCircleChoosen;
	}
	
	/**
	* Checks weather circle is chosen  
	* @param boolean 
	 *@return void 
	*/
	public void setIsCircleChoosen(boolean a) {
		String imageToSet;
		
		if (!a) { imageToSet ="view/resources/detectivechooser/empty1.png"	;}
		else { imageToSet ="view/resources/detectivechooser/empty.png";}
		
		System.out.println(imageToSet);
		circleImage.setImage(new Image(imageToSet));
	}
}
