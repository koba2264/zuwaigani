package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message implements Serializable, Comparable<Message> {
	@JsonProperty("text")
//	内容
	private String text;
//	送信時間
	private LocalDateTime sendingTime;
	@JsonProperty("strSendingTime")
//	送信時間(文字型)
	private String strSendingTime;
	@JsonProperty("looked")
//	既読
	private boolean looked;
	@JsonProperty("mine")
//	自分のか
	private boolean mine;
	@JsonProperty("sendId")
//	送ったID
	private String sendId;

//	ゲッター
	public String getText() {
		return text;
	}
	public LocalDateTime getSendingTime() {
		return sendingTime;
	}
	public boolean isLooked() {
		return looked;
	}
	public boolean isMine() {
		return mine;
	}
	public String getStrSendingTime() {
		return this.strSendingTime;
	}

//	セッター
	public void setText(String text) {
		this.text = text;
	}
	public void setSendingTime(LocalDateTime sendingTime) {
		this.sendingTime = sendingTime;
		this.setStrSendingTime(this.sendingTime);
	}
//	sql用
	public void setSendingTimeSql(Timestamp sendingTime) {
		this.sendingTime = sendingTime.toLocalDateTime();
		this.setStrSendingTime(this.sendingTime);
	}
	public void setLooked(boolean looked) {
		this.looked = looked;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	private void setStrSendingTime(LocalDateTime sendingTime) {
		this.strSendingTime = sendingTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	}

//	時間順に並び替え用
	@Override
	public int compareTo(Message o) {
		if (this.sendingTime.isEqual(o.getSendingTime())) {
			return 0;
		} else if (this.sendingTime.isAfter(o.getSendingTime())) {
			return 1;
		} else {
			return -1;
		}
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
}
