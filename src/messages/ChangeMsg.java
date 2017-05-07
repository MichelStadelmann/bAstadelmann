package messages;

public class ChangeMsg extends Message {
	
	int index;
	
	public ChangeMsg(int index){
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
