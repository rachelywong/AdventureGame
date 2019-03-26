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
public class LocationAGUI {

    //Create static variables for all scenes 
    
	public static Scene scene1, scene2, scene3, scene4, scene5;
    private static Stage window;

	public Stage getStage() {
        return window;
    }
	
	public static void setPolygon(Button arrow){
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
		arrow.setShape(polygon);
		
	}
	
			
	public static void display() {
		
		//block scene
		Image blockImage = new Image("file:brickwall.png");
		ImageView blockView = new ImageView(blockImage);
		GridPane blockPane = new GridPane();
		blockPane.setMaxSize(847, 600);
		blockPane.getChildren().add(blockView);
		Scene block = new Scene(blockPane);
		
		
		
		
	
		
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
		arrowA1.setOnAction(e -> window.setScene(block));
		setPolygon(arrowA1);
		
		Button arrowB1 = new Button("B");
		arrowB1.setOnAction(e -> window.setScene(scene2));
		setPolygon(arrowB1);
		
		Button arrowC1 = new Button("C");
		setPolygon(arrowC1);
		arrowC1.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent attack) {
				Scene attackerScene = attackGUI.getAttackScene();
				window.setScene(attackerScene);
				//attackTerm.doattackTerm();
			}
		});
		
		
		arrows1.getChildren().add(arrowA1);
		arrows1.getChildren().add(arrowB1);
		arrows1.getChildren().add(arrowC1);
		
		//Background2
		//Image background2 = new Image("file:doors2.jpg");
		ImageView mv2 = new ImageView(background1);
		GridPane root2 = new GridPane();
		root2.getChildren().add(mv2);
		
		
		//Intro Label 2
		HBox door2loc = new HBox();
		door2loc.setAlignment(Pos.BOTTOM_CENTER);
		Label door2 = new Label("You are at door #2");
		door2.setTextFill(Color.web("#FFFFFF"));
		door2.setFont(new Font("Times New Roman", 36));
		door2.setTextAlignment(TextAlignment.CENTER);
		door2.setWrapText(true);			
		root2.getChildren().add(door2loc);
		door2loc.getChildren().add(door2);
		
		//Arrows2
		HBox arrows2  = new HBox(250);
		arrows2.setAlignment(Pos.CENTER);
		root2.getChildren().add(arrows2);
		
		Button arrowA2= new Button("A");
		arrowA2.setOnAction(e -> window.setScene(block));
		setPolygon(arrowA2);
		Button arrowB2 = new Button("B");
		setPolygon(arrowB2);
		Button arrowC2 = new Button("C");
		arrowC2.setOnAction(e -> window.setScene(scene3));
		setPolygon(arrowC2);
		
		
		
		arrows2.getChildren().add(arrowA2);
		arrows2.getChildren().add(arrowB2);
		arrows2.getChildren().add(arrowC2);
		
		scene2 = new Scene(root2);
		
		//Background3

		ImageView mv3 = new ImageView(background1);
		GridPane root3 = new GridPane();
		root3.getChildren().add(mv3);
		
		
		//Label 3
		HBox door3loc = new HBox();
		door3loc.setAlignment(Pos.BOTTOM_CENTER);
		Label door3 = new Label("You are at door #3");
		door3.setTextFill(Color.web("#FFFFFF"));
		door3.setFont(new Font("Times New Roman", 36));
		door3.setTextAlignment(TextAlignment.CENTER);
		door3.setWrapText(true);			
		root3.getChildren().add(door3loc);
		door3loc.getChildren().add(door3);
		
		//Arrows3
		HBox arrows3  = new HBox(250);
		arrows3.setAlignment(Pos.CENTER);
		root3.getChildren().add(arrows3);
		
		Button arrowA3= new Button("A");
		arrowA3.setOnAction(e -> window.setScene(scene4));
		setPolygon(arrowA3);
		
		Button arrowB3 = new Button("B");
		setPolygon(arrowB3);
		
		Button arrowC3 = new Button("C");
		arrowC3.setOnAction(e -> window.setScene(block));
		setPolygon(arrowC3);
	

		
		arrows3.getChildren().add(arrowA3);
		arrows3.getChildren().add(arrowB3);
		arrows3.getChildren().add(arrowC3);
		
		scene3 = new Scene(root3);
		
		//Background4
		Image background4 = new Image("file:witness.jpg");
		ImageView mv4 = new ImageView(background4);
		GridPane root4 = new GridPane();
		root4.getChildren().add(mv4);
		
		
		scene4 = new Scene(root4);
		
		
		
		
		scene1 = new Scene(root);
		window.setScene(scene1);
		window.showAndWait();

    }

}