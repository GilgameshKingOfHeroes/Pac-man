

public class Main {

	public static void main(String[] args) {
		int playerState = 0;
		EZ.initialize(1024, 768);
		EZ.addImage("pacman.png", 1024/2,768/2);
		Player myPlayer = new Player();

		while (playerState == 0) {

			// Steer the Player
			myPlayer.ControlIt();
			EZ.refreshScreen();
		}
	}
}