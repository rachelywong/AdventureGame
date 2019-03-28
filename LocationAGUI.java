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
    
	protected static Scene scene1, scene2, scene3, scene4, scene5;
    protected static Stage window;

	public static Stage getStage() {
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
		System.out.println("You have arrived at the witness's house, the front door is open, but you must navigate through the "+
								"house to find the witness. Keep your eyes peeled, you never know what dangers may lurk!");
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
		arrowB1.setOnAction(e -> window.setScene(scene4));
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
		
		scene1 = new Scene(root);
		
		
		
		//Background4
		Image background4 = new Image("file:witness.jpg");
		ImageView mv4 = new ImageView(background4);
		GridPane root4 = new GridPane();
		root4.getChildren().add(mv4);
		
		
		scene4 = new Scene(root4);
		
		
		
		
		//scene1 = new Scene(root);
		window.setScene(scene1);
		window.showAndWait();

    }

}
