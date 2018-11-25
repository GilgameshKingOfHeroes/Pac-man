
//Alison Tomooka
//November 2018

public class Ghost {	//Open Ghost class

	
	public EZImage picture; //declare private variable "picture" of type EZImage
	
	private int x;	//declare private variable "x" of type integer
	private int y;	//declare private variable "y" of type integer
	

	
	//Class Constructor
	Ghost(int posX, int posY) {
		
		x = posX;	//assign value of posX to x
		y = posY;	//assign value of posY to y
		
		picture = EZ.addImage("ghost.png", x, y);	//assign image to picture
		
	}
	
	
	//Declare getX function
	public int getX() {
		return x;	//return the value of x
	}
	
	
	//Declare getY function
	public int getY() {
		return y;	//return the value of y
	}
	
	
	//Declare moveUp function
	public void moveUp() {
		
		y -= 1;	//decrease y by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
		
	}
	
	
	//Declare moveDown function
	public void moveDown() {
		
		y += 1;	//increase y by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
	}
	
	
	//Declare moveLeft function
	public void moveLeft() {
		
		x -= 1;	//decrease x by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
	
	}
	
	
	//Declare moveRight function
	public void moveRight() {
		
		x += 1;	//increase x by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
		
	}
	
	
	//Declare hit function
	public void hit(int posX, int posY, Life whatLeft) {
		
		x = posX;	//assign value of posX to x
		y = posY;	//assign value posY to y
		
		picture.translateTo(x,y);	//translate picture to new x and y
		
		whatLeft.decreaseLives();	//call decreaseLives function from Life class
	}
	
	
	//Declare arrayColumn function
	//This function gives an approximate relationship between the Ghost's x-coordinate and 2D Array
	public int arrayColumn() {
		int column = getX()/32;	//Declare column variable and assign the value of the Ghost's x divided by 32
		return column;	//return the value of column
	}
	
	
	//Declare arrayRow function
	//This function gives an approximate relationship between the Ghost's y-coordinate and 2D Array
	public int arrayRow() {
		int row = getY()/32;	//Declare row variable and assign the value of the Ghost's y divided by 32
		return row;	//return the value of row
	}
	
}	
