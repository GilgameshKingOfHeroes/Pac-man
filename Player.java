
//Justin Chen
//November 2018

public class Player {
	private EZImage pacmanPicture; // declare private variable "pacmanPicture" of type EZImage
	private int x, y; // declare private variable "x,y" of type int
	static final int PLAYER_SPEED = 32; // declare static final of type int to player speed
	
	// Constructor for creating a player.
	public Player() {
		pacmanPicture = EZ.addImage("pacman2.png", 32, 32); // assign image to pacmanPicture
		x = 32; //assign 32 to variable x
		y = 32; //assign 32 to variable y
	}

	// Accessor method to retrieve the position of the player.
	public int getX() {
		return x; 
	}

	public int getY() {
		return y;
	}

	// Set the position of the player
	public void setPosition(int posx, int posy) {
		x = posx; 
		y = posy;
		setPlayerImagePosition(x, y);
	}

	private void setPlayerImagePosition(int posx, int posy) {
		pacmanPicture.translateTo(posx, posy);
	}

	// Methods for moving the player.
	public void moveLeft(int step) {
		x = x - step;
		setPlayerImagePosition(x, y);
	}

	public void moveRight(int step) {
		x = x + step;
		setPlayerImagePosition(x, y);
	}

	public void moveUp(int step) {
		y = y - step;
		setPlayerImagePosition(x, y);
	}

	public void moveDown(int step) {
		y = y + step;
		setPlayerImagePosition(x, y);
	}

	// Keyboard controls for moving the player.
	public void ControlIt(String [][] walls, String ck) {
		if (EZInteraction.wasKeyReleased('w') && (walls[(getX()/32)][(getY()/32)-1]!= ck)) {
			moveUp(PLAYER_SPEED);
		} else if (EZInteraction.wasKeyReleased('a') && (walls[(getX()/32)-1][(getY()/32)]!= ck)) {
			moveLeft(PLAYER_SPEED);
		} else if (EZInteraction.wasKeyReleased('s') && (walls[(getX()/32)][(getY()/32)+1]!= ck)) {
			moveDown(PLAYER_SPEED);
		} else if (EZInteraction.wasKeyReleased('d') && (walls[(getX()/32)+1][(getY()/32)]!= ck)) {
			moveRight(PLAYER_SPEED);
		}
	}
}
	



