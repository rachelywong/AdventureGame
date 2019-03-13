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

public class PoliceStation {
	
	public static void PS(){
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Police Station");
		
		VBox root = new VBox();
		Button b1 = new Button("Location A");
		Button b2 = new Button("Location B");
		Button b3 = new Button("Location C");
		Button b4 = new Button("Location D");
		/**b1.setOnAction(e -> {
		tester.display();
		});*/
		root.getChildren().add(b1);
		root.getChildren().add(b2);
		root.getChildren().add(b3);
		root.getChildren().add(b4);
	
		Scene application = new Scene(root, 400, 169);
		primaryStage.setScene(application);
		primaryStage.show();
		primaryStage.showAndWait();
		
	}
}