package tictactoe;

public enum Turn {

	Player1, Player2, GameFinished;

	public String getTurn() {

		if (this == Player1) {
			return "Player1";
		}

		if (this == Player2) {
			return "Player2";
		}

		else if (this == GameFinished) {
			return "GameFinished";
		}
		return "";
	}

}
