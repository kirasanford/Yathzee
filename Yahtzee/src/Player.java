public class Player {

// no amount of help can save me now
//	keep track of the player’s part of the game
//	Keep score

	int playerNumber;

	Game game = new Game();

	public Player(int playerNumber) {
		this.playerNumber = playerNumber;
		Scorecard.scoreCard();
	}

	public Game getGame() {
		return game;
	}

	public int getName() {
		return playerNumber;
	}
}
