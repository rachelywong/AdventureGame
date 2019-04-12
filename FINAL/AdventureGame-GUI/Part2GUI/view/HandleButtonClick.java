package view;


import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class HandleButtonClick implements EventHandler<ActionEvent> {
	
    //private String message;
    private Label label;
    private TextField text;
     
    public HandleButtonClick(String aMessage, Label aLabel){
       // message = aMessage;     
        label = aLabel;
    }
             
    public void handle(ActionEvent event){
        String textToDisplay = text.getText();
        label.setText(textToDisplay);
         
    }
}