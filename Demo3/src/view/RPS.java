package view;

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

import java.util.Scanner; 
import java.util.Random; 

public class RPS{
	
	private static String personPlay;
	private static String computerPlay = "";
	private static String computerPlayer = "";
	private static int computerInt; //Randomly generated number used to determine computer's play 
    private String response; 
	
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
	
	public static Scene getAttackScene(){
		Image attackImage = new Image("view/resources/monster.png");
		ImageView attackView = new ImageView(attackImage);
		GridPane attackPane = new GridPane();
		attackPane.setMaxSize(800, 600);
		
		attackPane.getChildren().add(attackView);
	
		
		HBox choices = new HBox();
		choices.setAlignment(Pos.BOTTOM_LEFT);
		attackPane.getChildren().add(choices);
		
		boolean attacking = true;
		
			
		computerPlayer = getcompGen();
		System.out.println("What's your play?"); 
		
		Button rockchoice = new Button("R");
		rockchoice.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent rock){
				personPlay ="R";
				
				if (personPlay.equals(computerPlayer)){
					System.out.println("It's a tie!"); 
				} else if (computerPlayer.equals("P")){
					System.out.println("You loose");
				} else if (computerPlayer.equals("S")){
					System.out.println("You Win");
					//setScene
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
				} else if (computerPlayer.equals("S")){
					System.out.println("You loose");
				} else if (computerPlayer.equals("R")){
					System.out.println("You Win");
					
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
					
				}
				
			}
			});
	
	
		choices.getChildren().addAll(rockchoice,paperchoice,scissorchoice);
		
		
		Scene attackscene = new Scene(attackPane);
		
		return attackscene;
	}

}
