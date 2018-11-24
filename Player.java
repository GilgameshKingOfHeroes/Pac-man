
public class Player {
	private EZImage pacmanPicture;
	private int x, y;
	static final int PLAYER_SPEED = 2;
	
	// Constructor for creating a player.
	public Player() {
		pacmanPicture = EZ.addImage("pacman.png", 32, 32);
		x = 32;
		y = 32;
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
	public void ControlIt() {
		if (EZInteraction.isKeyDown('w')) {
			moveUp(PLAYER_SPEED);
		} else if (EZInteraction.isKeyDown('a')) {
			moveLeft(PLAYER_SPEED);
		} else if (EZInteraction.isKeyDown('s')) {
			moveDown(PLAYER_SPEED);
		} else if (EZInteraction.isKeyDown('d')) {
			moveRight(PLAYER_SPEED);
		}
	}
}
	



