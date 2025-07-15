package bean;

import java.io.Serializable;

import enu.State;

public class Medhis implements Serializable {
//	病名
	private String name;
//	発症年齢
	private int age;
//	状態
	private State state;


//	ゲッター
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public State getState() {
		return state;
	}

//	セッター
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setState(State state) {
		this.state = state;
	}
}
