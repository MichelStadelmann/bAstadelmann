package tictactoe;

public enum State {

	NONE, X, O;

	public String getText() {
		if (this == X) {
			return "X";
		} else if (this == O) {
			return "O";
		}
		return "";
	}

}
