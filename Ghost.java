//Alison Tomooka
//11.23.18 V.1

public class Ghost {	//Open Ghost class

	
	private EZImage picture; //declare private variable "picture" of type EZImage
	
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
		
		y -= 10;	//decrease y by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
		
	}
	
	
	//Declare moveDown function
	public void moveDown() {
		
		y += 10;	//increase y by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
	}
	
	
	//Declare moveLeft function
	public void moveLeft() {
		
		x -= 10;	//decrease x by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
	
	}
	
	
	//Declare moveRight function
	public void moveRight() {
		
		x += 10;	//increase x by 10
		
		picture.translateTo(x, y);	//translate picture to new x and y
		
	}
	
	
	//Declare hit function
	public void hit(int posX, int posY) {
		
		x = posX;	//assign value of posX to x
		y = posY;	//assign value posY to y
		
		picture.translateTo(x,y);	//translate picture to new x and y
		
	}

	
}	