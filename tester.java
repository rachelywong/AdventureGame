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
public class tester {

    //Create variable
    static boolean answer;
	static Scene scene1, scene2, scene3;
    
	public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("locA");
        
      

        //Background
		Image background1 = new Image("file:doors2.jpg");
		ImageView mv1 = new ImageView(background1);
		GridPane root = new GridPane();
		root.setMaxSize(847, 600);
		root.getChildren().add(mv1);
		
		
		//Intro Label 
		HBox introloc = new HBox();
		introloc.setAlignment(Pos.BOTTOM_CENTER);
		Label intro = new Label("You have arrived at the witness's house, the front door is open, but you must navigate through the "+
								"house to find the witness. Keep your eyes peeled, you never know what dangers may lurk!" );
		intro.setTextFill(Color.web("#FFFFFF"));
		intro.setFont(new Font("Times New Roman", 18));
		intro.setTextAlignment(TextAlignment.CENTER);
		intro.setWrapText(true);			
		root.getChildren().add(introloc);
		introloc.getChildren().add(intro);
		
		//Arrows
		HBox arrows1  = new HBox(250);
		arrows1.setAlignment(Pos.CENTER);
		root.getChildren().add(arrows1);
		
		Button arrowA1= new Button("A");
		arrowA1.setOnAction(e -> {
	block.wall();
	});
		
		Button arrowB1 = new Button("B");
		//arrowB1.setOnAction(e -> window.setScene(scene2));
		Button arrowC1 = new Button("C");
		
		Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            0.0, 0.0,
            100.0, 0.0,
            75.0, 20.0,
			125.0,65.0,
			75.0,125.0,
			25.0, 80.0,
			0.0,100.0
			});
		arrowA1.setShape(polygon);
		arrowB1.setShape(polygon);
		arrowC1.setShape(polygon);
		
		arrows1.getChildren().add(arrowA1);
		arrows1.getChildren().add(arrowB1);
		arrows1.getChildren().add(arrowC1);
		
		
    }

}