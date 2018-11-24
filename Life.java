//Alison Tomooka
//11.23.18 V.1

import java.awt.Color;	//Import Color

public class Life {	//Open Life class

	
	private int count;	//declare private variable "count" of type integer
	private EZText counter;	//declare private variable "counter" of type EXText
	
	
	//Class Constructor
	Life() {
		
		count = 3;	//assign value 3 to count
		
		counter = EZ.addText(320, 633, "LIVES: "+ count, Color.white, 10); //assign text to counter
		
	}
	
	
	//Declare decreaseLives function
	public void decreaseLives() {
		
		count -= 1;	//decrease count by 1
		
		counter.setMsg("LIVES: "+ count);	//update counter message to new count value
		
	}
	
	
	//Declare dead function
	public void dead() {
		
		counter.setMsg("NO MORE LIVES");	//change counter message to "NO MORE LIVES"
		
	}
	
}
