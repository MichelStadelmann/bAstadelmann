package messages;

public class BoardMsg extends Message {

	private String name;
	private String sign;

	public BoardMsg(String name, String sign) {
		super(MessageType.Board);
		this.name = name;
		this.sign = sign;
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
