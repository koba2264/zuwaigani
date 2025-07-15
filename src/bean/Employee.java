package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
//	従業員番号
	private String id;
//	名前
	private String name;
//	フリガナ
	private String namef;
//	性別
	private String genderName;
	private String genderId;
//	生年月日
	private LocalDate birthDay;
//	01:管理者 02:一般
	private String role;
//	配偶者
	private boolean spouse;
//	職業
	private String jobId;
	private String jobName;
//	メッセージ一覧
	private List<Message> MessageList = new ArrayList<>();

//	セッター
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
//	sql用
	public void setBirthDaySql(Date birthDay) {
		this.birthDay = birthDay.toLocalDate();
	}

	public void setNamef(String namef) {
		this.namef = namef;
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public void setMessageList(List<Message> messageList) {
		MessageList = messageList;
	}
	public void setMessage(Message message) {
		MessageList.add(message);
	}

//	ゲッター
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
//	sql用
	public Date getBirthDaySql() {
		return Date.valueOf(this.birthDay);
	}
	public String getNamef() {
		return namef;
	}
	public String getGenderId() {
		return genderId;
	}
	public String getRole() {
		return role;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public String getJobId() {
		return jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public String getGenderName() {
		return genderName;
	}
	public List<Message> getMessageList() {
		return MessageList;
	}
}

