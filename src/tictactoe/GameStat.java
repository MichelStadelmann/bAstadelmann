package tictactoe;

public class GameStat {

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String state;

	public GameStat(int index, String state) {
		this.index = index;
		this.state = state;
	}

}
