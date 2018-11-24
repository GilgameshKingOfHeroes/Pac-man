

public class Main {

	public static void main(String[] args) {
		int playerState = 0;
		EZ.initialize(1024, 768);
		Player myPlayer = new Player();

		while (playerState == 0) {

			// Steer the Player
			myPlayer.ControlIt();
			EZ.refreshScreen();
		}
	}
}
