package bean;

import java.io.Serializable;

import enu.Timing;

//処方箋
public class Drag implements Serializable {
//	薬名
	private String name;
//	タイミング
	private Timing timing;
//	量
	private int amount;

//	ゲッター
	public String getName() {
		return name;
	}
	public Timing getTiming() {
		return timing;
	}
	public int getAmount() {
		return amount;
	}

//	セッター
	public void setName(String name) {
		this.name = name;
	}
	public void setTiming(Timing timing) {
		this.timing = timing;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
