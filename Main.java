//Justin Chen, Tristan Yousuf-Leo, Alison Tomooka
//November 2018

//Use of:
	//2D Arrays, File Reading, Public/Private Member Variables/Functions

//Instructions:
	//Use WASD keys to control the playable character (what looks like Pacman)
	//Collect all the coins
	//Avoid the ghosts
	//Stay alive

import java.awt.Color;	//Import Color
import java.io.FileReader;	//Import File Reader
import java.io.IOException;	//Import io.IOException
import java.util.Scanner;	//Import Scanner

public class Main {	//Open Main class
	
	//Open main program with throws
	public static void main(String[] args) throws IOException {

		EZ.initialize(20*32, 20*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		Map map = new Map();
		
		Life lives = new Life();	//Create lives object of type Life
		
		//Open file reader and file scanner to use for level.txt file
		FileReader fileReader = new FileReader("level.txt");
		Scanner fs = new Scanner(fileReader);

		//declare width, height, and inputText variable (int, int, String types respectively)
		//based on read information
		int width = fs.nextInt();
		int height = fs.nextInt();
		String inputText = fs.nextLine();
		
		//Create 2D Array of type String called mazeWalls of size defined by width and height
		String[][] mazeWalls = new String[width][height];
		
		//Declare variable check of type String and assign "wall here"
		String check = "wall here";
		
		//Create 2D Array of type Point called myPoints of size defined by width and height
		Point[][] myPoints = new Point[width][height];
		
		
		//If the read character is 'R' create a new point in given array spot
		//If the read character is 'G' create a new point off the screen
			//and assign check value to give spot in mazeWalls array
		for(int row = 0; row < height; row++){
			
			inputText = fs.nextLine();
			
			for (int column = 0; column < width; column++){
				
				char ch = inputText.charAt(column);
		
					if (ch == 'R') {
						myPoints[column][row] = new Point(column, row);
					}else if (ch == 'G') {
						myPoints[column][row] = new Point(-20, -20);
						mazeWalls[column][row] = check;
					}
			}	
		}
		
		//Close the file scanner
		fs.close();
		
		//Declare variable count of type integer with value 0
		int count = 0;
		
		//Create new text called counter
		EZText counter = EZ.addText(30, 633, "POINTS: " + count, Color.white, 10);
		
		
		//Declare three new Ghosts at different positions on the screen
		Ghost g1 = new Ghost(17*32, 32);
		Ghost g2 = new Ghost(64, 12*32);
		Ghost g3 = new Ghost(32, 18*32);
		
		//Declare variable playerState of type integer with value 0
		int playerState = 0;
		
		//Create myPlayer object of type Player
		Player myPlayer = new Player();

		while (playerState == 0) {
			
			
			//If there is not a wall in front of Ghost g1, move down
			//If there is a wall, then move up until wall is in Ghost g1's path
			if (mazeWalls[g1.arrayColumn()][g1.arrayRow() + 1] != check) {
				g1.moveDown();
			} else if (mazeWalls[g1.arrayColumn()][g1.arrayRow() + 1] == check) {
				while (mazeWalls[g1.arrayColumn()][g1.arrayRow() - 1] != check) {
					g1.moveUp();
				}
			}

			
			//If there is not a wall in front of Ghost g2, move right
			//If there is a wall, then move left until wall is in Ghost g2's path
			if (mazeWalls[g2.arrayColumn() + 1][g2.arrayRow()] != check) {
				g2.moveRight();
			} else if (mazeWalls[g2.arrayColumn() + 1][g2.arrayRow()] == check) {
				while (mazeWalls[g2.arrayColumn() - 1][g2.arrayRow()] != check) {
					g2.moveLeft();
				}
			}
			
			
			//If there is not a wall in front of Ghost g2, move right
			//If there is a wall, then move left until wall is in Ghost g2's path
			if (mazeWalls[g3.arrayColumn() + 1][g3.arrayRow()] != check) {
				g3.moveRight();
			} else if (mazeWalls[g3.arrayColumn() + 1][g3.arrayRow()] == check) {
				while (mazeWalls[g3.arrayColumn() - 1][g3.arrayRow()] != check) {
					g3.moveLeft();
				}
			}
			
			
			//If myPlayer is inside Ghosts' image then call hit function
			//If number of lives is now zero, call dead function
			if (g1.picture.isPointInElement(myPlayer.getX(), myPlayer.getY())) {
				g1.hit(17*32, 32, lives);
			}
			if (lives.howManyLeft() == 0) {
				lives.dead();
			}
			
			//If myPlayer is inside Ghosts' image then call hit function
			//If number of lives is now zero, call dead function
			if (g2.picture.isPointInElement(myPlayer.getX(), myPlayer.getY())) {
				g2.hit(64, 12*32, lives);
			}
			if (lives.howManyLeft() == 0) {
				lives.dead();
			}
			
			//If myPlayer is inside Ghosts' image then call hit function
			//If number of lives is now zero, call dead function
			if (g3.picture.isPointInElement(myPlayer.getX(), myPlayer.getY())) {
				g3.hit(32, 18*32, lives);
			}
			if (lives.howManyLeft() == 0) {
				lives.dead();
			}
			
			// Steer the Player
			myPlayer.ControlIt(mazeWalls, check);
			
			
			//For the entire myPoints 2D array, check if myPlayer is within the Points' image
			//If inside then call increase count by 1, "collected function, and update counter message with new value
			for(int column = 1; column < width; column++){
				for (int row = 1; row < height; row++){

					if (myPoints[column][row].picture.isPointInElement(myPlayer.getX(), myPlayer.getY())) {
						
						count++;
						
						myPoints[column][row].collected();
						
						counter.setMsg("POINT: " + count);
					}
					
					//End game if all points are collected and count equals 230
					if (count == 230) {
						break;
					}
					
				}	
			}
			
			//Refresh the screen
			EZ.refreshScreen();
		}
	}

}

