package bean;

import java.io.Serializable;

public class Medrec implements Serializable {
	private User user;
//	部屋番号
	private String roomNum;
//	介助レベル
	private String level;
//	身長
	private float height;
//	体重
	private float weight;
//	血圧
	private String bloodPres;

//	ゲッター
	public User getUser() {
		return user;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getLevel() {
		return level;
	}
	public float getHeight() {
		return height;
	}
	public float getWeight() {
		return weight;
	}
	public String getBloodPres() {
		return bloodPres;
	}

//	セッター
	public void setUser(User user) {
		this.user = user;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setBloodPres(String bloodPres) {
		this.bloodPres = bloodPres;
	}
}
