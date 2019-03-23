package tictactoegui;


	import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.layout.*;
	import javafx.scene.text.Text;
	import javafx.scene.control.Label;
	import javafx.scene.control.Button;
	import javafx.event.*;
	import javafx.scene.input.*;
	 

	 
	public class TicTacToeGUI extends Application {
	    private Button[][] gridButtons = new Button[3][3];
	    private Text messages = new Text();
	     
	    @Override
	    public void start(Stage primaryStage) {
	        // build grid of buttons for the board (visual component)
	        GridPane grid = new GridPane();
	        for (int row = 0; row < 3; row++) {
	            for (int column = 0; column < 3; column++){
	                Button b = new Button(" ");
	                gridButtons[row][column] = b;
	                grid.add(gridButtons[row][column], row, column);                
	            }
	        }
	         
	        new GameController(this);
	         
	        // build entire scene: grid and label
	        BorderPane root = new BorderPane();
	        root.setCenter(grid);
	        root.setBottom(messages);
	         
	        Scene scene = new Scene(root, 300, 300);
	 
	        primaryStage.setTitle("Tic Tac Toe");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	     
	    public static void main(String[] args) {
	        launch(args);
	    }
	     
	    public void placeToken(char token, int row, int col) {
	        Button b = gridButtons[row][col];
	        b.setText("" + token);
	        b.setDisable(true);
	    }
	     
	    public void setMessage(String message) {
	        messages.setText(message);
	    }
	     
	    public void disable() {
	        for (Button[] row : gridButtons) {
	            for (Button b : row) {
	                b.setDisable(true);
	            }
	        }
	    }
	     
	    public void setButtonHandler(EventHandler<ActionEvent> handler, int row, int col){
	        gridButtons[row][col].setOnAction(handler);     
	    }
	}
