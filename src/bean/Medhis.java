package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Medhis implements Serializable {
//	病名
	private String name;
//	発症年齢
	private int age;
//	状態
	private String stateId;
	private String state;
	private static Map<String, String> stateMap = new HashMap<>();
	static {
		stateMap.put("01","治療中");
		stateMap.put("02","寛容");
		stateMap.put("03","治癒");
	}

//	ゲッター
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getStateId() {
		return stateId;
	}
	public String getState() {
		return state;
	}

//	セッター
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
		this.setState(stateId);
	}
	private void setState(String stateId) {
		this.state = stateMap.get(stateId);
	}
}
