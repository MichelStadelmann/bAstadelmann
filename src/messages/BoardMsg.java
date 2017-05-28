package messages;

public class BoardMsg extends Message {

	private String name;
	private int index;
	private String sign;

	public BoardMsg(String name, int index, String sign) {
		super(MessageType.Board);
		this.name = name;
		this.index = index;
		this.sign = sign;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
