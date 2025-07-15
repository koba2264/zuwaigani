package bean;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

public class Schedule implements Serializable {
//	開始時刻
	private LocalTime startTime;
//	内容
	private String process;

//	ゲッター
	public LocalTime getStartTime() {
		return startTime;
	}
//	sql用
	public Time getStartTimeSql() {
		return Time.valueOf(this.startTime);
	}
	public String getProcess() {
		return process;
	}

//	セッター
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
//	sql用
	public void setStartTime(Time startTime) {
		this.startTime = startTime.toLocalTime();
	}
	public void setProcess(String process) {
		this.process = process;
	}
}
