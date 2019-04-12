package view;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class Puzzle extends Application {
	
	
	public void start(Stage primaryStage) {
		try {
			
			
			Group root = new Group();
			Scene scene = new Scene(root, 500, 500);
		
			Label clue = new Label("Solve the puzzle to show the murder weapon, \n" +
					       "and reveal a clue about the murderer.");
			clue.setLayoutX(100);
			clue.setLayoutY(400);
			root.getChildren().add(clue);
						
			//Take in tile images
			FileInputStream t1 = new FileInputStream("shoe1.jpg"); 
			Image tile1 = new Image(t1);
			ImageView iv_t1 = new ImageView(tile1);
			FileInputStream t2 = new FileInputStream("shoe2.jpg"); 
			Image tile2 = new Image(t2);
			ImageView iv_t2 = new ImageView(tile2);
			FileInputStream t3 = new FileInputStream("shoe3.jpg"); 
			Image tile3 = new Image(t3);
			ImageView iv_t3 = new ImageView(tile3);
			FileInputStream t4 = new FileInputStream("shoe4.jpg"); 
			Image tile4 = new Image(t4);
			ImageView iv_t4 = new ImageView(tile4);
			FileInputStream t5 = new FileInputStream("shoe5.jpg"); 
			Image tile5 = new Image(t5);
			ImageView iv_t5 = new ImageView(tile5);
			FileInputStream t6 = new FileInputStream("shoe6.jpg"); 
			Image tile6 = new Image(t6);
			ImageView iv_t6 = new ImageView(tile6);
			FileInputStream t7 = new FileInputStream("shoe7.jpg"); 
			Image tile7 = new Image(t7);
			ImageView iv_t7 = new ImageView(tile7);
			FileInputStream t8 = new FileInputStream("shoe8.jpg"); 
			Image tile8 = new Image(t8);
			ImageView iv_t8 = new ImageView(tile8);
			
			// Put them into an ArrayList
			ArrayList tiles = new ArrayList();
			tiles.add(iv_t1);
			tiles.add(iv_t2);
			tiles.add(iv_t3);
			tiles.add(iv_t4);
			tiles.add(iv_t5);
			tiles.add(iv_t6);
			tiles.add(iv_t7);
			tiles.add(iv_t8);
			//tiles.add(tile9);
			
			// Randomize the order
			Collections.shuffle(tiles);
			
			// Set where to start placing the tiles
			int startX = 20;
			int startY = 20;
			int spacing = 10;
			int tilesPlaced = 0;
			int numSquares = 9;
			int imgSize = 100;
			
			for(int i = 0; i < Math.sqrt(numSquares); i++) {
				for(int j = 0; j < Math.sqrt(numSquares); j++) {
					if(tilesPlaced < numSquares - 1) {
						((ImageView)(tiles.get(tilesPlaced))).setY(i*(imgSize + spacing));
						((ImageView)(tiles.get(tilesPlaced))).setX(j*(imgSize + spacing));
						((ImageView)(tiles.get(tilesPlaced))).setFitHeight(imgSize);
						((ImageView)(tiles.get(tilesPlaced))).setFitWidth(imgSize);
						tilesPlaced += 1;
					}
				}
			}
			
			int[][] boardStatus = new int[(int) Math.sqrt(numSquares)][(int) Math.sqrt(numSquares)];
			
			for(int i = 0; i < numSquares - 1; i++) {
				root.getChildren().add((ImageView)(tiles.get(i)));
				if(((ImageView)(tiles.get(i))) == iv_t1) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 1;
				}else if(((ImageView)(tiles.get(i))) == iv_t2) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 2;
				}else if(((ImageView)(tiles.get(i))) == iv_t3) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 3;
				}else if(((ImageView)(tiles.get(i))) == iv_t4) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 4;
				}else if(((ImageView)(tiles.get(i))) == iv_t5) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 5;
				}else if(((ImageView)(tiles.get(i))) == iv_t6) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 6;
				}else if(((ImageView)(tiles.get(i))) == iv_t7) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 7;
				}else if(((ImageView)(tiles.get(i))) == iv_t8) {
					boardStatus[i / ((int) Math.sqrt(numSquares))][i % ((int) Math.sqrt(numSquares))] = 8;
				}
			}
			
			// Make -1 indicate the blank
			boardStatus[(int) Math.sqrt(numSquares) - 1][(int) Math.sqrt(numSquares) - 1] = -1;

			// Make all the buttons clickable
			iv_t1.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(1, boardStatus));
				if(canMove(1, boardStatus)) {
	            	movePic(1, boardStatus, iv_t1, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t2.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(2, boardStatus));
				if(canMove(2, boardStatus)) {
	            	movePic(2, boardStatus, iv_t2, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t3.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(3, boardStatus));
				if(canMove(3, boardStatus)) {
	            	movePic(3, boardStatus, iv_t3, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t4.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(4, boardStatus));
				if(canMove(4, boardStatus)) {
	            	movePic(4, boardStatus, iv_t4, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t5.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(5, boardStatus));
				if(canMove(5, boardStatus)) {
	            	movePic(5, boardStatus, iv_t5, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t6.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(6, boardStatus));
				if(canMove(6, boardStatus)) {
	            	movePic(6, boardStatus, iv_t6, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t7.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(7, boardStatus));
				if(canMove(7, boardStatus)) {
	            	movePic(7, boardStatus, iv_t7, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			iv_t8.setOnMouseClicked((MouseEvent e) -> {
				System.out.println(canMove(8, boardStatus));
				if(canMove(8, boardStatus)) {
	            	movePic(8, boardStatus, iv_t8, imgSize, spacing);
	            	printBoard(boardStatus);
	            }
	        });
			
			
			printBoard(boardStatus);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printBoard(int[][] boardStatus) {
		for(int i = 0; i < 3; i++)
		   {
		      for(int j = 0; j < 3; j++)
		      {
		         System.out.printf("%5d ", boardStatus[i][j]);
		      }
		      System.out.println();
		   }
	}
	
	public void movePic(int tileNum, int [][] boardStat, ImageView imgToMove, int imgSize, int spacing) {
		
		int tileXIndex = 0;
		int tileYIndex = 0;
		
		// Find the tile's position
		for (int i = 0; i < boardStat.length; i++) {
		    for (int j = 0; j < boardStat[i].length; j++) {
		        if(boardStat[i][j] == tileNum) {
		        	tileYIndex = i;
		        	tileXIndex = j;
		        }
		    }
		}
		
		System.out.println("Tile x = " + tileXIndex);
		System.out.println("Tile y = " + tileYIndex);
				
		
		int blankXIndex = 0;
		int blankYIndex = 0;
		
		// Find the tile's position
		for (int i = 0; i < boardStat.length; i++) {
		    for (int j = 0; j < boardStat[i].length; j++) {
		        if(boardStat[i][j] == -1) {
		        	blankYIndex = i;
		        	blankXIndex = j;
		        }
		    }
		}
		
		System.out.println("Blank x = " + blankXIndex);
		System.out.println("Blank y = " + blankYIndex);
		
		
		boardStat[blankYIndex][blankXIndex] = tileNum;
		boardStat[tileYIndex][tileXIndex] = -1;
		
		imgToMove.setX(blankXIndex*(imgSize + spacing));
		imgToMove.setY(blankYIndex*(imgSize + spacing));
		
		System.out.println("X = " + (blankXIndex*(imgSize + spacing)));
		System.out.println("Y = " + (blankYIndex*(imgSize + spacing)));
		
		
	}
	
	public boolean canMove(int tileNum, int [][] boardStat) {
		
		boolean ret = false;
		int tileXIndex = 0;
		int tileYIndex = 0;
		
		// Find the tile's position
		for (int i = 0; i < boardStat.length; i++) {
		    for (int j = 0; j < boardStat[i].length; j++) {
		        if(boardStat[i][j] == tileNum) {
		        	tileYIndex = i;
		        	tileXIndex = j;
		        }
		    }
		}
		
		//System.out.println("Tile x = " + tileXIndex);
		//System.out.println("Tile y = " + tileYIndex);
		
		// Make ret true if it borders the empty space
		if(tileYIndex > 0){
			if(boardStat[tileYIndex - 1][tileXIndex] == -1) {
				ret = true;
			}
		}
		if(tileYIndex < boardStat.length - 1){
			if(boardStat[tileYIndex + 1][tileXIndex] == -1) {
				ret = true;
			}
		}
		if(tileXIndex > 0){
			if(boardStat[tileYIndex][tileXIndex - 1] == -1) {
				ret = true;
			}
		}
		if(tileXIndex < boardStat[1].length - 1){
			if(boardStat[tileYIndex][tileXIndex + 1] == -1) {
				ret = true;
			}
		}
		
		return(ret);
		
	}
	
		
	public static void main(String[] args) {
		launch(args);
	}
}