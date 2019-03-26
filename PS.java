import javafx.application.Application; 
import javafx.scene.Scene; 
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

public class PS extends Application{
	
	
	public void start(Stage primaryStage){
	VBox hello = new VBox();
	Button b1 = new Button("Location A");
	Button b2 = new Button("Location B");
	Button b3 = new Button("Location C");
	Button b4 = new Button("Location D");
	b1.setOnAction(e -> {
		
	LocationAGUI.display();
	});
	hello.getChildren().add(b1);
	hello.getChildren().add(b2);
	hello.getChildren().add(b3);
	hello.getChildren().add(b4);
	
	Scene application = new Scene(hello, 400, 169);
	primaryStage.setScene(application);
	primaryStage.show();
	}
}