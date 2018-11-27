import java.awt.Color; //Imports the Color module from java.awt
import java.io.FileReader; //Imports the FileReader module from java.io
import java.io.InputStreamReader; //Imports the InputStreamReader module from java.io
import java.util.Scanner; //Imports the Scanner module from java.util


public class Map { //Creates a public class called Map
	
	Map() throws java.io.IOException {  //Creates a function called Map that throws an IOException incase of an error
		
		FileReader fr = new FileReader("level.txt"); //Creates a filereader called fr that reads a text file called level.txt
		Scanner fileScanner = new Scanner(fr); //Creates a scanner called filescanner that scans the filereader variable called fr
		int width = fileScanner.nextInt(); //Creates an integer called width that uses the next integer within the filescanner
		int height = fileScanner.nextInt(); //Creates an integer called width that uses the next integer within the filescanner
		String inputText = fileScanner.nextLine(); //Creates a string called inputText that uses the next lines within the filescanner

		EZ.initialize(width*32,height*32); //Initializes EZ with the size being the width and height multiplied by 32
		EZ.setBackgroundColor(new Color(0, 0,0)); //Sets the default background color to be black
		
		EZImage mypics[] = new EZImage[1000]; //Creates an EZImage array called mypics that can store up to 1000 image files 


		int i = 0; //Creates the integer i and sets it to 0
		for(int row = 0; row < height; row++){ //Creates a for loop that iterates through the height integer
			
			inputText = fileScanner.nextLine(); //Sets the value of inputText to read the next line in the file
			System.out.println(inputText); //Prints that row
			
			for (int column = 0; column < width; column++){ //Creates a nested for loop that iterates through the width integer
				
				char ch = inputText.charAt(column); //Creates a char variable called ch that reads the current character position in the column
		
				switch(ch){ //Creates a switch with ch
					case 'R': //For case R
						EZ.addImage("dirt.png",column*32,row*32); //Adds the image of dirt to the position
						break;	//Reset
					case 'G': //For case G
						EZ.addImage("grass.png",column*32,row*32); //Adds the image of grass to the position
						break; //Reset
					default: //The default case if none of the switches are in place
						break;	//Reset		
				}
			}

			EZ.refreshScreen(); //Refreshes the screen
		}
		
		fileScanner.close(); //Closes the file scanner
		fr.close(); //Closes the file reader
	}

}
