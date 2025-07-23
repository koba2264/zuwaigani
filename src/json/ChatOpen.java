package json;

public class ChatOpen {
	private String type;
	private String sendId;
	private String myId;

	public ChatOpen() {}

//	ゲッター
	public String getType() {
		return type;
	}
	public String getSendId() {
		return sendId;
	}
	public String getMyId() {
		return myId;
	}

//	セッター
	public void setType(String type) {
		this.type = type;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}

}
