package messages;

public class GameMsg extends Message {
	private Boolean turn;
	

	public GameMsg(Boolean turn) {
		super(MessageType.Game);
		this.turn = turn;
	}
	
	public Boolean getTurn() {
		return turn;
	}


	public void setTurn(Boolean turn) {
		this.turn = turn;
	}



}
