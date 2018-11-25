//Alison Tomooka
//November 2018


public class Point { 	//Open Point class

	
	EZImage picture;	//declare variable "picture" of type EZImage
	
	private int x;	//declare private variable "x" of type integer
	private int y;	//declare private variable "y" of type integer
	
	
	//Class Constructor
	Point(int column, int row) {
		
		x = 32*column;	//assign value 32 to x
		y = 32*row;	//assign value 32 to y
		
		picture = EZ.addImage("coin.png", x, y);	//assign image to picture
		
	}
	
	

	//Declare collected function
	public void collected() {
			
			picture.hide();	//hide picture
			
	}
	
	
	//Declare getX function
	public int getX() {
		return x;	//return value of x
	}
	
	
	//Declare getY function
	public int getY() {
		return y;	//return value of y
	}
	
	
}
