package messages;

public class GameMsg extends Message {
	private String turn;

	public GameMsg(String turn) {
		super(MessageType.Game);
		this.turn = turn;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

}
