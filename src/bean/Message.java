package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Message implements Serializable, Comparable<Message> {
//	内容
	private String text;
//	送信時間
	private LocalDateTime sendingTime;
//	既読
	private boolean looked;
//	自分のか
	private boolean mine;

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

//	セッター
	public void setText(String text) {
		this.text = text;
	}
	public void setSendingTime(LocalDateTime sendingTime) {
		this.sendingTime = sendingTime;
	}
//	sql用
	public void setSendingTimeSql(Timestamp sendingTime) {
		this.sendingTime = sendingTime.toLocalDateTime();
	}
	public void setLooked(boolean looked) {
		this.looked = looked;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}

//	時間順に並び替え用
	@Override
	public int compareTo(Message o) {
		if (this.sendingTime.isEqual(o.getSendingTime())) {
			return 0;
		} else if (this.sendingTime.isAfter(o.getSendingTime())) {
			return -1;
		} else {
			return 1;
		}
	}
}
