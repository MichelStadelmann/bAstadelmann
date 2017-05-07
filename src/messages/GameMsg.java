package messages;

public class GameMsg extends Message {
	private int field;
	private String content;

	public GameMsg(int field, String content) {
		super(MessageType.Game);
		this.field = field;
		this.content = content;
	}

	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}

}
