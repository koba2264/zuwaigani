package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import enu.Gender;
import enu.Job;
import enu.Role;

public class Employee implements Serializable {
//	従業員番号
	private String id;
//	名前
	private String name;
//	フリガナ
	private String namef;
//	性別
	private Gender gender;
//	生年月日
	private LocalDate birthDay;
//	権限
	private Role role;
//	配偶者
	private boolean spouse;
//	職業
	private Job job;
//	メッセージ一覧
	private List<Message> messageList = new ArrayList<>();
//	新着メッセージ数
	private int messageNum;
//	最後のメッセージ
	private Message lastMessage = null;

//	セッター
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
//	sql用
	public void setBirthDaySql(Date birthDay) {
		this.birthDay = birthDay.toLocalDate();
	}

	public void setNamef(String namef) {
		this.namef = namef;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
		if (this.messageList.size() > 0) {
			this.setLastMessage(this.messageList.get(this.messageList.size() - 1));
		}
	}
	public void setMessage(Message message) {
		messageList.add(message);
	}
	public void setGender(Gender gender) {
		this.gender = gender;
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
	public Role getRole() {
		return role;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public Job getJob() {
		return job;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public Gender getGender() {
		return gender;
	}

	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public Message getLastMessage() {
		return lastMessage;
	}
	private void setLastMessage(Message lastMessage) {
		this.lastMessage = lastMessage;
	}
}

