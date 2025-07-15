package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//処方箋
public class Drag implements Serializable {
//	薬名
	private String name;
//	タイミング
	private String TimingId;
	private String Timing;
	private static Map<String, String> timingMap = new HashMap<>();
	static {
		timingMap.put("01", "食前");
		timingMap.put("02", "食後");
		timingMap.put("03", "食間");
		timingMap.put("04", "いつでも");
	}
//	量
	private int amount;

//	ゲッター
	public String getName() {
		return name;
	}
	public String getTimingId() {
		return TimingId;
	}
	public String getTiming() {
		return Timing;
	}
	public int getAmount() {
		return amount;
	}

//	セッター
	public void setName(String name) {
		this.name = name;
	}
	public void setTimingId(String timingId) {
		TimingId = timingId;
	}
	public void setTiming(String timing) {
		Timing = timing;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
