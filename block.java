import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*; 
import javafx.geometry.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class block{
	
	static Scene scene1;
	
	public static void display(){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("WALL");
		
		Image background_wall = new Image("file:brickwall.jpg");
		ImageView wall_view = new ImageView(background_wall);
		GridPane root_wall = new GridPane();
		root_wall.getChildren().add(wall_view);
		
		
		scene1 = new Scene(root_wall);
		window.setScene(scene1);
		window.showAndWait();
	}
}