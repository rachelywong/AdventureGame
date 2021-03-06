/**
 * @author Team7
 */


/**
 * Class represents the mini game of Rock Paper Scissors
 * <p>
 * 
 */ 

package view;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import model.TalkStealButton;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent; 
import java.util.Random; 

public class RPS extends PoliceStation {
	
	//instance variables 
	private static String personPlay;
	private static String computerPlay = "";
	private static String computerPlayer = "";
	private static int computerInt; //Randomly generated number used to determine computer's play 
    //private String response; 
	
	
    /**
	 * Method generates random int (1-3). Int is then converted to Strings R, P or S.
	 * 
	 * @param no parameters
	 * @return returns String R, P or S
	 */ 
	public static String getcompGen(){
		Random generator = new Random();
		computerInt = generator.nextInt(3)+1;
		
		if (computerInt == 1){
			computerPlay = "R";
			}
			else if (computerInt == 2){ 
			computerPlay = "P";
			}
			else if (computerInt == 3){
				computerPlay = "S";
				}
		return computerPlay;
	}
	

	/**
	 * getAttackScene() Scene creates a monster Scene with buttons to choose either R,P or S.
	 * Once player has won, "Go back" button redirects them back to Polic Station.
	 * 
	 * @param no parameters
	 * @return returns Scene attackScene
	 */ 
	public static Scene getAttackScene(){
		Image attackImage = new Image("view/resources/monster.png");
		ImageView attackView = new ImageView(attackImage);
		GridPane attackPane = new GridPane();
		attackPane.setMaxSize(400, 300);
		
		attackPane.getChildren().add(attackView);
		
		VBox labels = new VBox();
		labels.setAlignment(Pos.TOP_LEFT);
		Label a_intro = new Label("You've encountered a monster! Win Rock Paper Scissors \n" +
		                          "in order to go back!");
		setFormat(a_intro);
		Label win_label = new Label("You win!!");
		setFormat(win_label);
		Label loose_label = new Label("You loose!!");
		setFormat(loose_label);
		labels.getChildren().add(a_intro);
		attackPane.getChildren().add(labels);
		
		
		HBox choices = new HBox();
		choices.setAlignment(Pos.BOTTOM_LEFT);
		attackPane.getChildren().add(choices);
		
		
		TalkStealButton backButton = new TalkStealButton("Back to Map");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent backto) {
				talkStage.show();
				
				
			}
		});
		
		computerPlayer = getcompGen();
		System.out.println("What's your play?"); 
		
		Button rockchoice = new Button("R");
		rockchoice.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent rock){
				personPlay ="R";
				
				if (personPlay.equals(computerPlayer)){
					System.out.println("It's a tie!"); 
					labels.getChildren().add(loose_label);
				} else if (computerPlayer.equals("P")){
					System.out.println("You loose");
					labels.getChildren().add(loose_label);
				} else if (computerPlayer.equals("S")){
					System.out.println("You win!");
					labels.getChildren().add(win_label);
					choices.getChildren().add(backButton);
				}
				
			}
			});
		
		Button paperchoice = new Button("P");
		paperchoice.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent paper){
				personPlay ="P";
				
				if (personPlay.equals(computerPlayer)){
					System.out.println("It's a tie!");
					labels.getChildren().add(loose_label);					
				} else if (computerPlayer.equals("S")){
					System.out.println("You loose");
					labels.getChildren().add(loose_label);
				} else if (computerPlayer.equals("R")){
					System.out.println("You Win");
					labels.getChildren().add(win_label);
					choices.getChildren().add(backButton);
				}
				
			}
			});
		
		Button scissorchoice = new Button ("S");
		scissorchoice.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent scissor){
				personPlay ="S";
				
				if (personPlay.equals(computerPlay)){
					System.out.println("It's a tie!"); 
					
				} else if (computerPlay.equals("R")){
					System.out.println("You loose");
				} else if (computerPlay.equals("P")){
					System.out.println("You Win");
					labels.getChildren().add(win_label);
					choices.getChildren().add(backButton);
				}
				
			}
			});
		
		choices.getChildren().addAll(rockchoice,paperchoice,scissorchoice);
		Scene attackscene = new Scene(attackPane);
	    return attackscene;
	}
	
	public static void setFormat(Label aResultLabel){
		aResultLabel.setTextFill(Color.web("#FFFFFF"));
		aResultLabel.setFont(new Font("Times New Roman", 18));
		aResultLabel.setWrapText(true);	
		
	}
}