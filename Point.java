//Alison Tomooka
//11.23.18 V.1

import java.awt.Color;	//Import Color

public class Point { 	//Open Point class

	
	private EZImage picture;	//declare private variable "picture" of type EZImage
	
	private int x;	//declare private variable "x" of type integer
	private int y;	//declare private variable "y" of type integer
	private int count;	//declare private variable "count" of type integer
	private EZText counter;	//declare private variable "counter" of type EZText
	
	
	//Class Constructor
	Point(int column, int row) {
		
		x = 32;	//assign value 32 to x
		y = 32;	//assign value 32 to y
		
		picture = EZ.addImage("coin.png", column*x, row*y);	//assign image to picture
		
		
		count = 0; //assign value of 0 to count
		
		counter = EZ.addText(30, 633, "POINTS: " + count, Color.white, 10);	//assign text to counter
		
	}
	
	
	//Declare collected function
	public void collected() {
		
			count++;	//increase count by 1
			
			picture.hide();	//hide picture
			
			counter.setMsg("POINTS: " + count);	//update counter message to new count value
			
	}
	
	
}
